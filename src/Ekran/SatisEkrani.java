package Ekran;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;

import veritabani_Islemleri.JpaCrudDaoClass;
import veritabani_Islemleri.MusteriDaoClassBean;
import veritabani_Islemleri.UrunSatisDaoClassBean;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import jsoupParser.HtmlParseJava;
import jsoupParser.HtmlSatisFiyatParseJava;
import jsoupParser.htmlparseEski;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SatisEkrani extends JFrame {

	private JPanel contentPane;
	private JTextPane txtpnTarih;
	private JTextPane txtpnGramadet;
	private JTextPane txtpnrnCinsi;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textToplamUrunAlis;
	private JTextField textTarihKurGuncel;
	private JTable table;
	private JComboBox comboBox;
	private JTextField textMusteriAdi;
	private JButton pesinsatisbutonu;
	private JButton btnVeresiyeSatisButonu;
	private JLabel lblMterininSoyad;
	private JTextField textMusteriSoyadi;
	private JScrollPane scrollPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SatisEkrani frame = new SatisEkrani();
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
	public SatisEkrani() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				SatisEkrani.class
						.getResource("/Ekran/cash-register-icon 2.png")));
		setTitle("SATI\u015E EKRANI");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtpnTarih = new JTextPane();
		txtpnTarih.setBounds(25, 112, 67, 20);
		txtpnTarih.setEditable(false);
		txtpnTarih.setBackground(new Color(0, 191, 255));
		txtpnTarih.setText("Tarih");

		txtpnGramadet = new JTextPane();
		txtpnGramadet.setBounds(25, 173, 64, 20);
		txtpnGramadet.setEditable(false);
		txtpnGramadet.setBackground(new Color(0, 191, 255));
		txtpnGramadet.setText("Gram - Adet");

		txtpnrnCinsi = new JTextPane();
		txtpnrnCinsi.setBounds(25, 205, 54, 20);
		txtpnrnCinsi.setEditable(false);
		txtpnrnCinsi.setBackground(new Color(0, 191, 255));
		txtpnrnCinsi.setText("\u00DCr\u00FCn Cinsi");

		textField = new JTextField();
		textField.setBounds(116, 112, 311, 35);
		textField.setEditable(false);
		textField.setColumns(10);
		comboBox = new JComboBox();
		comboBox.setBounds(116, 203, 311, 32);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Besibirlik",
				"Cumhuriyet Eski 2,5 ", "Cumhuriyet Yeni 2,5",
				"Liral\u0131k Eski", "Liral\u0131k Yeni",
				"Re\u015Fat, Hamit, Aziz", "Ata Lira Eski", "Ata Lira Yeni",
				"Yar\u0131m Eski", "Yarim Yeni", "\u00C7eyrek Eski",
				"\u00C7eyrek Yeni", "22 Ayar Bilezik", "22 Kordon",
				"22 S\u0131f\u0131r Zincir", "18 Ayar", "14 Ayar",
				"G\u00FCm\u00FC\u015F Yerli", "Otantik G\u00FCm\u00FC\u015F",
				"G\u00FCm\u00FC\u015F \u0130thal", "G\u00FCm\u00FC\u015F Has" }));

		textField_1 = new JTextField();
		textField_1.setBounds(116, 165, 311, 32);
		textField_1.setColumns(10);

		JButton btnFiyatHesapla = new JButton("Fiyat Toplam\u0131");
		btnFiyatHesapla.setBounds(162, 341, 188, 47);
		btnFiyatHesapla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(User.id);
			}
		});
		btnFiyatHesapla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HtmlSatisFiyatParseJava satisFiyat = new HtmlSatisFiyatParseJava();
				String[][] gelenVeri2 = null;

				gelenVeri2 = satisFiyat.kuyumcuVeriCek();
				System.out.println(gelenVeri2[1][0]);

				double i = Double.parseDouble(textField_1.getText());

				String s = comboBox.getSelectedItem().toString();

				// 1
				if (s.equals("Besibirlik")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);
					double gelenVeri = 0;

					try {
						gelenVeri = nf_in.parse(gelenVeri2[1][0]).doubleValue();
					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 2
				} else if (s.equals("Cumhuriyet Eski 2,5")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[3][0]).doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;

					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 3
				} else if (s.equals("Cumhuriyet Yeni 2,5")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[6][0]).doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;

					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 4
				} else if (s.equals("Liral\u0131k Eski")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[8][0]).doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;

					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 5
				} else if (s.equals("Liral\u0131k Yeni")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[11][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;

					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 6
				} else if (s.equals("Re\u015Fat, Hamit, Aziz")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[13][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 7
				} else if (s.equals("Ata Lira Eski")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[15][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 8
				} else if (s.equals("Ata Lira Yeni")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[17][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 9
				} else if (s.equals("Yar\u0131m Eski")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[19][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 10
				} else if (s.equals("Yarim Yeni")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[22][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 11
				} else if (s.equals("\u00C7eyrek Eski")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[24][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 12
				} else if (s.equals("\u00C7eyrek Yeni")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[26][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 13
				} else if (s.equals("22 Ayar Bilezik")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[28][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 14
				} else if (s.equals("22 Kordon")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[30][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 15
				} else if (s.equals("22 S\u0131f\u0131r Zincir")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[32][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 16
				} else if (s.equals("18 Ayar")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[34][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));
					// 17
				} else if (s.equals("14 Ayar")) {
					NumberFormat nf_in = NumberFormat
							.getNumberInstance(Locale.GERMANY);

					double gelenVeri = 0;
					try {

						gelenVeri = nf_in.parse(gelenVeri2[36][0])
								.doubleValue();

					} catch (ParseException e1) {

						e1.printStackTrace();
					}

					double sonuc = i * gelenVeri;
					textToplamUrunAlis.setText(toString().valueOf(sonuc));

				}

			}
		});

		textToplamUrunAlis = new JTextField();
		textToplamUrunAlis.setBounds(116, 246, 311, 30);
		textToplamUrunAlis.setEditable(false);
		textToplamUrunAlis.setColumns(10);

		JTextPane txtpnTarih_1 = new JTextPane();
		txtpnTarih_1.setBounds(476, 31, 137, 20);
		txtpnTarih_1.setEditable(false);
		txtpnTarih_1.setBackground(new Color(0, 191, 255));
		txtpnTarih_1.setText("Guncelleme Tarihi");
		
		htmlparseEski parser1 = new htmlparseEski();
		 String [][] gelenVeriSaat1= null ;
		 gelenVeriSaat1 = parser1.kuyumcuVeriCek();
		 
		textTarihKurGuncel = new JTextField();
		
		textTarihKurGuncel.setText(gelenVeriSaat1[0][0]);
		textTarihKurGuncel.setBounds(610, 31, 172, 20);
		textTarihKurGuncel.setEditable(false);
		textTarihKurGuncel.setColumns(10);

		table = new JTable();
		table.setBounds(813, 576, 1, 1);

		JTextPane txtpnMteriAdSoyad = new JTextPane();
		txtpnMteriAdSoyad.setBounds(25, 50, 76, 20);
		txtpnMteriAdSoyad.setBackground(new Color(0, 191, 255));
		txtpnMteriAdSoyad.setText("M\u00FC\u015Fterinin Ad\u0131 ");

		textMusteriAdi = new JTextField();
		textMusteriAdi.setBounds(116, 41, 311, 33);
		textMusteriAdi.setColumns(10);

		pesinsatisbutonu = new JButton("PE\u015E\u0130N SATI\u015E !");
		pesinsatisbutonu.setBounds(43, 428, 147, 47);
		pesinsatisbutonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.out.println(User.id);

				UrunSatisDaoClassBean urunsat = new UrunSatisDaoClassBean();
				JpaCrudDaoClass musteriadsoyadagoreidal = new JpaCrudDaoClass();

				model.Musteri isimDegiskeni;

				isimDegiskeni = musteriadsoyadagoreidal
						.AdSoyadaGoreMusteriidGetir(textMusteriAdi.getText(),
								textMusteriSoyadi.getText());

				java.sql.Time sqlDate = new java.sql.Time(new java.util.Date()
						.getTime());

				String s = comboBox.getSelectedItem().toString();

				if (s.equals("Besibirlik")) {

					urunsat.setSatisElemani_idSatisElemani(User.id);
					urunsat.setUrunSatisTarihi(sqlDate);
					urunsat.setUrunSatisFiyati(Double
							.parseDouble(textToplamUrunAlis.getText()));
					urunsat.setUrun_idUrun(1);
					urunsat.setMusteri_idMusteri(isimDegiskeni.getIdMusteri());
					urunsat.urunSatDao();

				}

			}
		});

		btnVeresiyeSatisButonu = new JButton("Veresiye SATI\u015E !");
		btnVeresiyeSatisButonu.setBounds(264, 428, 163, 47);
		btnVeresiyeSatisButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				UrunSatisDaoClassBean urunsat = new UrunSatisDaoClassBean();
				JpaCrudDaoClass musteriadsoyadagoreidal = new JpaCrudDaoClass();
				MusteriDaoClassBean MusteriVeresiyeBorcuGuncelle = new MusteriDaoClassBean();

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

					double MusteriBorcu = IdDegiskeni.getMusterininBorcu();
					urunsat.setSatisElemani_idSatisElemani(User.id);
					urunsat.setUrunSatisTarihi(sqlDate);
					urunsat.setUrunSatisFiyati(Double
							.parseDouble(textToplamUrunAlis.getText()));
					urunsat.setUrun_idUrun(1);
					urunsat.setMusteri_idMusteri(IdDegiskeni.getIdMusteri());

					MusteriVeresiyeBorcuGuncelle.setIdMusteri(IdDegiskeni
							.getIdMusteri());
					MusteriVeresiyeBorcuGuncelle
							.setMusterininBorcu(MusteriBorcu
									+ Double.parseDouble(textToplamUrunAlis
											.getText()));
					MusteriVeresiyeBorcuGuncelle.setMusteriAdi(textMusteriAdi
							.getText());
					MusteriVeresiyeBorcuGuncelle
							.setMusteriSoyadi(textMusteriSoyadi.getText());

					try {
						MusteriVeresiyeBorcuGuncelle.UpdateDaoCustomer();

						urunsat.urunSatDao();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (s.equals("Cumhuriyet Eski 2,5")) {

					double MusteriBorcu = IdDegiskeni.getMusterininBorcu();
					urunsat.setSatisElemani_idSatisElemani(User.id);
					urunsat.setUrunSatisTarihi(sqlDate);
					urunsat.setUrunSatisFiyati(Double
							.parseDouble(textToplamUrunAlis.getText()));
					urunsat.setUrun_idUrun(2);
					urunsat.setMusteri_idMusteri(IdDegiskeni.getIdMusteri());

					MusteriVeresiyeBorcuGuncelle.setIdMusteri(IdDegiskeni
							.getIdMusteri());
					MusteriVeresiyeBorcuGuncelle
							.setMusterininBorcu(MusteriBorcu
									+ Double.parseDouble(textToplamUrunAlis
											.getText()));
					MusteriVeresiyeBorcuGuncelle.setMusteriAdi(textMusteriAdi
							.getText());
					MusteriVeresiyeBorcuGuncelle
							.setMusteriSoyadi(textMusteriSoyadi.getText());

					try {
						MusteriVeresiyeBorcuGuncelle.UpdateDaoCustomer();

						urunsat.urunSatDao();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (s.equals("Besibirlik")) {

					double MusteriBorcu = IdDegiskeni.getMusterininBorcu();
					urunsat.setSatisElemani_idSatisElemani(User.id);
					urunsat.setUrunSatisTarihi(sqlDate);
					urunsat.setUrunSatisFiyati(Double
							.parseDouble(textToplamUrunAlis.getText()));
					urunsat.setUrun_idUrun(1);
					urunsat.setMusteri_idMusteri(IdDegiskeni.getIdMusteri());

					MusteriVeresiyeBorcuGuncelle.setIdMusteri(IdDegiskeni
							.getIdMusteri());
					MusteriVeresiyeBorcuGuncelle
							.setMusterininBorcu(MusteriBorcu
									+ Double.parseDouble(textToplamUrunAlis
											.getText()));
					MusteriVeresiyeBorcuGuncelle.setMusteriAdi(textMusteriAdi
							.getText());
					MusteriVeresiyeBorcuGuncelle
							.setMusteriSoyadi(textMusteriSoyadi.getText());

					try {
						MusteriVeresiyeBorcuGuncelle.UpdateDaoCustomer();

						urunsat.urunSatDao();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (s.equals("Besibirlik")) {

					double MusteriBorcu = IdDegiskeni.getMusterininBorcu();
					urunsat.setSatisElemani_idSatisElemani(User.id);
					urunsat.setUrunSatisTarihi(sqlDate);
					urunsat.setUrunSatisFiyati(Double
							.parseDouble(textToplamUrunAlis.getText()));
					urunsat.setUrun_idUrun(1);
					urunsat.setMusteri_idMusteri(IdDegiskeni.getIdMusteri());

					MusteriVeresiyeBorcuGuncelle.setIdMusteri(IdDegiskeni
							.getIdMusteri());
					MusteriVeresiyeBorcuGuncelle
							.setMusterininBorcu(MusteriBorcu
									+ Double.parseDouble(textToplamUrunAlis
											.getText()));
					MusteriVeresiyeBorcuGuncelle.setMusteriAdi(textMusteriAdi
							.getText());
					MusteriVeresiyeBorcuGuncelle
							.setMusteriSoyadi(textMusteriSoyadi.getText());

					try {
						MusteriVeresiyeBorcuGuncelle.UpdateDaoCustomer();

						urunsat.urunSatDao();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (s.equals("Besibirlik")) {

					double MusteriBorcu = IdDegiskeni.getMusterininBorcu();
					urunsat.setSatisElemani_idSatisElemani(User.id);
					urunsat.setUrunSatisTarihi(sqlDate);
					urunsat.setUrunSatisFiyati(Double
							.parseDouble(textToplamUrunAlis.getText()));
					urunsat.setUrun_idUrun(1);
					urunsat.setMusteri_idMusteri(IdDegiskeni.getIdMusteri());

					MusteriVeresiyeBorcuGuncelle.setIdMusteri(IdDegiskeni
							.getIdMusteri());
					MusteriVeresiyeBorcuGuncelle
							.setMusterininBorcu(MusteriBorcu
									+ Double.parseDouble(textToplamUrunAlis
											.getText()));
					MusteriVeresiyeBorcuGuncelle.setMusteriAdi(textMusteriAdi
							.getText());
					MusteriVeresiyeBorcuGuncelle
							.setMusteriSoyadi(textMusteriSoyadi.getText());

					try {
						MusteriVeresiyeBorcuGuncelle.UpdateDaoCustomer();

						urunsat.urunSatDao();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (s.equals("Besibirlik")) {

					double MusteriBorcu = IdDegiskeni.getMusterininBorcu();
					urunsat.setSatisElemani_idSatisElemani(User.id);
					urunsat.setUrunSatisTarihi(sqlDate);
					urunsat.setUrunSatisFiyati(Double
							.parseDouble(textToplamUrunAlis.getText()));
					urunsat.setUrun_idUrun(1);
					urunsat.setMusteri_idMusteri(IdDegiskeni.getIdMusteri());

					MusteriVeresiyeBorcuGuncelle.setIdMusteri(IdDegiskeni
							.getIdMusteri());
					MusteriVeresiyeBorcuGuncelle
							.setMusterininBorcu(MusteriBorcu
									+ Double.parseDouble(textToplamUrunAlis
											.getText()));
					MusteriVeresiyeBorcuGuncelle.setMusteriAdi(textMusteriAdi
							.getText());
					MusteriVeresiyeBorcuGuncelle
							.setMusteriSoyadi(textMusteriSoyadi.getText());

					try {
						MusteriVeresiyeBorcuGuncelle.UpdateDaoCustomer();

						urunsat.urunSatDao();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});

		lblMterininSoyad = new JLabel("M\u00FC\u015Fterinin Soyad\u0131 ");
		lblMterininSoyad.setBounds(25, 87, 87, 14);

		textMusteriSoyadi = new JTextField();
		textMusteriSoyadi.setBounds(116, 80, 311, 28);
		textMusteriSoyadi.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(559, 101, 236, 328);
		HtmlParseJava parse = new HtmlParseJava();
		String[][] gelenVeri = null;

		gelenVeri = parse.kuyumcuVeriCek();
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {

		{ "" + gelenVeri[0][0], "" + gelenVeri[0][1], "" + gelenVeri[0][2] },
		/*
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
		contentPane.add(table);
		contentPane.add(txtpnMteriAdSoyad);
		contentPane.add(textMusteriAdi);
		contentPane.add(lblMterininSoyad);
		contentPane.add(textMusteriSoyadi);
		contentPane.add(txtpnTarih);
		contentPane.add(textField);
		contentPane.add(txtpnGramadet);
		contentPane.add(textField_1);
		contentPane.add(txtpnrnCinsi);
		contentPane.add(comboBox);
		contentPane.add(textToplamUrunAlis);
		contentPane.add(pesinsatisbutonu);
		contentPane.add(btnVeresiyeSatisButonu);
		contentPane.add(btnFiyatHesapla);
		contentPane.add(scrollPane);
		contentPane.add(txtpnTarih_1);
		contentPane.add(textTarihKurGuncel);
	}
}
