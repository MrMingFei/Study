package com.thinkInJava.thirteenth;

import static com.thinkInJava.mylibraries.Print.print;

public class DatabaseException extends Exception {
    public DatabaseException(int transactionID, int queryID, String msg){
        super(String.format("(t%d, q%d) %s", transactionID, queryID, msg));
    }
    public static void main(String[] args){
        try {
            throw new DatabaseException(3, 7, "Write failed");
        }catch (DatabaseException e){
            print(e);
        }
    }
}
