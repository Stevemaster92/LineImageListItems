package tirol.hit.android.lili.example.fragments;

import tirol.hit.android.lili.adapters.ListAdapter;
import tirol.hit.android.lili.adapters.OneLineCardItemAdapter;
import tirol.hit.android.lili.adapters.OneLineImageItemAdapter;
import tirol.hit.android.lili.example.models.OneLineDummy;
import tirol.hit.android.lili.example.models.view.OneLineDummyModel;


/**
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class OneLineFragment extends BaseListFragment<OneLineDummy, OneLineDummyModel> {
    @Override
    public String getFragmentTag() {
        return "one_item_fragment";
    }

    @Override
    protected ListAdapter<OneLineDummy> getAdapter() {
        return new OneLineCardItemAdapter<>();
    }

    @Override
    protected Class<OneLineDummyModel> getModelClass() {
        return OneLineDummyModel.class;
    }
}
