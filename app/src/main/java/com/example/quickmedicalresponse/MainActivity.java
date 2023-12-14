package com.example.quickmedicalresponse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
        ImageView imageView = findViewById(R.id.imageView);

        BriefInfo.setVisibility(View.GONE);
        FullInfo.setVisibility(View.GONE);

        ScanButton.setOnClickListener(v -> {
            IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
            integrator.setPrompt(" ");
            integrator.setCameraId(0); // Используем заднюю камеру для сканирования, если нужно
            integrator.initiateScan();
            NameMed.setText("");
            BriefMed.setText("");
            imageView.setImageResource(R.drawable.back8);
            NameMed.setBackground(null);
            BriefMed.setBackground(null);
            BriefInfo.setVisibility(View.GONE);
            FullInfo.setVisibility(View.GONE);
        });

        BriefInfo.setOnClickListener(v -> {
            String medicineName = NameMed.getText().toString();
            BriefMed.setBackgroundResource(R.drawable.textview_border1);
            switch (medicineName) {
                case "Мукалтин": {
                    String medicineInfo = "Это медицинский препарат, который часто используется для лечения заболеваний дыхательных путей. Он обладает отхаркивающим действием, помогая разжижать и удалять мокроту из дыхательных путей. Это делает его полезным для лечения кашля, связанного с такими состояниями, как бронхит, трахеит и другие заболевания.";
                    BriefMed.setText(medicineInfo); break;
                }
                case "Валидол": {
                    String medicineInfo = "Это медицинский препарат, используемый для облегчения сердечных болей, связанных с невротическими расстройствами и легкими приступами стенокардии. Он также помогает при укачивании и уменьшает чувство тревоги. Активным компонентом Валидола является ментол, который оказывает седативное и вазодилатирующее действие.";
                    BriefMed.setText(medicineInfo); break;
                }
                case "ТАЙЛОЛ ХОТ": {
                    String medicineInfo = "Это комбинированный медицинский препарат, который обычно используется для облегчения симптомов простуды и гриппа. Он может включать в себя такие компоненты, как парацетамол, фенилэфрин, аскорбиновая кислота (витамин С) и другие ингредиенты.";
                    BriefMed.setText(medicineInfo); break;
                }
                case "Перекись водорода": {
                    String medicineInfo = "Это медицинский препарат, который используется для дезинфекции и очистки ран, таких как порезы, царапины и ожоги. Она эффективна в уничтожении бактерий, предотвращении инфекций и ускорении процесса заживления. Также перекись водорода может использоваться для удаления мертвых тканей из ран, что способствует более быстрому их заживлению.";
                    BriefMed.setText(medicineInfo); break;
                }
                case "Линкас": {
                    String medicineInfo = "Это медицинский бальзам на натуральной основе, используемый для облегчения симптомов простуды и кашля. Он помогает уменьшить заложенность носа, облегчает дыхание и снижает раздражение в горле, вызванное кашлем. Благодаря своим успокаивающим и отхаркивающим свойствам, он облегчает выведение мокроты и уменьшает частоту кашля.";
                    BriefMed.setText(medicineInfo); break;
                }
                case "НО-ШПА": {
                    String medicineInfo = "Это медицинский препарат, который используется для облегчения спазмов гладкой мускулатуры в различных органах. Она эффективна при болях в животе, вызванных спазмами кишечника, желчного пузыря или желчевыводящих путей, а также при спазмах мочевыводящих путей, включая уретеральные колики.";
                    BriefMed.setText(medicineInfo); break;
                }
                case "Люголит": {
                    String medicineInfo = "Это препарат, который часто используется для лечения заболеваний горла и рта. Он содержит йод, который обладает антисептическими свойствами, помогая уничтожать микробы и уменьшать воспаление. Люголь применяется при ларингите, фарингите, тонзиллите и других инфекционных и воспалительных заболеваниях горла.";
                    BriefMed.setText(medicineInfo); break;
                }
                default:
                    BriefMed.setBackground(null);
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

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(v -> finish());

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FileContentActivity.class);
            intent.putExtra(FileContentActivity.FILE_NAME_EXTRA, "about.txt");
            startActivity(intent);
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        TextView NameMed = findViewById(R.id.textView2);
        ImageView imageView = findViewById(R.id.imageView);
        Button BriefInfo = findViewById(R.id.button2);
        Button FullInfo = findViewById(R.id.button3);
        if (result != null) {
            if (result.getContents() == null) {
                new Handler().postDelayed(() ->
                        Toast.makeText(this, "Сканирование отменено", Toast.LENGTH_SHORT).show(), 600);
            } else {
                NameMed.setText(result.getContents());
                imageView.setImageResource(R.drawable.back9);
                NameMed.setBackgroundResource(R.drawable.textview_border1);
                BriefInfo.setVisibility(View.VISIBLE);
                FullInfo.setVisibility(View.VISIBLE);
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
