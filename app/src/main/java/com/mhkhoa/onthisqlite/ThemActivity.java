package com.mhkhoa.onthisqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThemActivity extends AppCompatActivity
{
    EditText edtCongViec;
    Button btnThem;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);
        anhXa();
        suKien();
    }

    private void suKien()
    {
        btnThem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String tencv = edtCongViec.getText().toString();
                MainActivity.database.QueryData("INSERT INTO CONGVIEC VALUES (null , '" +tencv+ "')");
                finish();
            }
        });
    }

    private void anhXa()
    {
        edtCongViec = findViewById(R.id.edittextthemcv);
        btnThem = findViewById(R.id.buttonthem);
    }
}
