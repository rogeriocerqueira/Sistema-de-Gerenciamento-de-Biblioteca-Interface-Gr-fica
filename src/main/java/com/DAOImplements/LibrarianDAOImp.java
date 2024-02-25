package Model.DAO;

import Model.Librarian;
import Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;


public class LibrarianDAOImp implements LibrarianDAO{

    @Override
    public String record(Librarian aLibrarian) throws IOException {

        String sms = "Cadastro salvo !";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonLib = gson.toJson(aLibrarian);

        Path mainPackage = FileSystems.getDefault().getPath("");
        String directory = mainPackage.toAbsolutePath().toString();

        System.out.println(directory);

        FileWriter file = new FileWriter(directory + "/src/Model/Database/librarianDatabase/" + aLibrarian.getCpf() + ".json");
        file.write(jsonLib);
        file.close();

        return jsonLib;

    }

    @Override
    public ArrayList<Librarian> recover() {

        Path mainPackage = FileSystems.getDefault().getPath("");
        String directory = mainPackage.toAbsolutePath().toString();
        File libPackage = new File(directory + "/src/Model/Database/librarianDatabase");

        ArrayList<Librarian> lCollection= new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File[] arquillian = libPackage.listFiles();
        assert arquillian != null;

        for (File json : arquillian){

            Librarian lib = gson.fromJson(String.valueOf(json),Librarian.class);
            lCollection.add(lib);
        }
        return lCollection;
    }
}
