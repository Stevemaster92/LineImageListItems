package at.haselwanter.android.lili.fragments;

import android.widget.ExpandableListView;

import at.haselwanter.android.lili.R;
import at.haselwanter.android.lili.adapters.ExpandableListAdapter;
import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.models.OneLineImageGroupItem;
import at.haselwanter.android.lili.models.OneLineImageItem;

/**
 * A fragment extending the {@link ListFragment} by using an expandable list view and an {@link ExpandableListAdapter}.
 * <p/>
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public abstract class ExpandableListFragment<G extends OneLineImageGroupItem<C>, C extends OneLineImageItem> extends ListFragment<G> {
    private ExpandableListAdapter<G, C> adapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.expandable_list;
    }

    @Override
    protected void setupViews() {
        adapter = getExpandableAdapter();
        listView = (ExpandableListView) view.findViewById(R.id.list);
        ((ExpandableListView) listView).setAdapter(adapter);
    }

    @Override
    protected void notifyAdapter() {
        if (adapter != null)
            adapter.notifyDataSetChanged();
    }

    @Override
    protected final ListAdapter<G> getAdapter() {
        // Force to use the expandable list adapter.
        throw new UnsupportedOperationException();
    }

    protected abstract ExpandableListAdapter<G, C> getExpandableAdapter();
}
