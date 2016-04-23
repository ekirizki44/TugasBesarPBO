/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Aplikasi;
import model.Dokter;
import model.PasienInap;
import model.Ruangan;
import view.MainMenu;

/**
 *
 * @author aldebaranbn
 */
public class ControllerMainMenu implements ActionListener, KeyListener{
    Aplikasi model;
    MainMenu view;
    
    public ControllerMainMenu(){
        this.model = model;
        view = new MainMenu();
        view.setVisible(true);
        view.addActionListener(this);
        
        view.getBtnSimpanRuangan().addActionListener(this);
        this.view.getBtnSimpanPasien().addActionListener(this);
        this.view.getBtnSimpanDokter().addActionListener(this);
    }
    
    public void addDokterToTable(JTable table, ArrayList<Dokter> array){
        String[] columnDokter = {"NAMA","UMUR","JENIS KELAMIN","ALAMAT","SPESIALIS","NIP"};
        DefaultTableModel tb = new DefaultTableModel(columnDokter, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        for (Dokter d : array)
        {
            String[] data = {d.getNama(), d.getUmur(), d.getjenisKelamin(), d.getAlamat(), d.getSpesialis(), d.getNip()};
            tb.addRow(data);
        }
        table.setModel(tb);
    }
    
    public void addPasienToTable(JTable table, ArrayList<PasienInap> array){
        String[] columnPasien = {"NAMA","UMUR","JENIS KELAMIN","ALAMAT","NO REGISTRASI","NIP DOKTER","DIAGNOSA"};
        DefaultTableModel tb = new DefaultTableModel(columnPasien, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        for (PasienInap p : array){
            String[] data = {p.getPasien().getNama(), p.getPasien().getUmur(), p.getPasien().getjenisKelamin(), p.getPasien().getAlamat(), p.getPasien().getNoRegistrasi(), p.getDokter().getNama(), p.getDiagnosaByIndex(i)};
            tb.addRow(data);
        }
        table.setModel(tb);
    }
    
    public void show(JPanel panel, String cardName)
    {
        CardLayout card = (CardLayout) panel.getLayout();
        card.show(panel, cardName);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        //button simpan ruangan di klik
        if (source.equals(view.getBtnSimpanDokter()))
        {
            Dokter d = new Dokter(view.getNamaDokterField().getText(), 
                                  view.getUmurDokterField().getText(), 
                                  view.getJKDokterField().getText(), 
                                  view.getAlamatDokterField().getText(), 
                                  view.getSpesialisField().getText(), 
                                  view.getNIPField().getText());
            if (app.insertDokter(d))
            {
                view.showMessage("Insert Berhasil !!");
            }
            else
            {
                view.showMessage("Insert GAGAL!", "ERROR INSERT", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
