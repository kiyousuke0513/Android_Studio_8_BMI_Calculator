package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView textView_output = findViewById(R.id.textView_Output);

        //檢查Intent是否有Extra，以判別是否是由ActivityB跳轉過來
        //if (this.getIntent().hasExtra("Input_Text")) {
            //Bundle bundle = this.getIntent().getExtras();
            //接收自ActivityB名為Input_Text的資料
            //String Output_Text = bundle.getString("Input_Text");
            //textView_output.setText(Output_Text);
        //}
    }



    public void BTN_TRIG(View view) {
        EditText editText_Height = findViewById(R.id.editTextNumber_Height);
        EditText editText_Weight = findViewById(R.id.editTextNumber_Weight);

        if( !String.valueOf(editText_Height.getText()).equals("")
        &&  !String.valueOf(editText_Weight.getText()).equals(""))
        {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ResultAcitvity.class);

            Bundle bundle = new Bundle();//建立Bundle以傳送資料

            double Height = Double.parseDouble(editText_Height.getText().toString());
            double Weight = Double.parseDouble(editText_Weight.getText().toString());

            bundle.putDouble("Height", Height);
            bundle.putDouble("Weight", Weight);

            intent.putExtras(bundle);//將Bundle物件put給intent

            startActivity(intent);

            //MainActivity.this.finish();//結束目前 Activity
        }
        else
            Toast.makeText(this,"請輸入完整訊息!",Toast.LENGTH_SHORT).show();
    }
}

