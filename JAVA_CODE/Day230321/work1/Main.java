import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please input(0-2):");
        int menu = sc.nextInt();
        do{
            if(menu == 1){//圆
                Circle a = new Circle();
                a.setX(sc.nextDouble());
                a.setY(sc.nextDouble());
                a.setR(sc.nextDouble());
                a.print();
            }else if(menu==2){//圆柱
                Cylinder a = new Cylinder();
                a.setX(sc.nextDouble());
                a.setY(sc.nextDouble());
                a.setR(sc.nextDouble());
                a.setH(sc.nextDouble());
                a.print();
            }else{
                break;
            }
            System.out.println("please input(0-2):");
            menu = sc.nextInt();
        }while(menu!=0);
    }

}
class Point{
    protected double x;
    protected double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
class Circle extends Point{
    protected double r;

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
    public double area(){
        return Math.PI*r*r;
    }
    public void print(){
        System.out.printf("(%.1f,%.1f);%.1f;%.2f\n",x,y,r,area());
    }
}
class Cylinder extends Circle{
    protected double h;

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
    public double volume(){
        return h*area();
    }
    public void print(){
        System.out.printf("(%.1f,%.1f);%.1f;%.2f;%.1f;%.4f\n",x,y,r,area(),h,volume());
    }
}
