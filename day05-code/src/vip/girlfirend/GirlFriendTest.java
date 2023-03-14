package vip.girlfirend;

import java.util.Scanner;

public class GirlFriendTest {
    public static void main(String[] args) {
        GirlFriend person = new GirlFriend();
        Scanner cin = new Scanner(System.in);
        System.out.println("请输入npy名字：");
        person.setName(cin.next());
        person.setHigh(cin.nextDouble());
        System.out.println("女朋友的名字是：" + person.getName());
        System.out.println("女朋友的身高是：" + person.getHigh());
        System.out.println("你好"+123+' '+1.25+'我');
        int[] b = new int[5];
        b[0]=1;
        b[1]=2;
        b[5]=3;


    }
}
