package Ekran;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MusteriEkrani extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StokDurum frame = new StokDurum();
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
	public MusteriEkrani() {
		setResizable(false);
		setTitle("MÜÞTERÝ EKRANI");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StokDurum.class.getResource("/Ekran/stock2.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 273);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnMusteriKaydi = new JButton("M\u00DC\u015ETER\u0130 KAYDI");
		btnMusteriKaydi.setBackground(new Color(0, 191, 255));
		btnMusteriKaydi.setBounds(84, 67, 153, 106);
		btnMusteriKaydi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Musteri ms = new Musteri();
				ms.setVisible(true);
				
			}
		});
		
		JButton btnMusteriGuncelle = new JButton("M\u00DC\u015ETER\u0130 G\u00DCNCELLE");
		btnMusteriGuncelle.setBackground(new Color(0, 191, 255));
		btnMusteriGuncelle.setBounds(295, 67, 153, 106);
		btnMusteriGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MusteriBilgiGuncelle mbg = new MusteriBilgiGuncelle();
				mbg.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnMusteriKaydi);
		contentPane.add(btnMusteriGuncelle);
	}
}
