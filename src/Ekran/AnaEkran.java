package Ekran;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class AnaEkran extends JFrame {

	private JPanel contentPane;
	private JTextField textPersonelAdiSoyadi;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaEkran frame = new AnaEkran();
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
	public AnaEkran() {
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AnaEkran.class.getResource("/Ekran/gold-bullion-icon.png")));
		
		    int stage_height=400;//örnektir
		    int stage_width=800;//örnektir
		    int stage_start_position_x;
		    int stage_start_position_y;
		    Dimension screen_size=Toolkit.getDefaultToolkit().getScreenSize();

		    stage_start_position_x = (int)(screen_size.getWidth()-stage_width)/2;
		    stage_start_position_y = (int)(screen_size.getHeight()-stage_height)/2;

		 
		  
		    setBounds(stage_start_position_x, stage_start_position_y, stage_width, stage_height);
		 
		    setTitle("KUYUMCU OTOMASYONU");
		    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("ALI\u015E");
		btnNewButton.setBounds(288, 5, 222, 68);
		btnNewButton.setIcon(new ImageIcon(AnaEkran.class.getResource("/Ekran/cash-register-icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AlisEkrani al = new AlisEkrani();
				al.setVisible(true);
			}
		});
		
		JButton btnSat = new JButton("SATI\u015E");
		btnSat.setBounds(15, 5, 222, 68);
		btnSat.setIcon(new ImageIcon(AnaEkran.class.getResource("/Ekran/cash-register-icon.png")));
		btnSat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SatisEkrani al = new SatisEkrani();
				al.setVisible(true);
			}
		});
		
		JButton btnIstatistikEkran = new JButton("\u0130STAT\u0130ST\u0130K");
		btnIstatistikEkran.setBounds(557, 5, 222, 68);
		btnIstatistikEkran.setIcon(new ImageIcon(AnaEkran.class.getResource("/Ekran/1393948515_gnumeric.png")));
		btnIstatistikEkran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ÝstatistikEkrani is = new ÝstatistikEkrani();
				is.setVisible(true);

			}
		});
		
		JButton btnKurBilgileriEkran = new JButton("STOK");
		btnKurBilgileriEkran.setBounds(557, 97, 222, 68);
		btnKurBilgileriEkran.setIcon(new ImageIcon(AnaEkran.class.getResource("/Ekran/Actions-stock-save-as-icon.png")));
		btnKurBilgileriEkran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StokDurum sd = new StokDurum();
				sd.setVisible(true);
				
			}
		});
		
		JButton btnDvizEkran = new JButton("D\u00D6V\u0130Z");
		btnDvizEkran.setBounds(557, 183, 222, 68);
		btnDvizEkran.setIcon(new ImageIcon(AnaEkran.class.getResource("/Ekran/d\u00F6v1.png")));
		btnDvizEkran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DovizEkrani dz = new DovizEkrani();
				dz.setVisible(true);
				
			}
		});
		
		JButton btnMteriTanmla = new JButton("M\u00DC\u015ETER\u0130");
		btnMteriTanmla.setBounds(15, 97, 222, 68);
		btnMteriTanmla.setIcon(new ImageIcon(AnaEkran.class.getResource("/Ekran/addd.png")));
		btnMteriTanmla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				MusteriEkrani me = new MusteriEkrani();
				me.setVisible(true);
			
			}
		});
		
		JButton btnPersonelTanmla = new JButton("PERSONEL");
		btnPersonelTanmla.setBounds(290, 97, 220, 68);
		btnPersonelTanmla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Personel ps = new Personel();
				ps.setVisible(true);
			
			}
		});
		btnPersonelTanmla.setIcon(new ImageIcon(AnaEkran.class.getResource("/Ekran/perso.png")));
		
		JButton btnHesapMakinas = new JButton("HESAP MAK\u0130NASI");
		btnHesapMakinas.setBounds(15, 183, 222, 68);
		btnHesapMakinas.setIcon(new ImageIcon(AnaEkran.class.getResource("/Ekran/calc1.png")));
		btnHesapMakinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hesap hs = new Hesap();
				hs.setVisible(true);
			
			}
		});
		
		JTextPane txtpnHosgeldnz = new JTextPane();
		txtpnHosgeldnz.setBackground(UIManager.getColor("Button.background"));
		txtpnHosgeldnz.setBounds(316, 231, 103, 20);
		txtpnHosgeldnz.setText("      HOSGELDINIZ ");
		contentPane.setLayout(null);
		contentPane.add(btnHesapMakinas);
		contentPane.add(btnMteriTanmla);
		contentPane.add(btnSat);
		contentPane.add(btnNewButton);
		contentPane.add(btnPersonelTanmla);
		contentPane.add(btnDvizEkran);
		contentPane.add(btnKurBilgileriEkran);
		contentPane.add(btnIstatistikEkran);
		contentPane.add(txtpnHosgeldnz);
		
		textPersonelAdiSoyadi = new JTextField();
		textPersonelAdiSoyadi.setEditable(false);
		textPersonelAdiSoyadi.setEnabled(false);
		
		textPersonelAdiSoyadi.setBounds(293, 268, 167, 20);
		
		textPersonelAdiSoyadi.setText(User.kullaniciadi);
				
		
		contentPane.add(textPersonelAdiSoyadi);
		
		textPersonelAdiSoyadi.setColumns(10);

		
	}
}
