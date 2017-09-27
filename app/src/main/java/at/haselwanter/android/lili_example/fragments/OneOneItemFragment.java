package at.haselwanter.android.lili_example.fragments;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.fragments.ExpandableListFragment;
import at.haselwanter.android.lili_example.ListActivity;
import at.haselwanter.android.lili_example.adapters.OneGroupOneChildItemAdapter;
import at.haselwanter.android.lili_example.models.OneGroupOneChildItem;
import at.haselwanter.android.lili_example.models.OneLineDummy;


/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class OneOneItemFragment extends ExpandableListFragment<OneGroupOneChildItem, OneLineDummy> {
    @Override
    public String getFragmentTag() {
        return "one_one_item_fragment";
    }

    @Override
    protected ExpandableListAdapter<OneGroupOneChildItem, OneLineDummy> getExpandableAdapter() {
        return new OneGroupOneChildItemAdapter(getContext(), list, listener);
    }

    @Override
    public List<OneGroupOneChildItem> loadData() {
        List<OneGroupOneChildItem> groups = new ArrayList<>();
        List<OneLineDummy> children = new ArrayList<>();

        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS / 2; i++)
            children.add(new OneLineDummy());
        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS; i++)
            groups.add(new OneGroupOneChildItem(children));

        return groups;
    }

    @Override
    public void onNoDataLoaded() {

    }
}
