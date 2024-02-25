package Model.DAO;
import Model.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/*Interface of the user*/
public interface UserDAO {
    public String record(User aUser) throws IOException;
    public ArrayList<User> recover() throws FileNotFoundException;

}
