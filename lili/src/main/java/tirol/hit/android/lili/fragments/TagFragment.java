package tirol.hit.android.lili.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * The placeholder and root fragment containing default methods for initializing the fragment.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public abstract class TagFragment extends Fragment {
    protected View view;

    protected TagFragment(@LayoutRes int resId) {
        super(resId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = super.onCreateView(inflater, container, savedInstanceState);
            setupViews(savedInstanceState);
        }

        return view;
    }

    /**
     * Returns the tag related to this fragment.
     *
     * @return This fragment's tag.
     */
    @NonNull
    public abstract String getFragmentTag();

    /**
     * Initializes all the views.
     *
     * @param savedInstanceState The previously saved state.
     */
    protected abstract void setupViews(@Nullable Bundle savedInstanceState);
}
