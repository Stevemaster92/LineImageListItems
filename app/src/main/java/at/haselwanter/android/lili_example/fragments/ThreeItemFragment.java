package at.haselwanter.android.lili_example.fragments;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.ThreeLineImageItemAdapter;
import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili_example.MainActivity;
import at.haselwanter.android.lili_example.models.ThreeLineDummy;

/**
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class ThreeItemFragment extends ListFragment<ThreeLineDummy> {
    @Override
    public String getFragmentTag() {
        return "three_item_fragment";
    }

    @Override
    protected ListAdapter<ThreeLineDummy> getAdapter() {
        return new ThreeLineImageItemAdapter<>(getContext(), list);
    }

    @Override
    protected List<ThreeLineDummy> loadData() {
        List<ThreeLineDummy> list = new ArrayList<>();

        for (int i = 0; i < MainActivity.NUMBER_OF_ITEMS; i++)
            list.add(new ThreeLineDummy());

        return list;
    }

    @Override
    protected void onNoDataLoaded() {

    }
}
