package at.haselwanter.android.lili_example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    public static final String TAG_LIST_INDEX = "list_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout buttonMenu = findViewById(R.id.button_menu);
        for (int i = 0; i < buttonMenu.getChildCount(); i++) {
            final int index = i;
            buttonMenu.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ListActivity.class);
                    intent.putExtra(TAG_LIST_INDEX, index);
                    startActivity(intent);
                }
            });
        }
    }
}
