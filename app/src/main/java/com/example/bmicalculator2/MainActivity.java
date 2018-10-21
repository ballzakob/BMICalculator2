package com.example.bmicalculator2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bmicalculator2.model.Body;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button calculateButton = findViewById(R.id.calculator_button);
        calculateButton.setOnClickListener(new View.OnClickListener() { //
            @Override
            public void onClick(View view) {
                EditText heightEditText = findViewById(R.id.height_edit_text);
                EditText weightEditText = findViewById(R.id.weight_edit_text);

                int h = Integer.parseInt(heightEditText.getText().toString());
                int w = Integer.parseInt(weightEditText.getText().toString());
                Body body = new Body(h,w);

                float bmi = body.calculateBmi();

                //String msg = "Value BMI is "+String.format(Locale.US,"%.2f",bmi);
                String msg = "เกณฑ์น้ำหนักของคุณ: "+body.getResultText();

                Toast t =Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG);
                t.show();
                //Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
                //Toast มันจะโปว์แปปเดียว

                // ต่อไปนี้จะทำให้เป็นหน้าต่างแสดงมาเลย
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Result");
                dialog.setMessage(msg);
                // 47-47 ทำการ set dialog

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo : Code ที่ให้ทำเมื่อ User คลิก OK ใน dialog
                    }
                });
                dialog.setNegativeButton("No",null);
                dialog.setCancelable(false);
                //todo : ถ้าไม่ใส่ dialog.setCancelable(false); เราจะสามารถออกจากหน้าต่างของ dialog โดยการกดข้างนอกปุ่มได้ แต่ถ้าใส่ เราต้องกดปุ่มใน dialog เท่านั้นจึงจะออกจากหน้าต่างของ dialog ได้
                dialog.show();
                //todo : show dialog

                //todo :สามารถเขียนdialog อีกแบบได้ เช่น บรรทัดที่ 75-79
                //new AlertDialog.Builder(MainActivity.this)
                // .setTitle("Result")
                // .setMessage(msg)
                // .setPositiveButton("OK",nul)
                // .setNegativeButton("No",null).show;

                //todo : libraly Glide เป็น libraly ที่เอาไว้โหลดรูปจาก internet (บรรทัด 82)
                //Glide.with(context).load(URL).into(imageview);
            }
        });
    }

}
