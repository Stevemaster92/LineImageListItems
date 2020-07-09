package tirol.hit.android.lili.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public abstract class BaseModelFragment<M extends ViewModel> extends TagFragment {
    protected M model;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(getModelClass());
    }

    protected abstract Class<M> getModelClass();

    protected abstract void observeData(Object... args);

    protected abstract void observeError();
}
