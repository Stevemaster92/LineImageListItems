package at.haselwanter.android.lili.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import at.haselwanter.android.lili.R;
import at.haselwanter.android.lili.models.ThreeLineImageGroupItem;

/**
 * A list adapter for {@link ThreeLineImageGroupItem}s.
 * <p/>
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class ThreeLineImageGroupItemAdapter<T extends ThreeLineImageGroupItem> extends TwoLineImageGroupItemAdapter<T> {
    public ThreeLineImageGroupItemAdapter(Context context, List<T> groups) {
        super(context, groups);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.expandable_list_three_line_image_item;
    }

    @Override
    protected void prepareViewHolder(View v) {
        super.prepareViewHolder(v);

        TwoLineImageGroupItemAdapter.ViewHolder parentHolder = (TwoLineImageGroupItemAdapter.ViewHolder) v.getTag();
        ViewHolder holder = new ViewHolder();
        holder.groupIndicator = parentHolder.groupIndicator;
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
     * This class represents the root view holder for {@link ThreeLineImageGroupItem}s.
     */
    protected static class ViewHolder extends TwoLineImageGroupItemAdapter.ViewHolder {
        public TextView thirdLine;
    }
}