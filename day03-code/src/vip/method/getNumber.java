package vip.method;
import  java.lang.Integer;
import java.util.Scanner;

public class getNumber {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String Value = cin.nextLine();
        String[] nums = Value.split(" ");
        int[] a = new int [nums.length];

        for(int i=0;i<nums.length;i++){
            a[i] = Integer.parseInt(nums[i]);
        }
        for(int x : a){
            System.out.println(x);
        }

    }
}
