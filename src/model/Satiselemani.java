package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the satiselemani database table.
 * 
 */
@Entity
@NamedQuery(name="Satiselemani.findAll", query="SELECT s FROM Satiselemani s")
public class Satiselemani implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSatisElemani;

	private String satisElemaniAdi;

	private String satisElemaniAdres;

	private String satisElemaniCinsiyet;

	private String satisElemaniSifre;

	private String satisElemaniSoyadi;

	private String satisElemaniSubeAdi;

	private String satisElemaniTcno;

	private double satisElemaniTelefon;

	//bi-directional many-to-one association to Dovizsatisi
	@OneToMany(mappedBy="satiselemani")
	private List<Dovizsatisi> dovizsatisis;

	//bi-directional many-to-one association to Urunalissatisi
	@OneToMany(mappedBy="satiselemani")
	private List<Urunalissatisi> urunalissatisis;

	public Satiselemani() {
	}

	public int getIdSatisElemani() {
		return this.idSatisElemani;
	}

	public void setIdSatisElemani(int idSatisElemani) {
		this.idSatisElemani = idSatisElemani;
	}

	public String getSatisElemaniAdi() {
		return this.satisElemaniAdi;
	}

	public void setSatisElemaniAdi(String satisElemaniAdi) {
		this.satisElemaniAdi = satisElemaniAdi;
	}

	public String getSatisElemaniAdres() {
		return this.satisElemaniAdres;
	}

	public void setSatisElemaniAdres(String satisElemaniAdres) {
		this.satisElemaniAdres = satisElemaniAdres;
	}

	public String getSatisElemaniCinsiyet() {
		return this.satisElemaniCinsiyet;
	}

	public void setSatisElemaniCinsiyet(String satisElemaniCinsiyet) {
		this.satisElemaniCinsiyet = satisElemaniCinsiyet;
	}

	public String getSatisElemaniSifre() {
		return this.satisElemaniSifre;
	}

	public void setSatisElemaniSifre(String satisElemaniSifre) {
		this.satisElemaniSifre = satisElemaniSifre;
	}

	public String getSatisElemaniSoyadi() {
		return this.satisElemaniSoyadi;
	}

	public void setSatisElemaniSoyadi(String satisElemaniSoyadi) {
		this.satisElemaniSoyadi = satisElemaniSoyadi;
	}

	public String getSatisElemaniSubeAdi() {
		return this.satisElemaniSubeAdi;
	}

	public void setSatisElemaniSubeAdi(String satisElemaniSubeAdi) {
		this.satisElemaniSubeAdi = satisElemaniSubeAdi;
	}

	public String getSatisElemaniTcno() {
		return this.satisElemaniTcno;
	}

	public void setSatisElemaniTcno(String satisElemaniTcno) {
		this.satisElemaniTcno = satisElemaniTcno;
	}

	public double getSatisElemaniTelefon() {
		return this.satisElemaniTelefon;
	}

	public void setSatisElemaniTelefon(double satisElemaniTelefon) {
		this.satisElemaniTelefon = satisElemaniTelefon;
	}

	public List<Dovizsatisi> getDovizsatisis() {
		return this.dovizsatisis;
	}

	public void setDovizsatisis(List<Dovizsatisi> dovizsatisis) {
		this.dovizsatisis = dovizsatisis;
	}

	public Dovizsatisi addDovizsatisi(Dovizsatisi dovizsatisi) {
		getDovizsatisis().add(dovizsatisi);
		dovizsatisi.setSatiselemani(this);

		return dovizsatisi;
	}

	public Dovizsatisi removeDovizsatisi(Dovizsatisi dovizsatisi) {
		getDovizsatisis().remove(dovizsatisi);
		dovizsatisi.setSatiselemani(null);

		return dovizsatisi;
	}

	public List<Urunalissatisi> getUrunalissatisis() {
		return this.urunalissatisis;
	}

	public void setUrunalissatisis(List<Urunalissatisi> urunalissatisis) {
		this.urunalissatisis = urunalissatisis;
	}

	public Urunalissatisi addUrunalissatisi(Urunalissatisi urunalissatisi) {
		getUrunalissatisis().add(urunalissatisi);
		urunalissatisi.setSatiselemani(this);

		return urunalissatisi;
	}

	public Urunalissatisi removeUrunalissatisi(Urunalissatisi urunalissatisi) {
		getUrunalissatisis().remove(urunalissatisi);
		urunalissatisi.setSatiselemani(null);

		return urunalissatisi;
	}

}