package com.blogspot.danserlesgens.dao.impl;

import com.blogspot.danserlesgens.dao.ICompanyDAO;
import com.blogspot.danserlesgens.value.CompanyValue;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.blogspot.danserlesgens.factory.ConnectionFactory.getUniqueConnection;
public class CompanyDaoImpl implements ICompanyDAO {
    private String sql = null;
    @Override
    public void create(CompanyValue company) throws Exception {
        sql = "INSERT INTO company_info VALUES (?,?,?)";
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,company.getName());
            ps.setString(2,company.getMan());
            ps.setBigDecimal(3,company.getManCardId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("单位DAO增加错误"+e.getMessage());
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
    public void delete(CompanyValue company) throws Exception {
        sql = "DELETE FROM company_info WHERE com_name = ?";
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, company.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("CompanyDao删除错误" + e.getMessage());
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
    public void update(CompanyValue company) throws Exception {
        sql = "UPDATE company_info SET main_man = ?,main_man_card_id = ? WHERE com_name = ?";
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,company.getMan());
            ps.setBigDecimal(2,company.getManCardId());
            ps.setString(3,company.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("CompanyDao更新错误"+e.getMessage());
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
    public List<CompanyValue> findAll() throws Exception {
        sql = "SELECT * FROM company_info";
        List<CompanyValue> list = new ArrayList<>();
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CompanyValue company = new CompanyValue();
                company.setName(rs.getString(1));
                company.setMan(rs.getString(2));
                company.setManCardId(rs.getBigDecimal(3));
                list.add(company);
            }
        } catch (SQLException e) {
            throw new Exception("CompanyDaoImpl得到单位列表错误" + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    @Override
    public CompanyValue findByName(String name) throws Exception {
        sql = "SELECT * FROM company_info WHERE com_name = ?";
        CompanyValue company = new CompanyValue();
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            while(rs.next()){
                company.setName(rs.getString(1));
                company.setMan(rs.getString(2));
                company.setManCardId(rs.getBigDecimal(3));
            }

        } catch (SQLException e) {
            conn.rollback();
            throw new Exception("CompanyDAO得到单位错误"+e.getMessage());
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
        return company;
    }

    @Override
    public List<CompanyValue> findByPage(int pageNumber, int pageSize, String order) throws Exception {
        sql = "SELECT * FROM company_info WHERE com_name REGEXP ? LIMIT ?,?";
        List<CompanyValue> list = new ArrayList<>();
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,order);
            ps.setInt(2,(pageNumber-1)*pageSize);
            ps.setInt(3,pageSize);
            rs = ps.executeQuery();
            while(rs.next()){
                CompanyValue company = new CompanyValue();
                company.setName(rs.getString(1));
                company.setMan(rs.getString(2));
                company.setManCardId(rs.getBigDecimal(3));
                list.add(company);
            }
        } catch (SQLException e) {
            throw new Exception("companyDao得到分页列表错误"+e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps !=null) {
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return list;
    }

    @Override
    public List<CompanyValue> findByPage(int pageNumber, int pageSize) throws Exception {
        sql = "SELECT * FROM company_info LIMIT ?,?";
        List<CompanyValue> list = new ArrayList<>();
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,(pageNumber-1)*pageSize);
            ps.setInt(2,pageSize);
            rs = ps.executeQuery();
            while(rs.next()){
                CompanyValue company = new CompanyValue();
                company.setName(rs.getString(1));
                company.setMan(rs.getString(2));
                company.setManCardId(rs.getBigDecimal(3));
                list.add(company);
            }
        } catch (SQLException e) {
            throw new Exception("companyDao得到分页列表错误"+e.getMessage());
        } finally {

            if (rs != null) {
                rs.close();
            }
            if (ps !=null) {
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return list;
    }

    @Override
    public int listNumber() throws Exception {
        sql = "SELECT Count(*) FROM company_info";
        int listNumber = 0;
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                listNumber = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new Exception("CompanyDao得到分页列表错误"+e.getMessage());
        } finally {

            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return listNumber;
    }

    @Override
    public double totalPay(CompanyValue company) throws Exception {
        sql = "CALL process_pay(?,?)";
        double payment = 0.0;
        Connection conn = getUniqueConnection();
        CallableStatement csPro = null;
        try {
            csPro = conn.prepareCall(sql);
            csPro.setString(1,company.getName());
            csPro.registerOutParameter(2,Types.DOUBLE);
            csPro.execute();
            payment = csPro.getDouble(2);
        }catch (SQLException e){
            throw new Exception("CompanyDao得到总支出（存储过程）错误"+e.getMessage());
        } finally {
            if (csPro != null){
                csPro.close();
            }
            if (conn != null){
                conn.close();
            }
        }
        return payment;
    }

    @Override
    public Map<String, Integer> possession() throws Exception {
        sql = "SELECT * FROM possession_num";
        Map<String,Integer> poss = new HashMap<>();
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String comName = rs.getString(1);
                Integer num = rs.getInt(2);
                poss.put(comName,num);
            }
        }catch (SQLException e){
            conn.rollback();
            throw new Exception("CompanyDAO possession视图错误"+e.getMessage());
        } finally {
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (conn != null){
                conn.close();
            }
        }
        return poss;
    }
}
