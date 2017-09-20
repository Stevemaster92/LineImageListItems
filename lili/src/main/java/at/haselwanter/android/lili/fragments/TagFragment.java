package at.haselwanter.android.lili.fragments;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * The placeholder and root fragment containing default methods for initializing the fragment.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public abstract class TagFragment extends Fragment {
    protected View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(getLayoutResource(), container, false);
            setupViews();
        }

        return view;
    }

    /**
     * Returns the tag related to this fragment.
     *
     * @return This fragment's tag.
     */
    public abstract String getFragmentTag();

    /**
     * Returns the current layout resource.
     *
     * @return The layout resource.
     */
    @LayoutRes
    protected abstract int getLayoutResource();

    /**
     * Initializes all views.
     */
    protected abstract void setupViews();
}
