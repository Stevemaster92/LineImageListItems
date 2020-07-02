package tirol.hit.android.lili.example.models.view;

import android.app.Application;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import tirol.hit.android.lili.example.MainActivity;
import tirol.hit.android.lili.example.models.ThreeLineDummy;
import tirol.hit.android.lili.models.BaseViewModel;

public class ThreeLineDummyModel extends BaseViewModel<ThreeLineDummy> {
    public ThreeLineDummyModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected List<ThreeLineDummy> onDataLoading(Object... args) {
        List<ThreeLineDummy> list = new ArrayList<>();

        for (int i = 0; i < MainActivity.NUMBER_OF_ITEMS; i++)
            list.add(new ThreeLineDummy(i, "Dummy " + (i + 1), "Position " + i, "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam..."));

        MainActivity.simulateWaitingForData();

        return list;
    }
}
