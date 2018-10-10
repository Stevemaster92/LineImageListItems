package at.haselwanter.android.lili.models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

/**
 * A list item containing one line of text and one image.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public abstract class OneLineImageItem implements Comparable<OneLineImageItem> {
    protected long id;
    protected String firstLine;
    protected int imageDrawableRes;
    protected Drawable imageDrawable;
    protected Bitmap imageBitmap;

    protected OneLineImageItem(long id, String firstLine, @DrawableRes int image) {
        this.id = id;
        this.firstLine = firstLine;
        this.imageDrawableRes = image;
    }

    protected OneLineImageItem(long id, String firstLine, Drawable image) {
        this.id = id;
        this.firstLine = firstLine;
        this.imageDrawable = image;
    }

    protected OneLineImageItem(long id, String firstLine, Bitmap image) {
        this.id = id;
        this.firstLine = firstLine;
        this.imageBitmap = image;
    }

    public long getId() {
        return id;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public int getImageDrawableRes() {
        return imageDrawableRes;
    }

    public Drawable getImageDrawable() {
        return imageDrawable;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    @Override
    public int compareTo(@NonNull OneLineImageItem o) {
        return Long.valueOf(id).compareTo(o.id);
    }

    @Override
    public String toString() {
        return "OneLineImageItem (" + id + ")";
    }
}
