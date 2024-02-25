package Model.DAO;

import Model.Borrowing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface BorrowingDAO {
    public String record(Borrowing aBorrow) throws IOException;
    public ArrayList<File> recover();

}
