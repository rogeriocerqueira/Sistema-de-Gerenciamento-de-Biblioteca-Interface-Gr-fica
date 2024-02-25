package Model.DAO;

import Model.Borrowing;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

public class BorrowingDAOImp implements BorrowingDAO{

    @Override
    public String record(Borrowing aBorrow) throws IOException {

        Gson gson = new Gson();
        String jsonBorrow = gson.toJson(aBorrow);

        Path mainPackage = FileSystems.getDefault().getPath("");
        String directory = mainPackage.toAbsolutePath().toString();

        FileWriter file = new FileWriter(directory + "/src/Model/Database/borrowingDatabase/" + aBorrow.getIdB() + ".json");
        file.write(jsonBorrow);
        file.close();

        return jsonBorrow;

    }

    @Override
    public ArrayList<File> recover(){

        ArrayList<File> borrows = new ArrayList<>();

        Path mainPackage = FileSystems.getDefault().getPath("");
        String directory = mainPackage.toAbsolutePath().toString();

        File borrowPackage = new File(directory + "/src/Model/Database/borrowingDatabase");

        for(File file : borrowPackage.listFiles()){

            borrows.add(file);
        }

        return borrows;
    }
}
