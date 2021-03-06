package tirol.hit.android.lili.models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;

import tirol.hit.android.lili.models.OneLineImageItem;

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
}
