package com.example.quickmedicalresponse;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    private TextView textView; // Объявление переменной для TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView); // Находим TextView по его ID

        Button scanButton = findViewById(R.id.scanButton);
        scanButton.setOnClickListener(v -> {
            IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
            integrator.setPrompt(" ");
            integrator.setCameraId(0); // Используем заднюю камеру для сканирования, если нужно
            integrator.initiateScan();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                // Сообщение о том, что сканирование было отменено с задержкой в 5 секунд
                new Handler().postDelayed(() ->
                        Toast.makeText(this, "Сканирование отменено", Toast.LENGTH_SHORT).show(), 600);
            } else {
                // Устанавливаем результат сканирования в TextView
                textView.setText(result.getContents());
                // Сообщение о том, что сканирование прошло успешно с задержкой в 5 секунд
                new Handler().postDelayed(() ->
                        Toast.makeText(this, "Сканирование успешно", Toast.LENGTH_SHORT).show(), 600);
            }
        } else {
            // Сообщение о том, что сканирование не выполнено с задержкой в 5 секунд
            new Handler().postDelayed(() ->
                    Toast.makeText(this, "Сканирование не выполнено", Toast.LENGTH_SHORT).show(), 600);
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
