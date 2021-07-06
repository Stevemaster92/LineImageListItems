package tirol.hit.android.lili.fragments;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public abstract class BaseModelFragment<M extends ViewModel> extends TagFragment {
    private final Class<M> modelClass;
    private M model;

    protected BaseModelFragment(@LayoutRes int resId, Class<M> modelClass) {
        super(resId);
        this.modelClass = modelClass;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(modelClass);
    }

    protected M getModel() {
        return model;
    }

    protected abstract void observeData(Object... args);

    protected abstract void observeError();
}
