package edu.bbte.bibliospring.model.dto;

import java.util.Date;
import java.util.List;

public class BookCompleteDTO extends BaseDTO {

    private String title;
    private String isbn;
    private Date publishingDate;
    private String type;
    private List<AuthorCompleteDTO> authors;

    public BookCompleteDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AuthorCompleteDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorCompleteDTO> authors) {
        this.authors = authors;
    }
}
