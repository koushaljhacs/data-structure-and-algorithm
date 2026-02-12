package practice;

import java.util.Scanner;

public class test {
    // static variable: same copy provide
    // 
    // instance variable: each object make own copy from original object

    String Student; // null
    int rollNo; // 0

    test() {
        System.out.println("this is constructor");
    }
    public static void main(String[] args) {
        test t1 = new test();
        System.out.println("this is main method execution");
    }
}
