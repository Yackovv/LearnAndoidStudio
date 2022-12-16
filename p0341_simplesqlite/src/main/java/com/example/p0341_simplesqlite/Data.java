package com.example.p0341_simplesqlite;

public class Data {
    private final String name;
    private final String email;
    private int id;

     public Data(String name, String email){
         this.name = name;
         this.email = email;
     }

     public Data(String name, String email, int id){
         this.name = name;
         this.email = email;
         this.id = id;
     }

     public String getName(){
         return name;
     }

     public String getEmail(){
         return email;
     }

     public int getId(){
         return id;
     }
}
