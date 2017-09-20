package at.haselwanter.android.lili.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import at.haselwanter.android.lili.R;
import at.haselwanter.android.lili.models.TwoLineImageItem;

/**
 * A list adapter for {@link TwoLineImageItem}s.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class TwoLineImageItemAdapter<T extends TwoLineImageItem> extends OneLineImageItemAdapter<T> {
    public TwoLineImageItemAdapter(Context context, List<T> items) {
        super(context, items);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.list_two_line_image_item;
    }

    @Override
    protected void prepareViewHolder(View v) {
        super.prepareViewHolder(v);

        OneLineImageItemAdapter.ViewHolder parentHolder = (OneLineImageItemAdapter.ViewHolder) v.getTag();
        ViewHolder holder = new ViewHolder();
        holder.firstLine = parentHolder.firstLine;
        holder.image = parentHolder.image;
        holder.secondLine = (TextView) v.findViewById(R.id.second_line);

        v.setTag(holder);
    }

    @Override
    protected void populateView(View v, int position) {
        super.populateView(v, position);

        ViewHolder holder = (ViewHolder) v.getTag();
        T item = getItem(position);

        String secondLineText = item.getSecondLine();
        if (secondLineText != null && !secondLineText.equals("")) {
            holder.secondLine.setVisibility(View.VISIBLE);
            holder.secondLine.setText(secondLineText);
        } else
            holder.secondLine.setVisibility(View.GONE);
    }

    /**
     * This class represents the root view holder for {@link TwoLineImageItem}s.
     */
    protected static class ViewHolder extends OneLineImageItemAdapter.ViewHolder {
        public TextView secondLine;
    }
}