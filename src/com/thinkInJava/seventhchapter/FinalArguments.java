package com.thinkInJava.seventhchapter;

public class FinalArguments {
    void with(final Gizmo gizmo){
        //! gizmo = new Gizmo();// Error： gizmo is final
    }
    void without(Gizmo gizmo){
        gizmo = new Gizmo();
        gizmo.spin();
    }
    //! void f(final int i){ i++ }//Cannot change
    int g(final int i){ return i + 1; }
    public static void main(String[] args){
        FinalArguments fa = new FinalArguments();
        fa.with(null);
        fa.without(null);
    }

}
class
Gizmo{
    public void spin(){}
}
