package fully.qualified.Model;

public class Person extends AbstractPerson {


    private  String sex ;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param sex
     */
    public Person(String firstName, String lastName, String sex) {
        super(firstName, lastName);
        this.sex = sex;
    }

}
