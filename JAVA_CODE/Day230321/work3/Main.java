import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //普通文理生
        int n1 = sc.nextInt();
        NomStudent[] s1 = new NomStudent[n1];
        for (int i = 0; i < n1; i++) {
            s1[i] = new NomStudent(sc.next(),sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(s1, (a, b) -> {
            if(a.sum()==b.sum()){
                return Integer.parseInt(a.num)-Integer.parseInt(b.num);
            }
            return b.sum()-a.sum();
        });

        //艺体生
        int n2 = sc.nextInt();
        exStudent[] s2 = new exStudent[n2];
        for (int i = 0; i < n2; i++) {
            s2[i] = new exStudent(sc.next(),sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(s2, (a, b) -> {
            if(a.sum()==b.sum() && b.score!=a.score){
                return b.score-a.score;
            }else if(a.sum()==b.sum() && b.score==a.score){
                return Integer.parseInt(a.num)-Integer.parseInt(b.num);
            }
            return b.sum()-a.sum();
        });

        for (int i = 0; i < n1; i++) {
            if(s1[i].wlcmp==1) s1[i].print();
        }
        for (int i = 0; i < n1; i++) {
            if(s1[i].wlcmp==2) s1[i].print();
        }

        for (int i = 0; i < n2; i++) {
            if(s2[i].ytcmp==1 && s2[i].wlcmp==1) s2[i].print();
        }
        for (int i = 0; i < n2; i++) {
            if(s2[i].ytcmp==1 && s2[i].wlcmp==2) s2[i].print();
        }
        for (int i = 0; i < n2; i++) {
            if(s2[i].ytcmp==2 && s2[i].wlcmp==1) s2[i].print();
        }
        for (int i = 0; i < n2; i++) {
            if(s2[i].ytcmp==2 && s2[i].wlcmp==2) s2[i].print();
        }
    
    }

}
class Student{
    protected String num;
    protected String name;
    protected int chinese;
    protected int math;
    protected int english;

    public Student(String num, String name, int chinese, int math, int english) {
        this.num = num;
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }
    public int sum(){
        return chinese+math+english;
    }
}
class NomStudent extends Student{
    protected int wlcmp;
    protected int synthesis;

    public NomStudent(String num, String name, int wlcmp, int chinese, int math, int english,  int synthesis) {
        super(num, name, chinese, math, english);
        this.wlcmp = wlcmp;
        this.synthesis = synthesis;
    }
    public int sum(){
        return super.sum()+synthesis;
    }
    public void print(){
        System.out.printf("%s,%s,%d,%d,%d,%d,%d,%d\n",num,name,chinese,math,english,synthesis,sum(),wlcmp);
    }
}
class exStudent extends NomStudent{
    protected int ytcmp;
    protected int score;

    public exStudent(String num, String name, int wlcmp, int ytcmp,int chinese, int math, int english, int synthesis, int score) {
        super(num, name, wlcmp, chinese, math, english, synthesis);
        this.ytcmp = ytcmp;
        this.score = score;
    }
    public int sum(){
        return super.sum()+score;
    }
    public void print(){
        System.out.printf("%s,%s,%d,%d,%d,%d,%d,%d,%d%d\n",num,name,chinese,math,english,synthesis,score,sum(),ytcmp,wlcmp);
    }
}
