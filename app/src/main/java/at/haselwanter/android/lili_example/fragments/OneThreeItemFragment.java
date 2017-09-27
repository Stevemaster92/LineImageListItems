package at.haselwanter.android.lili_example.fragments;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.fragments.ExpandableListFragment;
import at.haselwanter.android.lili_example.ListActivity;
import at.haselwanter.android.lili_example.adapters.OneGroupThreeChildItemAdapter;
import at.haselwanter.android.lili_example.models.OneGroupThreeChildItem;
import at.haselwanter.android.lili_example.models.ThreeLineDummy;


/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class OneThreeItemFragment extends ExpandableListFragment<OneGroupThreeChildItem, ThreeLineDummy> {
    @Override
    public String getFragmentTag() {
        return "one_three_item_fragment";
    }

    @Override
    protected ExpandableListAdapter<OneGroupThreeChildItem, ThreeLineDummy> getExpandableAdapter() {
        return new OneGroupThreeChildItemAdapter(getContext(), list, listener);
    }

    @Override
    public List<OneGroupThreeChildItem> loadData() {
        List<OneGroupThreeChildItem> groups = new ArrayList<>();
        List<ThreeLineDummy> children = new ArrayList<>();

        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS / 2; i++)
            children.add(new ThreeLineDummy());
        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS; i++)
            groups.add(new OneGroupThreeChildItem(children));

        return groups;
    }

    @Override
    public void onNoDataLoaded() {

    }
}
