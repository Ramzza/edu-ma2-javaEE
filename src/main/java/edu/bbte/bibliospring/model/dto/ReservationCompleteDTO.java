package edu.bbte.bibliospring.model.dto;

public class ReservationCompleteDTO extends BaseDTO {

    private UserMinimalDTO user;
    private BookMinimalDTO book;

    public UserMinimalDTO getUser() {
        return user;
    }

    public void setUser(UserMinimalDTO user) {
        this.user = user;
    }

    public BookMinimalDTO getBook() {
        return book;
    }

    public void setBook(BookMinimalDTO book) {
        this.book = book;
    }

}
