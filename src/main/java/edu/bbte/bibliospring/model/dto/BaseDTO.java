package edu.bbte.bibliospring.model.dto;

public class BaseDTO {

    private Long id;

    protected BaseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
