package com.example.bmical;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText edtWeight,edtHeightft,edtHeightin;
        Button  btncalc;
        TextView txtResult;

        edtWeight=findViewById(R.id.edtWeight);
        edtHeightft=findViewById(R.id.edtHeightft);
        edtHeightin=findViewById(R.id.edtHeightin);
        btncalc=findViewById(R.id.btncalc);
        txtResult=findViewById(R.id.txtResult);

        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt=Integer.parseInt(edtWeight.getText().toString());
                int ft=Integer.parseInt(edtHeightft.getText().toString());
                int in=Integer.parseInt(edtHeightin.getText().toString());

                int totalIn=ft*12+in;
                double totalcm=totalIn*2.53;
                double totalM=totalcm/100;
                double bmi=wt/(totalM*totalM);

                if(bmi>25){
                    txtResult.setText("You r overweigh");
                } else if (bmi<18) {
                    txtResult.setText("You r underWeight");
                }else {
                    txtResult.setText("You are Healthy");
                }
            }
        });
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}