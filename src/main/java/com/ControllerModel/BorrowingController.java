package com.ControllerModel;

import com.Model.Book;
import com.Model.Borrowing;
import java.util.ArrayList;


/**Classe destinada a controlar o jogo de valor das classes relacionadas a emprestimo.
 * @author João Macedo e Rogério Cerqueira
 * @version 1.0
 *
 */


public class BorrowingController {

    /** Método para criar um emprestimo.
     * @return void - Emprestimo*/

    Functions function = new Functions();

    public String createBorrow(ArrayList<Borrowing> bingCollection, ArrayList<Book> bCollection, String idUser, String userName, String isbn, String bookName){

        Borrowing borrowing = new Borrowing();
        String sms = null;

        borrowing.setIdB(function.generateId("r"));
        borrowing.setIdUser(idUser);
        borrowing.setUserName(userName);
        borrowing.setIsbn(isbn);
        borrowing.setBookName(bookName);
        borrowing.setdStart(function.actualDater());

        for (Book book : bCollection){

            if(book.getIsbn().equals(isbn) && book.getTitle().equals(bookName)) {

                if(book.getNumber() <= 0){
                    book.setNumber(0);
                    borrowing.setrSituation("2"); /* 2 - Reserva */
                    bingCollection.add(borrowing);
                    sms = "Livro indisponível, reserva realizada.";
                }
                else{
                    int n = book.getNumber() - 1;
                    book.setNumber(n);
                    borrowing.setrSituation("1"); /* 1 - Empréstimo em vigor */
                    bingCollection.add(borrowing);
                    sms = "Empréstimo realizado, retire o livro.";
                }
            }
        }
        return sms;
    }

    /** Método para ler um emprestimo.
     * @return Borrowing - Emprestimo*
     * @param id String - id de busca*
     * @param bingCollection ArrayList<String> - lista de emprestimo/reserva ou histórico de emprestimos*/

    public Borrowing readBorrowing( ArrayList<Borrowing> bingCollection, String id){

        Borrowing search = new Borrowing();

        for(Borrowing borrowing : bingCollection){

            if(borrowing.getIdB().equals(id)){
                search = borrowing;

            }
        }

        return search;
    }

    /** Método para atualizar um emprestimo.
     * @param id String - id de busca*
     * @param nIdUser String - novo id do usuario*
     * @param nUserName String - novo nome do usuario*
     * @param nIsbn String - isbn correto*
     * @param nBookName String - nome do livro correto*/

    public void updateBorrow(ArrayList<Borrowing> bingCollection , String id, String nIdUser, String nUserName, String nIsbn, String nBookName){

        for (Borrowing borrowing : bingCollection){

            if(borrowing.getIdB().equals(id)){

                if(nIdUser != null){
                    borrowing.setIdUser(nIdUser);
                }
                if(nUserName != null){
                    borrowing.setUserName(nUserName);
                }
                if(nIsbn != null){
                    borrowing.setIsbn(nIsbn);
                }
                if(nBookName != null){
                    borrowing.setBookName(nBookName);
                }
            }

        }
    }


    /** Método para excluir um emprestimo.
     *@param id String - id de busca*/
    public void deleteBorrow(ArrayList<Borrowing> bingCollection, String id){

        int index = 0;

        for(Borrowing borrowing : bingCollection){

            if (borrowing.getIdB().equals(id)){
                bingCollection.remove(index);
            }
            else {
                index = index +1;
            }
        }
    }

}
