package tirol.hit.android.lili.models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;

/**
 * A list item containing three lines of text and one image.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public abstract class ThreeLineImageItem extends TwoLineImageItem {
    protected String thirdLine;

    protected ThreeLineImageItem(long id, String firstLine, String secondLine, String thirdLine, @DrawableRes int image) {
        super(id, firstLine, secondLine, image);
        this.thirdLine = thirdLine;
    }

    protected ThreeLineImageItem(long id, String firstLine, String secondLine, String thirdLine, Drawable image) {
        super(id, firstLine, secondLine, image);
        this.thirdLine = thirdLine;
    }

    protected ThreeLineImageItem(long id, String firstLine, String secondLine, String thirdLine, Bitmap image) {
        super(id, firstLine, secondLine, image);
        this.thirdLine = thirdLine;
    }

    public String getThirdLine() {
        return thirdLine;
    }
}
