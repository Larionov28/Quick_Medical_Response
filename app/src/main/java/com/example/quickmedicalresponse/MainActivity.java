package com.example.quickmedicalresponse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.media.MediaPlayer;


public class MainActivity extends AppCompatActivity {

    private TextView textView; // Объявление переменной для TextView

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.red));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView); // Находим TextView по его ID

        Button button5 = findViewById(R.id.button5);
        TextView textView = findViewById(R.id.textView);
        TextView textView3 = findViewById(R.id.textView3);

        button5.setOnClickListener(v -> {
            String medicineName = textView.getText().toString();
            switch (medicineName) {
                case "Мукалтин": {
                    String medicineInfo = "Препарат от кашля и заболеваний дыхательных путей. Для взрослых и детей от 12 лет рекомендуется принимать 1-2 таблетки 2-3 раза в день перед едой.";
                    textView3.setText(medicineInfo);
                    break;
                }
                case "Валидол": {
                    String medicineInfo = "Успокаивающее средство для облегчения стенокардии, морской болезни, истерии и головной боли от нитратов. Принимается под язык: для взрослых 1-2 таблетки до полного рассасывания до 4 раз в день до 7 дней.";
                    textView3.setText(medicineInfo);
                    break;
                }
                case "ТАЙЛОЛ ХОТ": {
                    String medicineInfo = "Препарат помогает при простуде и гриппе, а также симптомах верхних дыхательных путей. Принимается, растворяя содержимое пакета в горячей воде и выпивая. Для взрослых максимальная суточная доза - 4 пакета.";
                    textView3.setText(medicineInfo);
                    break;
                }
                case "Перекись водорода": {
                    String medicineInfo = "Препарат помогает при воспалениях и гнойных ранах. Наносят на повреждения кожи или слизистую ватным тампоном, смоченным раствором препарата. Не для полоскания полостей.";
                    textView3.setText(medicineInfo);
                    break;
                }
                case "Линкас": {
                    String medicineInfo = "Мазь для симптоматического лечения простуды, помогает с кашлем, заложенностью носа и болями в мышцах. Наносится на грудь или область боли 3-4 раза в день на протяжении 7 дней.";
                    textView3.setText(medicineInfo);
                    break;
                }
                case "НО-ШПА": {
                    String medicineInfo = "Препарат помогает при спазмах в желчевыводящих, мочевыводящих путях, животе, головной боли. Для взрослых - 1-2 таблетки до 3 раз в день, детям от 6 до 12 лет - по 1 таблетке до 2 раз в день. Не для беременных и детей до 6 лет.";
                    textView3.setText(medicineInfo);
                    break;
                }
                case "Люголит": {
                    String medicineInfo = "Антисептик для горла, применяется как спрей при ангине и проблемах с горлом. Не для беременных и детей до 8 лет.";
                    textView3.setText(medicineInfo);
                    break;
                }
                default:
                    Toast.makeText(getApplicationContext(), "Такого препарата нет в базе данных", Toast.LENGTH_SHORT).show();
                    break;
            }
        });



        Button scanButton = findViewById(R.id.scanButton);
        scanButton.setOnClickListener(v -> {
            IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
            integrator.setPrompt(" ");
            integrator.setCameraId(0); // Используем заднюю камеру для сканирования, если нужно
            integrator.initiateScan();
            textView.setText("");
            textView3.setText("");
        });

        Button button7 = findViewById(R.id.button7);

        button7.setOnClickListener(v -> {
            TextView textView1 = findViewById(R.id.textView);

            String medicineName = textView1.getText().toString();

            switch (medicineName) {
                case "Мукалтин": {
                    Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
                    intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "mucaltin.txt");
                    startActivity(intent);
                    break;
                }
                case "Валидол": {
                    Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
                    intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "validol.txt");
                    startActivity(intent);
                    break;
                }
                case "ТАЙЛОЛ ХОТ": {
                    Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
                    intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "tailolhot.txt");
                    startActivity(intent);
                    break;
                }
                case "Перекись водорода": {
                    Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
                    intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "perekis.txt");
                    startActivity(intent);
                    break;
                }
                case "Линкас": {
                    Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
                    intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "linkas.txt");
                    startActivity(intent);
                    break;
                }
                case "НО-ШПА": {
                    Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
                    intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "noshpa.txt");
                    startActivity(intent);
                    break;
                }
                case "Люголит": {
                    Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
                    intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "lugol.txt");
                    startActivity(intent);
                    break;
                }
                default:
                    Toast.makeText(getApplicationContext(), "Такого препарата нет в базе данных", Toast.LENGTH_SHORT).show();
                    break;
            }
        });

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.audio); // Замените на имя вашего аудиофайла
        // Освободить ресурсы MediaPlayer после окончания воспроизведения
        mediaPlayer.setOnCompletionListener(MediaPlayer::release);

        mediaPlayer.start(); // Начать воспроизведение аудио

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
