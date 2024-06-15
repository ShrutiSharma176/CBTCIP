package Dto;

public class IssuedBook {
    int userId,bookId;
    boolean  isIssuedNow;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public boolean isIsIssuedNow() {
        return isIssuedNow;
    }

    public void setIsIssuedNow(boolean isIssuedNow) {
        this.isIssuedNow = isIssuedNow;
    }
    
    
}
