package at.haselwanter.android.lili_example.fragments;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.fragments.ExpandableListFragment;
import at.haselwanter.android.lili_example.ListActivity;
import at.haselwanter.android.lili_example.adapters.OneGroupTwoChildItemAdapter;
import at.haselwanter.android.lili_example.models.OneGroupTwoChildItem;
import at.haselwanter.android.lili_example.models.TwoLineDummy;


/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class OneTwoItemFragment extends ExpandableListFragment<OneGroupTwoChildItem, TwoLineDummy> {
    @Override
    public String getFragmentTag() {
        return "one_two_item_fragment";
    }

    @Override
    protected ExpandableListAdapter<OneGroupTwoChildItem, TwoLineDummy> getExpandableAdapter() {
        return new OneGroupTwoChildItemAdapter(getContext(), list, listener);
    }

    @Override
    public List<OneGroupTwoChildItem> loadData() {
        List<OneGroupTwoChildItem> groups = new ArrayList<>();
        List<TwoLineDummy> children = new ArrayList<>();

        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS / 2; i++)
            children.add(new TwoLineDummy());
        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS; i++)
            groups.add(new OneGroupTwoChildItem(children));

        return groups;
    }

    @Override
    public void onNoDataLoaded() {

    }
}
