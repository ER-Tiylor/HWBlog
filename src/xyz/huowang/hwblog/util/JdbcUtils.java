package xyz.huowang.hwblog.util;

import java.sql.*;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:35
 * @description：TODO
 * @version: 1.0
 */
public class JdbcUtils {
    Connection connection;
    //加载驱动
    static {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            System.out.println("数据库加载成功！");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    Connection getConn(){
        String url="jdbc:mysql://localhost:3306/hwblog";
        String userName="root";
        String passWord="HJJ119108";
        try {
            connection= DriverManager.getConnection(url,userName,passWord);
            if (connection!=null) {
                System.out.println("链接成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

        return rs;
    }
    //输出查询结果,用于测试，不使用
    public void outPut(ResultSet rs)throws Exception{
        while(rs.next()) {
            String couname=rs.getString("couname");
            String truename=rs.getString("truename");
            String grade=rs.getString("grade");
            System.out.println(couname+" "+truename+" "+grade+"");
        }
    }
    //数据更新
    public void Update(String sql) throws Exception {
        test=new JdbcUtils();
        con=test.getConn();
        System.out.println(con.getCatalog());
        statement = con.createStatement();
        int i=statement.executeUpdate(sql);
        if(i>0) {
            System.out.println("操作数据成功!");
        }else {
            System.out.println("操作数据失败!");
        }
    }
    //关闭占用资源
    public void closeSource() throws Exception{
        if (rs!=null) {
            rs.close();
            rs=null;
            System.out.println("关闭rs成功！");
        }
        if(statement!=null) {
            statement.close();
            statement=null;
            System.out.println("关闭statement成功！");
        }
        if(con!=null && con.isClosed()==false) {
            con.close();
            con=null;
            System.out.println("关闭数据库的连接成功");
        }
    }
}
