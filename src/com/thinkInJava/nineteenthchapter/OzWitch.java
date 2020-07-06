package com.thinkInJava.nineteenthchapter;

public enum OzWitch {
    WEST("Miss Gulch"),
    NORTH("Glinda, the good"),
    EAST("Wicked Witch of"),
    SOUTH("Good by");

    private String des;
    private OzWitch(String des){
        this.des = des;
    }

    public String getDes(){
        return des;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()){
            System.out.println(witch + ": " + witch.getDes());
        }
    }
}
