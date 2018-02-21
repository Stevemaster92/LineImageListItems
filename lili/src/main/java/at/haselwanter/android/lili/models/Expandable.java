package at.haselwanter.android.lili.models;

import java.util.List;

/**
 * The interface for expandable list items.
 * <p/>
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public interface Expandable<T> {
    List<T> getChildren();

    void setChildren(List<T> children);
}
