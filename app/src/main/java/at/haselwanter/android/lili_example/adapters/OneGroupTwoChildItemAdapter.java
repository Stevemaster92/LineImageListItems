package at.haselwanter.android.lili_example.adapters;

import android.content.Context;

import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.OneLineImageGroupItemAdapter;
import at.haselwanter.android.lili.adapters.TwoLineImageItemAdapter;
import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili_example.models.OneGroupTwoChildItem;
import at.haselwanter.android.lili_example.models.TwoLineDummy;

/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class OneGroupTwoChildItemAdapter extends ExpandableListAdapter<OneGroupTwoChildItem, TwoLineDummy> {
    public OneGroupTwoChildItemAdapter(Context context, List<OneGroupTwoChildItem> groups, ListFragment
            .OnListItemActionListener childListener) {
        super(context, new OneLineImageGroupItemAdapter<>(context, groups), childListener);
    }

    @Override
    protected ListAdapter<TwoLineDummy> getChildAdapter(Context context, List<TwoLineDummy> children) {
        return new TwoLineImageItemAdapter<>(context, children);
    }
}
