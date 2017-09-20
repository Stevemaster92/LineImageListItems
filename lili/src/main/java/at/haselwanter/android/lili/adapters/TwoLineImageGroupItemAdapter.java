package at.haselwanter.android.lili.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import at.haselwanter.android.lili.R;
import at.haselwanter.android.lili.models.TwoLineImageGroupItem;

/**
 * A list adapter for {@link TwoLineImageGroupItem}s.
 * <p/>
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class TwoLineImageGroupItemAdapter<T extends TwoLineImageGroupItem> extends OneLineImageGroupItemAdapter<T> {
    public TwoLineImageGroupItemAdapter(Context context, List<T> groups) {
        super(context, groups);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.expandable_list_two_line_image_item;
    }

    @Override
    protected void prepareViewHolder(View v) {
        super.prepareViewHolder(v);

        OneLineImageGroupItemAdapter.ViewHolder parentHolder = (OneLineImageGroupItemAdapter.ViewHolder) v.getTag();
        ViewHolder holder = new ViewHolder();
        holder.groupIndicator = parentHolder.groupIndicator;
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
     * This class represents the root view holder for {@link TwoLineImageGroupItem}s.
     */
    protected static class ViewHolder extends OneLineImageGroupItemAdapter.ViewHolder {
        public TextView secondLine;
    }
}