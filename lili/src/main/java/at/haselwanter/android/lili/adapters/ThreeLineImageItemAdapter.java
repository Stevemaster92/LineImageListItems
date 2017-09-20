package at.haselwanter.android.lili.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import at.haselwanter.android.lili.R;
import at.haselwanter.android.lili.models.ThreeLineImageItem;

/**
 * A list adapter for {@link ThreeLineImageItem}s.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class ThreeLineImageItemAdapter<T extends ThreeLineImageItem> extends TwoLineImageItemAdapter<T> {
    public ThreeLineImageItemAdapter(Context context, List<T> items) {
        super(context, items);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.list_three_line_image_item;
    }

    @Override
    protected void prepareViewHolder(View v) {
        super.prepareViewHolder(v);

        TwoLineImageItemAdapter.ViewHolder parentHolder = (TwoLineImageItemAdapter.ViewHolder) v.getTag();
        ViewHolder holder = new ViewHolder();
        holder.firstLine = parentHolder.firstLine;
        holder.image = parentHolder.image;
        holder.secondLine = parentHolder.secondLine;
        holder.thirdLine = (TextView) v.findViewById(R.id.third_line);

        v.setTag(holder);
    }

    @Override
    protected void populateView(View v, int position) {
        super.populateView(v, position);

        ViewHolder holder = (ViewHolder) v.getTag();
        T item = getItem(position);

        String thirdLineText = item.getThirdLine();
        if (thirdLineText != null && !thirdLineText.equals("")) {
            holder.thirdLine.setVisibility(View.VISIBLE);
            holder.thirdLine.setText(thirdLineText);
        } else
            holder.thirdLine.setVisibility(View.GONE);
    }

    /**
     * This class represents the root view holder for {@link ThreeLineImageItem}s.
     */
    protected static class ViewHolder extends TwoLineImageItemAdapter.ViewHolder {
        public TextView thirdLine;
    }
}