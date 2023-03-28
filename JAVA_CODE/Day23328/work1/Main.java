import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] stu = new Student[110];
        int n = sc.nextInt();
        int i;
        for (i = 0; i < n; i++) {
            stu[i] = new EngStudent(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
        }
        int m = sc.nextInt();
        for(;i<n+m;i++){
            stu[i] = new ComStudent(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
        }

        for(int j=0;j<m+n;j++){
            for(int k=0;k<m+n-j-1;k++){

                if(stu[k].age==stu[k+1].age){
                    if(Integer.parseInt(stu[k].num)>Integer.parseInt(stu[k+1].num)){
                        Student t = stu[k];
                        stu[k] = stu[k+1];
                        stu[k+1] = t;
                    }
                }else{
                    if(stu[k].age>stu[k+1].age){
                        Student t = stu[k];
                        stu[k] = stu[k+1];
                        stu[k+1] = t;
                    }
                }
            }
        }


        for (int j = 0; j < (m+n); j++) {
            stu[j].print();
        }
    }
}
class Student{
    protected String num;
    protected String name;
    protected String sex;
    public int age;

    protected double mid;
    protected double end;

    public Student(String num, String name, String sex, int age, double mid, double end) {
        this.num = num;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.mid = mid;
        this.end = end;
    }

    public void print(){}
    public double getAve(){return 0;}
}
class EngStudent extends Student{
    protected double speak;

    public EngStudent(String num, String name, String sex, int age, double speak, double mid, double end) {
        super(num, name, sex, age, mid, end);
        this.speak = speak;
    }
    public double getAve(){
        return 0.5*speak+0.25*mid+0.25*end;
    }
    public void print(){
        System.out.printf("%s,%s,%s,%d,English,%.1f,%.1f,%.1f,%.1f\n",num,name,sex,age,speak,mid,end,getAve());
    }
}
class ComStudent extends Student{
    protected double operate;
    protected double enWriter;

    public ComStudent(String num, String name, String sex, int age, double operate, double enWriter, double mid, double end) {
        super(num, name, sex, age, mid, end);
        this.operate = operate;
        this.enWriter = enWriter;
    }
    public double getAve(){
        return 0.4*operate+0.2*enWriter+0.2*mid+0.2*end;
    }
    public void print(){
        System.out.printf("%s,%s,%s,%d,Computer,%.1f,%.1f,%.1f,%.1f,%.1f\n",num,name,sex,age,operate,enWriter,mid,end,getAve());
    }
}
