package fully.qualified.Model;

public class AbstractPerson {

    private  String firstName;
    private String lastName;


    /**
     *
     * @param firstName
     * @param lastName
     */
    public AbstractPerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
