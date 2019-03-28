package hello;

public class Student{
    int rollno;
    String name;

    void m1(int x,int y){
        System.out.println("add is" +(x+y));
    }

    private void m3(String name){
        this.name=name;
        System.out.println("danger yappa:"+name);
    }
    void m4(){
        System.out.println("This is m4");
    }

    void print(){
        System.out.println(String.format("%s " , this.name ));
    }
}