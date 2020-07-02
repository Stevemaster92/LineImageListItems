package at.haselwanter.android.lili_example.fragments;

import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.TwoLineImageItemAdapter;
import at.haselwanter.android.lili_example.models.TwoLineDummy;
import at.haselwanter.android.lili_example.models.view.TwoLineDummyModel;


/**
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class TwoLineFragment extends BaseListFragment<TwoLineDummy, TwoLineDummyModel> {
    @Override
    public String getFragmentTag() {
        return "two_item_fragment";
    }

    @Override
    protected ListAdapter<TwoLineDummy> getAdapter() {
        return new TwoLineImageItemAdapter<>(list, this);
    }

    @Override
    protected Class<TwoLineDummyModel> getModelClass() {
        return TwoLineDummyModel.class;
    }
}
