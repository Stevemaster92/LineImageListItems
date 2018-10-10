package at.haselwanter.android.lili_example;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String TAG_LIST_INDEX = "list_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout buttonMenu = findViewById(R.id.button_menu);
        for (int i = 0; i < buttonMenu.getChildCount(); i++) {
            final int index = i;
            buttonMenu.getChildAt(i).setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra(TAG_LIST_INDEX, index);
                startActivity(intent);
            });
        }
    }
}
