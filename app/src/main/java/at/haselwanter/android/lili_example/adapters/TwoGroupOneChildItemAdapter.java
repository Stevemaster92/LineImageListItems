package at.haselwanter.android.lili_example.adapters;

import android.content.Context;

import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.OneLineImageItemAdapter;
import at.haselwanter.android.lili.adapters.TwoLineImageGroupItemAdapter;
import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili_example.models.OneLineDummy;
import at.haselwanter.android.lili_example.models.TwoGroupOneChildItem;

/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class TwoGroupOneChildItemAdapter extends ExpandableListAdapter<TwoGroupOneChildItem, OneLineDummy> {
    public TwoGroupOneChildItemAdapter(Context context, List<TwoGroupOneChildItem> groups,
                                       ListFragment.OnListItemActionListener childListener) {
        super(context, new TwoLineImageGroupItemAdapter<>(context, groups), childListener);
    }

    @Override
    protected ListAdapter<OneLineDummy> getChildAdapter(Context context, List<OneLineDummy> children) {
        return new OneLineImageItemAdapter<>(context, children);
    }
}
