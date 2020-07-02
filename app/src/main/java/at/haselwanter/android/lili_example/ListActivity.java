package at.haselwanter.android.lili_example;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili.fragments.TagFragment;
import at.haselwanter.android.lili_example.fragments.OneLineFragment;
import at.haselwanter.android.lili_example.fragments.ThreeLineFragment;
import at.haselwanter.android.lili_example.fragments.TwoLineFragment;

public class ListActivity extends AppCompatActivity {
//
//    private ListFragment listFragment;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list);
//
//        listFragment = chooseFragment(getIntent().getIntExtra(MainActivity.TAG_LIST_INDEX, -1));
//        showFragment(listFragment);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.refresh:
//                // Signal SwipeRefreshLayout to start the progress indicator
//                listFragment.setRefreshing(true);
//                // Start the refresh background task.
//                // This method calls setRefreshing(false) when it's finished.
//                listFragment.refreshList();
//                return true;
//            case R.id.help:
//                Toast.makeText(this, "Please select an item", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.add:
//                listFragment.setRefreshing(true);
//                if (listFragment instanceof OneLineFragment)
//                    ((OneLineFragment) listFragment).loadMoreData();
//                else if (listFragment instanceof TwoLineFragment)
//                    ((TwoLineFragment) listFragment).loadMoreData();
//                else if (listFragment instanceof ThreeLineFragment)
//                    ((ThreeLineFragment) listFragment).loadMoreData();
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.main_menu, menu);
//
//        return true;
//    }

//    private ListFragment chooseFragment(int index) {
//        switch (index) {
//             List fragments with single 1-line, 2-line, or 3-line items.
//            default:
//            case 0:
//                return new OneLineFragment();
//            case 1:
//                return new TwoLineFragment();
//            case 2:
//                return new ThreeLineFragment();
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
//        }
//    }

//    private void showFragment(TagFragment fragment) {
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//
//        if (fragment.isAdded())
//            ft.show(fragment);
//        else
//            ft.replace(R.id.fragment_container, fragment, fragment.getFragmentTag());
//
//        ft.commit();
//    }
}
