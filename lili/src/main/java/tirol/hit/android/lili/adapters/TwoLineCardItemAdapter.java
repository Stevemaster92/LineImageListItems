package tirol.hit.android.lili.adapters;

import java.util.List;

import tirol.hit.android.lili.R;
import tirol.hit.android.lili.models.TwoLineImageItem;

public class TwoLineCardItemAdapter<T extends TwoLineImageItem> extends TwoLineImageItemAdapter<T> {
    public TwoLineCardItemAdapter(List<T> items, OnListItemActionListener listener) {
        super(items, listener);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.two_line_card_item;
    }
}
