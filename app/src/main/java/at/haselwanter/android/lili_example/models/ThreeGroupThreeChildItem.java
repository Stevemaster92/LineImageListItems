package at.haselwanter.android.lili_example.models;

import java.util.List;

import at.haselwanter.android.lili.models.ThreeLineImageGroupItem;
import at.haselwanter.android.lili_example.R;

/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */
public class ThreeGroupThreeChildItem extends ThreeLineImageGroupItem<ThreeLineDummy> {
    public ThreeGroupThreeChildItem(List<ThreeLineDummy> children) {
        super(0, "First line", "Second line", "Third line", R.drawable.ic_android, children);
    }
}