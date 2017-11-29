package com.mhkhoa.onthisqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by thaim on 29/11/2017.
 */

public class Adapter extends BaseAdapter
{
    Context context;
    ArrayList<CongViec> congViecArrayList;
    LayoutInflater inflater;


    public Adapter (Context context , ArrayList<CongViec> congViecArrayList)
    {
        this.context = context;
        this.congViecArrayList = congViecArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return congViecArrayList.size();
    }

    @Override
    public Object getItem(int i)
    {
        return congViecArrayList.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = inflater.inflate(R.layout.item,null);
        TextView txtID = view.findViewById(R.id.textviewid);
        TextView txtCV = view.findViewById(R.id.textviewcv);
        txtID.setText(String.valueOf(congViecArrayList.get(i).getId()));
        txtCV.setText(congViecArrayList.get(i).getTen());
        return view;
    }
}
