package at.haselwanter.android.lili_example.fragments;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.TwoLineImageItemAdapter;
import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili_example.MainActivity;
import at.haselwanter.android.lili_example.models.TwoLineDummy;

/**
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class TwoItemFragment extends ListFragment<TwoLineDummy> {
    @Override
    public String getFragmentTag() {
        return "two_item_fragment";
    }

    @Override
    protected ListAdapter<TwoLineDummy> getAdapter() {
        return new TwoLineImageItemAdapter<>(getContext(), list);
    }

    @Override
    protected List<TwoLineDummy> loadData() {
        List<TwoLineDummy> list = new ArrayList<>();

        for (int i = 0; i < MainActivity.NUMBER_OF_ITEMS; i++)
            list.add(new TwoLineDummy());

        return list;
    }

    @Override
    protected void onNoDataLoaded() {

    }
}
