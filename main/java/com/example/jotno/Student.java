package com.example.jotno;

public class Student {
    private String name;
    private String phone;

    Student()
    {

    }

    Student(String name,String phone)
    {
        this.name=name;
        this.phone=phone;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
