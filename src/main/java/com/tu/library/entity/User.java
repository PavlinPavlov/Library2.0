package com.tu.library.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;
    private final String name;
    private final String password;

    @OneToMany(mappedBy = "user")
    private Set<TakenDetail> takenDetails;



    public User() {
        this(0, null, null);
    }

    public User(String name, String password) {
        this(0, name, password);
    }

    public User(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public void takeBook(TakenDetail takenDetail) {
        if (takenDetails == null) {
            takenDetails = new HashSet<>();
        }
        takenDetails.add(takenDetail);

        takenDetail.setUser(this);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Set<TakenDetail> getTakenDetails() {
        return takenDetails;
    }

    public void setTakenDetails(Set<TakenDetail> takenDetails) {
        this.takenDetails = takenDetails;
    }


}
