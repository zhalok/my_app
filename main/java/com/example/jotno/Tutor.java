package com.example.jotno;

import java.util.ArrayList;

public class Tutor {
  private String name;
  private String age;
  private String location;
  private String subject;
  private String email;
  private String institute;
  private String department;


  public Tutor(String name,String age,String location,String subject,String email,String institute,String department)
  {
      this.name=name;
      this.age=age;
      this.location=location;
      this.subject=subject;
      this.email=email;
      this.institute=institute;
      this.department=department;
  }
  public Tutor()
  {

  }

  public String getName()
  {
      return name;
  }

   public String getAge()
   {
       return age;
   }

   public String getLocation()
   {
       return location;
   }

   public String getSubject()
   {
       return subject;
   }

   public String getEmail(){return email;}

   public String getInstitute() { return institute; }

   public String getDepartment() { return department; }



   public void setLocation(String location)
   {
       this.location=location;
   }

   public void setDepartment(String department) { this.department=department; }






}
