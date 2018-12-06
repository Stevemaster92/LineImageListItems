package at.haselwanter.android.lili_example.fragments;

import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.OneLineImageItemAdapter;
import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili_example.models.OneLineDummy;
import at.haselwanter.android.lili_example.viewmodels.OneLineDummyModel;


/**
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class OneItemFragment extends ListFragment<OneLineDummy, OneLineDummyModel> {
    @Override
    public String getFragmentTag() {
        return "one_item_fragment";
    }

    @Override
    protected ListAdapter<OneLineDummy> getAdapter() {
        return new OneLineImageItemAdapter<>(list, listener);
    }

    @Override
    protected Class<OneLineDummyModel> getModelClass() {
        return OneLineDummyModel.class;
    }

    public void loadMoreData() {
        model.loadDataAsync();
    }
}
