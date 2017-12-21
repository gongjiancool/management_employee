package com.study.dao.impl;

import com.study.dao.PermissionDAO;
import com.study.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by HP on 2017/12/19.
 */
public class PermissionDAOImpl implements PermissionDAO{
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public Map<String, List<String>> getPermission(String account) throws SQLException {
        Map<String, List<String>> permissionMap = new HashMap<>();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.`group_name`,t2.`nape_name` FROM t_group t1\n" +
                "INNER JOIN t_nape t2\n" +
                "ON t1.`group_id` = t2.`group_id`\n" +
                "INNER JOIN t_mapping t3\n" +
                "ON t2.`nape_id` = t3.`nape_id`\n" +
                "WHERE t3.`account`= ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, account);
        ResultSet rs = ps.executeQuery();
        List<String> napeList1 = new ArrayList<>();
        List<String> napeList2 = new ArrayList<>();
        List<String> napeList3 = new ArrayList<>();
        List<String> napeList4 = new ArrayList<>();
        List<String> napeList5 = new ArrayList<>();
        List<String> napeList6 = new ArrayList<>();
        List<String> napeList7 = new ArrayList<>();
        Set<String> nameSet = new HashSet<>();
        while (rs.next()) {
            String group_name = rs.getString("group_name");
            nameSet.add(group_name);
            String nape_name = rs.getString("nape_name");
            if (nape_name.contains("档案")) {
                napeList1.add(nape_name);
            }
            if (nape_name.contains("培训")) {
                napeList2.add(nape_name);
            }
            if (nape_name.contains("工资")) {
                napeList3.add(nape_name);
            }
            if (nape_name.contains("信息")) {
                napeList4.add(nape_name);
            }
            if (nape_name.contains("发送" )) {
                napeList5.add(nape_name);
            }
            if (nape_name.contains("奖惩")) {
                napeList6.add(nape_name);
            }
            if (nape_name.contains("考勤")) {
                napeList7.add(nape_name);
            }
        }
        List<String>[] lists = new List[]{napeList1, napeList2, napeList3, napeList4,napeList5,napeList6,napeList7};
        for (int i = 0, j = 0; i < lists.length; i++) {
            if (lists[i].size() != 0) {
                String name = nameSet.toArray()[j].toString();
                permissionMap.put(name, lists[i]);
                j++;
            } else {
                continue;
            }
        }
        return permissionMap;
    }
}
