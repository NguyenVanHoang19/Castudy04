package com.example.casestudy04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {

    private TextView textViewKetQua;
    private EditText edtTuoi;
    private Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewKetQua = (TextView) findViewById(R.id.textViewKetQua);
        btnExit = (Button) findViewById(R.id.btnExit);
        edtTuoi = (EditText) findViewById(R.id.edtNhapTuoi);
        textViewKetQua.setText("Tên: "+getIntent().getExtras().getString("Ten")+"\n"+"Năm Sinh: " +getIntent().getExtras().getString("NamSinh")+"\n"+"Tuổi: "+getIntent().getExtras().getString("Tuoi")+"\n");
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                intent.putExtra("strTuoi",edtTuoi.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}