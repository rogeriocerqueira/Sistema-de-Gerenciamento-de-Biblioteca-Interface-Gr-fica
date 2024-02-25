package com.Model;

import java.util.Calendar;

public class Borrowing {

    private String idB;
    private String idUser;
    private String userName;
    private String isbn;
    private String bookName;
    private Calendar dStart;
    private Calendar devolution;
    private Calendar dEnd;
    private String rSituation;

    /*SETS E GETS*/

    public String getIdB() {
        return idB;
    }

    public void setIdB(String idB) {
        this.idB = idB;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Calendar getdStart() {
        return dStart;
    }

    public void setdStart(Calendar dStart) {
        this.dStart = dStart;
    }

    public Calendar getDevolution() {
        return devolution;
    }

    public void setDevolution(Calendar devolution) {
        this.devolution = devolution;
    }

    public Calendar getdEnd() {
        return dEnd;
    }

    public void setdEnd(Calendar dEnd) {
        this.dEnd = dEnd;
    }

    public String getrSituation() {
        return rSituation;
    }

    public void setrSituation(String rSituation) {
        this.rSituation = rSituation;
    }
}


