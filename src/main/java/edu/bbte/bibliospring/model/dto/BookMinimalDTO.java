package edu.bbte.bibliospring.model.dto;

import java.util.List;

public class BookMinimalDTO extends BaseDTO {
    private String title;
    private List<AuthorCompleteDTO> authors;

    public List<AuthorCompleteDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorCompleteDTO> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
