package at.haselwanter.android.lili_example.models.view;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import at.haselwanter.android.lili.models.BaseViewModel;
import at.haselwanter.android.lili_example.ListActivity;
import at.haselwanter.android.lili_example.MainActivity;
import at.haselwanter.android.lili_example.models.ThreeLineDummy;

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
