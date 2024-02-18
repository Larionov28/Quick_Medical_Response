package com.example.quickmedicalresponse;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.media.MediaPlayer;


public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрывает нижнюю панель навигации
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // скрывает строку состояния
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        ImageButton ScanButton = findViewById(R.id.ScanButton);
        ScanButton.setOnClickListener(v -> {
            IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
            integrator.setPrompt(" ");
            integrator.setCameraId(0); // Используем заднюю камеру для сканирования, если нужно
            integrator.initiateScan();
        });

        ImageButton imageButton10 = findViewById(R.id.imageButton10);
        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton11 = findViewById(R.id.imageButton11);
        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        ImageButton button1 = findViewById(R.id.imageButton4);
        ImageButton button2 = findViewById(R.id.imageButton5);
        ImageButton button3 = findViewById(R.id.imageButton6);
        ImageButton button4 = findViewById(R.id.imageButton7);
        ImageButton button5 = findViewById(R.id.imageButton8);

        button1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("buttonToHide", 1);
            startActivity(intent);
        });

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("buttonToHide", 2);
            startActivity(intent);
        });

        button3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("buttonToHide", 3);
            startActivity(intent);
        });

        button4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("buttonToHide", 4);
            startActivity(intent);
        });

        button5.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("buttonToHide", 5);
            startActivity(intent);
        });

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
                Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
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
