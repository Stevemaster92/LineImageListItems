package at.haselwanter.android.lili_example.adapters;

import android.content.Context;

import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.OneLineImageItemAdapter;
import at.haselwanter.android.lili.adapters.ThreeLineImageGroupItemAdapter;
import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili_example.models.OneLineDummy;
import at.haselwanter.android.lili_example.models.ThreeGroupOneChildItem;

/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class ThreeGroupOneChildItemAdapter extends ExpandableListAdapter<ThreeGroupOneChildItem, OneLineDummy> {
    public ThreeGroupOneChildItemAdapter(Context context, List<ThreeGroupOneChildItem> groups,
                                         ListFragment.OnListItemActionListener childListener) {
        super(context, new ThreeLineImageGroupItemAdapter<>(context, groups), childListener);
    }

    @Override
    protected ListAdapter<OneLineDummy> getChildAdapter(Context context, List<OneLineDummy> children) {
        return new OneLineImageItemAdapter<>(context, children);
    }
}
