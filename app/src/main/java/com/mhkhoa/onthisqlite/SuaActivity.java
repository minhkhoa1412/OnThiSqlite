package com.mhkhoa.onthisqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SuaActivity extends AppCompatActivity
{
    EditText edtSua;
    Button btnSua;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua);
        anhXa();
        getDataIntent();
        suKien();
    }

    private void getDataIntent()
    {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        id = bundle.getInt("id");
        String tencv = bundle.getString("tencv");

        edtSua.setText(tencv);
    }

    private void suKien()
    {
        btnSua.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                MainActivity.database.QueryData("UPDATE CONGVIEC SET TENCV = '"+edtSua.getText().toString()+"' WHERE ID = '"+ id +"' ");
                finish();
            }
        });
    }

    private void anhXa()
    {
        btnSua = findViewById(R.id.buttonsuacv);
        edtSua = findViewById(R.id.edittextsua);
    }
}
