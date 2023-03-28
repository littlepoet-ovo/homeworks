import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Student[] stu = new Student[t];
        ArrayList<Student> goodBen = new ArrayList<>();
        ArrayList<Student> goodYan = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int type = sc.nextInt();
            if(type==1){//本科生
                stu[i] = new BenStudent(sc.next(),sc.next(),sc.nextBoolean(),sc.nextDouble());
                if(stu[i].isCET4() && stu[i].score>85) goodBen.add(stu[i]);
            }else{//研究生
                stu[i] = new YanStudent(sc.next(),sc.next(),sc.nextBoolean(),sc.nextInt(),sc.nextDouble());
                if(stu[i].isCET6() && stu[i].score>85 && stu[i].getPaper()>=1) goodYan.add(stu[i]);
            }
        }
        Student[] GoodBen = new Student[goodBen.size()];
        Student[] GoodYan = new Student[goodYan.size()];
        GoodBen = goodBen.toArray(GoodBen);
        GoodYan = goodYan.toArray(GoodYan);
        Arrays.sort(GoodBen,(a, b)->{
            if(Math.abs(a.score-b.score)<1e-6){
                return Integer.parseInt(a.num.substring(1))-Integer.parseInt(b.num.substring(1));
            }
            if(b.score>a.score) return 1;
            return -1;
        });
        Arrays.sort(GoodYan,(a,b)->{
            if(Math.abs(a.score-b.score)<1e-6){
                return Integer.parseInt(a.num.substring(1))-Integer.parseInt(b.num.substring(1));
            }
            if(b.score>a.score) return 1;
            return -1;
        });

        if(GoodBen.length!=0){
            System.out.println("excellent undergraduate student:");
            for (int i = 0; i < GoodBen.length; i++) {
                GoodBen[i].print();
            }
        }
        if(GoodYan.length!=0){
            System.out.println("excellent graduate student:");
            for (int i = 0; i < GoodYan.length; i++) {
                GoodYan[i].print();
            }
        }



    }
}
class Student{
    protected String num;
    protected String name;
    protected double score;

    public Student(String num, String name, double score) {
        this.num = num;
        this.name = name;
        this.score = score;
    }
    public void print(){}
    public boolean isCET4() {return true;}
    public boolean isCET6() {return true;}
    public int getPaper() {return 0;}
}
class BenStudent extends Student{
    protected boolean CET4;

    public BenStudent(String num, String name, boolean CET4, double score) {
        super(num, name, score);
        this.CET4 = CET4;
    }
    public void print(){
        System.out.printf("%s,%s,%s,%.3f\n",num,name,CET4,score);
    }

    public boolean isCET4() {
        return CET4;
    }
}
class YanStudent extends Student{
    public YanStudent(String num, String name, boolean CET6, int paper, double score) {
        super(num, name, score);
        this.CET6 = CET6;
        this.paper = paper;
    }

    protected boolean CET6;
    protected int paper;
    public void print(){
        System.out.printf("%s,%s,%s,%d,%.3f\n",num,name,CET6,paper,score);
    }


    public boolean isCET6() {
        return CET6;
    }

    public int getPaper() {
        return paper;
    }
}
