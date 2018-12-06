package at.haselwanter.android.lili_example;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili.fragments.TagFragment;
import at.haselwanter.android.lili.models.OneLineImageItem;
import at.haselwanter.android.lili_example.fragments.OneItemFragment;
import at.haselwanter.android.lili_example.fragments.ThreeItemFragment;
import at.haselwanter.android.lili_example.fragments.TwoItemFragment;

public class ListActivity extends AppCompatActivity implements ListAdapter.OnListItemActionListener {
    public static final int NUMBER_OF_ITEMS = 10;
    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listFragment = chooseFragment(getIntent().getIntExtra(MainActivity.TAG_LIST_INDEX, -1));
        showFragment(listFragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                // Signal SwipeRefreshLayout to start the progress indicator
                listFragment.setRefreshing(true);
                // Start the refresh background task.
                // This method calls setRefreshing(false) when it's finished.
                listFragment.refreshList();
                return true;
            case R.id.help:
                Toast.makeText(this, "Please select an item", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.add:
                listFragment.setRefreshing(true);
                if (listFragment instanceof OneItemFragment)
                    ((OneItemFragment) listFragment).loadMoreData();
                else if (listFragment instanceof TwoItemFragment)
                    ((TwoItemFragment) listFragment).loadMoreData();
                else if (listFragment instanceof ThreeItemFragment)
                    ((ThreeItemFragment) listFragment).loadMoreData();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_menu, menu);

        return true;
    }

    @Override
    public <T extends OneLineImageItem> void onListItemSelected(int position, T item, View view) {
        Toast.makeText(this, "Selected: " + item + " @ " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public <T extends OneLineImageItem> void onListItemLongPressed(int position, T item, View view) {
        Toast.makeText(this, "Long Press: " + item + " @ " + position, Toast.LENGTH_SHORT).show();
    }

    private ListFragment chooseFragment(int index) {
        switch (index) {
            // List fragments with single 1-line, 2-line, or 3-line items.
            default:
            case 0:
                return new OneItemFragment();
            case 1:
                return new TwoItemFragment();
            case 2:
                return new ThreeItemFragment();
//            // List fragments with 1-line group items and 1-line, 2-line, or 3-line child items.
//            case 3:
//                return new OneOneItemFragment();
//            case 4:
//                return new OneTwoItemFragment();
//            case 5:
//                return new OneThreeItemFragment();
//            // List fragments with 2-line group items and 1-line, 2-line, or 3-line child items.
//            case 6:
//                return new TwoOneItemFragment();
//            case 7:
//                return new TwoTwoItemFragment();
//            case 8:
//                return new TwoThreeItemFragment();
//            // List fragments with 3-line group items and 1-line, 2-line, or 3-line child items.
//            case 9:
//                return new ThreeOneItemFragment();
//            case 10:
//                return new ThreeTwoItemFragment();
//            case 11:
//                return new ThreeThreeItemFragment();
        }
    }

    private void showFragment(TagFragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (fragment.isAdded())
            ft.show(fragment);
        else
            ft.replace(R.id.fragment_container, fragment, fragment.getFragmentTag());

        ft.commit();
    }

    public static void simulateWaitingForData() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
