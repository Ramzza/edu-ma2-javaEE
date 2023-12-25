package edu.bbte.bibliospring.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import edu.bbte.bibliospring.model.entity.base.BaseEntity;

import javax.persistence.Column;

@Entity
@Table(name = "Author")
public class Author extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    public Author() {
        super();
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

    @Override
    public String toString() {
        return super.toString();
    }
}
