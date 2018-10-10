package at.haselwanter.android.lili.models;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel<T> extends ViewModel {
    protected MutableLiveData<List<T>> items;

    public MutableLiveData<List<T>> getItems() {
        if (items == null) {
            items = new MutableLiveData<>();
            loadDataAsync();
        }

        return items;
    }

    @SuppressLint("StaticFieldLeak")
    public void loadDataAsync(Object... args) {
        new AsyncTask<Object, Void, List<T>>() {
            @Override
            protected List<T> doInBackground(Object... params) {
                List<T> items = onDataLoading(params);

                if (items == null || items.isEmpty() || isCancelled())
                    onNoDataLoaded();

                return items;
            }

            @Override
            protected void onPostExecute(List<T> items) {
                if (items == null || items.isEmpty() || isCancelled()) {
                    onNoDataLoaded();
                    return;
                }

                onPrepareData();

                List<T> list = BaseViewModel.this.items.getValue();
                if (list != null && !list.isEmpty()) {
                    List<T> cloned = new ArrayList<>(list);
                    cloned.addAll(items);
                    BaseViewModel.this.items.setValue(cloned);
                } else {
                    BaseViewModel.this.items.setValue(items);
                }
            }
        }.execute(args);
    }

    public void refreshData(Object... args) {
        items.getValue().clear();
        loadDataAsync(args);
    }

    protected abstract List<T> onDataLoading(Object... args);

    protected void onNoDataLoaded() {
    }

    protected void onPrepareData() {
    }
}
