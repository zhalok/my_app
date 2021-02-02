package com.example.jotno;

public class Tutor {
  private String name;
  private String age;
  private String location;
  private String subject;

  public Tutor(String name,String age,String location,String subject)
  {
      this.name=name;
      this.age=age;
      this.location=location;
      this.subject=subject;
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







}
