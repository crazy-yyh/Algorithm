package com.yan01.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author yyh
 * @create 2020-10-28 8:39
 */
public class Practices {

    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int i = scanner.nextInt();
       int g = i % 10;
       int s = (i % 100) / 10;
       int b = i / 100;
        System.out.println(b+s+g);
    }
}
