package org.rudn.timeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String Date;
    TextView GetDateAndTime;
    Button BtnTime;

    EditText inputText;
    TextView textView;
    Button btnName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        inputText = (EditText) findViewById(R.id.inputText);

        btnName = (Button) findViewById(R.id.btnName);


        View.OnClickListener oclbtnName = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", inputText.getText().toString());
                startActivity(intent);
            }
        };

        btnName.setOnClickListener(oclbtnName);


        GetDateAndTime=findViewById(R.id.getDateAndTime);
        BtnTime=findViewById(R.id.btnTime);
        calendar=Calendar.getInstance();
        simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date=simpleDateFormat.format(calendar.getTime());

        BtnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetDateAndTime.setText(Date);
            }
        });

    }

//    public void updateText(View view) {
//        textView.setText("Hi " + inputText.getText());
//
//        System.out.println("Button clicked");
//    }
}