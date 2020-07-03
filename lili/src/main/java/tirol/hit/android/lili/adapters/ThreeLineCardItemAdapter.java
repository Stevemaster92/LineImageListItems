package tirol.hit.android.lili.adapters;

import java.util.List;

import tirol.hit.android.lili.R;
import tirol.hit.android.lili.models.ThreeLineImageItem;

/**
 * A list adapter for {@link ThreeLineImageItem}s.
 * <p/>
 * Created by Stefan Haselwanter on 02.07.2020.
 */
public class ThreeLineCardItemAdapter<T extends ThreeLineImageItem> extends ThreeLineImageItemAdapter<T> {
    public ThreeLineCardItemAdapter() {
        super();
    }

    public ThreeLineCardItemAdapter(List<T> items) {
        super(items);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.three_line_card_item;
    }
}
