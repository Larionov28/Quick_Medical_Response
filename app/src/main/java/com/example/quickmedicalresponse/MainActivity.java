package com.example.quickmedicalresponse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editTextText);
        final TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        // Обработчик события для EditText
        editText.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                // При фокусировке очищаем EditText, если текст "Введи имя" ещё там есть
                if (editText.getText().toString().equals("Введи имя")) {
                    editText.setText("");
                }
            }
        });

        // Обработчик события для кнопки
        button.setOnClickListener(v -> {
            String name = editText.getText().toString();

            // Проверяем, пустое ли поле ввода
            if (!name.isEmpty()) {
                // Выводим текст в TextView с использованием введённого имени
                textView.setText(String.format("Привет '%s' !", name));
            }
        });
    }
}
