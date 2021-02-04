package com.example.jotno;

public class Tutor {
  private String name;
  private String age;
  private String location;
  private String subject;
  private String email;

  public Tutor(String name,String age,String location,String subject,String email)
  {
      this.name=name;
      this.age=age;
      this.location=location;
      this.subject=subject;
      this.email=email;
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

   public void setLocation(String location)
   {
       this.location=location;
   }








}
