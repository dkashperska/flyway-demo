package luxoft.beans;

import java.util.Date;

public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Date reg_date;
    private String login;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public String getLogin() {
        return login;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
