package com.ControllerModel;
import com.Model.User;
import java.util.ArrayList;


public class UserController {
    /*
     * @param name String - nome do usuário
     * @param cpf String - cpf do usuário
     * @param office String -  profissão do usuário
     * @param age int - idade do usuário
     * @param email String do usuário
     *  */

    Functions function = new Functions();

    public void createUser(ArrayList<User> uCollection, String cpf, String name, String nPhone, String email, String address){

        User user = new User();

        user.setId(function.generateId("u"));
        user.setName(name);
        user.setCpf(cpf);
        user.setOffice("Usuário");
        user.setnPhone(nPhone);
        user.setEmail(email);
        user.setAddress(address);

        uCollection.add(user);
    }

    public User readUser(ArrayList<User> uCollection, String id, String name, String cpf){

        User search = new User();

        for (User user : uCollection){

            if(user.getId().equals(id) || user.getName().equals(name) || user.getCpf().equals(cpf) ){

                search = user;
            }
        }
        return search;
    }

    /*
     * @param idLibrarian String id gerado pela classe de função de forma aleartória necessário para atualização e identificação única de cada usuário
     * */
    public void updateUser(ArrayList<User> uCollection, String idUser,String nName, String nCpf, String nPhone, String nEmail,String nAddress) {

        for (User user : uCollection) {

            if (user.getId().equals(idUser)) {

                if (nName != null) {
                    user.setName(nName);
                }

                if (nCpf != null){
                    user.setCpf(nCpf);
                }
                if(nPhone != null){
                    user.setnPhone(nPhone);
                }
                if(nEmail != null){
                    user.setEmail(nEmail);
                }
                if(nAddress != null){
                    user.setAddress(nAddress);
                }
            }
        }
    }

    public void deleteUser(ArrayList<User> uCollection, String idUser) {

        int index = 0;

        for (User user : uCollection) {

            if (user.getId().equals(idUser)) {
                uCollection.remove(index);
            } else {
                index = index + 1;
            }
        }
    }

}
