package tirol.hit.android.lili.models;

import android.app.Application;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

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

    public void loadDataAsync(Object... args) {
        new Thread(() -> {
            List<T> data = onDataLoading(args);

            if (data == null || data.isEmpty()) {
                onNoDataLoaded();
            } else {
                onDataLoaded(data);

                List<T> list = BaseViewModel.this.data.getValue();
                if (list == null || list.isEmpty()) {
                    // Assign the new data to the list.
                    BaseViewModel.this.data.postValue(data);
                } else {
                    // Append the new data if the list is not empty.
                    List<T> cloned = new ArrayList<>(list);
                    cloned.addAll(data);
                    BaseViewModel.this.data.postValue(cloned);
                }
            }
        }).start();
    }

    public void refreshData(Object... args) {
        if (data.getValue() != null) {
            data.getValue().clear();
            loadDataAsync(args);
        }
    }

    protected void setError(int code, String message) {
        if (Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            error.setValue(new DataError(code, message));
        } else {
            error.postValue(new DataError(code, message));
        }
    }

    protected abstract List<T> onDataLoading(Object... args);

    protected void onDataLoaded(@NonNull List<T> data) {
    }

    protected void onNoDataLoaded() {
        setError(404, "No data loaded");
    }
}
