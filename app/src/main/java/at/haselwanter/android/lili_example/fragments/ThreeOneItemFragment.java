package at.haselwanter.android.lili_example.fragments;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.fragments.ExpandableListFragment;
import at.haselwanter.android.lili_example.MainActivity;
import at.haselwanter.android.lili_example.adapters.ThreeGroupOneChildItemAdapter;
import at.haselwanter.android.lili_example.models.OneLineDummy;
import at.haselwanter.android.lili_example.models.ThreeGroupOneChildItem;


/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class ThreeOneItemFragment extends ExpandableListFragment<ThreeGroupOneChildItem, OneLineDummy> {
    @Override
    public String getFragmentTag() {
        return "three_one_item_fragment";
    }

    @Override
    protected ExpandableListAdapter<ThreeGroupOneChildItem, OneLineDummy> getExpandableAdapter() {
        return new ThreeGroupOneChildItemAdapter(getContext(), list, listener);
    }

    @Override
    protected List<ThreeGroupOneChildItem> loadData() {
        List<ThreeGroupOneChildItem> groups = new ArrayList<>();
        List<OneLineDummy> children = new ArrayList<>();

        for (int i = 0; i < MainActivity.NUMBER_OF_ITEMS / 2; i++)
            children.add(new OneLineDummy());
        for (int i = 0; i < MainActivity.NUMBER_OF_ITEMS; i++)
            groups.add(new ThreeGroupOneChildItem(children));

        return groups;
    }

    @Override
    protected void onNoDataLoaded() {

    }
}
