package com.thinkInJava.tenthchapter;

public class TestParcel {
    public static void main(String[] args){
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("shijiazhuang");
        //Illegal -- can`t access private class:
        //Parcel4.PContent pc = p.new PContent();
    }
}
class Parcel4{
    private class PContent implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }
    protected class PDestination implements Destination{
        private String label;
        private PDestination(String label){
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }
    public Destination destination(String s){
        return new PDestination(s);
    }
    public Contents contents(){
        return new PContent();
    }
}
