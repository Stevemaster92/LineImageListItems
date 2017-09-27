package at.haselwanter.android.lili.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import at.haselwanter.android.lili.LoadWithProgressBarTask;
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
public abstract class ListFragment<T extends OneLineImageItem> extends TagFragment implements AdapterView.OnItemClickListener {
    protected List<T> list;
    protected ListAdapter<T> adapter;
    protected ListView listView;
    protected OnListItemActionListener listener;
    protected boolean isInitialized, loadingEnabled = true;
    private LoadDataTask task;

    protected ListFragment() {
        list = new ArrayList<>();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (loadingEnabled && !isInitialized)
            loadDataWithProgressBar();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position >= list.size())
            return;

        if (listener != null)
            listener.onListItemSelected(position, adapter.getItem(position));
    }

    public void setOnListItemActionListener(OnListItemActionListener listener) {
        this.listener = listener;
    }

    public void setOnScrollListener(AbsListView.OnScrollListener listener) {
        listView.setOnScrollListener(listener);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.list;
    }

    @Override
    protected void setupViews() {
        adapter = getAdapter();
        listView = (ListView) view.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
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

    protected String getLoadingText() {
        return "Loading...";
    }

    /**
     * Starts a new task with a progress bar for loading data.
     */
    protected void loadDataWithProgressBar() {
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
    }

    /**
     * An asynchronous task to load arbitrary data.
     */
    private class LoadDataTask extends LoadWithProgressBarTask<Integer, Void, List<T>> {
        public LoadDataTask() {
            super(getContext(), listView, getLoadingText());
        }

        @Override
        protected List<T> doInBackground(Integer... params) {
            super.doInBackground(params);

            List<T> items = loadData();

            if (items == null)
                onNoDataLoaded();

            return items;
        }

        @Override
        protected void onPostExecute(final List<T> result) {
            if (result != null && result.size() > 0) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        updateList(result);
                        isInitialized = true;
                    }
                });
            }

            super.onPostExecute(result);
        }
    }
}
