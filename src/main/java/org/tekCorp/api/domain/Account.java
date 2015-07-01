package org.tekCorp.api.domain;

import javax.persistence.*;

/**
 * Created by Inspiron on 22/06/2015.
 */
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUser;

    @Column(unique=true)
    private String boincId;
    @Column(unique=true)
    private String login;
    private String password;

    public Account(){}
    public Account(String boincId, String login, String password) {
        this.boincId = boincId;
        this.login = login;
        this.password = password;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getBoincId() {
        return boincId;
    }

    public void setBoincId(String boincId) {
        this.boincId = boincId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        return getIdUser().equals(account.getIdUser());

    }

    @Override
    public int hashCode() {
        return getIdUser().hashCode();
    }
}
