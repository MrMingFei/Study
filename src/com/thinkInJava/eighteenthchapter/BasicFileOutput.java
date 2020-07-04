package com.thinkInJava.eighteenthchapter;

import java.io.*;

public class BasicFileOutput {

    private static String file = "F:\\git_repository\\Study\\src\\com\\thinkInJava\\eighteenthchapter\\BasicFileOutput.java";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("D:\\ProgramData\\test.txt")));
        PrintWriter out = new PrintWriter("D:\\ProgramData\\test.txt");

        int lineCount = 0;
        String s;
        while ((s = in.readLine()) != null){
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
