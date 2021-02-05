package com.example.jotno;

public class Requester {

    private String name;
    private String number;

    Requester(String name,String number)
    {
        this.name=name;
        this.number=number;
    }

    Requester(){}


    public void setName(String name)

    {
        this.name=name;
    }

    public void setNumber(String number)
    {
        this.number=number;
    }

    public String getName()
    {
        return name;
    }

    public String getNumber()
    {
        return number;
    }




}
