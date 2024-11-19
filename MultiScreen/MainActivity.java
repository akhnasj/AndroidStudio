package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final String MSG = "com.example.multiscreen.ORDER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void placeOrder(View view){
        Intent intent = new Intent(this, OrderActivity.class);
        EditText item1 = findViewById(R.id.editText1);
        EditText item2 = findViewById(R.id.editText2);
        EditText item3 = findViewById(R.id.editText3);

        String message = "Order for " +item1.getText().toString()+ ", " +item2.getText().toString()+ " & " +item3.getText().toString()+ " has been successfully placed!";
        intent.putExtra(MSG, message);
        startActivity(intent);
    }
}