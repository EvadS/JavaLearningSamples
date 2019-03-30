package fully.qualified.Model;

public class Student extends  AbstractPerson {

    private String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }


    /**
     *
     * @param firstName
     * @param lastName
     * @param group
     */

    public Student(String firstName, String lastName, String group) {
        super(firstName, lastName);
        this.group = group;
    }
}
