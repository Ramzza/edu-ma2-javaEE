package edu.bbte.bibliospring.model.dto;

public class AuthorCompleteDTO extends BaseDTO {
    private String firstName;
    private String lastName;

    public AuthorCompleteDTO() {
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

}
