package Ekran;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DovizEkrani extends JFrame {

	private JPanel contentPane;
	private JTextField textKurBilgisi;
	private JTextField textDovizMiktar;
	private JTextField textDovizHesaplananDeger;
	private JTextField textDovizMusterininAdi;
	private JTextField textDovizMusterininSoyadi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DovizEkrani frame = new DovizEkrani();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DovizEkrani() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DovizEkrani.class.getResource("/Ekran/d\u00F6v2.png")));
		setTitle("D\u00D6V\u0130Z EKRANI");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnTr = new JTextPane();
		txtpnTr.setBounds(15, 29, 129, 20);
		txtpnTr.setEditable(false);
		txtpnTr.setBackground(new Color(0, 191, 255));
		txtpnTr.setText("\u0130\u015ELEM YAPILACAK B\u0130R\u0130M:");
		
		final JComboBox comboBoxIslemBirimi = new JComboBox();
		comboBoxIslemBirimi.setBounds(185, 29, 267, 32);
		comboBoxIslemBirimi.setModel(new DefaultComboBoxModel(new String[] {"Euro", "Dolar"}));
		
		JTextPane txtpnMiktar = new JTextPane();
		txtpnMiktar.setBounds(15, 145, 48, 20);
		txtpnMiktar.setEditable(false);
		txtpnMiktar.setBackground(new Color(0, 191, 255));
		txtpnMiktar.setText("M\u0130KTAR:");
		
		JTextPane txtpnKurBilgisi = new JTextPane();
		txtpnKurBilgisi.setBounds(15, 79, 69, 20);
		txtpnKurBilgisi.setEditable(false);
		txtpnKurBilgisi.setBackground(new Color(0, 191, 255));
		txtpnKurBilgisi.setText("KUR B\u0130LG\u0130S\u0130:");
		
		textKurBilgisi = new JTextField();
		textKurBilgisi.setBounds(185, 79, 267, 46);
		textKurBilgisi.setColumns(10);
		
		textDovizMiktar = new JTextField();
		textDovizMiktar.setBounds(185, 145, 267, 46);
		textDovizMiktar.setColumns(10);
		
		textDovizHesaplananDeger = new JTextField();
		textDovizHesaplananDeger.setBounds(185, 417, 267, 46);
		textDovizHesaplananDeger.setColumns(10);
		
		JButton btnDovizHesapla = new JButton("HESAPLA");
		btnDovizHesapla.setBounds(185, 348, 267, 46);
		btnDovizHesapla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String s = comboBoxIslemBirimi.getSelectedItem().toString();
				
				 if(s.equals("Euro")){
					 
					 
				 }
				
		
			}
		});
		
		JTextPane txtpnMteriAdSoyad = new JTextPane();
		txtpnMteriAdSoyad.setBounds(15, 209, 75, 20);
		txtpnMteriAdSoyad.setEditable(false);
		txtpnMteriAdSoyad.setBackground(new Color(0, 191, 255));
		txtpnMteriAdSoyad.setText("M\u00DC\u015ETER\u0130 ADI:");
		
		textDovizMusterininAdi = new JTextField();
		textDovizMusterininAdi.setBounds(185, 209, 267, 46);
		textDovizMusterininAdi.setColumns(10);
		
		textDovizMusterininSoyadi = new JTextField();
		textDovizMusterininSoyadi.setBounds(185, 275, 267, 46);
		textDovizMusterininSoyadi.setColumns(10);
		
		JLabel lblMterininSoyad = new JLabel("M\u00DC\u015ETER\u0130 SOYADI:");
		lblMterininSoyad.setBounds(15, 275, 89, 14);
		
		JButton btnPesinSatisiTamamla = new JButton("PE\u015E\u0130N SAT");
		btnPesinSatisiTamamla.setIcon(new ImageIcon(DovizEkrani.class.getResource("/Ekran/Check-icon.png")));
		btnPesinSatisiTamamla.setBounds(184, 490, 134, 70);
		
		JButton btnVeresiyeSatisiTamamla = new JButton("VERES\u0130YE SAT");
		btnVeresiyeSatisiTamamla.setIcon(new ImageIcon(DovizEkrani.class.getResource("/Ekran/Check-icon.png")));
		btnVeresiyeSatisiTamamla.setBounds(340, 490, 129, 70);
		contentPane.setLayout(null);
		contentPane.add(txtpnMteriAdSoyad);
		contentPane.add(txtpnTr);
		contentPane.add(txtpnKurBilgisi);
		contentPane.add(txtpnMiktar);
		contentPane.add(lblMterininSoyad);
		contentPane.add(textDovizMusterininAdi);
		contentPane.add(textDovizMiktar);
		contentPane.add(textKurBilgisi);
		contentPane.add(comboBoxIslemBirimi);
		contentPane.add(textDovizHesaplananDeger);
		contentPane.add(btnDovizHesapla);
		contentPane.add(textDovizMusterininSoyadi);
		contentPane.add(btnPesinSatisiTamamla);
		contentPane.add(btnVeresiyeSatisiTamamla);
	}
}
