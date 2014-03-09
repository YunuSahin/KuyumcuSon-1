package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the urunalissatisi database table.
 * 
 */
@Entity
@NamedQuery(name="Urunalissatisi.findAll", query="SELECT u FROM Urunalissatisi u")
public class Urunalissatisi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UrunalissatisiPK id;

	private double urunAlisFiyati;

	private double urunSatisFiyati;

	//bi-directional many-to-one association to Musteri
	@ManyToOne
	private Musteri musteri;

	//bi-directional many-to-one association to Satiselemani
	@ManyToOne
	private Satiselemani satiselemani;

	//bi-directional many-to-one association to Urun
	@ManyToOne
	private Urun urun;

	public Urunalissatisi() {
	}

	public UrunalissatisiPK getId() {
		return this.id;
	}

	public void setId(UrunalissatisiPK id) {
		this.id = id;
	}

	public double getUrunAlisFiyati() {
		return this.urunAlisFiyati;
	}

	public void setUrunAlisFiyati(double urunAlisFiyati) {
		this.urunAlisFiyati = urunAlisFiyati;
	}

	public double getUrunSatisFiyati() {
		return this.urunSatisFiyati;
	}

	public void setUrunSatisFiyati(double urunSatisFiyati) {
		this.urunSatisFiyati = urunSatisFiyati;
	}

	public Musteri getMusteri() {
		return this.musteri;
	}

	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}

	public Satiselemani getSatiselemani() {
		return this.satiselemani;
	}

	public void setSatiselemani(Satiselemani satiselemani) {
		this.satiselemani = satiselemani;
	}

	public Urun getUrun() {
		return this.urun;
	}

	public void setUrun(Urun urun) {
		this.urun = urun;
	}

}