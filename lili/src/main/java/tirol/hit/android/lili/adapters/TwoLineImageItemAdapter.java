package tirol.hit.android.lili.adapters;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tirol.hit.android.lili.R;
import tirol.hit.android.lili.models.TwoLineImageItem;

/**
 * A list adapter for {@link TwoLineImageItem}s.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class TwoLineImageItemAdapter<T extends TwoLineImageItem> extends OneLineImageItemAdapter<T> {
    public TwoLineImageItemAdapter() {
        super();
    }

    public TwoLineImageItemAdapter(List<T> items) {
        super(items);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        ViewHolder thisHolder = (ViewHolder) holder;
        T item = getItem(position);

        String secondLineText = item.getSecondLine();
        if (!TextUtils.isEmpty(secondLineText)) {
            thisHolder.secondLine.setVisibility(View.VISIBLE);
            thisHolder.secondLine.setText(secondLineText);
        } else {
            thisHolder.secondLine.setVisibility(View.GONE);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.two_line_image_item;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder createViewHolder(@NonNull View view) {
        return new ViewHolder(view);
    }

    /**
     * This class represents the root view holder for {@link TwoLineImageItem}s.
     */
    protected static class ViewHolder extends OneLineImageItemAdapter.ViewHolder {
        public TextView secondLine;

        public ViewHolder(View itemView) {
            super(itemView);
            secondLine = itemView.findViewById(R.id.second_line);
        }
    }
}