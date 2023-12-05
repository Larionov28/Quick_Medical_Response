package com.example.quickmedicalresponse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
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
    }
}
