package at.haselwanter.android.lili_example.fragments;

import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.TwoLineImageItemAdapter;
import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili_example.models.TwoLineDummy;
import at.haselwanter.android.lili_example.viewmodels.TwoLineDummyModel;


/**
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class TwoItemFragment extends ListFragment<TwoLineDummy, TwoLineDummyModel> {
    @Override
    public String getFragmentTag() {
        return "two_item_fragment";
    }

    @Override
    protected ListAdapter<TwoLineDummy> getAdapter() {
        return new TwoLineImageItemAdapter<>(list, listener);
    }

    @Override
    protected Class<TwoLineDummyModel> getModelClass() {
        return TwoLineDummyModel.class;
    }

    public void loadMoreData() {
        model.loadDataAsync();
    }
}
