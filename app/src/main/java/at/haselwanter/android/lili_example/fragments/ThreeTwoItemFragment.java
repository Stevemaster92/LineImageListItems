package at.haselwanter.android.lili_example.fragments;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.fragments.ExpandableListFragment;
import at.haselwanter.android.lili_example.MainActivity;
import at.haselwanter.android.lili_example.adapters.ThreeGroupTwoChildItemAdapter;
import at.haselwanter.android.lili_example.models.ThreeGroupTwoChildItem;
import at.haselwanter.android.lili_example.models.TwoLineDummy;


/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class ThreeTwoItemFragment extends ExpandableListFragment<ThreeGroupTwoChildItem, TwoLineDummy> {
    @Override
    public String getFragmentTag() {
        return "two_two_item_fragment";
    }

    @Override
    protected ExpandableListAdapter<ThreeGroupTwoChildItem, TwoLineDummy> getExpandableAdapter() {
        return new ThreeGroupTwoChildItemAdapter(getContext(), list, listener);
    }

    @Override
    public List<ThreeGroupTwoChildItem> onDataLoading() {
        List<ThreeGroupTwoChildItem> groups = new ArrayList<>();
        List<TwoLineDummy> children = new ArrayList<>();

        for (int i = 0; i < MainActivity.NUMBER_OF_ITEMS; i++)
            children.add(new TwoLineDummy());
        for (int i = 0; i < MainActivity.NUMBER_OF_ITEMS; i++)
            groups.add(new ThreeGroupTwoChildItem(children));

        return groups;
    }

    @Override
    public void onNoDataLoaded() {

    }
}
