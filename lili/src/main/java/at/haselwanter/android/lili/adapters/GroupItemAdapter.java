package at.haselwanter.android.lili.adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import at.haselwanter.android.lili.R;
import at.haselwanter.android.lili.models.Expandable;

/**
 * A placeholder list adapter for items extending the {@link Expandable} interface.
 * <p/>
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public abstract class GroupItemAdapter<T extends Expandable> extends ListAdapter<T> {
    protected GroupItemAdapter(Context context, List<T> groups) {
        super(context, groups);
    }

    @Override
    protected void prepareViewHolder(View v) {
        v.setTag(new ViewHolder(v));
    }

    @Override
    protected void populateView(View v, int position) {
        ViewHolder holder = (ViewHolder) v.getTag();
        T item = getItem(position);

        if (item.getChildren() != null && item.getChildren().size() > 0)
            holder.groupIndicator.setVisibility(View.VISIBLE);
        else
            holder.groupIndicator.setVisibility(View.GONE);
    }

    public void toggleChildren(View v, boolean isExpanded) {
        ViewHolder holder = (ViewHolder) v.getTag();

        if (isExpanded)
            holder.groupIndicator.setImageResource(R.drawable.ic_expand_less);
        else
            holder.groupIndicator.setImageResource(R.drawable.ic_expand_more);
    }

    protected static class ViewHolder {
        public ImageView groupIndicator;

        public ViewHolder(View itemView) {
            groupIndicator = (ImageView) itemView.findViewById(R.id.group_indicator);
        }
    }
}