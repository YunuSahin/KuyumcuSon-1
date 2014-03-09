package Ekran;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import model.Satiselemani;

import org.eclipse.persistence.exceptions.DatabaseException;

import veritabani_Islemleri.JpaCrudDaoClass;
import veritabani_Islemleri.PersonelDaoClassBean;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textTcKimlikGiris;
	private JPasswordField passwordSifreGiris;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Ekran/gold-bullion-icon.png")));
		setTitle("KUYUMCU OTOMASYONU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textTcKimlikGiris = new JTextField();
		textTcKimlikGiris.setColumns(10);
		
		passwordSifreGiris = new JPasswordField();
		
		
		
		JButton btnNewButton = new JButton("G\u0130R\u0130\u015E");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				JpaCrudDaoClass TcSifreyeGorekisiBilgisiAl = new JpaCrudDaoClass();
				
				Satiselemani tcbilgisial ;
				 if (textTcKimlikGiris.getText().isEmpty()){
               	  
	               	   JOptionPane.showMessageDialog(null, "Lütfen Tc Kimlik Bilgisini gir");
					  }else  if (passwordSifreGiris.getText().isEmpty()){
	                	  
	               	   JOptionPane.showMessageDialog(null, "Lütfen Sifre Bilgisini gir");
					  }else {
				 try {
						tcbilgisial = TcSifreyeGorekisiBilgisiAl.TcSifreyeGoreSatisElemaniAdiGetir1(
								textTcKimlikGiris.getText(),passwordSifreGiris.getText());
						User.kullanicisoyadi = tcbilgisial.getSatisElemaniSoyadi();
						User.kullaniciadi = tcbilgisial.getSatisElemaniAdi();
						if(tcbilgisial == null){
							JOptionPane.showMessageDialog(null,"Tc kimlik bilgisi veya sifre bilgisi yanlis");
			    
			    }else if(tcbilgisial.getSatisElemaniTcno().equals(textTcKimlikGiris.getText())){
			    
			    	AnaEkran ae = new AnaEkran();
					ae.setVisible(true);
					setVisible(false);
					
					User.id = tcbilgisial.getIdSatisElemani();
					
				
				    
				
					
				 
					
			    }	
						} catch (DatabaseException e) {
							// TODO: handle exception
						}
					  }
			}
		});
		
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/Ekran/Check-icon.png")));
		
		JTextPane txtpnifre = new JTextPane();
		txtpnifre.setBackground(new Color(0, 191, 255));
		txtpnifre.setEditable(false);
		txtpnifre.setText("\u015E\u0130FRE:");
		
		JTextPane txtpnKullancAd = new JTextPane();
		txtpnKullancAd.setBackground(new Color(0, 191, 255));
		txtpnKullancAd.setEditable(false);
		txtpnKullancAd.setText("KULLANICI ADI:");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(191)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtpnifre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnKullancAd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textTcKimlikGiris, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordSifreGiris, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(106)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnKullancAd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textTcKimlikGiris, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(passwordSifreGiris, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtpnifre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
