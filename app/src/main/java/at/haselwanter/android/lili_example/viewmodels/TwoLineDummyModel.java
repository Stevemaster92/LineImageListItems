package at.haselwanter.android.lili_example.viewmodels;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.models.BaseViewModel;
import at.haselwanter.android.lili_example.ListActivity;
import at.haselwanter.android.lili_example.models.OneLineDummy;
import at.haselwanter.android.lili_example.models.TwoLineDummy;

public class TwoLineDummyModel extends BaseViewModel<TwoLineDummy> {
    @Override
    protected List<TwoLineDummy> onDataLoading(Object... args) {
        List<TwoLineDummy> list = new ArrayList<>();

        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS; i++)
            list.add(new TwoLineDummy(i, "Dummy " + (i + 1), "Position " + i));

        ListActivity.simulateWaitingForData();

        return list;
    }
}
