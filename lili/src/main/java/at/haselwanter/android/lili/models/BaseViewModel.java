package at.haselwanter.android.lili.models;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public abstract class BaseViewModel<T> extends AndroidViewModel {
    protected MutableLiveData<List<T>> data;
    protected Context context;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public MutableLiveData<List<T>> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
            loadDataAsync();
        }

        return data;
    }

    @SuppressLint("StaticFieldLeak")
    public void loadDataAsync(Object... args) {
        new AsyncTask<Object, Void, List<T>>() {
            @Override
            protected List<T> doInBackground(Object... params) {
                List<T> data = onDataLoading(params);

                if (data == null || data.isEmpty() || isCancelled())
                    onNoDataLoaded();

                return data;
            }

            @Override
            protected void onPostExecute(List<T> data) {
                if (data == null || data.isEmpty() || isCancelled()) {
                    onNoDataLoaded();
                    return;
                }

                onPrepareData(data);

                List<T> list = BaseViewModel.this.data.getValue();
                if (list != null && !list.isEmpty()) {
                    List<T> cloned = new ArrayList<>(list);
                    cloned.addAll(data);
                    BaseViewModel.this.data.setValue(cloned);
                } else {
                    BaseViewModel.this.data.setValue(data);
                }
            }
        }.execute(args);
    }

    public void refreshData(Object... args) {
        data.getValue().clear();
        loadDataAsync(args);
    }

    protected abstract List<T> onDataLoading(Object... args);

    protected void onNoDataLoaded() {
    }

    protected void onPrepareData(List<T> data) {
    }
}
