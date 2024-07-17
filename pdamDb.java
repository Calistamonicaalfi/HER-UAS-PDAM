/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.pdam;
import java.sql.*;
import java.util.*;
import dao.DBHelper;

/**
 *
 * @author CALISTA MONICA ALFI
 */
public class pdamDb {
    public void insert(pdam pdam) throws Exception {
        DBHelper db = new DBHelper();
        String query = "insert into pdam values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1, pdam.getKodePembayaran());
        ps.setString(2, pdam.getNama());
        ps.setString(3, pdam.getJenisPelanggan());
        ps.setString(4, pdam.getTanggal());
        ps.setString(5, pdam.getMeterBulanIni());
        ps.setString(6, pdam.getMeterBulanLalu());
        ps.setString(7, pdam.getBiayaPerMeter());
        ps.setString(8, pdam.getTotalBayar());
        ps.executeUpdate();
    }
    
    public void update(pdam pdam) throws Exception {
        DBHelper db = new DBHelper();
        String query = "update pdam set nama=?, jenispelanggan=?, "
                + "tanggal=?, meterbulanini=?, meterbulanlalu=?,"
                + "biayapermeter=?, totalbayar=? where kodepembayaran=?";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1, pdam.getNama());
        ps.setString(2, pdam.getJenisPelanggan());
        ps.setString(3, pdam.getTanggal());
        ps.setString(4, pdam.getMeterBulanIni());
        ps.setString(5, pdam.getMeterBulanLalu());
        ps.setString(6, pdam.getBiayaPerMeter());
        ps.setString(7, pdam.getTotalBayar());
        ps.setString(8, pdam.getKodePembayaran());
        ps.executeUpdate();
    }
    
    public void delete(String kodeTransaksi) throws Exception{
        DBHelper db = new DBHelper();
        String query = "delete from PDAM where kodepembayaran=?";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1, kodeTransaksi);
        ps.executeUpdate();
    }
    
    public pdam getPDAM(String kodeTransaksi) throws Exception{
        DBHelper db = new DBHelper();
        String query = "select * from PDAM where kodepembayaran=?";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1, kodeTransaksi);
        pdam pdam = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            pdam = new pdam();
            pdam.setKodePembayaran(rs.getString(1));
            pdam.setNama(rs.getString(2));
            pdam.setJenisPelanggan(rs.getString(3));
            pdam.setTanggal(rs.getString(4));
            pdam.setMeterBulanIni(rs.getString(5));
            pdam.setMeterBulanLalu(rs.getString(6));
            pdam.setBiayaPerMeter(rs.getString(7));
            pdam.setTotalBayar(rs.getString(8));
        }
        return pdam;
    }
    
    public List<pdam> getAllPDAM()  throws Exception{
        DBHelper db = new DBHelper();
        String query = "select * from PDAM";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        List<pdam> list = new ArrayList();
        pdam pdam = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            pdam = new pdam();
            pdam.setKodePembayaran(rs.getString(1));
            pdam.setNama(rs.getString(2));
            pdam.setJenisPelanggan(rs.getString(3));
            pdam.setTanggal(rs.getString(4));
            pdam.setMeterBulanIni(rs.getString(5));
            pdam.setMeterBulanLalu(rs.getString(6));
            pdam.setBiayaPerMeter(rs.getString(7));
            pdam.setTotalBayar(rs.getString(8));
            list.add(pdam);
        }
        return list;
    }
}
