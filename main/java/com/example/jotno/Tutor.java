package com.example.jotno;

public class Tutor {
    private String name;
    private String age;
    private String location;
    private String subject;

    Tutor(String name,String age,String location,String subject)
    {
        this.name=name;
        this.age=age;
        this.location=location;
        this.subject=subject;

    }

    public void setName(String name)
    {
        this.name=name;
    }

    public void setAge(String age)
    {
        this.age=age;
    }

    public void setLocation(String location)
    {
        this.location=location;
    }

    public void setSubject(String subject)
    {
        this.subject=subject;
    }



}
