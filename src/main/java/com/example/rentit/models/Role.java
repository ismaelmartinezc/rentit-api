package com.example.rentit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.validation.constraints.*;

@Entity
@Table(name = "roles")
public class Role extends AuditModel
{
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @NotBlank
    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus() {
        this.status = status;
    }
}