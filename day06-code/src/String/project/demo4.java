package String.project;

import java.util.Scanner;

public class demo4 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String num = cin.nextLine();
        String[] num1 = {" ","I","II","III","IV","V","VI","VII","VIII","IX"};
        for (int i = 0; i < 10; i++) {
            num = num.replace(String.valueOf(i),num1[i]);
        }
        System.out.println(num);

    }
}
