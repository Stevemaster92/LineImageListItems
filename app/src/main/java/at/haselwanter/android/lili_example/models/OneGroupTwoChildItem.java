package at.haselwanter.android.lili_example.models;

import java.util.List;

import at.haselwanter.android.lili.models.OneLineImageGroupItem;
import at.haselwanter.android.lili_example.R;

/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class OneGroupTwoChildItem extends OneLineImageGroupItem<TwoLineDummy> {
    public OneGroupTwoChildItem(List<TwoLineDummy> children) {
        super(0, "First line", R.drawable.ic_android_blue, children);
    }
}
