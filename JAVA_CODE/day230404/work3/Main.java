import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        if(c==1){
            sc.nextLine();
            String tmp = sc.nextLine();
            MyString s = new MyString(tmp,sc.nextInt());
            System.out.println(s.s);
            System.out.println(s.multiply(s.n));
        }else{
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]=sc.nextInt();
            }
            int beishu = sc.nextInt();
            MyArray ma = new MyArray(n,arr);
            System.out.println(ma.n+" "+ma);
            MyArray ans1 = ma.multiply(beishu);
            System.out.println(ans1.n+" "+ans1);
        }
    }
}
interface Mul<T>{
    T multiply(int n);
}
class MyString implements Mul<String>{
    String s;
    int n;
    public MyString(String s, int n) {
        this.s = s;
        this.n = n;
    }
    public String multiply(int n){
        String ans;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        ans = sb.toString();
        return ans;
    }
}
class MyArray implements Mul<MyArray>{
    int n;
    private int[] arr;
    public MyArray(int n,int[] arr) {
        this.n = n;
        this.arr = arr;
    }
    public MyArray multiply(int x){
        int[] ansArr = new int[n*x];
        int cnt=0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < n; j++) {
                ansArr[cnt++] = arr[j];
            }
        }
        MyArray ans = new MyArray(x*n,ansArr);
        return ans;
    }
    public String toString(){
        StringJoiner sj = new StringJoiner(",");
        for (int i = 0; i < n; i++) {
            sj.add(""+arr[i]);
        }
        return sj.toString();
    }
}

