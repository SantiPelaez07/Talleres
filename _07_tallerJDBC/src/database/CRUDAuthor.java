package database;

import java.sql.SQLException;
import java.util.List;

public interface CRUDAuthor {
    public Object insertAuthor(Object obj);
    public List<Object> listAuthor();
    public  boolean updateAuthor(Object obj);
    public  boolean deleteAuthor(Object obj);
}
