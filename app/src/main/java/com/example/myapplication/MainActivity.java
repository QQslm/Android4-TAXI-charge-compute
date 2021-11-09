package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Rate;
    EditText Per_Meter;
    EditText Extra_charge;
    EditText Distance;
    float CHARGE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Rate = findViewById(R.id.editTextNumber2);// 取得目標物件
        Per_Meter = findViewById(R.id.editTextNumber3);// 取得目標物件
        Extra_charge = findViewById(R.id.editTextNumber4);// 取得目標物件
        Distance = findViewById(R.id.editTextNumber5);// 取得目標物件
    }
    public void translate(View view) {
        try {
            if (!("".equals(Rate.getText().toString()))||!("".equals(Per_Meter.getText().toString()))||!("".equals(Extra_charge.getText().toString()))){
                TextView Fee = findViewById(R.id.textView3);
                float RATE = Float.parseFloat(Rate.getEditableText().toString());
                float PER_METER = Float.parseFloat(Per_Meter.getEditableText().toString());
                float EXTRA_CHARGE = Float.parseFloat(Extra_charge.getEditableText().toString());
                float DISTANCE = Float.parseFloat(Distance.getEditableText().toString());
                if(DISTANCE%PER_METER!=0) {
                    CHARGE = RATE+(DISTANCE/PER_METER+1)*EXTRA_CHARGE;
                }
                else{
                    CHARGE = RATE+(DISTANCE/PER_METER)*EXTRA_CHARGE;
                }
                Fee.setText("費用:"+CHARGE); //Display更改為輸入資料
            }

        }
        catch(Exception e){
                Toast.makeText(this, "PLEASE INPUT CORRECT DATA", Toast.LENGTH_SHORT).show();
            }

        }

}