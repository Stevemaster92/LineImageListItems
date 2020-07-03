package tirol.hit.android.lili.adapters;

import java.util.List;

import tirol.hit.android.lili.R;
import tirol.hit.android.lili.models.OneLineImageItem;

/**
 * A list adapter for {@link OneLineImageItem}s.
 * <p/>
 * Created by Stefan Haselwanter on 02.07.2020.
 */
public class OneLineCardItemAdapter<T extends OneLineImageItem> extends OneLineImageItemAdapter<T> {
    public OneLineCardItemAdapter() {
        super();
    }

    public OneLineCardItemAdapter(List<T> items) {
        super(items);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.one_line_card_item;
    }
}
