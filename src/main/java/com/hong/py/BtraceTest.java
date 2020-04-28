package com.hong.py;

import java.io.IOException;

/**
 * author: hongpy
 * create time: 2020-04-27 14:50
 * description:
 * life for code
 */
public class BtraceTest {

    public static void main(String[] args) throws IOException {

        String cmd;
        while (!(cmd = read()).equals("exit")) {
            doAction(cmd);
        }
    }

    private static String read() throws IOException {
        byte[] b = new byte[1024];
        int size = System.in.read(b);
        return new String(b, 0, size).trim();
    }


    public static String doAction(String val) {
        System.out.println("this is :" + val);
        return "哈哈";
    }

}
