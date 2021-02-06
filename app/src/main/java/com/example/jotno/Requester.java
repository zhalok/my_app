package com.example.jotno;

public class Requester {

    private String name;
    private String number;
    private String tutor_email;

    Requester(String name,String number,String tutor_email)
    {
        this.name=name;
        this.number=number;
        this.tutor_email=tutor_email;
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

    public void setTutor_email(String tutor_email) {
        this.tutor_email = tutor_email;
    }

    public String getName()
    {
        return name;
    }

    public String getNumber()
    {
        return number;
    }

    public String getTutor_email() {
        return tutor_email;
    }
}
