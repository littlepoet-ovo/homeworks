package ArrayList.prj;

import java.util.ArrayList;

public class demo1 {
    public static void main(String[] args) {
        //创建
        ArrayList<String> alStr = new ArrayList<>();
        //增
        alStr.add("aaa");
        alStr.add("bbb");
        alStr.add("ccc");
        alStr.add("ddd");
        System.out.println(alStr);
        //删
        alStr.remove("aaa");
        System.out.println(alStr);
        //改
        alStr.set(2,"dzj");
        System.out.println(alStr);
        //查
        System.out.println(alStr.get(2));
        //获取长度
        System.out.println(alStr.size());

    }
}
