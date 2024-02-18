package com.example.quickmedicalresponse;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.os.Bundle;
import android.view.View;

public class MainActivity5 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрывает нижнюю панель навигации
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // скрывает строку состояния
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        int imageResourceId = getIntent().getIntExtra("imageResourceId", android.R.color.transparent);

        RelativeLayout layout = findViewById(R.id.main_activity5_layout);
        layout.setBackgroundResource(imageResourceId);
    }
}