package com.thinkInJava.twelfth;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static com.thinkInJava.mylibraries.Print.print;

public class InputFile {
    private BufferedReader in;
    public InputFile(String fname) throws Exception{
        try {
            in = new BufferedReader(new FileReader(fname));
        }catch (FileNotFoundException e){
            print("Could not open " + fname);
            //Was not open, so do not close it
            throw e;
        }catch (Exception e){
            //All other exceptions must close it
            try {
                in.close();
            }catch (IOException ie){
                print("in.close() unsuccessful");
            }
            throw e;
        }finally {
            //Do not close it here
        }
    }
    public String getLine(){
        String s;
        try {
            s = in.readLine();
        }catch (IOException e){
            throw new RuntimeException("readLie() failed");
        }
        return s;
    }
    public void dispose(){
        try {
            in.close();
            print("dispose() successful");
        }catch (IOException ie){
            throw new RuntimeException("in.close failed");
        }
    }
}
