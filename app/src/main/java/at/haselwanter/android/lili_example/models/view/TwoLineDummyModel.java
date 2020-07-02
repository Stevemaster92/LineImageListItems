package at.haselwanter.android.lili_example.models.view;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import at.haselwanter.android.lili.models.BaseViewModel;
import at.haselwanter.android.lili_example.ListActivity;
import at.haselwanter.android.lili_example.MainActivity;
import at.haselwanter.android.lili_example.models.TwoLineDummy;

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
