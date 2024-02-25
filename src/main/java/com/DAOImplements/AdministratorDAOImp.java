package Model.DAO;

import Model.Administrator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

public class AdministratorDAOImp implements AdministratorDAO{
    @Override
    public String record(Administrator aAdministrator) throws IOException {

        String sms = "Cadastro salvo !";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonAdm = gson.toJson(aAdministrator);

        Path mainPackage = FileSystems.getDefault().getPath("");
        String directory = mainPackage.toAbsolutePath().toString();

        FileWriter file = new FileWriter(directory + "/src/Model/Database/administratorDatabase/" + aAdministrator.getCpf() + ".json");
        file.write(jsonAdm);
        file.close();

        return sms;
    }

    @Override
    public ArrayList<Administrator> recover() {

        Path mainPackage = FileSystems.getDefault().getPath("");
        String directory = mainPackage.toAbsolutePath().toString();
        File admPackage = new File(directory + "/src/Model/Database/administratorDatabase");

        ArrayList<Administrator> aCollection= new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        File[] arquillian = admPackage.listFiles();
        assert arquillian != null;

        for (File json : arquillian) {

            Administrator adm = gson.fromJson(String.valueOf(json),Administrator.class);
            aCollection.add(adm);

        }
        return aCollection;
    }
}
