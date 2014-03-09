package Ekran;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Toolkit;

import javax.swing.JLabel;

import veritabani_Islemleri.JpaCrudDaoClass;
import veritabani_Islemleri.MusteriDaoClassBean;
import veritabani_Islemleri.UrunSatisDaoClassBean;
import jsoupParser.HtmlParseJava;
import jsoupParser.HtmlSatisFiyatParseJava;
import jsoupParser.htmlparseEski;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class AlisEkrani extends JFrame {

	private JPanel contentPane;
	private JTextPane txtpnTarih;
	private JTextPane txtpnGramadet;
	private JTextPane txtpnrnCinsi;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JComboBox comboBox;
	private JTextField textMusteriAdi;
	private JButton btnAlisPesin;
	private JButton btnAlisVeresiye;
	private JTextField textMusteriSoyadi;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JTextPane txtpnToplam;
	private JTextField textTarihKurGuncel;
	private JTextField textToplamUrunAlis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlisEkrani frame = new AlisEkrani();
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
	public AlisEkrani() {
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						AlisEkrani.class
								.getResource("/Ekran/cash-register-icon 2.png")));
		setTitle("ALI\u015E EKRANI");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int stage_height = 600;// örnektir
		int stage_width = 800;// örnektir
		int stage_start_position_x;
		int stage_start_position_y;
		Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();

		stage_start_position_x = (int) (screen_size.getWidth() - stage_width) / 2;
		stage_start_position_y = (int) (screen_size.getHeight() - stage_height) / 2;

		

		setBounds(stage_start_position_x, stage_start_position_y, stage_width,
				stage_height);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtpnTarih = new JTextPane();
		txtpnTarih.setBounds(27, 153, 67, 20);
		txtpnTarih.setEditable(false);
		txtpnTarih.setBackground(new Color(0, 191, 255));
		txtpnTarih.setText("Tarih");

		txtpnGramadet = new JTextPane();
		txtpnGramadet.setBounds(27, 199, 64, 20);
		txtpnGramadet.setEditable(false);
		txtpnGramadet.setBackground(new Color(0, 191, 255));
		txtpnGramadet.setText("Gram - Adet");
		comboBox = new JComboBox();
		comboBox.setBounds(139, 264, 313, 32);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Besibirlik",
				"Cumhuriyet Eski 2,5", "Cumhuriyet Yeni 2,5",
				"Liral\u0131k Eski", "Liral\u0131k Yeni",
				"Re\u015Fat, Hamit, Aziz", "Ata Lira Eski", "Ata Lira Yeni",
				"Yar\u0131m Eski", "Yarim Yeni", "\u00C7eyrek Eski",
				"\u00C7eyrek Yeni", "22 Ayar Bilezik", "22 Kordon",
				"22 S\u0131f\u0131r Zincir", "18 Ayar", "14 Ayar",
				"G\u00FCm\u00FC\u015F Yerli", "Otantik G\u00FCm\u00FC\u015F",
				"G\u00FCm\u00FC\u015F \u0130thal", "G\u00FCm\u00FC\u015F Has" }));

		txtpnrnCinsi = new JTextPane();
		txtpnrnCinsi.setBounds(27, 264, 54, 20);
		txtpnrnCinsi.setEditable(false);
		txtpnrnCinsi.setBackground(new Color(0, 191, 255));
		txtpnrnCinsi.setText("\u00DCr\u00FCn Cinsi");

		textField = new JTextField();
		textField.setBounds(139, 153, 313, 35);
		textField.setEditable(false);
		textField.setColumns(10);
		textToplamUrunAlis = new JTextField();
		textToplamUrunAlis.setBounds(139, 318, 307, 20);
		contentPane.add(textToplamUrunAlis);
		textToplamUrunAlis.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setBounds(139, 199, 313, 32);
		textField_1.setColumns(10);

		JButton btnFiyatHesapla = new JButton("Fiyat Toplam\u0131");
		btnFiyatHesapla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				HtmlSatisFiyatParseJava satisFiyat = new HtmlSatisFiyatParseJava();
				String[][] gelenVeri2 = null;

				gelenVeri2 = satisFiyat.kuyumcuVeriCek();
				System.out.println(gelenVeri2[1][0]);

				double i = Double.parseDouble(textField_1.getText());

				String s = comboBox.getSelectedItem().toString();

				if (s.equals("Besibirlik")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);
					double gelenVeri = 0;

					try {
						gelenVeri = nf_in.parse(gelenVeri2[0][0]).doubleValue();
					} catch (ParseException e) {

						e.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("Cumhuriyet Eski 2,5")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[2][0]).doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;

					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("Cumhuriyet Yeni 2,5")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[2][0]).doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;

					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("Liral\u0131k Eski")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[7][0]).doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;

					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("Liral\u0131k Yeni")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[7][0]).doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;

					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("Re\u015Fat, Hamit, Aziz")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[7][0]).doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("Ata Lira Eski")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[14][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("Ata Lira Yeni")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[16][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("Yar\u0131m Eski")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[18][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("Yarim Yeni")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[18][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("\u00C7eyrek Eski")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[23][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("\u00C7eyrek Yeni")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[25][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("22 Ayar Bilezik")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[27][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("22 Kordon")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[29][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("22 S\u0131f\u0131r Zincir")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[31][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("18 Ayar")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[33][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				} else if (s.equals("14 Ayar")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[35][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				}

			}
		});
		btnFiyatHesapla.setBounds(80, 412, 122, 54);

		JTextPane txtpnTarih_1 = new JTextPane();
		txtpnTarih_1.setBounds(499, 34, 113, 20);
		txtpnTarih_1.setEditable(false);
		txtpnTarih_1.setBackground(new Color(0, 191, 255));
		txtpnTarih_1.setText("Guncelleme Tarihi ");

		table = new JTable();
		table.setBounds(746, 607, 1, 1);

		JTextPane txtpnMteriAdSoyad = new JTextPane();
		txtpnMteriAdSoyad.setBounds(27, 51, 76, 20);
		txtpnMteriAdSoyad.setBackground(new Color(0, 191, 255));
		txtpnMteriAdSoyad.setText("M\u00FC\u015Fterinin Ad\u0131 ");

		textMusteriAdi = new JTextField();
		textMusteriAdi.setBounds(139, 51, 313, 33);
		textMusteriAdi.setColumns(10);

		btnAlisPesin = new JButton("PE\u015E\u0130N ALI\u015E ");
		btnAlisPesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UrunSatisDaoClassBean urunAl = new UrunSatisDaoClassBean();
				JpaCrudDaoClass musteriadsoyadagoreidal = new JpaCrudDaoClass();

				model.Musteri isimDegiskeni ;
			
				isimDegiskeni = musteriadsoyadagoreidal
						.AdSoyadaGoreMusteriidGetir(textMusteriAdi.getText(),
								textMusteriSoyadi.getText());

				java.sql.Time sqlDate = new java.sql.Time(new java.util.Date()
						.getTime());

				String s = comboBox.getSelectedItem().toString();

				if (s.equals("Besibirlik")) {

					urunAl.setSatisElemani_idSatisElemani(User.id);
					urunAl.setUrunSatisTarihi(sqlDate);
					urunAl.setUrunAlisFiyati(Double
							.parseDouble(textToplamUrunAlis.getText()));
					urunAl.setUrun_idUrun(1);
					urunAl.setMusteri_idMusteri(isimDegiskeni.getIdMusteri());
					urunAl.urunSatDao();

				}

			}
				
				
				
			
		});
		btnAlisPesin.setBounds(212, 412, 122, 54);

		btnAlisVeresiye = new JButton("Veresiye ALI\u015E ");
		btnAlisVeresiye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				UrunSatisDaoClassBean urunAl = new UrunSatisDaoClassBean();
				JpaCrudDaoClass musteriadsoyadagoreidal = new JpaCrudDaoClass();
				MusteriDaoClassBean MusteriVeresiyeAlacagiGuncelle = new MusteriDaoClassBean();

				model.Musteri IdDegiskeni;

				IdDegiskeni = musteriadsoyadagoreidal
						.AdSoyadaGoreMusteriidGetir(textMusteriAdi.getText(),
								textMusteriSoyadi.getText());

				java.sql.Time sqlDate = new java.sql.Time(new java.util.Date()
						.getTime());

				String s = comboBox.getSelectedItem().toString();

				if (IdDegiskeni == null) {
					JOptionPane
							.showMessageDialog(null,
									"Musteri Kayýtlý Degil Lutfen Musteriyi Kayit Ediniz");
				}
				if (s.equals("Besibirlik")) {

					double MusteriAlacak = IdDegiskeni.getMusterininAlacagi();
					urunAl.setSatisElemani_idSatisElemani(User.id);
					urunAl.setUrunSatisTarihi(sqlDate);
					urunAl.setUrunAlisFiyati(Double
							.parseDouble(textToplamUrunAlis.getText()));
					urunAl.setUrun_idUrun(1);
					urunAl.setMusteri_idMusteri(IdDegiskeni.getIdMusteri());

					MusteriVeresiyeAlacagiGuncelle.setIdMusteri(IdDegiskeni
							.getIdMusteri());
					MusteriVeresiyeAlacagiGuncelle
							.setMusterininAlacagi(MusteriAlacak
									+ Double.parseDouble(textToplamUrunAlis
											.getText()));
					MusteriVeresiyeAlacagiGuncelle.setMusteriAdi(textMusteriAdi
							.getText());
					MusteriVeresiyeAlacagiGuncelle
							.setMusteriSoyadi(textMusteriSoyadi.getText());

					try {
						MusteriVeresiyeAlacagiGuncelle.UpdateDaoCustomer();

						urunAl.urunSatDao();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				
				
				
			}
		});
		btnAlisVeresiye.setBounds(344, 412, 122, 54);

		JLabel lblMterininSoyado = new JLabel(
				"M\u00FC\u015Fterinin Soyad\u0131 ");
		lblMterininSoyado.setBounds(25, 111, 87, 14);

		textMusteriSoyadi = new JTextField();
		textMusteriSoyadi.setBounds(139, 101, 313, 34);
		textMusteriSoyadi.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(528, 74, 231, 350);

		HtmlParseJava parse = new HtmlParseJava();
		String[][] gelenVeri = null;

		gelenVeri = parse.kuyumcuVeriCek();
		table_1 = new JTable();

		table_1.setModel(new DefaultTableModel(new Object[][] {
		/*
		 * {""+gelenVeri[0][0],""+gelenVeri[0][1],""+gelenVeri[0][2]},
		 * {""+gelenVeri[0][3],""+gelenVeri[0][4],""+gelenVeri[0][5]},
		 * {""+gelenVeri[0][6],""+gelenVeri[0][4],""+gelenVeri[0][7]},
		 * {""+gelenVeri[0][8],""+gelenVeri[0][9],""+gelenVeri[0][10]},
		 * {""+gelenVeri[0][11],""+gelenVeri[0][9],""+gelenVeri[0][12]},
		 * {""+gelenVeri[0][13],""+gelenVeri[0][14],""+gelenVeri[0][15]},
		 * {""+gelenVeri[0][16],""+gelenVeri[0][17],""+gelenVeri[0][18]},
		 * {""+gelenVeri[0][19],""+gelenVeri[0][20],""+gelenVeri[0][21]},
		 * {""+gelenVeri[0][22],""+gelenVeri[0][23],""+gelenVeri[0][24]},
		 * {""+gelenVeri[0][25],""+gelenVeri[0][23],""+gelenVeri[0][26]},
		 * {""+gelenVeri[0][27],""+gelenVeri[0][28],""+gelenVeri[0][29]},
		 * {""+gelenVeri[0][30],""+gelenVeri[0][31],""+gelenVeri[0][32]},
		 * {""+gelenVeri[0][33],""+gelenVeri[0][34],""+gelenVeri[0][35]},
		 * {""+gelenVeri[0][36],""+gelenVeri[0][37],""+gelenVeri[0][38]},
		 * {""+gelenVeri[0][39],""+gelenVeri[0][40],""+gelenVeri[0][41]},
		 * {""+gelenVeri[0][42],""+gelenVeri[0][43],""+gelenVeri[0][44]},
		 * {""+gelenVeri[0][45],""+gelenVeri[0][46],""+gelenVeri[0][47]},
		 * {""+gelenVeri[0][48],""+gelenVeri[0][49],""+gelenVeri[0][49]},
		 * {""+gelenVeri[0][50],""+gelenVeri[0][51],""+gelenVeri[0][51]},
		 * {""+gelenVeri[0][52],""+gelenVeri[0][53],""+gelenVeri[0][53]},
		 * {""+gelenVeri[0][54],""+gelenVeri[0][55],""+gelenVeri[0][55]},
		 * {""+gelenVeri[0][56],""+gelenVeri[0][57],""+gelenVeri[0][57]},
		 */
		}, new String[] { "ALTIN CiNSi", "ALIÞ", "SATIÞ" }));
		scrollPane.setViewportView(table_1);
		contentPane.setLayout(null);
		contentPane.add(txtpnTarih);
		contentPane.add(lblMterininSoyado);
		contentPane.add(txtpnrnCinsi);
		contentPane.add(txtpnGramadet);
		contentPane.add(txtpnMteriAdSoyad);
		contentPane.add(textField_1);
		contentPane.add(textMusteriSoyadi);
		contentPane.add(textMusteriAdi);
		contentPane.add(textToplamUrunAlis);
		contentPane.add(textField);
		contentPane.add(btnFiyatHesapla);
		contentPane.add(comboBox);
		contentPane.add(btnAlisPesin);
		contentPane.add(btnAlisVeresiye);
		contentPane.add(table);
		contentPane.add(txtpnTarih_1);
		contentPane.add(scrollPane);

		txtpnToplam = new JTextPane();
		txtpnToplam.setBackground(new Color(0, 191, 255));
		txtpnToplam.setText("TOPLAM:");
		txtpnToplam.setBounds(27, 318, 54, 20);
		contentPane.add(txtpnToplam);
		htmlparseEski parser1 = new htmlparseEski();
		 String [][] gelenVeriSaat1= null ;
		 gelenVeriSaat1 = parser1.kuyumcuVeriCek();
		textTarihKurGuncel = new JTextField();
		textTarihKurGuncel.setEditable(false);
		
		textTarihKurGuncel.setText(gelenVeriSaat1[0][0]);
		textTarihKurGuncel.setBounds(622, 34, 125, 20);
		contentPane.add(textTarihKurGuncel);
		textTarihKurGuncel.setColumns(10);

	}
}
