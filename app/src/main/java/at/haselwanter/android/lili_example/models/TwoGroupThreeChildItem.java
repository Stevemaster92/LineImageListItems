package at.haselwanter.android.lili_example.models;

import java.util.List;

import at.haselwanter.android.lili.models.TwoLineImageGroupItem;
import at.haselwanter.android.lili_example.R;

/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class TwoGroupThreeChildItem extends TwoLineImageGroupItem<ThreeLineDummy> {
    public TwoGroupThreeChildItem(List<ThreeLineDummy> children) {
        super(0, "First line", "Second line", R.drawable.ic_android_blue, children);
    }
}
