package com.hwua.jsp.daoImpl;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory ourInstance = new ConnectionFactory();
    private static DataSource ds;

    public static DataSource getDataSource() {
        return ds;
    }

    private ConnectionFactory() {
        InputStream is=null;
        try {
            Properties pro = new Properties();
            is = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
            pro.load(is);
            Map<String,String> params=new HashMap<String,String>();
            params.put("driverClassName",pro.getProperty("jdbc.driver"));
            params.put("url",pro.getProperty("jdbc.url"));
            params.put("username",pro.getProperty("jdbc.username"));
            params.put("password", pro.getProperty("jdbc.password"));
            ds=DruidDataSourceFactory.createDataSource(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
