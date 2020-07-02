package at.haselwanter.android.lili_example.models.view;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import at.haselwanter.android.lili.models.BaseViewModel;
import at.haselwanter.android.lili_example.ListActivity;
import at.haselwanter.android.lili_example.MainActivity;
import at.haselwanter.android.lili_example.models.OneLineDummy;

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
