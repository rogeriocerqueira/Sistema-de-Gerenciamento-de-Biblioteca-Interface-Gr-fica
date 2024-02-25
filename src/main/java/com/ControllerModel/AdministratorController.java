package com.ControllerModel;

import com.Model.Administrator;
import java.util.ArrayList;

public class AdministratorController {

    /*
    * @param name String - nome do administrador
    * @param cpf String - cpf do administrador
    * @param office String -  profissão do administrador
    * @param age int - idade do administrador
    * @param email String do administrador
    *  */

    Functions function = new Functions();

    public void createAdm(ArrayList<Administrator> aCollection, String name, String cpf, String nPhone, String email){

        Administrator administrator = new Administrator();

        administrator.setId(function.generateId("a"));
        administrator.setName(name);
        administrator.setCpf(cpf);
        administrator.setOffice("Administrador");
        administrator.setnPhone(nPhone);
        administrator.setEmail(email);
        aCollection.add(administrator);

    }

    public Administrator readAdm(ArrayList<Administrator> aCollection,String id, String name, String cpf){

        Administrator search = new Administrator();

        for (Administrator administrator : aCollection){

            if(administrator.getId().equals(id) || administrator.getName().equals(name) || administrator.getCpf().equals(cpf) ){

                search = administrator;
            }

        }
        return search;
    }


    public void updateAdm(ArrayList<Administrator> aCollection, String id,String nName, String nCpf, String nPhone, String nEmail) {

        for (Administrator administrator : aCollection){

            if (administrator.getId().equals(id)) {

                if (nName != null) {
                    administrator.setName(nName);
                }

                if (nCpf != null){
                    administrator.setCpf(nCpf);
                }

                if (administrator.getnPhone() != null){
                    administrator.setnPhone(nPhone);
                }
                if (administrator.getEmail() != null){
                    administrator.setOffice(nEmail);
                }
            }

        }
    }

/*@param idAdministrator String  - id gerado para identificação do objeto administrador*/
    public void deleteAdm(ArrayList<Administrator> aCollection, String id){

        int index = 0;

        for (Administrator administrator : aCollection){

            if(administrator.getId().equals(id)){
                aCollection.remove(index);
            }
            else{
                index = index + 1;
            }
        }
    }
}
