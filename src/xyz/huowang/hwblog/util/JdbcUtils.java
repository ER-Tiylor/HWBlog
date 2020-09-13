package xyz.huowang.hwblog.util;

import org.apache.log4j.Logger;

import java.sql.*;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:35
 * @description：TODO
 * @version: 1.0
 */
public class JdbcUtils {
    Connection connection;
    //通过Logger的getLogger获取一个Loogger实例
    public static Logger log= Logger.getLogger(JdbcUtils.class);
    //加载驱动
    static {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            log.info("数据库加载成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.error("数据库加载失败！");
        }

    }
    private Connection getConn(){
        String url="jdbc:mysql://localhost:3306/hwblog";
        String userName="root";
        String passWord="*********";
        try {
            connection= DriverManager.getConnection(url,userName,passWord);
            if (connection!=null) {
                log.info("数据库链接成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("数据库链接失败!");
        }
        return connection;
    }

    private Connection con = null;
    private Statement statement = null;
    private ResultSet rs =null;
    private JdbcUtils  test=null;

    //查询函数
    public ResultSet Query(String sql) throws Exception {
        test=new JdbcUtils();
        con = test.getConn();

        statement = con.createStatement();
        rs = statement.executeQuery(sql);
        if(rs==null){
            log.error("查询数据返回为空");
        }
        return rs;
    }

    //数据更新
    public void Update(String sql) throws Exception {
        test=new JdbcUtils();
        con=test.getConn();

        statement = con.createStatement();
        int i=statement.executeUpdate(sql);
        if(i>0) {
            log.info("数据库操作成功！");
        }else {
            log.error("数据库操作失败！");
        }
    }

    //关闭占用资源
    public void closeSource() throws Exception{
        if (rs!=null) {
            rs.close();
            rs=null;
            log.info("关闭rs成功!");
        }
        if(statement!=null) {
            statement.close();
            statement=null;
            log.info("关闭statement成功!");
        }
        if(con!=null && con.isClosed()==false) {
            con.close();
            con=null;
            log.info("关闭数据库的连接成功!");
        }
    }
}
