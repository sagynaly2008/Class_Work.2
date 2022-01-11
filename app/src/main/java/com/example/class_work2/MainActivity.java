package com.example.class_work2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText editText, editText2, editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.send);
        editText = findViewById(R.id.et_gmail);
        editText3 = findViewById(R.id.et_text);
        editText2 = findViewById(R.id.et_username);
        btn.setOnClickListener(view -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "abc@mail.com", null));
            emailIntent.putExtra(Intent.EXTRA_EMAIL, editText.getText().toString());
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, editText2.getText().toString());
            emailIntent.putExtra(Intent.EXTRA_TEXT, editText3.getText().toString());
            startActivity(Intent.createChooser(emailIntent, "Send Email..."));
        });
    }
}