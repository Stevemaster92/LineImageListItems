package at.haselwanter.android.lili_example.fragments;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.fragments.ExpandableListFragment;
import at.haselwanter.android.lili_example.MainActivity;
import at.haselwanter.android.lili_example.adapters.TwoGroupTwoChildItemAdapter;
import at.haselwanter.android.lili_example.models.TwoLineDummy;
import at.haselwanter.android.lili_example.models.TwoGroupTwoChildItem;


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
    protected List<TwoGroupTwoChildItem> loadData() {
        List<TwoGroupTwoChildItem> groups = new ArrayList<>();
        List<TwoLineDummy> children = new ArrayList<>();

        for (int i = 0; i < MainActivity.NUMBER_OF_ITEMS; i++)
            children.add(new TwoLineDummy());
        for (int i = 0; i < MainActivity.NUMBER_OF_ITEMS; i++)
            groups.add(new TwoGroupTwoChildItem(children));

        return groups;
    }

    @Override
    protected void onNoDataLoaded() {

    }
}
