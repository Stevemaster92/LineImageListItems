package tirol.hit.android.lili.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tirol.hit.android.lili.models.OneLineImageItem;


/**
 * A placeholder list adapter for several kinds of list items.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017
 */
public abstract class ListAdapter<T extends OneLineImageItem> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected List<T> items;
    protected OnListItemActionListener listener;

    protected ListAdapter(List<T> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutResource(), parent, false);
        return createViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // Register OnClickListeners.
        if (listener != null) {
            T item = getItem(position);
            holder.itemView.setOnClickListener(v -> listener.onListItemSelected(position, item, v));
            holder.itemView.setOnLongClickListener(v -> {
                listener.onListItemLongPressed(position, item, v);
                return true;
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public T getItem(int position) {
        return items.get(position);
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void setListener(OnListItemActionListener listener) {
        this.listener = listener;
    }

    /**
     * Removes the specific list item from the list.
     *
     * @param object List item.
     */
    public void remove(T object) {
        items.remove(object);
        notifyDataSetChanged();
    }

    /**
     * Clears the list.
     */
    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    /**
     * Returns the layout resource id used by the view.
     *
     * @return Layout resource id.
     */
    @LayoutRes
    protected abstract int getLayoutResource();

    /**
     * Initializes the view holder with the given view.
     *
     * @param view List item view.
     */
    @NonNull
    protected abstract RecyclerView.ViewHolder createViewHolder(@NonNull View view);

    /**
     * A listener for performing actions on list items.
     */
    public interface OnListItemActionListener {
        /**
         * Callback method to be invoked when a list item is selected.
         *
         * @param position The selected position in the list.
         * @param item     The selected list item.
         * @param view     The view of the selected list item.
         */
        <T extends OneLineImageItem> void onListItemSelected(int position, T item, View view);

        <T extends OneLineImageItem> void onListItemLongPressed(int position, T item, View view);
    }
}