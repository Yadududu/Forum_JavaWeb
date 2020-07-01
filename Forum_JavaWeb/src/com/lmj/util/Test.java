package com.lmj.util;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.dbutils.ResultSetHandler;



public class Test {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String username = "root";
    private static String password = "root";
    static {
        try {
            // �������ݿ�����
            Class.forName(driver);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * @Method: getConnection
     * @Description: ��ȡ���ݿ����Ӷ���
     * @Anthor:�°�����
     *
     * @return Connection���ݿ����Ӷ���
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * @Method: release
     * @Description: �ͷ���Դ�� Ҫ�ͷŵ���Դ����Connection���ݿ����Ӷ��󣬸���ִ��SQL�����Statement����
     *               �洢��ѯ�����ResultSet����
     * @Anthor:�°�����
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                // �رմ洢��ѯ�����ResultSet����
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (st != null) {
            try {
                // �رո���ִ��SQL�����Statement����
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                // �ر�Connection���ݿ����Ӷ���
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Method: update
     * @Description: ���ܸ��� ����ʵ���CUD�������������ͬ���������͸����ݿ��SQL��䲻ͬ���ѣ�
     *               ��˿��԰�CUD������������ͬ�����ȡ���������һ��update�����У�������������ձ仯��SQL���
     * @Anthor:�°�����
     * @param sql
     *            Ҫִ�е�SQL
     * @param params
     *            ִ��SQLʱʹ�õĲ���
     * @throws SQLException
     */
    public static void update(String sql, Object params[]) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            st = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            st.executeUpdate();

        } finally {
            release(conn, st, rs);
        }
    }

    /**
     * @Method: query
     * @Description:���ܲ�ѯ ʵ���R��������SQL��䲻֮ͬ�⣬���ݲ�����ʵ�岻ͬ����ResultSet��ӳ��Ҳ������ͬ��
     *                   ��˿���һ��query���������Բ�����ʽ���ձ仯��SQL����⣬
     *                   ����ʹ�ò���ģʽ��qurey�����ĵ����߾�����ΰ�ResultSet�е�����ӳ�䵽ʵ������С�
     * @Anthor:�°�����
     *
     * @param sql
     *            Ҫִ�е�SQL
     * @param params
     *            ִ��SQLʱʹ�õĲ���
     * @param rsh
     *            ��ѯ���صĽ����������
     * @return
     * @throws SQLException
     */
    public static Object query(String sql, Object params[], ResultSetHandler rsh) throws SQLException {

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            st = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            rs = st.executeQuery();
            /**
             * ���ڲ�ѯ���صĽ��������ʹ�õ��˲���ģʽ��
             * �����query����ʱ��query�����������޷�֪���û��Է��صĲ�ѯ�������ν��д���ģ�����֪��������Ĵ�����ԣ�
             * ��ô���������Ĵ�����Ծ����û��Լ��ṩ��query�����ڲ��͵����û��ύ�Ľ����������Խ��д���
             * Ϊ���ܹ����û��ṩ������Ĵ�����ԣ���Ҫ���û���¶��һ�����������ӿ�ResultSetHandler
             * �û�ֻҪʵ����ResultSetHandler�ӿڣ���ôquery�����ڲ���֪���û�Ҫ��δ���������
             */
            return rsh.handle(rs);

        } finally {
            release(conn, st, rs);
        }
    }
    
    public static DataSource getDataSource(){
        return new DataSource() {
            
            
            @Override
            public Connection getConnection(String username, String password) throws SQLException {
                
                return null;
            }
            
            @Override
            public Connection getConnection() throws SQLException {
                
                return Test.getConnection();
            }

            @Override
            public PrintWriter getLogWriter() throws SQLException {
                
                return null;
            }

            @Override
            public int getLoginTimeout() throws SQLException {
                
                return 0;
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                
                return null;
            }

            @Override
            public void setLogWriter(PrintWriter out) throws SQLException {
                
                
            }

            @Override
            public void setLoginTimeout(int seconds) throws SQLException {
                
                
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                
                return false;
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {
                
                return null;
            }
        };
    }
}