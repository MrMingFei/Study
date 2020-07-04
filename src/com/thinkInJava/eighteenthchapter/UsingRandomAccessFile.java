package com.thinkInJava.eighteenthchapter;

import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {

    private static String file = "D:\\ProgramData\\test.txt";
    public static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++){
            System.out.println("Value" + i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rw = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++){
            rw.writeDouble(i * 4.14);
        }
        rw.writeUTF("The end of the file");
        rw.close();
        display();
        rw = new RandomAccessFile(file, "rw");
        rw.seek(5 * 8);
        rw.writeDouble(47.0001);
        rw.close();
        display();
    }
}
