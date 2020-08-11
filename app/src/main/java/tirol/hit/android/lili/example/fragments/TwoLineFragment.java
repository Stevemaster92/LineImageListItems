package tirol.hit.android.lili.example.fragments;

import androidx.annotation.NonNull;

import tirol.hit.android.lili.adapters.ListAdapter;
import tirol.hit.android.lili.adapters.TwoLineCardItemAdapter;
import tirol.hit.android.lili.example.models.TwoLineDummy;
import tirol.hit.android.lili.example.models.view.TwoLineDummyModel;


/**
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class TwoLineFragment extends BaseListFragment<TwoLineDummy, TwoLineDummyModel> {
    public TwoLineFragment() {
        super(TwoLineDummyModel.class);
    }

    @NonNull
    @Override
    public String getFragmentTag() {
        return "two_item_fragment";
    }

    @NonNull
    @Override
    protected ListAdapter<TwoLineDummy> getAdapter() {
        return new TwoLineCardItemAdapter<>();
    }
}
