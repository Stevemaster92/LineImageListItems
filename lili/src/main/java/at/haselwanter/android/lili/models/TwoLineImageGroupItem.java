package at.haselwanter.android.lili.models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

import java.util.List;

/**
 * A group item (expanding list item) containing two lines of text and one image.
 * <p/>
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public abstract class TwoLineImageGroupItem<T extends OneLineImageItem> extends OneLineImageGroupItem<T> {
    protected String secondLine;

    protected TwoLineImageGroupItem(long id, String firstLine, String secondLine, @DrawableRes int image, List<T> children) {
        super(id, firstLine, image, children);
        this.secondLine = secondLine;
    }

    protected TwoLineImageGroupItem(long id, String firstLine, String secondLine, Drawable image, List<T> children) {
        super(id, firstLine, image, children);
        this.secondLine = secondLine;
    }

    protected TwoLineImageGroupItem(long id, String firstLine, String secondLine, Bitmap image, List<T> children) {
        super(id, firstLine, image, children);
        this.secondLine = secondLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    @Override
    public String toString() {
        return "TwoLineImageGroupItem (" + id + ")";
    }
}
