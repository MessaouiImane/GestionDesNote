package com.example.gestiondesnote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Bulletin> listBulletin=new ArrayList<Bulletin>();

    ArrayAdapter<Bulletin> adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button save=(Button) findViewById(R.id.save);
        TextView MoyenneText = findViewById(R.id.moyenne);
        adapter=new ArrayAdapter<Bulletin>(getApplicationContext(),android.R.layout.simple_list_item_1,listBulletin);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double Moyenne= Double.valueOf(0);

                Spinner mdl=(Spinner) findViewById(R.id.module);
                EditText nt=(EditText) findViewById(R.id.note);

                String module = mdl.getSelectedItem().toString();
                Double note = Double.valueOf(nt.getText().toString());

                Bulletin Mdl1 = new Bulletin(module,note);

                if(!listBulletin.contains(Mdl1)) {
                    listBulletin.add(Mdl1);
                }else {
                    Toast.makeText(getApplicationContext(),"la note est deja saisie ",Toast.LENGTH_SHORT).show();
                }





                for(int i=0;i<listBulletin.size();i++){
                    Moyenne += listBulletin.get(i).getNote();
                }
                Moyenne = Moyenne / listBulletin.size();
                MoyenneText.setText(Moyenne.toString());

                ListView list=(ListView) findViewById(R.id.bulletin);
                list.setAdapter(adapter);
            }
        });
    }

}

