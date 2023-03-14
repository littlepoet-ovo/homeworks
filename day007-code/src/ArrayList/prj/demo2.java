package ArrayList.prj;

import java.util.ArrayList;

public class demo2 {
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            num.add(i);
        }
        System.out.println(num);
    }
}
