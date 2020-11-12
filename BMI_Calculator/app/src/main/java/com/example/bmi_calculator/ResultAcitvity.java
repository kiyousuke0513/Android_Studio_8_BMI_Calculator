package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class ResultAcitvity extends AppCompatActivity {

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_acitvity);

        TextView textView_BMI = findViewById(R.id.textView_BMI_Val);
        TextView textView_BMI_Determine = findViewById(R.id.textView_BMI_Determine);


        //檢查Intent是否有Extra
        if (this.getIntent().hasExtra("Height") && this.getIntent().hasExtra("Weight"))
        {
            Bundle bundle = this.getIntent().getExtras();

            double Height = bundle.getDouble("Height");
            double Weight = bundle.getDouble("Weight");
            double BMI_Val = Weight/Math.pow((Height/100),2);

            textView_BMI.setText("你的BMI指數為 : " +  String.format("%.2f",BMI_Val));

            if(BMI_Val >= 18.5 && BMI_Val<24)
                textView_BMI_Determine.setText("檢測結果為 : " +  "正常");
            else
                textView_BMI_Determine.setText("檢測結果為 : " +  "異常");
        }
    }

}
