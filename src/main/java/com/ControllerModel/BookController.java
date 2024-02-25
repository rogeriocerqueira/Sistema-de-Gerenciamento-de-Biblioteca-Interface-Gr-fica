package com.ControllerModel;
import com.Model.Book;
import java.util.ArrayList;
public class BookController {

    Functions function = new Functions();

    public void createBook(ArrayList<Book> bCollection, String isbn, String title, String author, String publisher, String year, String category, int number){

        Book book = new Book();

        book.setIdBook(function.generateId("b"));
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setYear(year);
        book.setCategory(category);
        book.setNumber(number);

        bCollection.add(book);

    }

    public ArrayList<Book> readBook(ArrayList<Book> bCollection, String isbn, String title, String author, String category){

        ArrayList<Book> search = new ArrayList<>();

        for (Book book : bCollection){

            if(book.getTitle().equals(title) || book.getAuthor().equals(author) || book.getIsbn().equals(isbn) || book.getCategory().equals(category) ){

                search.add(book);
            }
        }
        return search;
    }


    public void updateBook(ArrayList<Book>bCollection, String id,String nIsbn, String nTitle, String nAuthor, String nPublisher, String nYear, String nCategory, int nNumber){

        for (Book book : bCollection){

            if (book.getIdBook().equals(id)){

                if(nIsbn != null){
                    book.setIsbn(nIsbn);
                }
                if(nTitle != null){
                    book.setTitle(nTitle);
                }
                if(nAuthor != null){
                    book.setAuthor(nAuthor);
                }
                if(nPublisher != null){
                    book.setPublisher(nPublisher);
                }
                if(nYear != null){
                    book.setYear(nYear);
                }
                if(nCategory != null){
                    book.setCategory(nCategory);
                }
                if(nNumber != 0){
                    book.setNumber(nNumber);
                }
            }
        }
    }

    public void deleteBook(ArrayList<Book> bCollection, String id){

        int index = 0;

        for (Book book : bCollection){

            if(book.getIdBook().equals(id)){
                bCollection.remove(index);
            }
            else{
                index = index + 1;
            }
        }

    }

}
