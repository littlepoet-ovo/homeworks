package vip.face;

public class GirlFriend {
    private int age;
    String name;

    public GirlFriend(){

    }
    public GirlFriend(int age,String name){
        this.name = name;
        this.age = age;
    }
    public void setAge(int age){
        if(age >= 18 && age <=20){
            this.age = age;
        }else{
            System.out.println("非法数据！");
        }
    }
    public int getAge(){
        return age;
    }

}
