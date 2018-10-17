package at.haselwanter.android.lili.models;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public abstract class BaseViewModel<T> extends AndroidViewModel {
    protected MutableLiveData<List<T>> data;
    protected MutableLiveData<DataError> error;
    protected Context context;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
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

    protected void setError(int code, String message) {
        if (Thread.currentThread().equals(Looper.getMainLooper().getThread()))
            error.setValue(new DataError(code, message));
        else
            error.postValue(new DataError(code, message));
    }

    @SuppressLint("StaticFieldLeak")
    public void loadDataAsync(Object... args) {
        new AsyncTask<Object, Void, List<T>>() {
            @Override
            protected List<T> doInBackground(Object... params) {
                List<T> data = onDataLoading(params);

                if (data == null || data.isEmpty() || isCancelled())
                    onNoDataLoaded();

                onDataPreparing(data);

                return data;
            }

            @Override
            protected void onPostExecute(List<T> data) {
                if (data == null || data.isEmpty() || isCancelled())
                    return;

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
        setError(404, "No data loaded");
    }

    protected void onDataPreparing(List<T> data) {
    }
}
