package com.example.quickmedicalresponse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileContentActivity extends AppCompatActivity {


    public static final String FILE_NAME_EXTRA = "file_name";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_content);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрывает нижнюю панель навигации
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // скрывает строку состояния
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        TextView textView = findViewById(R.id.file_content_text_view);

        String fileName = getIntent().getStringExtra(FILE_NAME_EXTRA);

        try {
            assert fileName != null;
            InputStream inputStream = getAssets().open(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }

            textView.setText(stringBuilder.toString());
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            textView.setText("Ошибка чтения файла " + fileName);
        }

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(v -> {
            finish(); // Закрываем текущую активность, чтобы вернуться к MainActivity
        });





    }
}
