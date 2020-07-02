package at.haselwanter.android.lili_example.fragments;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import at.haselwanter.android.lili.fragments.ListFragment;
import at.haselwanter.android.lili.models.BaseViewModel;
import at.haselwanter.android.lili.models.OneLineImageItem;
import at.haselwanter.android.lili_example.R;

public abstract class BaseListFragment<T extends OneLineImageItem, M extends BaseViewModel<T>> extends ListFragment<T, M> {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                refreshList();
                return true;
            case R.id.add:
                loadMoreData();
                return true;
        }

        return false;
    }

    @Override
    public <S extends OneLineImageItem> void onListItemSelected(int position, S item, View view) {
        Toast.makeText(requireActivity(), "Selected: " + item + " @ " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public <S extends OneLineImageItem> void onListItemLongPressed(int position, S item, View view) {
        Toast.makeText(requireActivity(), "Long Press: " + item + " @ " + position, Toast.LENGTH_SHORT).show();
    }
}
