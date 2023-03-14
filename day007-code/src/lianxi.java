public class lianxi {
    static int i;
    public int aMethod() {
        i++;
        return i;
    }
    public static void main (String args[]) {
        lianxi test=new lianxi() ;
        test.aMethod() ;
        System.out.println(test.aMethod()) ;
    }
}