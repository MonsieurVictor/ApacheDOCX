package com.samosvat.diplom;
import com.google.gson.Gson;

public class JSONTemp {
    public void start(){
            String json = "{\"nestedPojo\":[{\"name\":null, \"value\":42}]}";
            Gson gson = new Gson();
            gson.fromJson(json, Pojo.class);
        }
    }


    class Pojo {
        NestedPojo[] nestedPojo;
    }

    class NestedPojo {
        String name;
        int value;
    }

