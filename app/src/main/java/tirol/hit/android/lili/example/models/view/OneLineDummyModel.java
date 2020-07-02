package tirol.hit.android.lili.example.models.view;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import tirol.hit.android.lili.models.BaseViewModel;
import tirol.hit.android.lili.example.MainActivity;
import tirol.hit.android.lili.example.models.OneLineDummy;

public class OneLineDummyModel extends BaseViewModel<OneLineDummy> {
    public OneLineDummyModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected List<OneLineDummy> onDataLoading(Object... args) {
        List<OneLineDummy> list = new ArrayList<>();

        for (int i = 0; i < MainActivity.NUMBER_OF_ITEMS; i++)
            list.add(new OneLineDummy(i, "Dummy " + (i + 1)));

        MainActivity.simulateWaitingForData();

        return list;
    }
}
