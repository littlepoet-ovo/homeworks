package vip.method;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        int n;
        int[] arr = new int[5000];
        System.out.print("请输入需要排序数组的长度：");
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        System.out.println("请输入待排序的数组");
        for(int i=0;i<n;i++) arr[i] = cin.nextInt();
        quickSort(arr,0,n-1);
        for(int i=0;i<n;i++) System.out.print(arr[i]+" ");
    }
    public static void quickSort(int[] arr,int l,int r){
        if(l>=r) return ;
        int mid = arr[l+r>>1];
        int i=l-1,j=r+1;
        while(i<j){
            do i++;while(arr[i]<mid);
            do j--;while(arr[j]>mid);
            if(i<j){
                int t = arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
        }
        quickSort(arr,l,j);quickSort(arr,j+1,r);
    }
}
