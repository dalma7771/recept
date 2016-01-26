package hu.ektf.receptapp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main2Activity extends AppCompatActivity {
    int kepId;
    String nev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        kepId = getIntent().getIntExtra("kép", 0);
        nev = getIntent().getStringExtra("név");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(nev);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(kepId);
        String sdCard = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(sdCard+"/receptek/"+nev.toLowerCase()+".txt");
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            Reader reader = new InputStreamReader(is,"UTF-8");
            BufferedReader br = new BufferedReader(reader);
            TextView leir = (TextView) findViewById(R.id.textView3);
            String line;
            while ((line = br.readLine()) != null){
                leir.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
