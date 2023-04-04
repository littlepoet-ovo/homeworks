import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComputerAverage p;
        int c = sc.nextInt();
        if(c==1){
            Gymnastics p1 = new Gymnastics();
            for (int i = 0; i < 10; i++) {
                p1.add(sc.nextDouble());
            }
            p = p1;
            System.out.printf("%.3f",p.getAve());
        }else{
            int n = sc.nextInt();
            School p2 = new School(n);
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                p2.add(sc.nextDouble());
            }
            p = p2;
            System.out.printf("%.3f",p.getAve());

        }
    }

}
interface ComputerAverage{
    double getAve();
}
class School implements ComputerAverage{
    private int n;
    private double[] score;
    private int cnt=0;

    public School(int n) {
        this.n = n;
        score = new double[n];
    }
    public void add(double sc){
        score[cnt++] = sc;
    }
    public double getAve(){
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += score[i];
        }
        return sum / (double)n;
    }
}
class Gymnastics implements ComputerAverage{
    private double[] score = new double[10];
    private int cnt=0;
    public void add(double sc){
        score[cnt++] = sc;
    }
    public double getAve(){
        Arrays.sort(score);
        double sum = 0;
        for (int i = 1; i < 9; i++) {
            sum += score[i];

        }
        return sum / 8.0;
    }

}
