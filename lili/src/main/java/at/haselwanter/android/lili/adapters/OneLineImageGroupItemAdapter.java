package at.haselwanter.android.lili.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import at.haselwanter.android.lili.R;
import at.haselwanter.android.lili.models.OneLineImageGroupItem;

/**
 * A list adapter for {@link OneLineImageGroupItem}s.
 * <p/>
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class OneLineImageGroupItemAdapter<T extends OneLineImageGroupItem> extends GroupItemAdapter<T> {
    public OneLineImageGroupItemAdapter(Context context, List<T> groups) {
        super(context, groups);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.expandable_list_one_line_image_item;
    }

    @Override
    protected void prepareViewHolder(View v) {
        v.setTag(new ViewHolder(v));
    }

    @Override
    protected void populateView(View v, int position) {
        super.populateView(v, position);

        ViewHolder holder = (ViewHolder) v.getTag();
        T item = getItem(position);

        String firstLineText = item.getFirstLine();
        if (!TextUtils.isEmpty(firstLineText)) {
            holder.firstLine.setVisibility(View.VISIBLE);
            holder.firstLine.setText(firstLineText);
        } else
            holder.firstLine.setVisibility(View.GONE);

        int imageDrawableRes = item.getImageDrawableRes();
        if (imageDrawableRes != 0) {
            holder.image.setVisibility(View.VISIBLE);
            holder.image.setImageResource(imageDrawableRes);
        } else {
            Drawable imageDrawable = item.getImageDrawable();
            if (imageDrawable != null) {
                holder.image.setVisibility(View.VISIBLE);
                holder.image.setImageDrawable(imageDrawable);
            } else {
                Bitmap imageBitmap = item.getImageBitmap();
                if (imageBitmap != null) {
                    holder.image.setVisibility(View.VISIBLE);
                    holder.image.setImageBitmap(imageBitmap);
                } else {
                    holder.image.setVisibility(View.GONE);
                }
            }
        }
    }

    /**
     * This class represents the root view holder for {@link OneLineImageGroupItem}s.
     */
    protected static class ViewHolder extends GroupItemAdapter.ViewHolder {
        public TextView firstLine;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            firstLine = itemView.findViewById(R.id.first_line);
            image = itemView.findViewById(R.id.image);
        }
    }
}