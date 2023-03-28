import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue mq = new MyQueue(sc.nextInt());
        int n = sc.nextInt();
        while(n!=0){
            if(n==1){
                String type = sc.next();
                if(type.equals("a")){
                    student x = new student(sc.next(),sc.next());
                    if(!mq.full()){
                        mq.add(x);
                    }else{
                        System.out.println("queue is full,operation failed");
                    }
                }else{
                    Teacher x = new Teacher(sc.next(),sc.next(),sc.next());
                    if(!mq.full()){
                        mq.add(x);
                    }else{
                        System.out.println("queue is full,operation failed");
                    }
                }
            }else if(n==2){
                if(!mq.empty()){
                    System.out.println(mq.pop());
                }else{
                    System.out.println("queue is empty,operation failed");
                }
            }else if(n==3){
                mq.find(sc.next());
            }else if(n==4){
                System.out.println(mq.getLength());
            }else break;


            n = sc.nextInt();
        }
    }
}
class Person{
    protected String name;
    protected String num;

    public Person(String num, String name) {
        this.name = name;
        this.num = num;
    }

    public Person() {
    }

    public String toString() {
        return num +"," + name;
    }
    public String getPlace() {return "";}

    public void setPlace(String place) {}

}
class student extends Person{
    public student(String num, String name) {
        super(num, name);
    }

    public student() {
    }
}
class Teacher extends Person{
    protected String place;

    public Teacher(String num, String name, String place) {
        super(num, name);
        this.place = place;
    }

    public Teacher(String place) {
        this.place = place;
    }
    public String toString() {
        return num +"," + name+","+place;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
class MyQueue{
    private int size;
    private int front;
    private int rear;
    private int length=0;
    private Person[] p;

    public MyQueue(int size) {
        this.size = size;
        front=0;
        rear=0;
        p = new Person[size];

    }
    public boolean add(Person a){
        if(length<size){
            p[rear]=a;
            rear = (rear+1)%size;
            length++;
            return true;
        }
        return false;
    }
    public Person pop(){
        Person a = p[front];
        front=(front+1)%size;
        length--;
        return a;
    }
    public boolean empty(){
        return length == 0;
    }
    public boolean full(){
        return length == size;
    }
    public void find(String name){
        int flag=1;
        if(front<rear){
            for(int i=front;i<rear;i++){
                if (p[i].name.equals(name)) {
                    System.out.println(p[i]);
                    flag=0;
                }
            }
        }else{
            for(int i=front;i<size;i++){
                if (p[i].name.equals(name)) {
                    System.out.println(p[i]);
                    flag=0;
                }
            }
            for(int i=0;i<rear;i++){
                if (p[i].name.equals(name)) {
                    System.out.println(p[i]);
                    flag=0;
                }
            }
        }
        if(flag==1)
            System.out.println("no found");
    }

    public MyQueue() {
    }

    public int getLength() {
        return length;
    }
}
