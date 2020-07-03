package tirol.hit.android.lili.adapters;

import java.util.List;

import tirol.hit.android.lili.R;
import tirol.hit.android.lili.models.TwoLineImageItem;

/**
 * A list adapter for {@link TwoLineImageItem}s.
 * <p/>
 * Created by Stefan Haselwanter on 02.07.2020.
 */
public class TwoLineCardItemAdapter<T extends TwoLineImageItem> extends TwoLineImageItemAdapter<T> {
    public TwoLineCardItemAdapter() {
        super();
    }

    public TwoLineCardItemAdapter(List<T> items) {
        super(items);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.two_line_card_item;
    }
}
