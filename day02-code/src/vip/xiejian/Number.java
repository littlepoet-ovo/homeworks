package vip.xiejian;

import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.print("请输入一个三位数：");
        int num = cin.nextInt();
        System.out.println("个位是："+num%10);
        num /= 10;
        System.out.println("十位是："+num%10);
        num /= 10;
        System.out.println("百位是："+num%10);

    }
}
