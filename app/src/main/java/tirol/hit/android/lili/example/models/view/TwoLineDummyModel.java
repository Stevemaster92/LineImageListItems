package tirol.hit.android.lili.example.models.view;

import android.app.Application;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import tirol.hit.android.lili.example.MainActivity;
import tirol.hit.android.lili.example.models.TwoLineDummy;
import tirol.hit.android.lili.models.BaseViewModel;

public class TwoLineDummyModel extends BaseViewModel<TwoLineDummy> {
    public TwoLineDummyModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected List<TwoLineDummy> onDataLoading(Object... args) {
        List<TwoLineDummy> list = new ArrayList<>();

        for (int i = 0; i < MainActivity.NUMBER_OF_ITEMS; i++)
            list.add(new TwoLineDummy(i, "Dummy " + (i + 1), "Position " + i));

        MainActivity.simulateWaitingForData();

        return list;
    }
}
