package at.haselwanter.android.lili_example.fragments;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.fragments.ExpandableListFragment;
import at.haselwanter.android.lili_example.ListActivity;
import at.haselwanter.android.lili_example.adapters.ThreeGroupThreeChildItemAdapter;
import at.haselwanter.android.lili_example.models.ThreeGroupThreeChildItem;
import at.haselwanter.android.lili_example.models.ThreeLineDummy;


/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class ThreeThreeItemFragment extends ExpandableListFragment<ThreeGroupThreeChildItem, ThreeLineDummy> {
    @Override
    public String getFragmentTag() {
        return "two_three_item_fragment";
    }

    @Override
    protected ExpandableListAdapter<ThreeGroupThreeChildItem, ThreeLineDummy> getExpandableAdapter() {
        return new ThreeGroupThreeChildItemAdapter(getContext(), list, listener);
    }

    @Override
    public List<ThreeGroupThreeChildItem> loadData() {
        List<ThreeGroupThreeChildItem> groups = new ArrayList<>();
        List<ThreeLineDummy> children = new ArrayList<>();

        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS / 2; i++)
            children.add(new ThreeLineDummy());
        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS; i++)
            groups.add(new ThreeGroupThreeChildItem(children));

        return groups;
    }

    @Override
    public void onNoDataLoaded() {

    }
}
