package at.haselwanter.android.lili_example.fragments;

import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.ThreeLineImageItemAdapter;
import at.haselwanter.android.lili_example.models.ThreeLineDummy;
import at.haselwanter.android.lili_example.models.view.ThreeLineDummyModel;


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
        return new ThreeLineImageItemAdapter<>(list, this);
    }

    @Override
    protected Class<ThreeLineDummyModel> getModelClass() {
        return ThreeLineDummyModel.class;
    }
}
