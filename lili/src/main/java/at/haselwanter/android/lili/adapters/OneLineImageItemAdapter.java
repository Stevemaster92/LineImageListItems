package at.haselwanter.android.lili.adapters;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import at.haselwanter.android.lili.R;
import at.haselwanter.android.lili.models.OneLineImageItem;

/**
 * A list adapter for {@link OneLineImageItem}s.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class OneLineImageItemAdapter<T extends OneLineImageItem> extends ListAdapter<T> {
    public OneLineImageItemAdapter(List<T> items, OnListItemActionListener listener) {
        super(items, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        ViewHolder thisHolder = (ViewHolder) holder;
        T item = getItem(position);

        String firstLineText = item.getFirstLine();
        if (!TextUtils.isEmpty(firstLineText)) {
            thisHolder.firstLine.setVisibility(View.VISIBLE);
            thisHolder.firstLine.setText(firstLineText);
        } else {
            thisHolder.firstLine.setVisibility(View.GONE);
        }

        int imageDrawableRes = item.getImageDrawableRes();
        if (imageDrawableRes != 0) {
            thisHolder.image.setVisibility(View.VISIBLE);
            thisHolder.image.setImageResource(imageDrawableRes);
        } else {
            Drawable imageDrawable = item.getImageDrawable();
            if (imageDrawable != null) {
                thisHolder.image.setVisibility(View.VISIBLE);
                thisHolder.image.setImageDrawable(imageDrawable);
            } else {
                Bitmap imageBitmap = item.getImageBitmap();
                if (imageBitmap != null) {
                    thisHolder.image.setVisibility(View.VISIBLE);
                    thisHolder.image.setImageBitmap(imageBitmap);
                } else {
                    thisHolder.image.setVisibility(View.GONE);
                }
            }
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.one_line_image_item;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder createViewHolder(@NonNull View view) {
        return new ViewHolder(view);
    }

    /**
     * This class represents the root view holder for {@link OneLineImageItem}s.
     */
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView firstLine;
        public ImageView image;

        public ViewHolder(View view) {
            super(view);
            firstLine = view.findViewById(R.id.firstLine);
            image = view.findViewById(R.id.image);
        }
    }
}