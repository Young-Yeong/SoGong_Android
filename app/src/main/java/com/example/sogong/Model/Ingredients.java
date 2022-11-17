package com.example.sogong.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ingredients {
    @SerializedName("ingre_id")
    @Expose
    private int ingre_id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("unit")
    @Expose
    private String unit;

    @SerializedName("post_id")
    @Expose
    private int post_id;

    @SerializedName("ammount")
    @Expose
    private float ammount;

    public int getIngre_id() {
        return ingre_id;
    }

    public void setIngre_id(int ingre_id) {
        this.ingre_id = ingre_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public float getAmmount() {
        return ammount;
    }

    public void setAmmount(float ammount) {
        this.ammount = ammount;
    }

    public Ingredients(int ingre_id, String name, String unit, int post_id, float ammount) {
        this.ingre_id = ingre_id;
        this.name = name;
        this.unit = unit;
        this.post_id = post_id;
        this.ammount = ammount;
    }
}


//public class Recipe_Ingredients
//{
//    private String unit;
//
//    private String amount;
//
//    private String post_id;
//
//    private String name;
//
//    private String id;
//
//    public String getUnit ()
//    {
//        return unit;
//    }
//
//    public void setUnit (String unit)
//    {
//        this.unit = unit;
//    }
//
//    public String getAmount ()
//    {
//        return amount;
//    }
//
//    public void setAmount (String amount)
//    {
//        this.amount = amount;
//    }
//
//    public String getPost_id ()
//    {
//        return post_id;
//    }
//
//    public void setPost_id (String post_id)
//    {
//        this.post_id = post_id;
//    }
//
//    public String getName ()
//    {
//        return name;
//    }
//
//    public void setName (String name)
//    {
//        this.name = name;
//    }
//
//    public String getId ()
//    {
//        return id;
//    }
//
//    public void setId (String id)
//    {
//        this.id = id;
//    }
//
//    @Override
//    public String toString()
//    {
//        return "ClassPojo [unit = "+unit+", amount = "+amount+", post_id = "+post_id+", name = "+name+", id = "+id+"]";
//    }
//}
