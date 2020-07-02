package tirol.hit.android.lili.adapters;

import java.util.List;

import tirol.hit.android.lili.R;
import tirol.hit.android.lili.models.OneLineImageItem;

public class OneLineCardItemAdapter<T extends OneLineImageItem> extends OneLineImageItemAdapter<T> {
    public OneLineCardItemAdapter(List<T> items, OnListItemActionListener listener) {
        super(items, listener);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.one_line_card_item;
    }
}
