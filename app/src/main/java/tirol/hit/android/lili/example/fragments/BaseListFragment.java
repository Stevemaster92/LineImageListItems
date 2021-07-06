package tirol.hit.android.lili.example.fragments;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import tirol.hit.android.lili.example.R;
import tirol.hit.android.lili.fragments.ListFragment;
import tirol.hit.android.lili.models.BaseViewModel;
import tirol.hit.android.lili.models.OneLineImageItem;

public abstract class BaseListFragment<T extends OneLineImageItem, M extends BaseViewModel<T>> extends ListFragment<T, M> {
    protected BaseListFragment(Class<M> modelClass) {
        super(modelClass);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    protected void setupViews(@Nullable Bundle savedInstanceState) {
        super.setupViews(savedInstanceState);
        // Add horizontal divider for list items.
//        recyclerView.addItemDecoration(new DividerItemDecoration(
//                recyclerView.getContext(),
//                ((LinearLayoutManager) layoutManager).getOrientation())
//        );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.refresh) {
            refreshData();
            return true;
        } else if (id == R.id.add) {
            loadMoreData();
            return true;
        }

        return false;
    }

    @Override
    public void onListItemSelected(int position, T item, View view) {
        Toast.makeText(requireActivity(), "Selected: " + item + " @ " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListItemLongPressed(int position, T item, View view) {
        Toast.makeText(requireActivity(), "Long Press: " + item + " @ " + position, Toast.LENGTH_SHORT).show();
    }
}
