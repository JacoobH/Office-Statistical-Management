package com.blogspot.danserlesgens.dao.impl;

import com.blogspot.danserlesgens.dao.ICompanyNumDAO;
import com.blogspot.danserlesgens.factory.BusinessFactory;
import com.blogspot.danserlesgens.factory.DaoFactory;
import com.blogspot.danserlesgens.value.CompanyNumValue;
import com.blogspot.danserlesgens.value.CompanyValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.blogspot.danserlesgens.factory.ConnectionFactory.getUniqueConnection;

public class CompanyNumDaoImpl implements ICompanyNumDAO {
    private String sql = null;
    @Override
    public void create(CompanyNumValue companyNum) throws Exception {
        sql = "INSERT INTO company_num VALUES (?,?)";
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,companyNum.getName());
            ps.setInt(2,companyNum.getNum());
            ps.executeUpdate();
        }catch (SQLException e) {
            throw new Exception("单位联系号码DAO增加错误"+e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null){
                conn.close();
            }
        }
    }

    @Override
    public void delete(CompanyNumValue companyNum) throws Exception {
        sql = "DELETE FROM company_num WHERE com_name = ?";
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyNum.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("CompanyNumDao删除错误" + e.getMessage());
        } finally {
            if (ps != null){
                ps.close();
            }
            if (conn != null){
                conn.close();
            }
        }
    }

    @Override
    public void update(CompanyNumValue companyNum) throws Exception {
        sql = "UPDATE company_num SET com_num = ? WHERE com_name = ?";
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,companyNum.getNum());
            ps.setString(2,companyNum.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("CompanyNumDao更新错误"+e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null){
                conn.close();
            }
        }
    }

//    @Override
//    public List<CompanyNumValue> findAll() throws Exception {
//        sql = "SELECT * FROM company_num";
//        List<CompanyNumValue> list = new ArrayList<>();
//        Connection conn = getUniqueConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            ps = conn.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                CompanyNumValue companyNum = new CompanyNumValue();
//                companyNum.setName(rs.getString(1));
//                companyNum.setNum(rs.getInt(2));
//                list.add(companyNum);
//            }
//        } catch (SQLException e) {
//            throw new Exception("CompanyNumDaoImpl得到单位联系号码列表错误" + e.getMessage());
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (ps != null) {
//                ps.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return list;
//    }

    @Override
    public List<CompanyNumValue> findByName(String name) throws Exception {
        sql = "SELECT * FROM company_num WHERE com_name = ?";
        List<CompanyNumValue> list = new ArrayList<>();
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            while(rs.next()){
                CompanyNumValue companyNum = new CompanyNumValue();
                companyNum.setName(rs.getString(1));
                companyNum.setNum(rs.getInt(2));
                list.add(companyNum);
            }

        } catch (SQLException e) {
            conn.rollback();
            throw new Exception("CompanyNumDAO得到单位联系号码列表错误"+e.getMessage());
        } finally {

            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null){
                conn.close();
            }
        }
        return list;
    }
}
