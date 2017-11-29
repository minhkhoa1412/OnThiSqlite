package com.mhkhoa.onthisqlite;

/**
 * Created by thaim on 29/11/2017.
 */

public class CongViec
{
    private int id;
    private String ten;

    public CongViec(int id, String ten)
    {
        this.id = id;
        this.ten = ten;
    }

    public CongViec()
    {
    }

    public CongViec(String ten)
    {
        this.ten = ten;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTen()
    {
        return ten;
    }

    public void setTen(String ten)
    {
        this.ten = ten;
    }
}
