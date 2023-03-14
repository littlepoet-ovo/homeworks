package vip.xiejian;

import java.util.Scanner;

public class work1 {
    public static void main(String[] args) {
        int n,N=50010;
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        int[] a = new int[N];
        int[] s = new int[N];
        for (int i = 1; i <= n; i++) {
            a[i] = cin.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            s[i]=s[i-1]+a[i];
        }
        int l=1,r=n;
        int len = n;
        boolean flag = false;
        for(;len>=0;len--){
            for(int i=1;i<=n-len;i++){
                if((s[r+i]-s[l-1+i])%7==0){
                    flag = true;
                    System.out.println(len);
                    break;
                }
            }
            if(flag) break;
            r--;
        }

    }
}