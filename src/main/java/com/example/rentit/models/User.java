package com.example.rentit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User extends AuditModel
{
    @Id
    @GeneratedValue
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

    //Falta agregar las relaciones del modelo

    public Long getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

    public String getFirstname() {
        return first_name;
    }

    public void setFirstname() {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname() {
        this.surname = surname;
    }

    public String getPassowrd() {
        return password;
    }

    public void setPassword() {
        this.password = password;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus() {
        this.status = status;
    }
}