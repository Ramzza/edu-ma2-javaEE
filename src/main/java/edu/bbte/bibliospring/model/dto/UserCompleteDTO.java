package edu.bbte.bibliospring.model.dto;

public class UserCompleteDTO extends UserDTO {

    private String password;

    public UserCompleteDTO() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
