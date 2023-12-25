package edu.bbte.bibliospring.model.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.bbte.bibliospring.model.entity.base.BaseEntity;

import javax.persistence.Column;

@Entity
@Table(name = "Title")
public class Book extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publishingDate")
    private Date publishingDate;

    @Column(name = "type")
    private String type;

    @OneToMany
    @JoinTable(name = "TitleAuthor", joinColumns = { @JoinColumn(name = "Title_id") }, inverseJoinColumns = {
            @JoinColumn(name = "Author_id") })
    private List<Author> authors;

    public Book() {
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
