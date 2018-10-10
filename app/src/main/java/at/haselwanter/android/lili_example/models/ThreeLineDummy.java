package at.haselwanter.android.lili_example.models;

import at.haselwanter.android.lili.models.ThreeLineImageItem;
import at.haselwanter.android.lili_example.R;

/**
 * Created by Stefan Haselwanter on 15.09.2017.
 */

public class ThreeLineDummy extends ThreeLineImageItem {
    public ThreeLineDummy(long id, String name, String position, String description) {
        super(id, name, position, description, R.drawable.ic_android);
    }
}
