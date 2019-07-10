package hello;

public  class Person {
    private String name;
    private int age;

    public Person(){
        this.name = "Empty name";
        this.age = 16;
    }

    public Person(String name) { this.name = name; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.age = 18;
    }

    protected String getName2() { return name; }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void print(String param){
        System.out.println("----------------------");
        System.out.println(String.format("%s - %s : %s " , this.name , this.age,param));
    }

    public void test(){
        System.out.println("-----   test    -----------------");
    }
}