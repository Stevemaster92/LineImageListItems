package at.haselwanter.android.lili_example.fragments;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.fragments.ExpandableListFragment;
import at.haselwanter.android.lili_example.ListActivity;
import at.haselwanter.android.lili_example.adapters.TwoGroupOneChildItemAdapter;
import at.haselwanter.android.lili_example.models.OneLineDummy;
import at.haselwanter.android.lili_example.models.TwoGroupOneChildItem;


/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class TwoOneItemFragment extends ExpandableListFragment<TwoGroupOneChildItem, OneLineDummy> {
    @Override
    public String getFragmentTag() {
        return "two_one_item_fragment";
    }

    @Override
    protected ExpandableListAdapter<TwoGroupOneChildItem, OneLineDummy> getExpandableAdapter() {
        return new TwoGroupOneChildItemAdapter(getContext(), list, listener);
    }

    @Override
    public List<TwoGroupOneChildItem> loadData() {
        List<TwoGroupOneChildItem> groups = new ArrayList<>();
        List<OneLineDummy> children = new ArrayList<>();

        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS / 2; i++)
            children.add(new OneLineDummy());
        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS; i++)
            groups.add(new TwoGroupOneChildItem(children));

        return groups;
    }

    @Override
    public void onNoDataLoaded() {

    }
}
