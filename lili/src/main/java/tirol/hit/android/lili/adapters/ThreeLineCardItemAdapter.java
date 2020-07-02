package tirol.hit.android.lili.adapters;

import java.util.List;

import tirol.hit.android.lili.R;
import tirol.hit.android.lili.models.ThreeLineImageItem;

public class ThreeLineCardItemAdapter<T extends ThreeLineImageItem> extends ThreeLineImageItemAdapter<T> {
    public ThreeLineCardItemAdapter(List<T> items, OnListItemActionListener listener) {
        super(items, listener);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.three_line_card_item;
    }
}
