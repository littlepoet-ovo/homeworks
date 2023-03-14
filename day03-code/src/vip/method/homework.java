package vip.method;

import java.math.BigInteger;
import java.util.Scanner;

public class homework {
    public static void main(String[] args) {
        String a,b;
        Scanner cin = new Scanner(System.in);
        a = cin.next();
        b = cin.next();
        BigInteger B = new BigInteger(b);
        BigInteger ans = new BigInteger("1");


        for (BigInteger C = new BigInteger(a);C.compareTo(B) <= 0;C=C.add(BigInteger.valueOf(1))){
            ans = ans.multiply(C);
        }
        int cnt=0;
        System.out.println(ans);
        while(ans.compareTo(BigInteger.valueOf(0))!=0){
            BigInteger temp = ans.remainder(BigInteger.valueOf(10));

            if(temp.compareTo(BigInteger.valueOf(0))==0){
                cnt ++;
                ans = ans.divide(BigInteger.valueOf(10));
            }else{
                break;
            }
        }
        System.out.println(cnt);


    }
}
