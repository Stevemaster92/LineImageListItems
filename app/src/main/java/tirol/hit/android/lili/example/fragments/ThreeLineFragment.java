package tirol.hit.android.lili.example.fragments;

import tirol.hit.android.lili.adapters.ListAdapter;
import tirol.hit.android.lili.adapters.ThreeLineCardItemAdapter;
import tirol.hit.android.lili.adapters.ThreeLineImageItemAdapter;
import tirol.hit.android.lili.example.models.ThreeLineDummy;
import tirol.hit.android.lili.example.models.view.ThreeLineDummyModel;


/**
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class ThreeLineFragment extends BaseListFragment<ThreeLineDummy, ThreeLineDummyModel> {
    @Override
    public String getFragmentTag() {
        return "three_item_fragment";
    }

    @Override
    protected ListAdapter<ThreeLineDummy> getAdapter() {
        return new ThreeLineCardItemAdapter<>();
    }

    @Override
    protected Class<ThreeLineDummyModel> getModelClass() {
        return ThreeLineDummyModel.class;
    }
}
