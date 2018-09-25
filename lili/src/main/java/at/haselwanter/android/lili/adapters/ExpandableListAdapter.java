package at.haselwanter.android.lili.adapters;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.List;

import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili.models.Expandable;
import at.haselwanter.android.lili.models.OneLineImageItem;

/**
 * A placeholder list adapter for expanding group items (classes extending {@link Expandable}) and their child items (classes extending
 * {@link OneLineImageItem}).
 * It uses the {@link GroupItemAdapter} and its parent {@link ListAdapter} which handle the views of the group and child items.
 * <p/>
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public abstract class ExpandableListAdapter<G extends Expandable<C>, C extends OneLineImageItem> extends BaseExpandableListAdapter {
    private Context context;
    private GroupItemAdapter<G> groupAdapter;
    private SparseArray<ListAdapter<C>> childAdapters;
    private ListFragment.OnListItemActionListener listener;

    protected ExpandableListAdapter(Context context, GroupItemAdapter<G> groupAdapter, ListFragment.OnListItemActionListener childListener) {
        this.context = context;
        this.groupAdapter = groupAdapter;
        childAdapters = new SparseArray<>();
        this.listener = childListener;
        updateChildAdapters();
    }

    /**
     * Clears a lists of group and child adapters.
     */
    public void clear() {
        // Clear all child adapters.
        for (int i = 0; i < childAdapters.size(); i++) {
            childAdapters.get(i).clear();
        }
        // Clear group adapter.
        groupAdapter.clear();
        // Notify about changes.
        notifyDataSetChanged();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        groupAdapter.notifyDataSetChanged();
        updateChildAdapters();
    }

    @Override
    public int getGroupCount() {
        return groupAdapter.getCount();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childAdapters.get(groupPosition).getCount();
    }

    @Override
    public G getGroup(int groupPosition) {
        return groupAdapter.getItem(groupPosition);
    }

    @Override
    public C getChild(int groupPosition, int childPosition) {
        return childAdapters.get(groupPosition).getItem(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupAdapter.getItemId(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childAdapters.get(groupPosition).getItem(childPosition).getId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View rowView = groupAdapter.getView(groupPosition, convertView, parent);

        groupAdapter.toggleChildren(rowView, isExpanded);

        return rowView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final View rowView = childAdapters.get(groupPosition).getView(childPosition, convertView, parent);

        // Set OnClickListeners for child view.
        if (listener != null) {
            final C item = getChild(groupPosition, childPosition);
            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onListItemSelected(childPosition, item, rowView);
                }
            });
            rowView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onListItemLongPressed(childPosition, item, rowView);
                    return true;
                }
            });
        }

        return rowView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    /**
     * Updates the list of adapters for the child items if the list of group items changes.
     */
    private void updateChildAdapters() {
        for (int i = 0; i < getGroupCount(); i++)
            childAdapters.put(i, getChildAdapter(context, getGroup(i).getChildren()));
    }

    /**
     * Returns the adapter for the child items.
     *
     * @param context  Application context.
     * @param children The list of child items.
     * @return The adapter for the child items.
     */
    protected abstract ListAdapter<C> getChildAdapter(Context context, List<C> children);
}
