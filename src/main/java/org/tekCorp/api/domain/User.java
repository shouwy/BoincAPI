package org.tekCorp.api.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Inspiron on 15/06/2015.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idUser;
    @Column(unique=true)
    String login;

    String name;
    String password;
    String mail;
}
