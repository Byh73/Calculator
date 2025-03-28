package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
boolean active = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView heart = findViewById(R.id.heart);
        heart.setOnClickListener(v -> {
            if(active){
                heart.setImageResource(R.drawable.heart ) ;
                active =false;
            }else {
                heart.setImageResource(R.drawable.active_heart);
                active = true;
            }
        });
        Spinner spinner = findViewById(R.id.spinner2);
        String[] items = {"item 1", "item 2", "item 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>( SecondActivity.this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        findViewById(R.id.butt).setOnClickListener(view -> {
            finish();
        });

        Bundle bundle = getIntent().getBundleExtra("BUNDLE");
        TextView text = findViewById(R.id.result);
        text.setText(bundle.getString("RESULT"));
    }
}