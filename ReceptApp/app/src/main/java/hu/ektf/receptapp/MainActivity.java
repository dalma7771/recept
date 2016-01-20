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
        Recept r = new Recept("Túrógombóc",R.drawable.turogomboc);
        list.add(r);
        ReceptAdapter receptAdapter = new ReceptAdapter(MainActivity.this,list);
        ls.setAdapter(receptAdapter);
    }
}
