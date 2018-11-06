package com.blogspot.danserlesgens.dao.impl;

import com.blogspot.danserlesgens.dao.IAccountDAO;
import com.blogspot.danserlesgens.value.AccountValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.blogspot.danserlesgens.factory.ConnectionFactory.getUniqueConnection;

public class AccountDaoImpl implements IAccountDAO {
    private String sql = null;
    @Override
    public synchronized void create(AccountValue account) throws Exception {
        sql = "INSERT INTO account VALUES (?,?,?)";
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,account.getUser());
            ps.setString(2,account.getPassword());
            ps.setString(3,account.getPower());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("账户DAO增加错误"+e.getMessage());
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
    public synchronized void delete(AccountValue account) throws Exception {
        sql = "DELETE FROM account WHERE account.user = ?";
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getUser());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("账户DAO删除错误" + e.getMessage());
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
    public synchronized void update(AccountValue account) throws Exception {
        sql = "UPDATE account SET password = ?,power = ? WHERE user = ?";
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,account.getPassword());
            ps.setString(2,account.getPower());
            ps.setString(3,account.getUser());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("账户DAO更新错误"+e.getMessage());
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
    public List<AccountValue> findAll() throws Exception {
        sql = "SELECT * FROM account";
        List<AccountValue> list = new ArrayList<>();
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                AccountValue account = new AccountValue();
                account.setUser(rs.getString(1));
                account.setPassword(rs.getString(2));
                account.setPower(rs.getString(3));
                list.add(account);
            }
        } catch (SQLException e) {
            throw new Exception("账户DAO得到账户列表错误"+e.getMessage());
        } finally {
            if (rs != null){
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return list;
    }

    @Override
    public AccountValue findByUser(String user) throws Exception {
        sql = "SELECT * FROM account WHERE user = ?";
        AccountValue account = new AccountValue();
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            rs = ps.executeQuery();
            while(rs.next()){
                account.setUser(rs.getString(1));
                account.setPassword(rs.getString(2));
                account.setPower(rs.getString(3));
            }

        } catch (SQLException e) {
            conn.rollback();
            throw new Exception("账户DAO得到账户错误"+e.getMessage());
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
        return account;
    }
    @Override
    public List<AccountValue> findByPage(int pageNumber, int pageSize, String order) throws Exception {
        sql = "SELECT * FROM account WHERE user REGEXP ? LIMIT ?,?";
        List<AccountValue> list = new ArrayList<>();
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
                AccountValue account = new AccountValue();
                account.setUser(rs.getString(1));
                account.setPassword(rs.getString(2));
                account.setPower(rs.getString(3));
                list.add(account);
            }
        } catch (SQLException e) {
            throw new Exception("AccountDao得到分页列表错误"+e.getMessage());
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
    public List<AccountValue> findByPage(int pageNumber, int pageSize) throws Exception {
        sql = "SELECT * FROM account LIMIT ?,?";
        List<AccountValue> list = new ArrayList<>();
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,(pageNumber-1)*pageSize);
            ps.setInt(2,pageSize);
            rs = ps.executeQuery();
            while(rs.next()){
                AccountValue account = new AccountValue();
                account.setUser(rs.getString(1));
                account.setPassword(rs.getString(2));
                account.setPower(rs.getString(3));
                list.add(account);
            }
        } catch (SQLException e) {
            throw new Exception("AccountDao得到分页列表错误"+e.getMessage());
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
        sql = "SELECT Count(*) FROM account";
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
            throw new Exception("AccountDao得到分页列表错误"+e.getMessage());
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

}
