package at.haselwanter.android.lili.adapters;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import at.haselwanter.android.lili.R;
import at.haselwanter.android.lili.models.ThreeLineImageItem;

/**
 * A list adapter for {@link ThreeLineImageItem}s.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public class ThreeLineImageItemAdapter<T extends ThreeLineImageItem> extends TwoLineImageItemAdapter<T> {
    public ThreeLineImageItemAdapter(List<T> items, OnListItemActionListener listener) {
        super(items, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        ViewHolder thisHolder = (ViewHolder) holder;
        T item = getItem(position);

        String thirdLineText = item.getThirdLine();
        if (!TextUtils.isEmpty(thirdLineText)) {
            thisHolder.thirdLine.setVisibility(View.VISIBLE);
            thisHolder.thirdLine.setText(thirdLineText);
        } else
            thisHolder.thirdLine.setVisibility(View.GONE);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.list_three_line_image_item;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder createViewHolder(@NonNull View view) {
        return new ViewHolder(view);
    }

    /**
     * This class represents the root view holder for {@link ThreeLineImageItem}s.
     */
    protected static class ViewHolder extends TwoLineImageItemAdapter.ViewHolder {
        public TextView thirdLine;

        public ViewHolder(View itemView) {
            super(itemView);
            thirdLine = itemView.findViewById(R.id.third_line);
        }
    }
}