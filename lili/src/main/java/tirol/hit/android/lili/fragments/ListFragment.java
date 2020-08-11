package tirol.hit.android.lili.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import tirol.hit.android.lili.R;
import tirol.hit.android.lili.adapters.ListAdapter;
import tirol.hit.android.lili.models.BaseViewModel;
import tirol.hit.android.lili.models.OneLineImageItem;

/**
 * A fragment containing a simple list view of items extending the {@link OneLineImageItem} class.
 * The data for the list is loaded via a background task following the {@link androidx.lifecycle.ViewModel} pattern and populated by a {@link ListAdapter}.
 * <p/>
 * Created by Stefan Haselwanter on 10.10.2018
 */
public abstract class ListFragment<T extends OneLineImageItem, M extends BaseViewModel<T>>
        extends BaseModelFragment<M> implements ListAdapter.OnListItemActionListener<T> {
    protected List<T> list = new ArrayList<>();
    protected ListAdapter<T> adapter;
    protected RecyclerView recyclerView;
    protected RecyclerView.LayoutManager layoutManager;
    protected SwipeRefreshLayout swipeRefreshLayout;

    protected ListFragment(Class<M> modelClass) {
        this(R.layout.list, modelClass);
    }

    protected ListFragment(@LayoutRes int resId, Class<M> modelClass) {
        super(resId, modelClass);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        observeData();
        observeError();
    }

    /**
     * Notifies the widget that the refresh state has changed. Do not call this method when
     * refresh is triggered by a swipe gesture.
     *
     * @param refreshing Whether or not the view should show the refresh progress.
     */
    protected void setRefreshing(boolean refreshing) {
        if (swipeRefreshLayout != null) {
            new Handler(Looper.getMainLooper()).post(() -> swipeRefreshLayout.setRefreshing(refreshing));
        }
    }

    /**
     * Refreshes the list and reloads the data.
     *
     * @param args The optional arguments passed to the view model.
     */
    protected void refreshData(Object... args) {
        adapter.clear();
        setRefreshing(true);
        getModel().refreshData(args);
    }

    /**
     * Loads more data.
     *
     * @param args The optional arguments passed to the underlying view model.
     */
    protected void loadMoreData(Object... args) {
        setRefreshing(true);
        getModel().loadDataAsync(args);
    }

    @Override
    protected void setupViews(@Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.list);
        // Setup layout manager.
        layoutManager = new LinearLayoutManager(requireActivity());
        recyclerView.setLayoutManager(layoutManager);
        // Improve the performance if changes in the content do not affect the layout size of the recycler view.
        recyclerView.setHasFixedSize(true);
        // Setup adapter.
        adapter = getAdapter();
        adapter.setItems(list);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        // Setup swipe refresh layout.
        swipeRefreshLayout = view.findViewById(R.id.root);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(this::refreshData);
        }
    }

    @Override
    protected void observeData(Object... args) {
        setRefreshing(true);
        getModel().getData(args).observe(getViewLifecycleOwner(), items -> {
            addAll(items);
            setRefreshing(false);
        });
    }

    @Override
    protected void observeError() {
        getModel().getError().observe(getViewLifecycleOwner(), error -> {
            Toast.makeText(requireContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            setRefreshing(false);
        });
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
     * Updates the current list by appending the list of next items.
     *
     * @param nextItems The list of items to add next.
     */
    protected void addAll(List<T> nextItems) {
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
    protected void addAll(int index, List<T> nextItems) {
        list.addAll(index, nextItems);
        notifyAdapter();
    }

    /**
     * Notifies the list adapter that the data set has changed.
     */
    protected void notifyAdapter() {
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /**
     * Returns the list adapter used by the list view.
     *
     * @return The list adapter.
     */
    @NonNull
    protected abstract ListAdapter<T> getAdapter();
}
