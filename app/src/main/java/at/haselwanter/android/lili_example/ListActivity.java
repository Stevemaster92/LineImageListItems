package at.haselwanter.android.lili_example;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili.fragments.TagFragment;
import at.haselwanter.android.lili.models.OneLineImageItem;
import at.haselwanter.android.lili_example.fragments.OneItemFragment;
import at.haselwanter.android.lili_example.fragments.OneOneItemFragment;
import at.haselwanter.android.lili_example.fragments.OneThreeItemFragment;
import at.haselwanter.android.lili_example.fragments.OneTwoItemFragment;
import at.haselwanter.android.lili_example.fragments.ThreeItemFragment;
import at.haselwanter.android.lili_example.fragments.ThreeOneItemFragment;
import at.haselwanter.android.lili_example.fragments.ThreeThreeItemFragment;
import at.haselwanter.android.lili_example.fragments.ThreeTwoItemFragment;
import at.haselwanter.android.lili_example.fragments.TwoItemFragment;
import at.haselwanter.android.lili_example.fragments.TwoOneItemFragment;
import at.haselwanter.android.lili_example.fragments.TwoThreeItemFragment;
import at.haselwanter.android.lili_example.fragments.TwoTwoItemFragment;

public class ListActivity extends AppCompatActivity implements ListFragment.OnListItemActionListener {
    public static final int NUMBER_OF_ITEMS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListFragment lf = chooseFragment(getIntent().getIntExtra(MainActivity.TAG_LIST_INDEX, -1));
        lf.setOnListItemActionListener(this);
        showFragment(lf);
    }

    @Override
    public <T extends OneLineImageItem> void onListItemSelected(int position, T item) {
        Toast.makeText(this, item + " @ " + position, Toast.LENGTH_SHORT).show();
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
            // List fragments with 1-line group items and 1-line, 2-line, or 3-line child items.
            case 3:
                return new OneOneItemFragment();
            case 4:
                return new OneTwoItemFragment();
            case 5:
                return new OneThreeItemFragment();
            // List fragments with 2-line group items and 1-line, 2-line, or 3-line child items.
            case 6:
                return new TwoOneItemFragment();
            case 7:
                return new TwoTwoItemFragment();
            case 8:
                return new TwoThreeItemFragment();
            // List fragments with 3-line group items and 1-line, 2-line, or 3-line child items.
            case 9:
                return new ThreeOneItemFragment();
            case 10:
                return new ThreeTwoItemFragment();
            case 11:
                return new ThreeThreeItemFragment();
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
}
