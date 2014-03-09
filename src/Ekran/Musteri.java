package Ekran;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import veritabani_Islemleri.MusteriDaoClassBean;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Musteri extends JFrame {

	private JPanel contentPane;
	private JTextField musteriSoyadiTextField;
	private JTextField musteriNoTextField;
	private JTextField musteriCepTelftextField;
	private JTextField musteriReferansTextField;
	private JTextField musteriEmailTextField;
	private JTextField musteriAdiTextField;
	private JButton btnNewButton;
	private JTextField AlacakliBorcluTutarTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String Args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Musteri frame = new Musteri();
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
	public Musteri() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Musteri.class.getResource("/Ekran/adduser.png")));
		setTitle("M\u00DC\u015ETER\u0130 KAYDI");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 885, 528);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnAd = new JTextPane();
		txtpnAd.setBounds(15, 16, 28, 20);
		txtpnAd.setEditable(false);
		txtpnAd.setBackground(new Color(0, 191, 255));
		txtpnAd.setText("ADI:");
		
		JTextPane txtpnSoyad = new JTextPane();
		txtpnSoyad.setBounds(15, 69, 48, 20);
		txtpnSoyad.setEditable(false);
		txtpnSoyad.setBackground(new Color(0, 191, 255));
		txtpnSoyad.setText("SOYADI:");
		
		musteriSoyadiTextField = new JTextField();
		musteriSoyadiTextField.setBounds(98, 68, 254, 36);
		musteriSoyadiTextField.setColumns(10);
		
		musteriNoTextField = new JTextField();
		musteriNoTextField.setBounds(97, 128, 254, 37);
		musteriNoTextField.setColumns(10);
		
		JTextPane txtpnCepTelefonu = new JTextPane();
		txtpnCepTelefonu.setBounds(508, 16, 83, 20);
		txtpnCepTelefonu.setEditable(false);
		txtpnCepTelefonu.setBackground(new Color(0, 191, 255));
		txtpnCepTelefonu.setText("CEP TELEFONU:");
		
		JTextPane txtpnMteriNo = new JTextPane();
		txtpnMteriNo.setBounds(15, 129, 72, 20);
		txtpnMteriNo.setEditable(false);
		txtpnMteriNo.setBackground(new Color(0, 191, 255));
		txtpnMteriNo.setText("M\u00DC\u015ETER\u0130 NO:");
		
		musteriCepTelftextField = new JTextField();
		musteriCepTelftextField.setBounds(601, 16, 254, 35);
		musteriCepTelftextField.setColumns(10);
		
		musteriReferansTextField = new JTextField();
		musteriReferansTextField.setBounds(601, 69, 254, 35);
		musteriReferansTextField.setColumns(10);
		
		JTextPane txtpnReferans = new JTextPane();
		txtpnReferans.setBounds(508, 69, 62, 20);
		txtpnReferans.setEditable(false);
		txtpnReferans.setBackground(new Color(0, 191, 255));
		txtpnReferans.setText("REFERANS:");
		
		musteriEmailTextField = new JTextField();
		musteriEmailTextField.setBounds(601, 129, 254, 35);
		musteriEmailTextField.setColumns(10);
		final JRadioButton BorcluRdButton = new JRadioButton("BORCLU");
		BorcluRdButton.setBounds(758, 233, 83, 23);
		final JRadioButton AlacakliRdButton = new JRadioButton("ALACAKLI");
		AlacakliRdButton.setBounds(662, 233, 83, 23);
		AlacakliBorcluTutarTextField = new JTextField();
		AlacakliBorcluTutarTextField.setBounds(662, 263, 185, 35);
		
		musteriAdiTextField = new JTextField();
		musteriAdiTextField.setBounds(98, 16, 254, 35);
		musteriAdiTextField.setColumns(10);
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setBounds(508, 129, 40, 20);
		txtpnEmail.setEditable(false);
		txtpnEmail.setBackground(new Color(0, 191, 255));
		txtpnEmail.setText("EMA\u0130L:");
		
		btnNewButton = new JButton("KAYDET");
		btnNewButton.setBounds(278, 380, 143, 87);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 int idMusteri;
				 String musteriAdi;
				 String musteriEmail;	
				 String musteriReferans;
				 String musteriSoyadi;
				 double musteriTelefon;
                 double musteriBorcDegiskeni;
                 double musteriAlacakliDegiskeni;
                 MusteriDaoClassBean musteriKayit = new MusteriDaoClassBean();
                 
                   if (musteriAdiTextField.getText().isEmpty()){
                	  
                	   JOptionPane.showMessageDialog(null, "Lütfen Musteri Adý Bilgisini gir");
                
                
                } else if (musteriCepTelftextField.getText().isEmpty()){
                	 
                	JOptionPane.showMessageDialog(null, "Lütfen Musteri Telefon Bilgisini gir");
                	 
                	 
               }  else if (musteriSoyadiTextField.getText().isEmpty()){
                	
            	   JOptionPane.showMessageDialog(null, "Lütfen Musteri Soyadý Bilgisini gir");
                	 
              }   else if (musteriNoTextField.getText().isEmpty()){
              	
          	   JOptionPane.showMessageDialog(null, "Lütfen Musteri Numarasý Bilgisini gir");
             
              }            
            
            
                 else if(BorcluRdButton.isSelected()==true){
                	
                	
    				   try {
    					   musteriBorcDegiskeni = Double.parseDouble(AlacakliBorcluTutarTextField.getText());
    	                	idMusteri = Integer.parseInt(musteriNoTextField.getText());
    	                    musteriAdi = musteriAdiTextField.getText();				
    	    				musteriEmail= musteriEmailTextField.getText();
    	    				 java.sql.Time sqlDate = new java.sql.Time(new java.util.Date().getTime());
    	    			    musteriReferans = musteriReferansTextField.getText();
    	    			    musteriSoyadi = musteriSoyadiTextField.getText();
    	    			    musteriTelefon =Double.parseDouble(musteriCepTelftextField.getText());
    	    			    
    	    			    
    	    				   musteriKayit.setIdMusteri(idMusteri);
    	    				   musteriKayit.setMusteriAdi(musteriAdi);
    	    				   musteriKayit.setMusteriEmail(musteriEmail);
    	    				   musteriKayit.setMusterininAlacagi(musteriBorcDegiskeni);
    	    				   musteriKayit.setMusteriReferans(musteriReferans);
    	    				   musteriKayit.setMusteriSoyadi(musteriSoyadi);
    	    				   musteriKayit.setMusteriTelefon(musteriTelefon);
    	    				   musteriKayit.setMusteriKayitTarihi(sqlDate);
    					   
						musteriKayit.insertDaoBorcluCustomer();
						 JOptionPane.showMessageDialog(null, "Kayýt baþarýlý");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			    
                }else if (AlacakliRdButton.isSelected() == true){
                 
               
 				   try {
 					  musteriAlacakliDegiskeni = Double.parseDouble(AlacakliBorcluTutarTextField.getText());
 	                	idMusteri = Integer.parseInt(musteriNoTextField.getText());
 	                    musteriAdi = musteriAdiTextField.getText();				
 	    				musteriEmail= musteriEmailTextField.getText();
 	    				java.sql.Time sqlDate = new java.sql.Time(new java.util.Date().getTime());
 	    			    musteriReferans = musteriReferansTextField.getText();
 	    			    musteriSoyadi = musteriSoyadiTextField.getText();
 	    			    musteriTelefon =Double.parseDouble(musteriCepTelftextField.getText());
 	    			    
 	 				   musteriKayit.setIdMusteri(idMusteri);
 	 				   musteriKayit.setMusteriAdi(musteriAdi);
 	 				   musteriKayit.setMusteriEmail(musteriEmail);
 	 				   musteriKayit.setMusterininAlacagi(musteriAlacakliDegiskeni);
 	 				   musteriKayit.setMusteriReferans(musteriReferans);
 	 				   musteriKayit.setMusteriSoyadi(musteriSoyadi);
 	 				   musteriKayit.setMusteriTelefon(musteriTelefon);
 	 				   musteriKayit.setMusteriKayitTarihi(sqlDate);
					musteriKayit.insertDaoAlacakliCustomer();
					 JOptionPane.showMessageDialog(null, "Kayýt baþarýlý");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                }else {

	                	idMusteri = Integer.parseInt(musteriNoTextField.getText());
	                    musteriAdi = musteriAdiTextField.getText();				
	    				musteriEmail= musteriEmailTextField.getText();
	    				 java.sql.Time sqlDate = new java.sql.Time(new java.util.Date().getTime());
	    			    musteriReferans = musteriReferansTextField.getText();
	    			    musteriSoyadi = musteriSoyadiTextField.getText();
	    			    musteriTelefon =Double.parseDouble(musteriCepTelftextField.getText());
	    			    
	 				   musteriKayit.setIdMusteri(idMusteri);
	 				   musteriKayit.setMusteriAdi(musteriAdi);
	 				   musteriKayit.setMusteriEmail(musteriEmail);

	 				   musteriKayit.setMusteriReferans(musteriReferans);
	 				   musteriKayit.setMusteriSoyadi(musteriSoyadi);
	 				   musteriKayit.setMusteriTelefon(musteriTelefon);
	 				   musteriKayit.setMusteriKayitTarihi(sqlDate);
					try {
						musteriKayit.insertDaoAlacakliCustomer();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 JOptionPane.showMessageDialog(null, "Kayýt baþarýlý");
                	
                	
                }
			    
			    
			   
			   
			}
		});
		btnNewButton.setIcon(new ImageIcon(Musteri.class.getResource("/Ekran/Check-icon.png")));
		
	
	
		BorcluRdButton.setBackground(new Color(0, 139, 139));
		
		
		
		AlacakliRdButton.setBackground(new Color(0, 139, 139));
		
		
		AlacakliBorcluTutarTextField.setColumns(10);
		
		JTextPane txtpnTutar = new JTextPane();
		txtpnTutar.setEditable(false);
		txtpnTutar.setBounds(590, 263, 62, 20);
		txtpnTutar.setBackground(new Color(0, 139, 139));
		txtpnTutar.setText("     TUTAR:");
		
		JButton TemizleButonu = new JButton("TEMÝZLE");
		TemizleButonu.setIcon(new ImageIcon(Musteri.class.getResource("/Ekran/Actions-edit-clear-icon.png")));
		TemizleButonu.setBounds(508, 380, 143, 87);
		TemizleButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AlacakliBorcluTutarTextField.setText("");
				musteriAdiTextField.setText("");
				musteriSoyadiTextField.setText("");
				musteriEmailTextField.setText("");
				musteriNoTextField.setText("");
				musteriReferansTextField.setText("");
				musteriCepTelftextField.setText("");
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(txtpnSoyad);
		contentPane.add(txtpnAd);
		contentPane.add(txtpnMteriNo);
		contentPane.add(musteriAdiTextField);
		contentPane.add(musteriSoyadiTextField);
		contentPane.add(musteriNoTextField);
		contentPane.add(txtpnTutar);
		contentPane.add(AlacakliBorcluTutarTextField);
		contentPane.add(txtpnCepTelefonu);
		contentPane.add(txtpnReferans);
		contentPane.add(txtpnEmail);
		contentPane.add(musteriEmailTextField);
		contentPane.add(musteriCepTelftextField);
		contentPane.add(musteriReferansTextField);
		contentPane.add(AlacakliRdButton);
		contentPane.add(BorcluRdButton);
		contentPane.add(btnNewButton);
		contentPane.add(TemizleButonu);
	}
}
