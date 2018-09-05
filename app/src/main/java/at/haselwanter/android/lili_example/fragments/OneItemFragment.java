package at.haselwanter.android.lili_example.fragments;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.OneLineImageItemAdapter;
import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili_example.ListActivity;
import at.haselwanter.android.lili_example.models.OneLineDummy;


/**
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class OneItemFragment extends ListFragment<OneLineDummy> {
    @Override
    public String getFragmentTag() {
        return "one_item_fragment";
    }

    @Override
    protected ListAdapter<OneLineDummy> getAdapter() {
        return new OneLineImageItemAdapter<>(getContext(), list);
    }

    @Override
    public List<OneLineDummy> loadData() {
        List<OneLineDummy> list = new ArrayList<>();

        ListActivity.simulateWaitingForData();

        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS; i++)
            list.add(new OneLineDummy());

        return list;
    }

    @Override
    public void onNoDataLoaded() {

    }
}
