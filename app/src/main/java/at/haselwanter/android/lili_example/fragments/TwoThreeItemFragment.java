package at.haselwanter.android.lili_example.fragments;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.fragments.ExpandableListFragment;
import at.haselwanter.android.lili_example.ListActivity;
import at.haselwanter.android.lili_example.adapters.TwoGroupThreeChildItemAdapter;
import at.haselwanter.android.lili_example.models.ThreeLineDummy;
import at.haselwanter.android.lili_example.models.TwoGroupThreeChildItem;


/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class TwoThreeItemFragment extends ExpandableListFragment<TwoGroupThreeChildItem, ThreeLineDummy> {
    @Override
    public String getFragmentTag() {
        return "two_three_item_fragment";
    }

    @Override
    protected ExpandableListAdapter<TwoGroupThreeChildItem, ThreeLineDummy> getExpandableAdapter() {
        return new TwoGroupThreeChildItemAdapter(getContext(), list, listener);
    }

    @Override
    public List<TwoGroupThreeChildItem> loadData() {
        List<TwoGroupThreeChildItem> groups = new ArrayList<>();
        List<ThreeLineDummy> children = new ArrayList<>();

        ListActivity.simulateWaitingForData();

        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS / 2; i++)
            children.add(new ThreeLineDummy());
        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS; i++)
            groups.add(new TwoGroupThreeChildItem(children));

        return groups;
    }

    @Override
    public void onNoDataLoaded() {

    }
}
