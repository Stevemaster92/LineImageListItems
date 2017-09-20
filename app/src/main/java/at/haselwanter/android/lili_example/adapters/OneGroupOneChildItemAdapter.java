package at.haselwanter.android.lili_example.adapters;

import android.content.Context;

import java.util.List;

import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.adapters.OneLineImageGroupItemAdapter;
import at.haselwanter.android.lili.adapters.OneLineImageItemAdapter;
import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili_example.models.OneLineDummy;
import at.haselwanter.android.lili_example.models.OneGroupOneChildItem;

/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class OneGroupOneChildItemAdapter extends ExpandableListAdapter<OneGroupOneChildItem, OneLineDummy> {
    public OneGroupOneChildItemAdapter(Context context, List<OneGroupOneChildItem> groups,
                                       ListFragment.OnListItemActionListener childListener) {
        super(context, new OneLineImageGroupItemAdapter<>(context, groups), childListener);
    }

    @Override
    protected ListAdapter<OneLineDummy> getChildAdapter(Context context, List<OneLineDummy> children) {
        return new OneLineImageItemAdapter<>(context, children);
    }
}
