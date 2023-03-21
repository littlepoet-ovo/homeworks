import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        if(type==1){
            PubBank p  =new PubBank(sc.nextDouble(),sc.nextInt(),sc.nextDouble());
            p.getMoney();
        }else if(type==2){
            PriBank p  =new PriBank(sc.nextDouble(),sc.nextInt(),sc.nextDouble());
            p.getMoney();
        }
    
    }

}
class Bank{
    protected double interestRate = 0; // 定期利率
    protected double currentRate = 0;  // 活期利率

    public Bank(double interestRate, double currentRate) {
        this.interestRate = interestRate;
        this.currentRate = currentRate;
    }

    public Bank() {
    }
}
class PubBank extends Bank{
    private double money;//本金
    private int mYear;//几年期
    private double years;//存款时长

    public PubBank(double money, int mYear, double years) {


        this.money = money;
        this.mYear = mYear;
        this.years = years;
        currentRate = 0.00001;
        switch (mYear){
            case 1: interestRate = 0.0175;break;
            case 2: interestRate = 0.0225;break;
            case 3: case 5: interestRate = 0.0275;break;
            default: interestRate = 0;
        }
    }
    public void getMoney(){
        int times = (int)years/mYear;
        int days = (int)(years - times*mYear)*365 + (int)(((years - times*mYear)-Math.round(years - times*mYear))*1000);
        double ans = money*Math.pow((1+interestRate*mYear),times);
        ans += ans*days*currentRate;
        System.out.printf("%.1f",ans);

    }
}
class PriBank extends Bank{
    private double money;//本金
    private int mYear;//几年期
    private double years;//存款时长

    public PriBank(double money, int mYear, double years) {
        this.money = money;
        this.mYear = mYear;
        this.years = years;
        currentRate = 0.000012;
        switch (mYear){
            case 1: interestRate = 0.0195;break;
            case 2: interestRate = 0.0241;break;
            case 3: interestRate = 0.0275;break;
            case 5: interestRate = 0.03;break;
            default: interestRate = 0;
        }
    }
    public void getMoney(){
        int times = (int)years/mYear;//转存的次数
        int otherY = (int)years - times*mYear;//多出来的时间超过一年的时常
        int days = (int)((years - (int)years)*1000);
        double ans1 = money*Math.pow((1+interestRate*mYear),times);
        double ans2 = ans1*(1+0.0195*otherY);
        double ans3 = ans2+days*currentRate*ans2;
        System.out.printf("%.1f",ans3);
    }
}
