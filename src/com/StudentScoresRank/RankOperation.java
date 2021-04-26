package com.StudentScoresRank;

/*-
 * @project: CourseRank/src/com.StudentScoresRank/RankOperation
 * @description: operation
 * @author: 1910120228_louis
 * @Date: 2021/4/21 21:29
 *
 **/


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RankOperation {
    public static RankOperation instance = null;

    static {
        try {
            instance = new RankOperation();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static RankOperation getInstance() {
        return instance;
    }

    private Connection conn = null;

    boolean result = false;


    public RankOperation() throws SQLException {
    }

    public boolean saveScores(StuInfo stu) {

        try {
            conn = DatabaseConnection.getCon();  //建立数据库连接
            String sqlInset = "insert into score (Id, NAME, scoreCN, scoreMATH, scoreENG, scoreSCI, totalSCORES) values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常

            stmt.setInt(1, stu.getID());                //设置SQL语句第1个“？”的值
            stmt.setString(2, stu.getNAME());           //设置SQL语句第2个“？”的值
            stmt.setInt(3, stu.getScoreCN());           //设置SQL语句第3个“？”的值
            stmt.setInt(4, stu.getScoreMATH());         //设置SQL语句第4个“？”的值
            stmt.setInt(5, stu.getScoreENG());          //设置SQL语句第5个“？”的值
            stmt.setInt(6, stu.getScoreSCI());          //设置SQL语句第6个“？”的值
            stmt.setInt(7, stu.getTotalSCORES());       //设置SQL语句第7个“？”的值
//            stmt.setInt(8, stu.getRANKING());          //设置SQL语句第个“？”的值

            int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
            if (i == 1) {
                result = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {  // finally 的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                assert conn != null;
                conn.close();  //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * @description: Query the required data from the database
     * @Param: null
     * @return: stuList
     * @author: 1910120228_louis
     * @Date: 2021/4/21
     * @Time: 22:40
     **/
    public List<StuInfo> totalStuInfo() {
        List<StuInfo> stuList = new ArrayList<>();
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery("select * from score")) {  //执行SQL并返回结果集
                while (rs.next()) {
                    StuInfo stu = new StuInfo();

                    stu.setID(rs.getInt("ID"));
                    stu.setNAME(rs.getString("NAME"));      //从结果集rs中获取内容时，若为字符串类型的，用rs.getString("str")方法
                    stu.setScoreCN(rs.getInt("scoreCN"));   //其中str是想要从数据库的表中获取的信息
                    stu.setScoreMATH(rs.getInt("scoreMATH"));         //若为int类型，用re.getInt("number")
                    stu.setScoreENG(rs.getInt("scoreENG"));
                    stu.setScoreSIC(rs.getInt("scoreSCI"));
                    stu.setTotalSCORES(rs.getInt("totalSCORES"));

                    stuList.add(stu);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                assert conn != null;
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return stuList;
    }

    /**
     * @description: Query info by id
     * @Param: null
     * @return:
     * @author: 1910120228_louis
     * @Date: 2021/4/23
     * @Time: 19:12
     **/
    public StuInfo queryInfoById(int ID) {

        StuInfo stu = null;
        String sql = "select * from score where ID=?";

        try {
            conn = DatabaseConnection.getCon();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                stu = new StuInfo();
                stu.setID(rs.getInt("ID"));
                stu.setNAME(rs.getString("NAME"));
                stu.setScoreCN(rs.getInt("scoreCN"));
                stu.setScoreMATH(rs.getInt("scoreMATH"));
                stu.setScoreENG(rs.getInt("scoreENG"));
                stu.setScoreSIC(rs.getInt("scoreSCI"));
                stu.setTotalSCORES(rs.getInt("totalSCORES"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                assert conn != null;
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return stu;
    }

    /**
     * @description: this is a function to update
     * @Param: stu
     * @return: result
     * @author: 1910120228_louis
     * @Date: 2021/4/21
     * @Time: 21:34
     **/
    public boolean updateStu(StuInfo stu) {
        boolean result = false;
        try {
            conn = DatabaseConnection.getCon();
            String sql = "update assignment.score set NAME=?,scoreCN=?,scoreMATH=?,scoreENG=?,scoreSCI=?,totalSCORES=? where ID=?";   // TODO update operation
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(7, stu.getID());
            stmt.setString(1, stu.getNAME());
            stmt.setInt(2, stu.getScoreCN());
            stmt.setInt(3, stu.getScoreMATH());
            stmt.setInt(4, stu.getScoreENG());
            stmt.setInt(5, stu.getScoreSCI());
            stmt.setInt(6, stu.getTotalSCORES());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // TODO Auto-generated catch block
            try {
                assert conn != null;
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    /**
     * @description: this is a function to delete info
     * @Param: StuInfo stu
     * @return: null
     * @author: 1910120228_louis
     * @Date: 2021/4/21
     * @Time: 21:41
     **/
    public boolean deleteInfoById(StuInfo stu) {

        try {
            conn = DatabaseConnection.getCon();
            String sql = "delete from assignment.score where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, stu.getID());
            int i = stmt.executeUpdate();
            if (i == 1) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert conn != null;
                conn.close();
            } catch (Exception e) {
                // todo Auto-generated catch block
                e.printStackTrace();
            }finally {
                try {
                    assert conn != null;
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public List<StuInfo> Descending() {
        List<StuInfo> stuInfoList = new ArrayList<>();
        String sql = "select * from score order by totalSCORES desc";
        try {
            conn = DatabaseConnection.getCon();
            PreparedStatement stmt = conn.prepareStatement(sql);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    StuInfo stu = new StuInfo();
                    stu.setID(rs.getInt("ID"));
                    stu.setNAME(rs.getString("NAME"));
                    stu.setScoreCN(rs.getInt("scoreCN"));
                    stu.setScoreMATH(rs.getInt("scoreMATH"));
                    stu.setScoreENG(rs.getInt("scoreENG"));
                    stu.setScoreSIC(rs.getInt("scoreSCI"));
                    stu.setTotalSCORES(rs.getInt("totalSCORES"));

                    stuInfoList.add(stu);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                assert conn != null;
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return stuInfoList;
    }

}
