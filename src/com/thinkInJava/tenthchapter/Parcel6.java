package com.thinkInJava.tenthchapter;

public class Parcel6 {
    private void internalTracking(boolean b){
        if (b){
            class TrackingSlip{
                private String id;
                TrackingSlip(String id){
                    this.id = id;
                }
                String getSlip(){
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
        //Can`t use it here! Out of scope
        //TrankingSlip ts = new TrankingSlip();
    }
    public void track(){
        internalTracking(true);
    }
    public static void main(String[] args){
        Parcel6 p = new Parcel6();
        p.track();
    }
}
