import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x1,x2,y1,y2;
        Scanner cin = new Scanner(System.in);
        x1 = cin.nextInt();
        y1 = cin.nextInt();
        x2 = cin.nextInt();
        y2 = cin.nextInt();
        Point f1 = new Point();
        Point f2 = new Point();
        f1.x = x1;
        f1.y = y1;
        f2.x = x2;
        f2.y = y2;
        double ans = f1.calDistance(f2);
        System.out.printf("%.0f",ans);

    }
}
class Point{
    int x;
    int y;
    public Point(){}
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    double calDistance(Point f2){
        double ans = 1.0*(x-f2.x)*(x-f2.x) + 1.0*(y-f2.y)*(y-f2.y);
        ans = Math.sqrt(ans);
        return ans;
    }
}

