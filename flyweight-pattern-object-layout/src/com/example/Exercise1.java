package com.example;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
    public static void main(String[] args) {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(A.class).toPrintable());
    }

}

class A {
    byte b;
    short s;
    int i;
    long l;
    char c;
    boolean x;
    float f;
    double d;
    B r;
}

class B {
    int x;
    short s1;
    short s2;
    byte b1;
    byte b2;
    byte b3;
    byte b4;
    byte b5;
    byte b6;
}