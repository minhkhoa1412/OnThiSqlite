package com.mhkhoa.onthisqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    ListView lstCongViec;
    Button btnThem;
    public static Database database;
    Adapter adapter;
    ArrayList<CongViec> congViecArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        khoiTao();
        suKien();
    }

    private void khoiTao()
    {
        congViecArrayList = new ArrayList<>();
        adapter = new Adapter(getApplicationContext(),congViecArrayList);
        lstCongViec.setAdapter(adapter);

        database = new Database(MainActivity.this,"congviec.sqlite",null,1);
        database.QueryData("CREATE TABLE IF NOT EXISTS CONGVIEC (ID INTEGER PRIMARY KEY AUTOINCREMENT, TENCV NVARCHAR(50) )");

//        database.QueryData("INSERT INTO CONGVIEC VALUES (null , 'Làm bài tập android') ");

        getDuLieu();
    }

    public void getDuLieu()
    {
        Cursor cursor = database.GetData("SELECT * FROM CONGVIEC");
        congViecArrayList.clear();
        while ( cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String ten = cursor.getString(1);
            congViecArrayList.add(new CongViec(id,ten));
        }
        adapter.notifyDataSetChanged();
    }

    private void suKien()
    {
        btnThem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this,ThemActivity.class));
            }
        });

        lstCongViec.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                final int id = congViecArrayList.get(i).getId();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Chắc chưa nè ?");
                builder.setPositiveButton("Xóa đi", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        database.QueryData("DELETE FROM CONGVIEC WHERE ID = '"+ id +"' ");
                        getDuLieu();
                    }
                });
                builder.show();
                return false;
            }
        });

        lstCongViec.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                int id = congViecArrayList.get(i).getId();
                String tencv = congViecArrayList.get(i).getTen();
                Intent intent = new Intent(MainActivity.this,SuaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",id);
                bundle.putString("tencv",tencv);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
    }

    private void anhXa()
    {
        lstCongViec = findViewById(R.id.listviewcongviec);
        btnThem = findViewById(R.id.buttonthem);
    }

    @Override
    protected void onResume()
    {
        getDuLieu();
        super.onResume();
    }
}
