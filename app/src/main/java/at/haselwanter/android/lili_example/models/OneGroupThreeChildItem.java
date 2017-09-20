package at.haselwanter.android.lili_example.models;

import java.util.List;

import at.haselwanter.android.lili.models.OneLineImageGroupItem;
import at.haselwanter.android.lili_example.R;

/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class OneGroupThreeChildItem extends OneLineImageGroupItem<ThreeLineDummy> {
    public OneGroupThreeChildItem(List<ThreeLineDummy> children) {
        super(0, "First line", R.drawable.ic_android, children);
    }
}
