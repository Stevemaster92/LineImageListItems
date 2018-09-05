package at.haselwanter.android.lili_example.fragments;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.fragments.ExpandableListFragment;
import at.haselwanter.android.lili_example.ListActivity;
import at.haselwanter.android.lili_example.adapters.TwoGroupTwoChildItemAdapter;
import at.haselwanter.android.lili_example.models.TwoGroupTwoChildItem;
import at.haselwanter.android.lili_example.models.TwoLineDummy;


/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class TwoTwoItemFragment extends ExpandableListFragment<TwoGroupTwoChildItem, TwoLineDummy> {
    @Override
    public String getFragmentTag() {
        return "two_two_item_fragment";
    }

    @Override
    protected ExpandableListAdapter<TwoGroupTwoChildItem, TwoLineDummy> getExpandableAdapter() {
        return new TwoGroupTwoChildItemAdapter(getContext(), list, listener);
    }

    @Override
    public List<TwoGroupTwoChildItem> loadData() {
        List<TwoGroupTwoChildItem> groups = new ArrayList<>();
        List<TwoLineDummy> children = new ArrayList<>();

        ListActivity.simulateWaitingForData();

        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS / 2; i++)
            children.add(new TwoLineDummy());
        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS; i++)
            groups.add(new TwoGroupTwoChildItem(children));

        return groups;
    }

    @Override
    public void onNoDataLoaded() {

    }
}
