package com.example.rentit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.Set;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User extends AuditModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "email")
    @Email
    private String email;

    @Column(name = "first_name")
    @NotBlank
    @Size(min = 2, max = 50)
    private String first_name;

    @Column(name = "surname")
    @NotBlank
    @Size(min = 2, max = 50)
    private String surname;

    @Column(name = "password")
    @NotBlank
    private String password;

    @Column(name = "status")
    @NotBlank
    private boolean status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "permissions", 
        joinColumns = @JoinColumn(
            name = "user_id", 
            referencedColumnName = "id"
        ), 
        inverseJoinColumns = @JoinColumn(
            name = "role_id", 
            referencedColumnName = "id"
        )
    )
    private Set<Role> roles;

    public User() {
        //
    }

    public User(String email, String first_name, String surname, String password, boolean status) {
        this.email = email;
        this.first_name = first_name;
        this.surname = surname;
        this.password = password;
        this.status = status;
    }

    public User(String email, String first_name, String surname, Set<Role> roles) {
        this.email = email;
        this.first_name = first_name;
        this.surname = surname;
        this.roles = roles;
    }

    //Falta agregar las relaciones del modelo

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return first_name;
    }

    public void setFirstname(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassowrd() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}