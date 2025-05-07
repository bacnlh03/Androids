package com.example.activitiforresult;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    private int[] listButtonID2 = {R.id.btnLower, R.id.btnUpper};
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        init1();
    }
    public void init1(){
        editText = findViewById(R.id.edtTitle);
        for(int id:listButtonID2) {
            Button btnTemp1 = (Button) findViewById(id);
            btnTemp1.setOnClickListener(this);
        }
    }
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }
    @Override
    public void onClick(View view) {
        Intent intent = getIntent();
        if (TextUtils.isEmpty(editText.getText().toString())) {
            showToast("Bạn chưa nhập dữ liệu");
        } else {
            int viewId = view.getId();
            if (viewId == R.id.btnLower) {
                intent.putExtra("yourTitle", editText.getText().toString());
                setResult(MainActivity.RESULT_CODE_LOWER, intent);
                finish();
            } else if (viewId == R.id.btnUpper) {
                intent.putExtra("yourTitle", editText.getText().toString());
                setResult(MainActivity.RESULT_CODE_UPPER, intent);
                finish();
            }
        }
    }
}