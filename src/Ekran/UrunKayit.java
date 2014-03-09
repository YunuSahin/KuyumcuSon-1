package Ekran;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import veritabani_Islemleri.UrunDaoClassBean;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UrunKayit extends JFrame {

	private JPanel contentPane;
	private JTextField textUrunId;
	private JTextField textGramAdet;
	private JTextField textUrunIscilikFiyat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UrunKayit frame = new UrunKayit();
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
	public UrunKayit() {
		setTitle("\u00DCR\u00DCN EKLE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UrunKayit.class.getResource("/Ekran/disk2.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnrmId = new JTextPane();
		txtpnrmId.setEditable(false);
		txtpnrmId.setBackground(new Color(0, 191, 255));
		txtpnrmId.setText("\u00DCR\u00DCN ID:");
		
		JTextPane txtpnrnAd = new JTextPane();
		txtpnrnAd.setEditable(false);
		txtpnrnAd.setBackground(new Color(0, 191, 255));
		txtpnrnAd.setText("\u00DCR\u00DCN ADI:");
		
		JTextPane txtpnrnGram = new JTextPane();
		txtpnrnGram.setEditable(false);
		txtpnrnGram.setBackground(new Color(0, 191, 255));
		txtpnrnGram.setText("\u00DCR\u00DCN GRAMI - ADET\u0130:");
		
		textUrunId = new JTextField();
		textUrunId.setColumns(10);
		
		textGramAdet = new JTextField();
		textGramAdet.setColumns(10);
		
		JTextPane txtpnIilik = new JTextPane();
		txtpnIilik.setEditable(false);
		txtpnIilik.setBackground(new Color(0, 191, 255));
		txtpnIilik.setText("\u0130\u015E\u00C7\u0130L\u0130K :");
		
		textUrunIscilikFiyat = new JTextField();
		textUrunIscilikFiyat.setColumns(10);
		final JComboBox comboBoxUrunAdi = new JComboBox();
		comboBoxUrunAdi.setModel(new DefaultComboBoxModel(new String[] {"Besibirlik","Cumhuriyet Eski 2,5"," Cumhuriyet Yeni 2,5\t", " Liral\u0131k Eski\t", " Liral\u0131k Yeni\t ", " Re\u015Fat, Hamit, Aziz\t", " Ata Lira Eski", " Ata Lira Yeni\t", " Yar\u0131m Eski\t", " Yar\u0131m Yeni\t", " \u00C7eyrek Eski\t", " \u00C7eyrek Yeni\t", "  22 Ayar Bilezik\t", "  22 Kordon\t", "  22 S\u0131f\u0131r Zincir\t", "  18 Ayar\t", "  14 Ayar\t", "  G\u00FCm\u00FC\u015F Yerli\t", "  Otantik G\u00FCm\u00FC\u015F\t", "  G\u00FCm\u00FC\u015F \u0130thal\t", "  G\u00FCm\u00FC\u015F Has\t"}));
		JButton btnUrunEkle = new JButton("\u00DCR\u00DCN\u00DC EKLE");
		btnUrunEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UrunDaoClassBean urunKayitDao = new UrunDaoClassBean();
				

				String s = (String)comboBoxUrunAdi.getSelectedItem().toString();
				
				if(s.equals("Besibirlik")){
				
					try {
				 urunKayitDao.setIdUrun(Integer.parseInt(textUrunId.getText()));
				 urunKayitDao.setUrunAdeti(Double.parseDouble(textGramAdet.getText()));
				 urunKayitDao.setUrunAgirligi(Double.parseDouble(textGramAdet.getText()));
				 urunKayitDao.setUruniscilikFiyati(Double.parseDouble(textUrunIscilikFiyat.getText()));
				 urunKayitDao.setUrunAdi("Besibirlik");
				 urunKayitDao.setUrunKurFiyati(31000); // parse islemi bittiginde bu degeri oradan alacagýz
					urunKayitDao.instertUrun();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}	 else if (s.equals("Cumhuriyet Eski 2,5")){
					try {
						 urunKayitDao.setIdUrun(Integer.parseInt(textUrunId.getText()));
						 urunKayitDao.setUrunAdeti(Double.parseDouble(textGramAdet.getText()));
						 urunKayitDao.setUrunAgirligi(Double.parseDouble(textGramAdet.getText()));
						 urunKayitDao.setUruniscilikFiyati(Double.parseDouble(textUrunIscilikFiyat.getText()));
						 urunKayitDao.setUrunAdi("CumhuriyetEski");
						 urunKayitDao.setUrunKurFiyati(31000); // parse islemi bittiginde bu degeri oradan alacagýz
							urunKayitDao.instertUrun();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
				 
				
			
			}	});
		btnUrunEkle.setIcon(new ImageIcon(UrunKayit.class.getResource("/Ekran/Check-icon.png")));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnIilik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnrnGram, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnrnAd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnrmId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(67)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxUrunAdi, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textUrunIscilikFiyat, 215, 215, Short.MAX_VALUE)
									.addComponent(textGramAdet, 215, 215, Short.MAX_VALUE)
									.addComponent(textUrunId, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(237)
							.addComponent(btnUrunEkle, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(355, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textUrunId, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxUrunAdi, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(textGramAdet, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textUrunIscilikFiyat, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtpnrmId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(txtpnrnAd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(txtpnrnGram, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(txtpnIilik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(95)
					.addComponent(btnUrunEkle, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(149, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
