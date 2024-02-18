package com.example.quickmedicalresponse;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрывает нижнюю панель навигации
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // скрывает строку состояния
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        ImageButton imageButton2 = findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity4.this, MainActivity.class);
            startActivity(intent);
        });

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
            startActivity(intent);
        });

        ImageButton ScanButton = findViewById(R.id.scanButton);
        ScanButton.setOnClickListener(v -> {
            IntentIntegrator integrator = new IntentIntegrator(MainActivity4.this);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
            integrator.setPrompt(" ");
            integrator.setCameraId(0); // Используем заднюю камеру для сканирования, если нужно
            integrator.initiateScan();
        });

        ImageButton imageButton13 = findViewById(R.id.imageButton13);
        ImageButton imageButton14 = findViewById(R.id.imageButton14);
        ImageButton imageButton17 = findViewById(R.id.imageButton17);
        ImageButton imageButton18 = findViewById(R.id.imageButton18);
        ImageButton imageButton19 = findViewById(R.id.imageButton19);
        ImageButton imageButton20 = findViewById(R.id.imageButton20);

        imageButton13.setOnClickListener(v -> startMainActivity5(R.drawable.map1));

        imageButton14.setOnClickListener(v -> startMainActivity5(R.drawable.map2));

        imageButton17.setOnClickListener(v -> startMainActivity5(R.drawable.map3));

        imageButton18.setOnClickListener(v -> startMainActivity5(R.drawable.map4));

        imageButton19.setOnClickListener(v -> startMainActivity5(R.drawable.map5));

        imageButton20.setOnClickListener(v -> startMainActivity5(R.drawable.map6));


    }


    private void startMainActivity5(int imageResourceId) {
        Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
        intent.putExtra("imageResourceId", imageResourceId);
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                new Handler().postDelayed(() ->
                        Toast.makeText(this, "Сканирование отменено", Toast.LENGTH_SHORT).show(), 600);
            } else {
                String scannedData = result.getContents();
                Intent intent = new Intent(MainActivity4.this, FileContentActivity.class);
                intent.putExtra("QR_DATA", scannedData);
                startActivity(intent);
                new Handler().postDelayed(() ->
                        Toast.makeText(this, "Сканирование успешно", Toast.LENGTH_SHORT).show(), 600);

            }
        } else {
            new Handler().postDelayed(() ->
                    Toast.makeText(this, "Сканирование не выполнено", Toast.LENGTH_SHORT).show(), 600);
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}