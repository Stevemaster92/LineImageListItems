package at.haselwanter.android.lili.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
public abstract class ListFragment<T extends OneLineImageItem, M extends BaseViewModel<T>>
        extends BaseFragment<M> {
    protected List<T> list;
    protected ListAdapter<T> adapter;
    protected RecyclerView listView;
    protected RecyclerView.LayoutManager layoutManager;
    protected SwipeRefreshLayout swipeRefreshLayout;
    protected ListAdapter.OnListItemActionListener listener;

    protected ListFragment() {
        list = new ArrayList<>();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface.
        try {
            // Instantiate the listener so we can send events to the host.
            listener = (ListAdapter.OnListItemActionListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception.
            throw new ClassCastException(context.toString()
                    + " must implement OnListItemActionListener");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        observeData();
        observeError();
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
    public void refreshList(Object... args) {
        adapter.clear();
        model.refreshData(args);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.list;
    }

    @Override
    protected void setupViews() {
        listView = view.findViewById(R.id.list);
        // Set to 'true' to improve performance if changes in content do not change layout size of RecyclerView.
        listView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        listView.setLayoutManager(layoutManager);

        adapter = getAdapter();
        listView.setAdapter(adapter);

        swipeRefreshLayout = view.findViewById(R.id.root);
        swipeRefreshLayout.setOnRefreshListener(this::refreshList);
    }

    protected void observeData() {
        setRefreshing(true);
        model.getData().observe(requireActivity(), items -> {
            updateList(items);
            setRefreshing(false);
        });
    }

    protected void observeError() {
        model.getError().observe(requireActivity(), error -> {
            Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            setRefreshing(false);
        });
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
}
