package com.example.quickmedicalresponse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity {
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

        TextView NameMed = findViewById(R.id.textView2);
        TextView BriefMed = findViewById(R.id.textView3);
        Button ScanButton = findViewById(R.id.button);
        Button BriefInfo = findViewById(R.id.button2);
        Button FullInfo = findViewById(R.id.button3);

        ScanButton.setOnClickListener(v -> {
            IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
            integrator.setPrompt(" ");
            integrator.setCameraId(0); // Используем заднюю камеру для сканирования, если нужно
            integrator.initiateScan();
            NameMed.setText("");
            BriefMed.setText("");
        });

        BriefInfo.setOnClickListener(v -> {
            String medicineName = NameMed.getText().toString();
            switch (medicineName) {
                case "Мукалтин": {
                    String medicineInfo = "Препарат от кашля и заболеваний дыхательных путей. Для взрослых и детей от 12 лет рекомендуется принимать 1-2 таблетки 2-3 раза в день перед едой.";
                    BriefMed.setText(medicineInfo); break;
                }
                case "Валидол": {
                    String medicineInfo = "Успокаивающее средство для облегчения стенокардии, морской болезни, истерии и головной боли от нитратов. Принимается под язык: для взрослых 1-2 таблетки до полного рассасывания до 4 раз в день до 7 дней.";
                    BriefMed.setText(medicineInfo); break;
                }
                case "ТАЙЛОЛ ХОТ": {
                    String medicineInfo = "Препарат помогает при простуде и гриппе, а также симптомах верхних дыхательных путей. Принимается, растворяя содержимое пакета в горячей воде и выпивая. Для взрослых максимальная суточная доза - 4 пакета.";
                    BriefMed.setText(medicineInfo); break;
                }
                case "Перекись водорода": {
                    String medicineInfo = "Препарат помогает при воспалениях и гнойных ранах. Наносят на повреждения кожи или слизистую ватным тампоном, смоченным раствором препарата. Не для полоскания полостей.";
                    BriefMed.setText(medicineInfo); break;
                }
                case "Линкас": {
                    String medicineInfo = "Мазь для симптоматического лечения простуды, помогает с кашлем, заложенностью носа и болями в мышцах. Наносится на грудь или область боли 3-4 раза в день на протяжении 7 дней.";
                    BriefMed.setText(medicineInfo); break;
                }
                case "НО-ШПА": {
                    String medicineInfo = "Препарат помогает при спазмах в желчевыводящих, мочевыводящих путях, животе, головной боли. Для взрослых - 1-2 таблетки до 3 раз в день, детям от 6 до 12 лет - по 1 таблетке до 2 раз в день. Не для беременных и детей до 6 лет.";
                    BriefMed.setText(medicineInfo); break;
                }
                case "Люголит": {
                    String medicineInfo = "Антисептик для горла, применяется как спрей при ангине и проблемах с горлом. Не для беременных и детей до 8 лет.";
                    BriefMed.setText(medicineInfo); break;
                }
                default:
                    Toast.makeText(getApplicationContext(), "Такого препарата нет в базе данных", Toast.LENGTH_SHORT).show(); break;
            }
        });

        FullInfo.setOnClickListener(v -> {
            TextView textView1 = findViewById(R.id.textView2);
            String medicineName = textView1.getText().toString();
            switch (medicineName) {
                case "Мукалтин": {
                    Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
                    intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "mucaltin.txt");
                    startActivity(intent); break;
                }
                case "Валидол": {
                    Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
                    intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "validol.txt");
                    startActivity(intent); break;
                }
                case "ТАЙЛОЛ ХОТ": {
                    Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
                    intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "tailolhot.txt");
                    startActivity(intent); break;
                }
                case "Перекись водорода": {
                    Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
                    intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "perekis.txt");
                    startActivity(intent); break;
                }
                case "Линкас": {
                    Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
                    intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "linkas.txt");
                    startActivity(intent); break;
                }
                case "НО-ШПА": {
                    Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
                    intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "noshpa.txt");
                    startActivity(intent); break;
                }
                case "Люголит": {
                    Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
                    intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "lugol.txt");
                    startActivity(intent); break;
                }
                default:
                    Toast.makeText(getApplicationContext(), "Такого препарата нет в базе данных", Toast.LENGTH_SHORT).show(); break;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        TextView NameMed = findViewById(R.id.textView2);
        if (result != null) {
            if (result.getContents() == null) {
                new Handler().postDelayed(() ->
                        Toast.makeText(this, "Сканирование отменено", Toast.LENGTH_SHORT).show(), 600);
            } else {
                NameMed.setText(result.getContents());
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
