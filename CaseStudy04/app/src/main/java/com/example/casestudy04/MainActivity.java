package com.example.casestudy04;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText edtHoTen,edtNamSinh;
    private Button btnSubmit;
    private TextView textViewKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHoTen = (EditText) findViewById(R.id.edtHoTen);
        edtNamSinh = (EditText) findViewById(R.id.edtNamSinh);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        textViewKetQua = (TextView) findViewById(R.id.textViewKetQua);
        textViewKetQua.setText(getIntent().getStringExtra("strTuoi"));
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            //1900
            public void onClick(View view) {
                int tuoi = 0;
                try {
                    Calendar c = Calendar.getInstance();
                    int namHienTai =  c.get(Calendar.YEAR);
                    tuoi  =( namHienTai -  Integer.parseInt(edtNamSinh.getText() + ""));
                }catch (Exception ex){

                }
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("Ten",new String(edtHoTen.getText().toString()));
                intent.putExtra("NamSinh",new String(edtNamSinh.getText().toString()));
                intent.putExtra("Tuoi",new String(tuoi +""));
                startActivityForResult(intent,999);
            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == 999 && requestCode == RESULT_OK){
//            textViewKetQua.setText(data.getStringExtra("strTuoi"));
//        }
//    }
}