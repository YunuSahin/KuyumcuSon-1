package Ekran;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ÝstatistikEkrani extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ÝstatistikEkrani frame = new ÝstatistikEkrani();
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
	public ÝstatistikEkrani() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ÝstatistikEkrani.class.getResource("/Ekran/ista2.png")));
		setTitle("\u0130STAT\u0130ST\u0130K EKRANI");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 597, 292);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("ALINAN \u00DCR\u00DCNLER\u0130 G\u00D6R");
		btnNewButton.setBounds(44, 82, 153, 106);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				AlinanUrun au = new AlinanUrun();
				au.setVisible(true);
			}
		});
		
		JButton btnAlnanrnleriGr = new JButton("SATILAN \u00DCR\u00DCNLER\u0130 G\u00D6R");
		btnAlnanrnleriGr.setBounds(215, 82, 153, 106);
		btnAlnanrnleriGr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SatilanUrun su = new SatilanUrun();
				su.setVisible(true);
			}
		});
		
		JButton btnCiro = new JButton("C\u0130RO");
		btnCiro.setBounds(386, 82, 153, 107);
		btnCiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ciro cr = new Ciro();
				cr.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		contentPane.add(btnAlnanrnleriGr);
		contentPane.add(btnCiro);
	}

}
