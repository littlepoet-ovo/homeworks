package StringOther.project;

import java.util.StringJoiner;

public class demo2 {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(",","[","]");
        int[] arr = {1,2,3,4,5,6,7,8};
        for (int i = 0; i < arr.length; i++) {
            String s = ""+arr[i];
            sj.add(s);
        }
        String str =sj.toString();
        System.out.println(str);

    }
}
