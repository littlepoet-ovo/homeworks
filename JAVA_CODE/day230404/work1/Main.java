import java.util.Scanner;

public class Main {
    static double area=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape s1 = new Circle(sc.nextDouble());countArea(s1);
        Shape s2 = new Rectangle(sc.nextDouble(),sc.nextDouble());countArea(s2);
        Shape s3 = new Triangle(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());countArea(s3);
        Shape s4 = new Trapezoid(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());countArea(s4);

        System.out.printf("%.4f",area);
    }
    public static void countArea(Shape s){
        area += s.getArea();
    }
}
abstract class Shape{
    abstract public double getArea();
}
class Circle extends Shape{
    double r;

    public Circle(double r) {
        this.r = r;
    }
    public double getArea(){
        if(r>0)return Math.PI*r*r;
        else return 0;

    }
}
class Rectangle extends Shape{
    double a,b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }
    public double getArea(){
        if(a>0 && b>0)return a*b;
        else return 0;
    }
}
class Triangle extends Shape{
    double a,b,c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea(){
        if(a>0&&b>0&&c>0&&(a+b)>c&&(a+c)>b&&(b+c)>a){
            double p = (a+b+c)/2.0;
            return Math.sqrt(p*(p-a)*(p-b)*(p-c));
        }else return 0;

    }
}
class Trapezoid extends Shape{
    double a,b,h;

    public Trapezoid(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }
    public double getArea(){
        if(a>0 && b>0 && h>0) return (a+b)*h/2.0;
        return 0;

    }
}
