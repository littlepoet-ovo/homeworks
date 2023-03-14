package vip.method;

public class Method001 {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44,55};
        printArr(arr);
        System.out.println(getMax(arr));
    }
    public static void printArr(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if(i==arr.length-1) System.out.print(arr[i]);
            else System.out.print(arr[i] + ",");
        }
        System.out.println("]");
    }
    public static int getMax(int[] arr){
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }


}
