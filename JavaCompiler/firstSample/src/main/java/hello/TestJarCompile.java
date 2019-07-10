package hello;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestJarCompile {

    int id ;
    String name;

    public TestJarCompile(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TestJarCompile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void printCurrentTiem(){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
    }

    @Override
    public String toString() {
        return "TestJarCompile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
