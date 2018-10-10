package at.haselwanter.android.lili_example.viewmodels;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.models.BaseViewModel;
import at.haselwanter.android.lili_example.ListActivity;
import at.haselwanter.android.lili_example.models.ThreeLineDummy;
import at.haselwanter.android.lili_example.models.TwoLineDummy;

public class ThreeLineDummyModel extends BaseViewModel<ThreeLineDummy> {
    @Override
    protected List<ThreeLineDummy> onDataLoading(Object... args) {
        List<ThreeLineDummy> list = new ArrayList<>();

        for (int i = 0; i < ListActivity.NUMBER_OF_ITEMS; i++)
            list.add(new ThreeLineDummy(i, "Dummy " + (i + 1), "Position " + i, "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam..."));

        ListActivity.simulateWaitingForData();

        return list;
    }
}
