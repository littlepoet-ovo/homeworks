import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PublicWell.well = new PublicWell(s.nextInt());
        int n = s.nextInt();
        ArrayList<PrivateWell> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new PrivateWell(s.nextInt()));
        }
        int actionCount = s.nextInt();
        ArrayList<Action> alist = new ArrayList<>(actionCount);
        for (int i = 0; i < actionCount; i++) {
            Action action = new Action();
            action.villager = s.nextInt();
            action.time = Calendar.getInstance();
            action.time.set(s.nextInt(),s.nextInt() - 1,s.nextInt(),s.nextInt(),s.nextInt(),s.nextInt());
            action.amount = s.nextInt();
            alist.add(action);
        }
        for (Action act:
                alist) {
            PrivateWell privateWell = list.get(act.villager - 1);

            if (PublicWell.well.resetTime != null) {
                if (act.time.getTimeInMillis() -
                        PublicWell.well.resetTime.getTimeInMillis() >= 21600000) {
                    PublicWell.well.reset();
                    PublicWell.well.resetTime = null;
                }
            }
            if (privateWell.resetTime != null) {
                if (act.time.getTimeInMillis() -
                        privateWell.resetTime.getTimeInMillis() >= 3600000) {
                    privateWell.reset();
                    privateWell.resetTime = null;
                }
            }

            if (PublicWell.well.tryGet(act.amount,act.villager)) {
                if (PublicWell.well.resetTime == null && PublicWell.well.reserve <= 100)
                    PublicWell.well.resetTime = act.time;
                continue;
            }
            if (PublicWell.well.resetTime == null && PublicWell.well.reserve <= 100)
                PublicWell.well.resetTime = act.time;
            privateWell.tryGet(act.amount, act.villager);
            if (privateWell.resetTime == null && privateWell.reserve <= 100)
                privateWell.resetTime = act.time;

        }
    }
}
class Action {
    int villager;
    Calendar time;
    int amount;
}
class PublicWell {
    public static PublicWell well;

    public PublicWell(int reserve) {
        this.reserve = reserve;
    }

    int reserve;
    Calendar resetTime;
    boolean tryGet(int amount,int number) {
        if (resetTime != null) return false;
        if (reserve - amount < 100) return false;
        System.out.println(
                number + ":public,"
                        + amount + ","
                        + (reserve - amount));
        reserve -= amount;
        return true;
    }
    void reset() {
        reserve = 1000;
    }
}
class PrivateWell {
    public PrivateWell(int capacity) {
        this.capacity = capacity;
        reset();
    }

    int capacity;
    int reserve;
    Calendar resetTime;
    boolean tryGet(int amount, int number) {
        if (reserve <= 100 || resetTime != null) {
            System.out.println(number + ":wait");
            return false;
        }
        if (reserve - amount >= 100) {
            System.out.println(
                    number + ":private,"
                            + amount + ","
                            + (reserve - amount));
            reserve -= amount;
        }
        else {
            System.out.println(
                    number + ":private,"
                            + (reserve - 100) + ","
                            + 100);
            reserve = 100;
        }
        return true;
    }
    void reset() {
        reserve = capacity;
    }
}