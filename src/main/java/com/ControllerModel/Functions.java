package com.ControllerModel;

import com.Model.Book;
import com.Model.Borrowing;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

/**Classe destinada a gerar id's e responsavel pela manipulação de tempo.
 * @author João Macedo e Rogério Cerqueira
 * @version 1.0
 *
 */

public class Functions {

    /** Método para retorno id.
     * @return String - id*
     * @param typeId String - Tipo de id solicitado*/

    public String generateId(String typeId) {

        String code;

        Random random = new Random();
        int n = random.nextInt(100000000);
        String nS = String.valueOf(n);

        code = typeId + nS;

        return code;

    }

    /** Método para retorno datas.
     * @return Calendar - Data*/
    public Calendar actualDater(){

        return Calendar.getInstance();
    }

    /** Método responsavel por determinar a data de entrega.
     * @return Calendar - Data de entrega*/

    public Calendar receiveDater(){

        int plus = 7;
        Calendar date = Calendar.getInstance();

        if(date.get(Calendar.DAY_OF_MONTH) >= 25 && date.get(Calendar.MONTH) == Calendar.DECEMBER){

            int m = (date.get(Calendar.DAY_OF_MONTH) + plus) - 31;

            date.add(Calendar.YEAR,1);
            date.set(Calendar.MONTH,1);
            date.set(Calendar.DAY_OF_MONTH, m);
        }

        if(date.get(Calendar.DAY_OF_MONTH) + plus > 31){

            date.add(Calendar.MONTH,1);
            date.set(Calendar.DAY_OF_MONTH, plus);

        }
        else { date.add(Calendar.DAY_OF_MONTH,plus);}

        return date;

    }

    /** Método responsavel por determinar o tempo de bloqueio.
     * @return int - Multa*
     * @param dEnd Calendar - Datal que o livro foi devolvido/ emprestimo encrrado*
     * @param devolution Calendar - Data da estipulada devolução.*/

    public int blockerDater(Calendar dEnd, Calendar devolution){

        int block = 0;
        boolean confirm = dEnd.after(devolution);

        if(confirm){

            if(dEnd.get(Calendar.MONTH) > devolution.get(Calendar.MONTH)){

            int finish = dEnd.get(Calendar.DAY_OF_MONTH);
            int expected = devolution.get(Calendar.DAY_OF_MONTH);

            block = ((31-expected) + finish) * 2;
            }
            else{

                int finish = dEnd.get(Calendar.DAY_OF_MONTH);
                int expected = devolution.get(Calendar.DAY_OF_MONTH);
                block = (finish - expected) * 2; }

        }

        return block;
    }

    /** Método responsavel por determinar o status de emprestimo de um usuario.
     * @return boolean - status*/

    public boolean changeStatus (){
        return true;
    }

    /** Método responsavel por determinar se um usuario já está apto a fazer emprestimos.
     * @return boolean - status *
     * @param conferee Calendar - Dia maximo de bloqueio*/

    public boolean cofereeBlock(Calendar conferee){
        boolean status = true;

        Calendar actual = Calendar.getInstance();

        if(conferee.before(actual)){status = false;}

     return status;
    }

    /*public void registerBook(ArrayList<Book> collection){}
    public void searchBook(ArrayList<Book> collection){}*/

    public void loanBook(ArrayList<Book> collection, ArrayList <Borrowing> loans){


    }
    public void devolution(String idBorrow, ArrayList<Book> collection, ArrayList <Borrowing> loans, ArrayList<Borrowing> finished){

        String menssage;
        int i1 = 0;

        for (Borrowing borrowing : loans) {
            if(idBorrow.equals(borrowing.getIdB()) && borrowing.getrSituation().equals("1")){
                borrowing.setrSituation("3");
                finished.add(borrowing);
                loans.remove(i1);

                /*Parte do Dao - Salvar na pasta de emprestimos finalizados*/
            }
            i1 += 1;
        }

        int i2 = finished.size() - 1;

        for(int i = 0; i < loans.size(); i++){
            if(loans.get(i).getIsbn().equals(finished.get(i2).getIsbn()) && loans.get(i).getrSituation().equals("2")){ /* Se houver uma reserva(2 - Reserva) do livro devolvido no momento, então o livro será atribuido para essa reserva*/
                loans.get(i).setrSituation("1");
            }
            else{
                for(Book book : collection){
                    if(book.getIsbn().equals(finished.get(i2).getIsbn())){
                        int n = book.getNumber() + 1;
                        book.setNumber(n);
                    }

                }
            }
        }

    }

}
