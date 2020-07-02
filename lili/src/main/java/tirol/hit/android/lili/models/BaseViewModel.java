package tirol.hit.android.lili.models;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.AsyncTask;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import tirol.hit.android.lili.models.DataError;

public abstract class BaseViewModel<T> extends AndroidViewModel {
    protected MutableLiveData<List<T>> data;
    protected MutableLiveData<DataError> error;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<T>> getData(Object... args) {
        if (data == null) {
            data = new MutableLiveData<>();
            getError();
            loadDataAsync(args);
        }

        return data;
    }

    public MutableLiveData<DataError> getError() {
        if (error == null) {
            error = new MutableLiveData<>();
        }

        return error;
    }

    @SuppressLint("StaticFieldLeak")
    public void loadDataAsync(Object... args) {
        new AsyncTask<Object, Void, List<T>>() {
            @Override
            protected List<T> doInBackground(Object... params) {
                List<T> data = onDataLoading(params);

                if (data == null || data.isEmpty() || isCancelled()) {
                    onNoDataLoaded();
                } else {
                    onDataLoaded(data);
                }

                return data;
            }

            @Override
            protected void onPostExecute(List<T> data) {
                if (data == null || data.isEmpty() || isCancelled()) {
                    return;
                }

                List<T> list = BaseViewModel.this.data.getValue();
                if (list != null && !list.isEmpty()) {
                    // Append the new data if the list is not empty.
                    List<T> cloned = new ArrayList<>(list);
                    cloned.addAll(data);
                    BaseViewModel.this.data.setValue(cloned);
                } else {
                    // Otherwise, assign the new data to the list.
                    BaseViewModel.this.data.setValue(data);
                }
            }
        }.execute(args);
    }

    public void refreshData(Object... args) {
        if (data.getValue() != null) {
            data.getValue().clear();
            loadDataAsync(args);
        }
    }

    protected void setError(int code, String message) {
        if (Thread.currentThread().equals(Looper.getMainLooper().getThread()))
            error.setValue(new DataError(code, message));
        else
            error.postValue(new DataError(code, message));
    }

    protected abstract List<T> onDataLoading(Object... args);

    protected void onDataLoaded(List<T> data) {
    }

    protected void onNoDataLoaded() {
        setError(404, "No data loaded");
    }
}
