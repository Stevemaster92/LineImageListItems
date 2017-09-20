package at.haselwanter.android.lili.models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

import java.util.List;

/**
 * A group item (expanding list item) containing one line of text and one image.
 * <p/>
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public abstract class OneLineImageGroupItem<T extends OneLineImageItem> extends OneLineImageItem implements Expandable<T> {
    private List<T> children;

    protected OneLineImageGroupItem(long id, String firstLine, @DrawableRes int image, List<T> children) {
        super(id, firstLine, image);
        this.children = children;
    }

    protected OneLineImageGroupItem(long id, String firstLine, Drawable image, List<T> children) {
        super(id, firstLine, image);
        this.children = children;
    }

    protected OneLineImageGroupItem(long id, String firstLine, Bitmap image, List<T> children) {
        super(id, firstLine, image);
        this.children = children;
    }

    @Override
    public List<T> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "OneLineImageGroupItem (" + id + ")";
    }
}
