package StringOther.project;

public class demo1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abc");
        sb.append(123);
        sb.reverse();
        System.out.println(sb);
        String str = sb.toString();
        System.out.println(str);
    }
}
