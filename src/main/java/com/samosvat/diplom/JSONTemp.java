package com.samosvat.diplom;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONTemp {

    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public void start(){
            String json = "{\"nestedPojo\":[{\"name\":null, \"value\":42}]}";
            Gson gson = new Gson();
            gson.fromJson(json, NestedPojo.class);

            NestedPojo pojo = GSON.fromJson(json, NestedPojo.class);
            System.out.println(GSON.toJson(pojo));
            System.out.println(pojo.name);
            System.out.println(pojo.value);
        }
    }

    class Pojo {
        NestedPojo[] nestedPojo;
    }

class NestedPojo {
    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    String name;
    int value;
}

