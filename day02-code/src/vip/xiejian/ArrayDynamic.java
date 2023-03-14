package vip.xiejian;

import java.util.Scanner;

public class ArrayDynamic {
    public static void main(String[] args) {
        int[] a = new int[10];
        Scanner cin = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            a[i] = cin.nextInt();
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
