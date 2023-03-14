import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Scanner;

public class Main2 {
    public static int publicWell;
    public static int villager1Well;
    public static int villager2Well;
    public static long pubseconds = 0;
    public static long v1seconds = 0;
    public static long v2seconds = 0;
    public static long currentseconds = 0;
    public static int publicWellmax = 1000;
    public static int villager1Wellmax;
    public static int villager2Wellmax;
    public static LocalDateTime publicWellRecoveryTime = null;
    public static LocalDateTime villager1WellRecoveryTime = null;
    public static LocalDateTime villager2WellRecoveryTime = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        publicWell = scanner.nextInt();
        villager1Well = villager1Wellmax = scanner.nextInt();
        villager2Well = villager2Wellmax = scanner.nextInt();
        boolean pubb = false;
        boolean prb1 = false;
        boolean prb2 = false;
        // 模拟村民取水
        for (int i = 0; i < 4; i++) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int hour = scanner.nextInt();
            int minute = scanner.nextInt();
            int second = scanner.nextInt();
            int amount = scanner.nextInt();

            LocalDateTime currentTime =
                    LocalDateTime.of(year, month, day, hour, minute, second);
            currentseconds = currentTime.toEpochSecond(ZoneOffset.UTC);
            //recovery
            if(currentseconds - pubseconds > 21600&&pubb == true) {
                pubb = false;
                publicWell = 1000;
            }
            if(currentseconds - v1seconds > 3600&&prb1 == true) {
                prb1 = false;
                villager1Well = villager1Wellmax;
            }
            if(currentseconds - v2seconds > 3600&&prb1 == true) {
                prb2 = false;
                villager2Well = villager2Wellmax;
            }
            //recovery

            //take water
            //villager1
            if(i % 2 == 0) {
                if(!pubb) {
                    if(publicWell - amount >= 100) {
                        publicWell -= amount;
                        System.out.println("public:"+publicWell);
                    }
                    else {
                        if(prb1) {
                            System.out.println("wait");
                        }
                        else {
                            if(villager1Well - amount > 100) {
                                villager1Well -= amount;
                                System.out.println("private:"+villager1Well);
                            }
                            else {
                                villager1Well = 100;
                                System.out.println("private:"+villager1Well);
                            }
                        }
                    }
                }
                else {
                    if(prb1) {
                        System.out.println("wait");
                    }
                    else {
                        if(villager1Well - amount > 100) {
                            villager1Well -= amount;
                            System.out.println("private:"+villager1Well);
                        }
                        else {
                            villager1Well = 100;
                            System.out.println("private:"+villager1Well);
                        }
                    }
                }
            }
            //villager1
            //v2
            else {
                if(!pubb) {
                    if(publicWell - amount >= 100) {
                        publicWell -= amount;
                        System.out.println("public:"+publicWell);
                    }
                    else {
                        if(prb2) {
                            System.out.println("wait");
                        }
                        else {
                            if(villager2Well - amount > 100) {
                                villager2Well -= amount;
                                System.out.println("private:"+villager2Well);
                            }
                            else {
                                villager2Well = 100;
                                System.out.println("private:"+villager2Well);
                            }
                        }
                    }
                }
                else {
                    if(prb2) {
                        System.out.println("wait");
                    }
                    else {
                        if(villager2Well - amount > 100) {
                            villager2Well -= amount;
                            System.out.println("private:"+villager2Well);
                        }
                        else {
                            villager2Well = 100;
                            System.out.println("private:"+villager2Well);
                        }
                    }
                }
            }
            //v2


            //take water

            //ban?
            if(publicWell <= 100) {
                pubb = true;
                pubseconds = currentseconds;
            }
            if(villager1Well <= 100) {
                prb1 = true;
                v1seconds = currentseconds;
            }
            if(villager2Well <= 100) {
                prb2 = true;
                v2seconds = currentseconds;
            }
            //ban?

        }//for end
    }//method end
}//class end
