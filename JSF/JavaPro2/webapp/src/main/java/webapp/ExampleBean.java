package webapp;


import javax.inject.Named;

@Named
//import javax.enterprise.context.RequestScoped;
// @RequestScoped по умолчанию
// <- обработка одного запроса
public class ExampleBean {

    private String text = "CDI Exapmle";

    private  String login ;
    private String password;
    private  boolean logged;

    public void doLogin(){
      int a =10;
      int b =1;
      logged = true;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
