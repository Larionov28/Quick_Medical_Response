package com.example.quickmedicalresponse;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.media.MediaPlayer;

public class FileContentActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

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

        TextView textView2 = findViewById(R.id.file_content_text_view);
        ImageButton BriefInfo = findViewById(R.id.imageButton1);
        ImageButton FullInfo = findViewById(R.id.imageButton2);
        String scannedData = getIntent().getStringExtra("QR_DATA");
        TextView textView1 = findViewById(R.id.textView);
        textView1.setText(scannedData);



        BriefInfo.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.release(); // Освободить ресурсы предыдущего mediaPlayer, если он существует
            }
            if (textView2 != null) {
                textView2.setText(""); // Освободить ресурсы предыдущего mediaPlayer, если он существует
            }
            String medicineName = textView1.getText().toString();
            switch (medicineName) {
                case "Тримол": {
                    mediaPlayer = MediaPlayer.create(this, R.raw.tri); // Создать новый mediaPlayer
                    mediaPlayer.setOnCompletionListener(MediaPlayer::release); // Освободить ресурсы после окончания воспроизведения
                    mediaPlayer.start();
                    try {
                        InputStream inputStream = getAssets().open("triK.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Ибупрофен": {
                    mediaPlayer = MediaPlayer.create(this, R.raw.ibu); // Создать новый mediaPlayer
                    mediaPlayer.setOnCompletionListener(MediaPlayer::release); // Освободить ресурсы после окончания воспроизведения
                    mediaPlayer.start();
                    try {
                        InputStream inputStream = getAssets().open("ibuK.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Карвалол": {
                    mediaPlayer = MediaPlayer.create(this, R.raw.kar); // Создать новый mediaPlayer
                    mediaPlayer.setOnCompletionListener(MediaPlayer::release); // Освободить ресурсы после окончания воспроизведения
                    mediaPlayer.start();
                    try {
                        InputStream inputStream = getAssets().open("karvK.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Валидол": {
                    mediaPlayer = MediaPlayer.create(this, R.raw.val); // Создать новый mediaPlayer
                    mediaPlayer.setOnCompletionListener(MediaPlayer::release); // Освободить ресурсы после окончания воспроизведения
                    mediaPlayer.start();
                    try {
                        InputStream inputStream = getAssets().open("valK.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Лактамед": {
                    mediaPlayer = MediaPlayer.create(this, R.raw.lak); // Создать новый mediaPlayer
                    mediaPlayer.setOnCompletionListener(MediaPlayer::release); // Освободить ресурсы после окончания воспроизведения
                    mediaPlayer.start();
                    try {
                        InputStream inputStream = getAssets().open("lakK.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Флорак форте": {
                    mediaPlayer = MediaPlayer.create(this, R.raw.flo); // Создать новый mediaPlayer
                    mediaPlayer.setOnCompletionListener(MediaPlayer::release); // Освободить ресурсы после окончания воспроизведения
                    mediaPlayer.start();
                    try {
                        InputStream inputStream = getAssets().open("floK.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Антигриппин Китайский": {
                    mediaPlayer = MediaPlayer.create(this, R.raw.anti); // Создать новый mediaPlayer
                    mediaPlayer.setOnCompletionListener(MediaPlayer::release); // Освободить ресурсы после окончания воспроизведения
                    mediaPlayer.start();
                    try {
                        InputStream inputStream = getAssets().open("antiK.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Линьхуа Цинвэнь": {
                    mediaPlayer = MediaPlayer.create(this, R.raw.lan); // Создать новый mediaPlayer
                    mediaPlayer.setOnCompletionListener(MediaPlayer::release); // Освободить ресурсы после окончания воспроизведения
                    mediaPlayer.start();
                    try {
                        InputStream inputStream = getAssets().open("lanK.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Респиро": {
                    mediaPlayer = MediaPlayer.create(this, R.raw.res); // Создать новый mediaPlayer
                    mediaPlayer.setOnCompletionListener(MediaPlayer::release); // Освободить ресурсы после окончания воспроизведения
                    mediaPlayer.start();
                    try {
                        InputStream inputStream = getAssets().open("resK.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Лоратал": {
                    mediaPlayer = MediaPlayer.create(this, R.raw.lor); // Создать новый mediaPlayer
                    mediaPlayer.setOnCompletionListener(MediaPlayer::release); // Освободить ресурсы после окончания воспроизведения
                    mediaPlayer.start();
                    try {
                        InputStream inputStream = getAssets().open("lorK.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                default:
                    assert textView2 != null;
                    textView2.setBackground(null);
                    Toast.makeText(getApplicationContext(), "Такого препарата нет в базе данных", Toast.LENGTH_SHORT).show(); break;
            }
        });

        FullInfo.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.release(); // Освободить ресурсы предыдущего mediaPlayer, если он существует
            }
            if (textView2 != null) {
                textView2.setText(""); // Освободить ресурсы предыдущего mediaPlayer, если он существует
            }
            String medicineName = textView1.getText().toString();
            switch (medicineName) {
                case "Тримол": {
                    try {
                        InputStream inputStream = getAssets().open("triP.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Ибупрофен": {
                    try {
                        InputStream inputStream = getAssets().open("ibuP.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Карвалол": {
                    try {
                        InputStream inputStream = getAssets().open("karvP.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Валидол": {
                    try {
                        InputStream inputStream = getAssets().open("valP.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Лактамед": {
                    try {
                        InputStream inputStream = getAssets().open("lakP.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Флорак форте": {
                    try {
                        InputStream inputStream = getAssets().open("floP.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Антигриппин Китайский": {
                    try {
                        InputStream inputStream = getAssets().open("antiP.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Линьхуа Цинвэнь": {
                    try {
                        InputStream inputStream = getAssets().open("lanP.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Респиро": {
                    try {
                        InputStream inputStream = getAssets().open("resP.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Лоратал": {
                    try {
                        InputStream inputStream = getAssets().open("lorP.txt");
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        String medicineInfo = stringBuilder.toString();
                        assert textView2 != null;
                        textView2.setText(medicineInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                default:
                    assert textView2 != null;
                    textView2.setBackground(null);
                    Toast.makeText(getApplicationContext(), "Такого препарата нет в базе данных", Toast.LENGTH_SHORT).show(); break;
            }
        });


    }
}
