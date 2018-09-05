package at.haselwanter.android.lili.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.R;
import at.haselwanter.android.lili.adapters.ListAdapter;
import at.haselwanter.android.lili.models.OneLineImageItem;

/**
 * A fragment containing a simple list view of items extending the {@link OneLineImageItem} class.
 * The data for the list is loaded by an asynchronous {@link LoadDataTask} in the background after the fragment is created and the list items are
 * populated by a {@link ListAdapter} afterwards.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017
 */
public abstract class ListFragment<T extends OneLineImageItem> extends TagFragment implements /*LoaderManager.LoaderCallbacks<T>,*/ AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    protected List<T> list;
    protected ListAdapter<T> adapter;
    protected ListView listView;
    protected SwipeRefreshLayout swipeRefreshLayout;
    protected OnListItemActionListener listener;
    protected boolean isCreated, isInitialized, loadingEnabled = true;
    private LoadDataTask task;

    protected ListFragment() {
        list = new ArrayList<>();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Load data only if tab is selected and another tab except the next predecessor/successor tab was previously selected.
        if (loadingEnabled && !isInitialized && getUserVisibleHint()) {
            setRefreshing(true);
            startLoadDataTask();
        }

        isCreated = true;

        // The main load has ID = 0.
        //getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // Cancel currently running task if fragment is not visible to the user anymore.
        if (!isVisibleToUser && task != null && task.getStatus() == AsyncTask.Status.RUNNING) {
            task.cancel(true);
        }

        // Load data only if tab is selected and the next predecessor/successor tab was previously selected.
        if (!isInitialized && isVisibleToUser && isCreated) {
            setRefreshing(true);
            startLoadDataTask();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position >= list.size() || listener == null)
            return;

        listener.onListItemSelected(position, adapter.getItem(position));
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        if (position >= list.size() || listener == null)
            return false;

        listener.onListItemLongPressed(position, adapter.getItem(position));

        return true;
    }

    public void setOnListItemActionListener(OnListItemActionListener listener) {
        this.listener = listener;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.list;
    }

    @Override
    protected void setupViews() {
        adapter = getAdapter();
        listView = view.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

        swipeRefreshLayout = view.findViewById(R.id.root);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshList();
            }
        });
    }

    /**
     * Notify the widget that refresh state has changed. Do not call this when
     * refresh is triggered by a swipe gesture.
     *
     * @param refreshing Whether or not the view should show refresh progress.
     */
    public void setRefreshing(boolean refreshing) {
        swipeRefreshLayout.setRefreshing(refreshing);
    }

    /**
     * Refreshes the list and reloads data.
     */
    public void refreshList() {
        adapter.clear();
        isInitialized = false;

        startLoadDataTask();
    }

    /**
     * Updates the current list by appending the list of next items.
     *
     * @param nextItems The list of items to add next.
     */
    protected void updateList(List<T> nextItems) {
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
     * Starts a new task with a progress bar for loading data.
     */
    protected void startLoadDataTask() {
        if (task == null || task.getStatus() == AsyncTask.Status.FINISHED)
            task = new LoadDataTask();

        if (task.getStatus() == AsyncTask.Status.PENDING)
            task.execute();
    }

    /**
     * Loads data from external source and returns them as list.
     *
     * @return The list of arbitrary data.
     */
    protected abstract List<T> loadData();

    /**
     * Callback method to be invoked if no data was loaded by {@link #loadData()}.
     */
    protected abstract void onNoDataLoaded();

    /**
     * A listener for performing actions on list items.
     */
    public interface OnListItemActionListener {
        /**
         * Callback method to be invoked when a list item is selected.
         *
         * @param item List item.
         */
        <T extends OneLineImageItem> void onListItemSelected(int position, T item);

        <T extends OneLineImageItem> void onListItemLongPressed(int position, T item);
    }

    /**
     * An asynchronous task to load arbitrary data.
     */
    private class LoadDataTask extends AsyncTask<Integer, Void, List<T>> {
        @Override
        protected List<T> doInBackground(Integer... params) {
            List<T> items = loadData();

            if (isCancelled() || items == null)
                onNoDataLoaded();

            return items;
        }

        @Override
        protected void onPostExecute(final List<T> result) {
            if (!isCancelled() && result != null && result.size() > 0) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        updateList(result);
                        isInitialized = true;
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }

            super.onPostExecute(result);
        }

        @Override
        protected void onCancelled(List<T> ts) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}
