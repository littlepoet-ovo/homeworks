package String.project;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String str = cin.nextLine();
        char[] s = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            s[i] = c;
        }
        for (int i = 0; i < s.length; i++) {
            if(s[i]>='a' && s[i]<='z') s[i] = (char)(s[i]-('a'-'A'));
        }
        String str2 = new String(s);
        System.out.println(str2);

    }
}
