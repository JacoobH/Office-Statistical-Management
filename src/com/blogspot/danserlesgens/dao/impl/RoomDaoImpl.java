package com.blogspot.danserlesgens.dao.impl;

import com.blogspot.danserlesgens.dao.IRoomDAO;
import com.blogspot.danserlesgens.value.RoomValue;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.blogspot.danserlesgens.factory.ConnectionFactory.getUniqueConnection;
public class RoomDaoImpl implements IRoomDAO {
    private String sql = null;
    @Override
    public synchronized void create(RoomValue room) throws Exception {
        sql = "INSERT INTO room VALUES (?,?,?,?)";
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setBigDecimal(1,room.getId());
            ps.setString(2,room.getComName());
            ps.setBoolean(3,room.getSituation());
            ps.setDouble(4,room.getMoney());
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
    public synchronized void delete(RoomValue room) throws Exception {
        sql = "DELETE FROM room WHERE off_id = ?";
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setBigDecimal(1, room.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("房间DAO删除错误" + e.getMessage());
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
    public synchronized void update(RoomValue room) throws Exception {
        sql = "UPDATE room SET com_name = ?,off_situation = ?,off_money = ? WHERE off_id = ?";
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,room.getComName());
            ps.setBoolean(2,room.getSituation());
            ps.setDouble(3,room.getMoney());
            ps.setBigDecimal(4,room.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("房间DAO更新错误"+e.getMessage());
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
    public List<RoomValue> findAll() throws Exception {
        sql = "SELECT * FROM room";
        List<RoomValue> list = new ArrayList<>();
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                RoomValue room = new RoomValue();
                room.setId(rs.getBigDecimal(1));
                room.setComName(rs.getString(2));
                room.setSituation(rs.getBoolean(3));
                room.setMoney(rs.getDouble(4));
                list.add(room);
            }
        } catch (SQLException e) {
            throw new Exception("房间DAO得到房间列表错误"+e.getMessage());
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
    public RoomValue findById(BigDecimal id) throws Exception {
        sql = "SELECT * FROM room WHERE off_id = ?";
        RoomValue room = new RoomValue();
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setBigDecimal(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                room.setId(rs.getBigDecimal(1));
                room.setComName(rs.getString(2));
                room.setSituation(rs.getBoolean(3));
                room.setMoney(rs.getDouble(4));
            }

        } catch (SQLException e) {
            conn.rollback();
            throw new Exception("房间DAO得到房间错误"+e.getMessage());
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
        return room;
    }

    @Override
    public List<RoomValue> findByPage(int pageNumber, int pageSize, String order) throws Exception {
        sql = "SELECT * FROM room WHERE off_id REGEXP ? LIMIT ?,?";
        List<RoomValue> list = new ArrayList<>();
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
                RoomValue room = new RoomValue();
                room.setId(rs.getBigDecimal(1));
                room.setComName(rs.getString(2));
                room.setSituation(rs.getBoolean(3));
                room.setMoney(rs.getDouble(4));
                list.add(room);
            }
        } catch (SQLException e) {
            throw new Exception("RoomDao得到分页列表错误"+e.getMessage());
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
    public List<RoomValue> findByPage(int pageNumber, int pageSize) throws Exception {
        sql = "SELECT * FROM room LIMIT ?,?";
        List<RoomValue> list = new ArrayList<>();
        Connection conn = getUniqueConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,(pageNumber-1)*pageSize);
            ps.setInt(2,pageSize);
            rs = ps.executeQuery();
            while(rs.next()){
                RoomValue room = new RoomValue();
                room.setId(rs.getBigDecimal(1));
                room.setComName(rs.getString(2));
                room.setSituation(rs.getBoolean(3));
                room.setMoney(rs.getDouble(4));
                list.add(room);
            }
        } catch (SQLException e) {
            throw new Exception("RoomDao得到分页列表错误"+e.getMessage());
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
        sql = "SELECT Count(*) FROM room";
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
            throw new Exception("RoomDao得到分页列表错误"+e.getMessage());
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
