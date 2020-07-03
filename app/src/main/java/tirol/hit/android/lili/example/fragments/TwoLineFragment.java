package tirol.hit.android.lili.example.fragments;

import tirol.hit.android.lili.adapters.ListAdapter;
import tirol.hit.android.lili.adapters.TwoLineCardItemAdapter;
import tirol.hit.android.lili.example.models.TwoLineDummy;
import tirol.hit.android.lili.example.models.view.TwoLineDummyModel;


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
        return new TwoLineCardItemAdapter<>();
    }

    @Override
    protected Class<TwoLineDummyModel> getModelClass() {
        return TwoLineDummyModel.class;
    }
}
