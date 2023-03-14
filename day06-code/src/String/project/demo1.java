package String.project;

public class demo1 {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        String c = "ABC";


        System.out.println(a==b);//false
        System.out.println(a.equals(b));//true
        System.out.println(a.equalsIgnoreCase(c));//true

    }
}
