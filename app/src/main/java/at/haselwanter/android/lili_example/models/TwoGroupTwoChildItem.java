package at.haselwanter.android.lili_example.models;

import java.util.List;

import at.haselwanter.android.lili.models.TwoLineImageGroupItem;
import at.haselwanter.android.lili_example.R;

/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class TwoGroupTwoChildItem extends TwoLineImageGroupItem<TwoLineDummy> {
    public TwoGroupTwoChildItem(List<TwoLineDummy> children) {
        super(0, "First line", "Second line", R.drawable.ic_android_blue, children);
    }
}
