package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the urun database table.
 * 
 */
@Entity
@NamedQuery(name="Urun.findAll", query="SELECT u FROM Urun u")
public class Urun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUrun;

	private double urunAdeti;

	private String urunAdi;

	private double urunAgirligi;

	private double uruniscilikFiyati;

	private double urunKurFiyati;

	//bi-directional many-to-one association to Urunalissatisi
	@OneToMany(mappedBy="urun")
	private List<Urunalissatisi> urunalissatisis;

	public Urun() {
	}

	public int getIdUrun() {
		return this.idUrun;
	}

	public void setIdUrun(int idUrun) {
		this.idUrun = idUrun;
	}

	public double getUrunAdeti() {
		return this.urunAdeti;
	}

	public void setUrunAdeti(double urunAdeti) {
		this.urunAdeti = urunAdeti;
	}

	public String getUrunAdi() {
		return this.urunAdi;
	}

	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

	public double getUrunAgirligi() {
		return this.urunAgirligi;
	}

	public void setUrunAgirligi(double urunAgirligi) {
		this.urunAgirligi = urunAgirligi;
	}

	public double getUruniscilikFiyati() {
		return this.uruniscilikFiyati;
	}

	public void setUruniscilikFiyati(double uruniscilikFiyati) {
		this.uruniscilikFiyati = uruniscilikFiyati;
	}

	public double getUrunKurFiyati() {
		return this.urunKurFiyati;
	}

	public void setUrunKurFiyati(double urunKurFiyati) {
		this.urunKurFiyati = urunKurFiyati;
	}

	public List<Urunalissatisi> getUrunalissatisis() {
		return this.urunalissatisis;
	}

	public void setUrunalissatisis(List<Urunalissatisi> urunalissatisis) {
		this.urunalissatisis = urunalissatisis;
	}

	public Urunalissatisi addUrunalissatisi(Urunalissatisi urunalissatisi) {
		getUrunalissatisis().add(urunalissatisi);
		urunalissatisi.setUrun(this);

		return urunalissatisi;
	}

	public Urunalissatisi removeUrunalissatisi(Urunalissatisi urunalissatisi) {
		getUrunalissatisis().remove(urunalissatisi);
		urunalissatisi.setUrun(null);

		return urunalissatisi;
	}

}