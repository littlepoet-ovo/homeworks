import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Well pub = new Well(sc.nextInt(),6*3600);
        int m = sc.nextInt();
        Well[] Vlg = new Well[m];
        for (int i = 0; i < m; i++) {
            Vlg[i] = new Well(sc.nextInt(),3600);
        }
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt()-1;

            Time t = new Time(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
            int water = sc.nextInt();
            //村民编号:水井类型,成功取水量,本次取水后水井的剩余水量
            if(pub.DrWater(water,t)) {
                System.out.println((num+1)+":public,"+pub.getLastwater()+","+pub.getNowW());
            }else{
                if(Vlg[num].DrWater(water,t)){
                    System.out.println((num+1)+":private,"+Vlg[num].getLastwater()+","+Vlg[num].getNowW());
                }else{
                    System.out.println((num+1)+":wait");
                }
            }
        }

    }
}
class Well{
    private int maxW;
    private int nowW;
    private int waitTime;
    private Time time;
    private boolean GetWater = true;
    private int lastwater=0;
    public void setLastwater(int lastwater){
        this.lastwater = lastwater;
    }
    public int getLastwater(){
        return this.lastwater;
    }
    public boolean DrWater(int num,Time t){
        if(GetWater){
            if(nowW-num > 100){
                lastwater = num;
                nowW -= num;
                return true;
            }else if(nowW-num==100){
                lastwater = num;
                nowW = 100;
                time = t;
                GetWater = false;
                return true;
            }else if(waitTime==3600){
                lastwater = nowW-100;
                nowW = 100;
                time = t;
                GetWater = false;
                return true;
            }
        }else if(time.sub(t)>=waitTime){
            if(waitTime==3600) {
                nowW = maxW;
            }else{
                nowW = 1000;
            }
            GetWater=true;
            return DrWater(num,t);
        }
        return false;
    }
    public Well() {
    }
    public Well(int maxW, int nowW,int waitTime) {
        this.maxW = maxW;
        this.nowW = nowW;
        this.waitTime = waitTime;
    }
    public Well(int maxW,int waitTime) {
        this.maxW = maxW;
        this.nowW = maxW;
        this.waitTime = waitTime;
    }
    public int getMaxW() {
        return maxW;
    }
    public void setTime(Time time) {
        this.time = time;
    }
    public Time getTime() {
        return this.time;
    }
    public void setMaxW(int maxW) {
        this.maxW = maxW;
    }
    public int getNowW() {
        return nowW;
    }
    public void setNowW(int nowW) {
        this.nowW = nowW;
    }


}
class Time{
    private int year=0;
    private int month=0;
    private int day=0;
    private int hour=0;
    private int minute=0;
    private int second=0;


    public Time() {
    }

    public Time(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public long sub(Time t2){
        Calendar dateTime = Calendar.getInstance();
        dateTime.set(this.year, this.month-1, this.day, this.hour, this.minute, this.second);
        long timestamp = dateTime.getTimeInMillis()/1000;

        Calendar dateTime2 = Calendar.getInstance();
        dateTime2.set(t2.getYear(), t2.getMonth()-1, t2.getDay(), t2.getHour(), t2.getMinute(), t2.getSecond() );
        long timestamp2 = dateTime2.getTimeInMillis()/1000;
        return timestamp2 - timestamp;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
    public int getSecond() {
        return second;
    }
    public void setSecond(int second) {
        this.second = second;
    }


}