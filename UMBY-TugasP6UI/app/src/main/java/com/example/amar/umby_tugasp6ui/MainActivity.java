package com.example.amar.umby_tugasp6ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt_nim, txt_nama;
    RadioGroup gender;
    RadioButton jkLk, jkPr;
    CheckBox cb_hobi_1, cb_hobi_2, cb_hobi_3, cb_hobi_4;
    Button btn_view, btn_exit;
    TextView txt_hasil_nim, txt_hasil_nama, txt_hasil_jk, txt_hasil_agama, txt_hasil_hobi;

    Spinner optAgama;
    String[] list_agama = {"Islam", "Kristen", "Katolik", "Hindu", "Budha", "Konghucu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nim = (EditText) findViewById(R.id.txt_nim);
        txt_nama = (EditText) findViewById(R.id.txt_nama);
        gender = (RadioGroup) findViewById(R.id.gender);
        jkLk = (RadioButton) findViewById(R.id.jkLk);
        jkPr = (RadioButton) findViewById(R.id.jkPr);

        cb_hobi_1 = (CheckBox) findViewById(R.id.cb_hobi_1);
        cb_hobi_2 = (CheckBox) findViewById(R.id.cb_hobi_2);
        cb_hobi_3 = (CheckBox) findViewById(R.id.cb_hobi_3);
        cb_hobi_4 = (CheckBox) findViewById(R.id.cb_hobi_4);

        btn_view = (Button) findViewById(R.id.btn_view);
        btn_exit = (Button) findViewById(R.id.btn_exit);

        txt_hasil_nim = (TextView) findViewById(R.id.txt_hasil_nim);
        txt_hasil_nim.setText(": ");
        txt_hasil_nama = (TextView) findViewById(R.id.txt_hasil_nama);
        txt_hasil_nama.setText(": ");
        txt_hasil_jk = (TextView) findViewById(R.id.txt_hasil_jk);
        txt_hasil_jk.setText(": ");
        txt_hasil_agama = (TextView) findViewById(R.id.txt_hasil_agama);
        txt_hasil_agama.setText(": ");
        txt_hasil_hobi = (TextView) findViewById(R.id.txt_hasil_hobi);
        txt_hasil_hobi.setText(": ");

        optAgama = (Spinner) findViewById(R.id.optAgama);
        optAgama.setPrompt("Pilih Agama");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list_agama);
        optAgama.setAdapter(adapter);
        optAgama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_view = (Button) findViewById(R.id.btn_view);
        btn_view.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(txt_nim.getText().toString().equals("") && txt_nama.getText().toString().equals("")) {
                    Toast.makeText(getBaseContext(), "NIM dan Nama tidak boleh kosong !", Toast.LENGTH_SHORT).show();
                }else{
                    detail();
                }
            }
        });

        btn_exit = (Button) findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                AlertDialog.Builder dialogKonfirmasi = new AlertDialog.Builder(MainActivity.this);
                dialogKonfirmasi.setCancelable(false);
                dialogKonfirmasi.setMessage("Apakah anda ingin keluar dari aplikasi ini ?");
                dialogKonfirmasi.setTitle("Konfirmasi");

                dialogKonfirmasi.setPositiveButton("Ya", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        MainActivity.this.finish();
                    }
                });

                dialogKonfirmasi.setNegativeButton("Tidak", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                });

                dialogKonfirmasi.create().show();
            }
        });
    }

    public void detail(){
        // Result View
        txt_hasil_nim.setText(": "+txt_nim.getText());
        txt_hasil_nama.setText(": "+txt_nama.getText());
        if(jkLk.isChecked()) {
            txt_hasil_jk.setText(": "+jkLk.getText());
        }else if(jkPr.isChecked()){
            txt_hasil_jk.setText(": "+jkPr.getText());
        }else{
            txt_hasil_jk.setText(": ");
        }

         txt_hasil_agama.setText(": "+optAgama.getSelectedItem());

        int check_hobi = 0;
        String str_hobi = ": ";
        if(cb_hobi_1.isChecked()) {
            str_hobi += cb_hobi_1.getText();
            if(cb_hobi_2.isChecked() || cb_hobi_3.isChecked() || cb_hobi_4.isChecked()) {
                str_hobi += ", ";
            }
        }
        if(cb_hobi_2.isChecked()) {
            str_hobi += cb_hobi_2.getText();
            if(cb_hobi_3.isChecked() || cb_hobi_4.isChecked()) {
                str_hobi += ", ";
            }
        }
        if(cb_hobi_3.isChecked()) {
            str_hobi += cb_hobi_3.getText();
            if(cb_hobi_4.isChecked()) {
                str_hobi += ", ";
            }
        }
        if(cb_hobi_4.isChecked()) {
            str_hobi += cb_hobi_4.getText();
        }

        txt_hasil_hobi.setText(str_hobi);
    }
}
