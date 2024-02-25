package Model.DAO;

import Model.Librarian;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/*Interface of the librarian*/
public interface LibrarianDAO {
    public String record(Librarian aLibrarian) throws IOException;
    public ArrayList<Librarian> recover() throws FileNotFoundException;
}
