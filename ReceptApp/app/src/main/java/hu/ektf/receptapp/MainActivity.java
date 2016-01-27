package hu.ektf.receptapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView ls = (ListView)findViewById(R.id.listView);
        ArrayList<Recept> list = new ArrayList<>();
        Recept r = new Recept("vmi",R.mipmap.turogomboc);
        list.add(r);
        Recept r2 = new Recept("Rántott tejbegríz",R.mipmap.tejbegriz);
        list.add(r2);
        ReceptAdapter receptAdapter = new ReceptAdapter(MainActivity.this,list);
        ls.setAdapter(receptAdapter);
    }
}
