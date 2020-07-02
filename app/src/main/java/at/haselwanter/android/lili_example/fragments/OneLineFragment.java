package at.haselwanter.android.lili_example.fragments;

import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.OneLineImageItemAdapter;
import at.haselwanter.android.lili_example.models.OneLineDummy;
import at.haselwanter.android.lili_example.models.view.OneLineDummyModel;


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
        return new OneLineImageItemAdapter<>(list, this);
    }

    @Override
    protected Class<OneLineDummyModel> getModelClass() {
        return OneLineDummyModel.class;
    }
}
