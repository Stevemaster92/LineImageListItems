package at.haselwanter.android.lili_example.viewmodels;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.models.BaseViewModel;
import at.haselwanter.android.lili_example.ListActivity;
import at.haselwanter.android.lili_example.models.OneLineDummy;

public class OneLineDummyModel extends BaseViewModel<OneLineDummy> {
    @Override
    protected List<OneLineDummy> onDataLoading(Object... args) {
        List<OneLineDummy> list = new ArrayList<>();

        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS; i++)
            list.add(new OneLineDummy(i, "Dummy " + (i + 1)));

        ListActivity.simulateWaitingForData();

        return list;
    }
}
