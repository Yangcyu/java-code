package pers.ycy.javacode.system;

public class MyException extends Exception {
    public MyException(String message) {
            super(message);
    }

    public MyException(int code,String message) {
        super(message);
    }
}