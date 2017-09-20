package at.haselwanter.android.lili.models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

/**
 * A list item containing two lines of text and one image.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public abstract class TwoLineImageItem extends OneLineImageItem {
    protected String secondLine;

    protected TwoLineImageItem(long id, String firstLine, String secondLine, @DrawableRes int image) {
        super(id, firstLine, image);
        this.secondLine = secondLine;
    }

    protected TwoLineImageItem(long id, String firstLine, String secondLine, Drawable image) {
        super(id, firstLine, image);
        this.secondLine = secondLine;
    }

    protected TwoLineImageItem(long id, String firstLine, String secondLine, Bitmap image) {
        super(id, firstLine, image);
        this.secondLine = secondLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    @Override
    public String toString() {
        return "TwoLineImageItem (" + id + ")";
    }
}
