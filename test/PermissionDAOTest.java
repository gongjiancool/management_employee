import com.study.dao.PermissionDAO;
import com.study.factory.DAOFactory;
import org.junit.Before;
import org.junit.Test;
import org.omg.DynamicAny.DynAnyOperations;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by HP on 2017/12/19.
 */
public class PermissionDAOTest {
    private PermissionDAO permissionDAO;
    @Before
    public void setUp() throws Exception {
        permissionDAO = DAOFactory.getPermissionDAOInstance();
    }

    @Test
    public void getPermission() throws Exception {
        Map<String, List<String>> map = permissionDAO.getPermission("1602753103");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + ", value= " + entry.getValue());
        }
    }

}