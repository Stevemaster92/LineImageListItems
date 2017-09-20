package at.haselwanter.android.lili_example.adapters;

import android.content.Context;

import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.ThreeLineImageItemAdapter;
import at.haselwanter.android.lili.adapters.TwoLineImageGroupItemAdapter;
import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili_example.models.ThreeLineDummy;
import at.haselwanter.android.lili_example.models.TwoGroupThreeChildItem;

/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class TwoGroupThreeChildItemAdapter extends ExpandableListAdapter<TwoGroupThreeChildItem, ThreeLineDummy> {
    public TwoGroupThreeChildItemAdapter(Context context, List<TwoGroupThreeChildItem> groups,
                                         ListFragment.OnListItemActionListener childListener) {
        super(context, new TwoLineImageGroupItemAdapter<>(context, groups), childListener);
    }

    @Override
    protected ListAdapter<ThreeLineDummy> getChildAdapter(Context context, List<ThreeLineDummy> children) {
        return new ThreeLineImageItemAdapter<>(context, children);
    }
}
