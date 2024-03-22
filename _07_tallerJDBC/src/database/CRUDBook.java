package database;

import java.sql.SQLException;
import java.util.List;

public interface CRUDBook {
    public Object insertBook(Object obj);
    public List<Object> listBook();
    public  boolean updateBook(Object obj);
    public  boolean deleteBook(Object obj);
}
