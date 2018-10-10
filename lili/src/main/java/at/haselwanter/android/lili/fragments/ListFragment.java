package at.haselwanter.android.lili.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import at.haselwanter.android.lili.R;
import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.models.BaseViewModel;
import at.haselwanter.android.lili.models.OneLineImageItem;

/**
 * A fragment containing a simple list view of items extending the {@link OneLineImageItem} class.
 * The data for the list is loaded via a background task following the {@link androidx.lifecycle.ViewModel} pattern and populated by a {@link ListAdapter}.
 * <p/>
 * Created by Stefan Haselwanter on 10.10.2018
 */
public abstract class ListFragment<T extends OneLineImageItem, M extends BaseViewModel<T>> extends BaseFragment<M> implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    protected List<T> list;
    protected ListAdapter<T> adapter;
    protected ListView listView;
    protected SwipeRefreshLayout swipeRefreshLayout;
    protected OnListItemActionListener listener;

    protected ListFragment() {
        list = new ArrayList<>();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRefreshing(true);
        model.getItems().observe(getActivity(), items -> {
            updateList(items);
            setRefreshing(false);
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position >= list.size() || listener == null)
            return;

        listener.onListItemSelected(position, adapter.getItem(position), view);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        if (position >= list.size() || listener == null)
            return false;

        listener.onListItemLongPressed(position, adapter.getItem(position), view);

        return true;
    }

    public void setOnListItemActionListener(OnListItemActionListener listener) {
        this.listener = listener;
    }

    /**
     * Notify the widget that refresh state has changed. Do not call this when
     * refresh is triggered by a swipe gesture.
     *
     * @param refreshing Whether or not the view should show refresh progress.
     */
    public void setRefreshing(final boolean refreshing) {
        new Handler(Looper.getMainLooper()).post(() -> swipeRefreshLayout.setRefreshing(refreshing));
    }

    /**
     * Refreshes the list and reloads data.
     */
    public void refreshList() {
        adapter.clear();
        model.refreshData();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.list;
    }

    @Override
    protected void setupViews() {
        listView = view.findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

        adapter = getAdapter();
        listView.setAdapter(adapter);

        swipeRefreshLayout = view.findViewById(R.id.root);
        swipeRefreshLayout.setOnRefreshListener(this::refreshList);
    }

    /**
     * Updates the current list by appending the list of next items.
     *
     * @param nextItems The list of items to add next.
     */
    protected void updateList(List<T> nextItems) {
        list.clear();
        list.addAll(nextItems);
        notifyAdapter();
    }

    /**
     * Updates the current list by adding the list of next items at the specific index.
     *
     * @param index     The list index to start adding next items.
     * @param nextItems The list of items to add next.
     */
    protected void updateList(int index, List<T> nextItems) {
        list.addAll(index, nextItems);
        notifyAdapter();
    }

    /**
     * Updates the current list by adding the next item.
     *
     * @param nextItem The item to add next.
     */
    protected void add(T nextItem) {
        list.add(nextItem);
        notifyAdapter();
    }

    /**
     * Updates the current list by adding the next item at the specific index.
     *
     * @param index    The list index to start adding next item.
     * @param nextItem The items to add next.
     */
    protected void add(int index, T nextItem) {
        list.add(index, nextItem);
        notifyAdapter();
    }

    /**
     * Notifies the list adapter that the data set has changed.
     */
    protected void notifyAdapter() {
        if (adapter != null)
            adapter.notifyDataSetChanged();
    }

    /**
     * Returns the list adapter used by the list view.
     *
     * @return The list adapter.
     */
    protected abstract ListAdapter<T> getAdapter();

    /**
     * A listener for performing actions on list items.
     */
    public interface OnListItemActionListener {
        /**
         * Callback method to be invoked when a list item is selected.
         *
         * @param item List item.
         */
        <T extends OneLineImageItem> void onListItemSelected(int position, T item, View view);

        <T extends OneLineImageItem> void onListItemLongPressed(int position, T item, View view);
    }
}
