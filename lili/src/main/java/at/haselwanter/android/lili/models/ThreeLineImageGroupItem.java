package at.haselwanter.android.lili.models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

import java.util.List;

/**
 * A group item (expanding list item) containing three lines of text and one image.
 * <p/>
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public abstract class ThreeLineImageGroupItem<T extends OneLineImageItem> extends TwoLineImageGroupItem<T> {
    protected String thirdLine;

    protected ThreeLineImageGroupItem(long id, String firstLine, String secondLine, String thirdLine, @DrawableRes int image, List<T> children) {
        super(id, firstLine, secondLine, image, children);
        this.thirdLine = thirdLine;
    }

    protected ThreeLineImageGroupItem(long id, String firstLine, String secondLine, String thirdLine, Drawable image, List<T> children) {
        super(id, firstLine, secondLine, image, children);
        this.thirdLine = thirdLine;
    }

    protected ThreeLineImageGroupItem(long id, String firstLine, String secondLine, String thirdLine, Bitmap image, List<T> children) {
        super(id, firstLine, secondLine, image, children);
        this.thirdLine = thirdLine;
    }

    public String getThirdLine() {
        return thirdLine;
    }

    @Override
    public String toString() {
        return "ThreeLineImageGroupItem (" + id + ")";
    }
}
