package ArrayList.prj;

public class demo3 {

    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder();
        int out=0;
        for(int a=0;a<2;a++){
            for(int b=0;b<2;b++){
                for(int c=0;c<2;c++){
                    for(int d=0;d<2;d++){
                        for(int k1=0;k1<2;k1++){
                            for(int k2=0;k2<2;k2++){
                                if(k1==0 && k2==0) out = a;
                                else if(k1==0&&k2==1) out = b;
                                else if(k1==1&&k2==0) out = c;
                                else if(k1==1&&k2==1) out = d;
                                ans.append("#1 ");
                                ans.append("a=").append(a).append(";");
                                ans.append("b=").append(b).append(";");
                                ans.append("c=").append(c).append(";");
                                ans.append("d=").append(d).append(";");
                                ans.append("k=2'b").append(k1).append(k2).append(";");
                                ans.append("\n");


                            }
                        }
                    }
                }
            }
        }
        String rslt = ans.toString();
        System.out.println(rslt);
    }
}
