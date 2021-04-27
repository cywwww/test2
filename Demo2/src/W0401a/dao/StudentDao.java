package W0401a.dao;

import W0401a.bean.Student;
import W0401a.inter.StudentInterface;
import W0401a.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Author 王承尧
 * @Date 2021/4/1 6:01 下午
 */
public class StudentDao implements StudentInterface {

    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    @Override
    public boolean addStudent(Student stu) {
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into student values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,stu.getStuId());
            ps.setString(2,stu.getStuName());
            ps.setInt(3,stu.getStuAge());
            ps.setString(4,stu.getStuSex());
            ps.setFloat(5,stu.getStuScore());
            if (ps.executeUpdate()>0) {
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,ps,rs);
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String stuId) {
        try {
            conn = DBUtil.getConnection();
            String sql = "delete student where stuId = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,stuId);
            if (ps.executeUpdate()>0) {
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,ps,rs);
        }
        return false;
    }

    @Override
    public boolean setStudent(Student stu) {
        try{
            conn = DBUtil.getConnection();
            String sql = "update student SET stuName = ?,stuAge = ?,stuSex = ?,stuScore = ? where stuId = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(5,stu.getStuId());
            ps.setString(1,stu.getStuName());
            ps.setInt(2,stu.getStuAge());
            ps.setString(3,stu.getStuSex());
            ps.setFloat(4,stu.getStuScore());
            if (ps.executeUpdate()>0) {
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,ps,rs);
        }
        return false;
    }

    @Override
    public ArrayList<Student> selectAll() {
        ArrayList<Student> a = new ArrayList<>();
        try{
            conn = DBUtil.getConnection();
            String sql = "select * from student";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                a.add(new Student(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getFloat(5)));
            }
            return a;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,ps,rs);
        }
        return a;
    }

    @Override
    public Student select(String stuId) {
        Student stu =null;
        try{
            conn = DBUtil.getConnection();
            String sql = "select * from student where stuId = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,stuId);
            rs = ps.executeQuery();
            if (rs.next()) {
                stu = new Student(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getFloat(5));
            }
            return stu;

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,ps,rs);
        }
        return stu;
    }
}
