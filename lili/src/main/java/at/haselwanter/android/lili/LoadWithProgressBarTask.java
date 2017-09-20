package at.haselwanter.android.lili;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * An asynchronous task for loading data while displaying a progress bar with optional text during the loading process.
 * <p/>
 * Created by Stefan Haselwanter on 14.09.2017.
 */
public abstract class LoadWithProgressBarTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    private View progressBar;
    private ViewGroup parent;
    private boolean isProgressBarVisible;

    protected LoadWithProgressBarTask(Context context, ViewGroup parent, String loadingText) {
        this.parent = parent;
        isProgressBarVisible = false;
        initProgressBar(context, loadingText);
    }

    @Override
    protected void onPreExecute() {
        showProgressBar();
    }

    @Override
    protected Result doInBackground(Params... params) {
        if (isCancelled())
            hideProgressBar();

        return null;
    }

    @Override
    protected void onPostExecute(Result result) {
        hideProgressBar();
    }

    @Override
    protected void onCancelled() {
        hideProgressBar();
    }

    /**
     * Hides the progress bar inside the parent layout.
     */
    protected void hideProgressBar() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                if (isProgressBarVisible) {
                    isProgressBarVisible = false;
                    if (parent instanceof ListView)
                        ((ListView) parent).removeFooterView(progressBar);
                    else if (progressBar.getParent() != null)
                        parent.removeViewAt(0);
                }
            }
        });

    }

    /**
     * Shows the progress bar inside the parent layout.
     */
    protected void showProgressBar() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                if (!isProgressBarVisible) {
                    isProgressBarVisible = true;

                    if (parent instanceof ListView)
                        ((ListView) parent).addFooterView(progressBar);
                    else if (progressBar.getParent() == null)
                        parent.addView(progressBar, 0);
                }
            }
        });
    }

    /**
     * Initializes the progress bar.
     */
    private void initProgressBar(Context context, final String loadingText) {
        progressBar = LayoutInflater.from(context).inflate(R.layout.loading_item, null);

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                ((TextView) progressBar.findViewById(R.id.loading_text)).setText(loadingText);
            }
        });
    }
}
