package Ekran;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import veritabani_Islemleri.PersonelDaoClassBean;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Personel extends JFrame {
	

	private JPanel contentPane;
	private JTextField textPersonelAdi;
	private JTextField textPersonelSoyadi;
	private JTextField textPersonelNo;
	private JTextField textPersonelCepTelf;
	private JTextField textPersonelEmail;
	private JTextField textPersonelTcKimlik;
	private JPasswordField passwordPersonel;
	private JTextField textPersonelSubeAdi;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
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
	public Personel() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Personel.class.getResource("/Ekran/perso.png")));
		setTitle("PERSONEL KAYDI");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 820, 683);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnAd = new JTextPane();
		txtpnAd.setEditable(false);
		txtpnAd.setBackground(new Color(0, 191, 255));
		txtpnAd.setText("ADI:");
		
		JTextPane txtpnSoyad = new JTextPane();
		txtpnSoyad.setEditable(false);
		txtpnSoyad.setBackground(new Color(0, 191, 255));
		txtpnSoyad.setText("SOYADI:");
		
		JTextPane txtpnTcKimlikNo = new JTextPane();
		txtpnTcKimlikNo.setEditable(false);
		txtpnTcKimlikNo.setBackground(new Color(0, 191, 255));
		txtpnTcKimlikNo.setText("TC K\u0130ML\u0130K NO:");

		final JComboBox comboBoxPersonelCinsiyet = new JComboBox();
		textPersonelAdi = new JTextField();
		textPersonelAdi.setColumns(10);
		
		textPersonelSoyadi = new JTextField();
		textPersonelSoyadi.setColumns(10);
		
		textPersonelNo = new JTextField();
		textPersonelNo.setColumns(10);
		
		JTextPane txtpnCepTelefonu = new JTextPane();
		txtpnCepTelefonu.setEditable(false);
		txtpnCepTelefonu.setBackground(new Color(0, 191, 255));
		txtpnCepTelefonu.setText("CEP TELEFONU:");
		
		JTextPane txtpnITelefonu = new JTextPane();
		txtpnITelefonu.setEditable(false);
		txtpnITelefonu.setBackground(new Color(0, 191, 255));
		txtpnITelefonu.setText("EMA\u0130L:");
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setEditable(false);
		txtpnEmail.setBackground(new Color(0, 191, 255));
		txtpnEmail.setText("C\u0130NS\u0130YET:");
		
		textPersonelCepTelf = new JTextField();
		textPersonelCepTelf.setColumns(10);
		
		textPersonelEmail = new JTextField();
		textPersonelEmail.setColumns(10);
		
		JTextPane txtpnAdres = new JTextPane();
		txtpnAdres.setEditable(false);
		txtpnAdres.setBackground(new Color(0, 191, 255));
		txtpnAdres.setText("ADRES:");
		
		JTextPane txtpnMteriNo = new JTextPane();
		txtpnMteriNo.setBackground(new Color(0, 191, 255));
		txtpnMteriNo.setText("PERSONEL NO:");
		
		textPersonelTcKimlik = new JTextField();
		textPersonelTcKimlik.setColumns(10);
		
		final JEditorPane editorPersonelAdres = new JEditorPane();
		
		JButton btnPersonelKayit = new JButton("KAYDET");
		btnPersonelKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PersonelDaoClassBean personelKayitDao = new PersonelDaoClassBean();
				
				
				 if (textPersonelAdi.getText().isEmpty()){
                	  
               	   JOptionPane.showMessageDialog(null, "Lütfen Musteri Adý Bilgisini gir");
				  }else  if (textPersonelSoyadi.getText().isEmpty()){
                	  
               	   JOptionPane.showMessageDialog(null, "Lütfen Musteri Adý Bilgisini gir");
				  }else  if (textPersonelTcKimlik.getText().isEmpty()){
                	  
               	   JOptionPane.showMessageDialog(null, "Lütfen Musteri Adý Bilgisini gir");
				  }else  if (textPersonelSubeAdi.getText().isEmpty()){
                	  
               	   JOptionPane.showMessageDialog(null, "Lütfen Musteri Adý Bilgisini gir");
				  }else  if (textPersonelCepTelf.getText().isEmpty()){
                	  
               	   JOptionPane.showMessageDialog(null, "Lütfen Musteri Adý Bilgisini gir");
				  }
                       try {
             
               		 
               		 if(comboBoxPersonelCinsiyet.getSelectedItem().equals("BAY")){
               			 personelKayitDao.setSatisElemaniCinsiyet("Erkek");
               	  		 
                  	      personelKayitDao.setId(Integer.parseInt(textPersonelNo.getText()));
                  	      personelKayitDao.setSatisElemaniAdi(textPersonelAdi.getText());
                  		  personelKayitDao.setSatisElemaniSoyadi(textPersonelSoyadi.getText());
                  		  personelKayitDao.setSatisElemaniTcno(textPersonelTcKimlik.getText());
                  		  personelKayitDao.setSatisElemaniSubeAdi(textPersonelSubeAdi.getText());
                  		  personelKayitDao.setSatisElemaniTelefon(Double.parseDouble(textPersonelCepTelf.getText()));
                  		  personelKayitDao.setSatisElemaniAdres(editorPersonelAdres.getText());
                  		  personelKayitDao.setSatisElemaniSifre(passwordPersonel.getText());
                  		
                  		  personelKayitDao.instertDaoPersonel();
                  		  
               		 }else if (comboBoxPersonelCinsiyet.getSelectedItem().equals("BAYAN")){
               	      personelKayitDao.setSatisElemaniCinsiyet("Bayan");
               		  personelKayitDao.setId(Integer.parseInt(textPersonelNo.getText()));
              	      personelKayitDao.setSatisElemaniAdi(textPersonelAdi.getText());
              		  personelKayitDao.setSatisElemaniSoyadi(textPersonelSoyadi.getText());
              		  personelKayitDao.setSatisElemaniTcno(textPersonelTcKimlik.getText());
              		  personelKayitDao.setSatisElemaniSubeAdi(textPersonelSubeAdi.getText());
              		  personelKayitDao.setSatisElemaniTelefon(Double.parseDouble(textPersonelCepTelf.getText()));
              		  personelKayitDao.setSatisElemaniAdres(editorPersonelAdres.getText());
              		  personelKayitDao.setSatisElemaniSifre(passwordPersonel.getText());
              		 personelKayitDao.instertDaoPersonel();
               			 
               		 }
               		 
               		
					    JOptionPane.showMessageDialog(null, "Kayýt baþarýlý");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				  }
			
		});
		btnPersonelKayit.setIcon(new ImageIcon(Personel.class.getResource("/Ekran/Check-icon.png")));
		
		comboBoxPersonelCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"BAY", "BAYAN"}));
		
		JTextPane txtpnifre = new JTextPane();
		txtpnifre.setEditable(false);
		txtpnifre.setBackground(new Color(0, 191, 255));
		txtpnifre.setText("\u015E\u0130FRE:");
		
		passwordPersonel = new JPasswordField();
		
		JTextPane txtpnPersonelubeAd = new JTextPane();
		txtpnPersonelubeAd.setBackground(new Color(0, 191, 255));
		txtpnPersonelubeAd.setText("\u015EUBE ADI");
		
		textPersonelSubeAdi = new JTextField();
		textPersonelSubeAdi.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnSoyad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnAd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnMteriNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnTcKimlikNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtpnifre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtpnPersonelubeAd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordPersonel, 193, 193, 193)
								.addComponent(textPersonelTcKimlik, 193, 193, 193)
								.addComponent(textPersonelSoyadi, 193, 193, 193)
								.addComponent(textPersonelNo, 193, 193, 193)
								.addComponent(textPersonelAdi, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
							.addGap(67)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnCepTelefonu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnITelefonu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnAdres, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(textPersonelSubeAdi, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBoxPersonelCinsiyet, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addComponent(editorPersonelAdres, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPersonelEmail, Alignment.TRAILING, 220, 220, 220)
						.addComponent(textPersonelCepTelf, Alignment.TRAILING, 220, 220, 220))
					.addGap(211))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(166)
					.addComponent(btnPersonelKayit, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
					.addGap(492))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textPersonelCepTelf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textPersonelEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textPersonelAdi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnAd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtpnSoyad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPersonelSoyadi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtpnCepTelefonu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(txtpnITelefonu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textPersonelNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnMteriNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxPersonelCinsiyet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtpnAdres, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnTcKimlikNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPersonelTcKimlik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(passwordPersonel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtpnifre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textPersonelSubeAdi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnPersonelubeAd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(editorPersonelAdres, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addComponent(btnPersonelKayit, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(284))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
