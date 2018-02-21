package at.haselwanter.android.lili.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * A placeholder list adapter for several kinds of list items.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017
 */
public abstract class ListAdapter<T> extends BaseAdapter {
    protected List<T> items;
    private LayoutInflater inflater;

    protected ListAdapter(Context context, List<T> items) {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            rowView = inflater.inflate(getLayoutResource(), null);
            prepareViewHolder(rowView);
        }

        populateView(rowView, position);

        return rowView;
    }

    @Override
    public int getCount() {
        return items != null ? items.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
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
     * @param v List item view.
     */
    protected abstract void prepareViewHolder(View v);

    /**
     * Populates the view for the list item at the specific position.
     *
     * @param v        List item view.
     * @param position List item position.
     */
    protected abstract void populateView(View v, int position);
}