package tirol.hit.android.lili.example.fragments;

import androidx.annotation.NonNull;

import tirol.hit.android.lili.adapters.ListAdapter;
import tirol.hit.android.lili.adapters.OneLineCardItemAdapter;
import tirol.hit.android.lili.example.models.OneLineDummy;
import tirol.hit.android.lili.example.models.view.OneLineDummyModel;


/**
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class OneLineFragment extends BaseListFragment<OneLineDummy, OneLineDummyModel> {
    public OneLineFragment() {
        super(OneLineDummyModel.class);
    }

    @NonNull
    @Override
    public String getFragmentTag() {
        return "one_item_fragment";
    }

    @NonNull
    @Override
    protected ListAdapter<OneLineDummy> getAdapter() {
        return new OneLineCardItemAdapter<>();
    }
}
