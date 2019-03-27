package com.hwua.jsp.daoImpl;

import java.sql.*;
import java.util.*;
/*
 *
 * DAO = Data Access Object
 * 数据访问对象
 * 对用户表的操作，UserDao
 * 对商品表的操作，用GoodDao
 * 一般我们都会写一个XxxDao的接口，再写一个XxxDaoImpl
 * 为什么分为接口与实现。
 * 接口的作用：制定规范,只规定做什么事情，不规定这么做，具体的做法，是实现类问题
 * 比如UserDao接口，这里定义往数据库写入用户的信息，但是具体怎么写入，写入的数mysql数据库，还是oracle数据库，这个接口不管
 * 需要实现类来具体实现。
 *
 * */

public abstract class CommonDao<T> {

    public void close(ResultSet rs,PreparedStatement ps,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract T getDataFromResultSet(ResultSet rs);

    public int insertAndReturnId(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        int id = 0;
        try {
            conn = ConnectionFactory.getDataSource().getConnection();
            System.out.println("要执行的SQL：" + sql);
            System.out.println("输入的参数："+ Arrays.asList(params));
            ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject((i + 1), params[i]);
                }
            }
            ps.executeUpdate();
            rs=ps.getGeneratedKeys();
            while(rs.next()){
                id=rs.getInt(1);
            }
            System.out.println("受影响的行数：" + id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null,ps,conn);
            return id;

        }

    }




    public int commonUpdate(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            conn = ConnectionFactory.getDataSource().getConnection();
            System.out.println("要执行的SQL：" + sql);
            System.out.println("输入的参数："+ Arrays.asList(params));
            ps = conn.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject((i + 1), params[i]);
                }
            }
            result = ps.executeUpdate();
            System.out.println("受影响的行数：" + result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null,ps,conn);
            return result;

        }

    }

    public List<Map<String,Object>> queryForListMap(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        try {
            conn = ConnectionFactory.getDataSource().getConnection();
            System.out.println("要执行的SQL：" + sql);
            System.out.println("输入的参数："+ Arrays.asList(params));
            ps = conn.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject((i + 1), params[i]);
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int cc=rsmd.getColumnCount();
            String cname=null;
            Object value=null;
            Map<String,Object> map=null;
            while (rs.next()) {
                map=  new HashMap<String,Object>();
                for(int i=1;i<=cc;i++){
                    cname=rsmd.getColumnName(i);

                    value=rs.getObject(cname);
                    map.put(cname,value);
                }
                list.add(map);
            }
            System.out.println("获得的结果是：" + list);
            //关闭资源的顺序，是先打开的后关闭

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs,ps,conn);
            return list;
        }

    }

    public Map<String,Object> queryForMap(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String,Object> map=null;
        try {
            conn = ConnectionFactory.getDataSource().getConnection();
            System.out.println("要执行的SQL：" + sql);
            System.out.println("输入的参数："+ Arrays.asList(params));
            ps = conn.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject((i + 1), params[i]);
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int cc=rsmd.getColumnCount();
            String cname=null;
            Object value=null;
            while (rs.next()) {
                map=  new HashMap<String,Object>();
                for(int i=1;i<=cc;i++){
                    cname=rsmd.getColumnName(i);
                    value=rs.getObject(cname);
                    map.put(cname,value);
                }
            }
            System.out.println("获得的结果是：" + map);
            //关闭资源的顺序，是先打开的后关闭

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs,ps,conn);
            return map;
        }

    }

    public T queryForOne(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        T t=null;
        try {
            conn = ConnectionFactory.getDataSource().getConnection();
            System.out.println("要执行的SQL：" + sql);
            System.out.println("输入的参数："+ Arrays.asList(params));
            ps = conn.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject((i + 1), params[i]);
                }
            }
            rs = ps.executeQuery();
            while (rs.next()) {
               t=getDataFromResultSet(rs);
            }
            System.out.println("获得的结果是：" + t);
            //关闭资源的顺序，是先打开的后关闭

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs,ps,conn);
            return t;
        }

    }

    public List<T> queryForList(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list=new ArrayList<T>();
        try {
            conn = ConnectionFactory.getDataSource().getConnection();
            System.out.println("要执行的SQL：" + sql);
            System.out.println("输入的参数："+ Arrays.asList(params));
            ps = conn.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject((i + 1), params[i]);
                }
            }
            rs = ps.executeQuery();
            T t=null;
            while (rs.next()) {
                t=getDataFromResultSet(rs);
                list.add(t);
            }
            System.out.println("获得的结果是：" + list);
            //关闭资源的顺序，是先打开的后关闭

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs,ps,conn);
            return list;
        }

    }

    public int queryForCount(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count=0;
        try {
            conn = ConnectionFactory.getDataSource().getConnection();
            System.out.println("要执行的SQL：" + sql);
            System.out.println("输入的参数："+ Arrays.asList(params));
            ps = conn.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject((i + 1), params[i]);
                }
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                count=rs.getInt("total");
            }
            System.out.println("获得的结果是：" + count);
            //关闭资源的顺序，是先打开的后关闭

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs,ps,conn);
            return count;
        }

    }

}
