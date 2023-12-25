package edu.bbte.bibliospring.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.bbte.bibliospring.model.entity.base.BaseEntity;

@Entity
@Table(name = "Reservation")
public class Reservation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "BS_USER_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Title_id")
    private Book book;

    public Reservation() {
        super();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
