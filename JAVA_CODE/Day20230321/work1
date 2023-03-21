import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlainRect sq = new PlainRect(sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        System.out.printf("%.4f %.2f ",sq.area(),sq.perimeter());
        if(sq.isInside(x,y)) System.out.println("In");
        else System.out.println("Out");
    }

}
class Rect{
    protected double width;
    protected double height;

    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rect() {
        width = 10;
        height = 10;
    }
    public double area(){
        return width*height;
    }
    public double perimeter(){
        return 2*width+2*height;
    }

}
class PlainRect extends Rect{
    double startX;
    double startY;

    public PlainRect(double startX, double startY,double width, double height) {
        super(width, height);
        this.startX = startX;
        this.startY = startY;
    }
    public PlainRect(){
        super(0, 0);
        this.startX = 0;
        this.startY = 0;
    }
    public boolean isInside(double x,double y){
        if(x>=startX && x<=(startX+width) && y<=startY && y>=(startY-height)) return true;
        return false;
    }
}
