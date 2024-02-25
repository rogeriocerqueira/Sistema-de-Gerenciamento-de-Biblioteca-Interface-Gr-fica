package com.Model;

import java.util.Calendar;
import java.util.ArrayList;

public class User extends Person{

    ArrayList<Borrowing> bookList = new ArrayList<Borrowing>();
    private String address;
    private boolean status;
    private Calendar block;

    public ArrayList<Borrowing> getBookList() {
        return bookList;
    }

    public void setBookList(Borrowing aBorrow) {
        bookList.add(aBorrow);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Calendar getBlock() {
        return block;
    }

    public void setBlock(Calendar block) {
        this.block = block;
    }
}
