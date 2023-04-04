import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Graduate p1 = new Graduate(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextInt());
            String ans = p1.needMu();
            if(!ans.isEmpty()) System.out.println(ans);
        }
    }
}
interface StudentInterface {
    void setFee(int m);
    int getFee();
}
interface TeacherInterface {
    void setPay(int m);
    int getPay();
}
class Graduate implements  StudentInterface,TeacherInterface{
    String no;
    String name;
    String sex;
    int fee;
    int pay;

    public Graduate(String no, String name, String sex, int fee, int pay) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.fee = fee;
        this.pay = pay;
    }

    public void setFee(int fee){
        this.fee = fee;
    }
    public int getFee(){
        return fee;
    }
    public void setPay(int pay){
        this.pay = pay;
    }
    public int getPay(){
        return pay;
    }
    public String needMu(){
        if(pay*12-fee*2<2000){
            return no+","+name+",provide a loan";
        }
        return "";
    }
}

