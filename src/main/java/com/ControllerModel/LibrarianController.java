package com.ControllerModel;
import com.Model.Librarian;
import java.util.ArrayList;

public class LibrarianController {

    /*
    * @param name String - nome do bibliotecário
    * @param cpf String - cpf do bibliotecário
    * @param office String -  profissão do bibliotecário
    * @param age int - idade do bibliotecário
    * @param email String do bibliotecário
    *  */

    Functions function = new Functions();

    public void createLib(ArrayList<Librarian> lCollection, String name, String cpf, String nPhone, String email){

        Librarian librarian = new Librarian();

        librarian.setId(function.generateId("l"));
        librarian.setName(name);
        librarian.setCpf(cpf);
        librarian.setOffice("Blibiotecário");
        librarian.setnPhone(nPhone);
        librarian.setEmail(email);
        lCollection.add(librarian);
    }

    public Librarian readLib(ArrayList<Librarian> lCollection,String id, String name, String cpf){

        Librarian search = new Librarian();

        for (Librarian librarian : lCollection){

            if(librarian.getId().equals(id) || librarian.getName().equals(name) || librarian.getCpf().equals(cpf)){
                search = librarian;
            }

        }
        return search;
    }
    /*
    * @param idLibrarian String id gerado pela classe de função de forma aleartória necessário para atualização e identificação única de cada bibliotecário
    * */
    public void updateLib(ArrayList<Librarian> lCollection, String id,String nName, String nCpf, String nOffice, int nAge, String nPhone, String nEmail) {

        for (Librarian librarian : lCollection) {

            if (librarian.getId().equals(id)) {

                if (nName != null) {
                    librarian.setName(nName);
                }

                if (nCpf != null){
                    librarian.setCpf(nCpf);
                }

                if (librarian.getnPhone() != null){
                    librarian.setnPhone(nPhone);
                }
                if (librarian.getEmail() != null){
                    librarian.setOffice(nEmail);
                }
            }

        }
    }

    public void deleteLib(ArrayList<Librarian> lCollection, String id){

        int index = 0;

        for (Librarian librarian : lCollection){

            if(librarian.getId().equals(id)){
                lCollection.remove(index);
            }
            else{
                index = index + 1;
            }
        }
    }

    /*
    * @param borrowing Borrowing - Tipo de classe responsável pelo empréstimo
    *  @return borrowing retorna um tipo Borrowing  que contém as informações do empréstimo do(s) livros*/

    /*public Borrowing borrowingLibrarian(Borrowing borrowing, User user, ArrayList<Book> borrowedBooks, Book book) {

        String newIdB = bfunctions.generateId("br");
        String nidUser = bfunctions.generateId("us");
        String nUserName = borrowing.getUserName();
        String nIsbn = borrowing.getIsbn();
        String nBookName = borrowing.getBookName();
        Calendar ndStart = borrowing.getdStart();
        Calendar nDevolution = borrowing.getDevolution();
        Calendar nEnd = borrowing.getdEnd();
        Boolean nSituation = borrowing.getrSituation();

        if(nSituation == false) {

            if(borrowedBooks.isEmpty()){
                System.out.println("Nenhum livro emprestado.");

            } else borrowedBooks.add(book);

        } return borrowing;


    }*/


}
