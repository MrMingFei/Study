package com.thinkInJava.tenthchapter;

public class Parcel10 {
    public Destination destination(final String dest, final float price){
        return new Destination() {
            private int coast;
            {
                coast = Math.round(price);
                if (coast > 100){
                    System.out.println("Over budget!");
                }
            }
            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }
    public static void main(String[] args){
        Parcel10 p = new Parcel10();
        Destination d = p.destination("shijiazhuang", 101.233F);
    }
}
