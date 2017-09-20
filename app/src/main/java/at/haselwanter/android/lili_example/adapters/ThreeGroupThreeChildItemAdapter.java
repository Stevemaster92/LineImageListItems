package at.haselwanter.android.lili_example.adapters;

import android.content.Context;

import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.ThreeLineImageGroupItemAdapter;
import at.haselwanter.android.lili.adapters.ThreeLineImageItemAdapter;
import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili_example.models.ThreeLineDummy;
import at.haselwanter.android.lili_example.models.ThreeGroupThreeChildItem;

/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class ThreeGroupThreeChildItemAdapter extends ExpandableListAdapter<ThreeGroupThreeChildItem, ThreeLineDummy> {
    public ThreeGroupThreeChildItemAdapter(Context context, List<ThreeGroupThreeChildItem> groups,
                                           ListFragment.OnListItemActionListener childListener) {
        super(context, new ThreeLineImageGroupItemAdapter<>(context, groups), childListener);
    }

    @Override
    protected ListAdapter<ThreeLineDummy> getChildAdapter(Context context, List<ThreeLineDummy> children) {
        return new ThreeLineImageItemAdapter<>(context, children);
    }
}
