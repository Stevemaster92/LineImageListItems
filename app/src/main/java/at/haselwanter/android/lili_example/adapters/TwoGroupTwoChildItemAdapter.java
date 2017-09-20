package at.haselwanter.android.lili_example.adapters;

import android.content.Context;

import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.TwoLineImageGroupItemAdapter;
import at.haselwanter.android.lili.adapters.TwoLineImageItemAdapter;
import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili_example.models.TwoLineDummy;
import at.haselwanter.android.lili_example.models.TwoGroupTwoChildItem;

/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class TwoGroupTwoChildItemAdapter extends ExpandableListAdapter<TwoGroupTwoChildItem, TwoLineDummy> {
    public TwoGroupTwoChildItemAdapter(Context context, List<TwoGroupTwoChildItem> groups,
                                       ListFragment.OnListItemActionListener childListener) {
        super(context, new TwoLineImageGroupItemAdapter<>(context, groups), childListener);
    }

    @Override
    protected ListAdapter<TwoLineDummy> getChildAdapter(Context context, List<TwoLineDummy> children) {
        return new TwoLineImageItemAdapter<>(context, children);
    }
}
