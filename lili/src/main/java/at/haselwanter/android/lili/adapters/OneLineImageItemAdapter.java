package at.haselwanter.android.lili.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import at.haselwanter.android.lili.R;
import at.haselwanter.android.lili.models.OneLineImageItem;

/**
 * A list adapter for {@link OneLineImageItem}s.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class OneLineImageItemAdapter<T extends OneLineImageItem> extends ListAdapter<T> {
    public OneLineImageItemAdapter(Context context, List<T> items) {
        super(context, items);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.list_one_line_image_item;
    }

    @Override
    protected void prepareViewHolder(View v) {
        ViewHolder holder = new ViewHolder();
        holder.firstLine = (TextView) v.findViewById(R.id.first_line);
        holder.image = (ImageView) v.findViewById(R.id.image);

        v.setTag(holder);
    }

    @Override
    protected void populateView(View v, int position) {
        ViewHolder holder = (ViewHolder) v.getTag();
        T item = getItem(position);

        String firstLineText = item.getFirstLine();
        if (firstLineText != null && !firstLineText.equals("")) {
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
     * This class represents the root view holder for {@link OneLineImageItem}s.
     */
    protected static class ViewHolder {
        public TextView firstLine;
        public ImageView image;
    }
}