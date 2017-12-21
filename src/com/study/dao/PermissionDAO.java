package com.study.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by HP on 2017/12/19.
 */
public interface PermissionDAO {
    Map<String,List<String>> getPermission(String account) throws SQLException;
}
