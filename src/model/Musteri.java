package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the musteri database table.
 * 
 */
@Entity
@NamedQuery(name="Musteri.findAll", query="SELECT m FROM Musteri m")
public class Musteri implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMusteri;

	private String musteriAdi;

	private String musteriEmail;

	@Temporal(TemporalType.TIMESTAMP)
	private Date musteriKayitTarihi;

	private double musterininAlacagi;

	private double musterininBorcu;

	private String musteriReferans;

	private String musteriSoyadi;

	private double musteriTelefon;

	//bi-directional many-to-one association to Dovizsatisi
	@OneToMany(mappedBy="musteri")
	private List<Dovizsatisi> dovizsatisis;

	//bi-directional many-to-one association to Urunalissatisi
	@OneToMany(mappedBy="musteri")
	private List<Urunalissatisi> urunalissatisis;

	public Musteri() {
	}

	public int getIdMusteri() {
		return this.idMusteri;
	}

	public void setIdMusteri(int idMusteri) {
		this.idMusteri = idMusteri;
	}

	public String getMusteriAdi() {
		return this.musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}

	public String getMusteriEmail() {
		return this.musteriEmail;
	}

	public void setMusteriEmail(String musteriEmail) {
		this.musteriEmail = musteriEmail;
	}

	public Date getMusteriKayitTarihi() {
		return this.musteriKayitTarihi;
	}

	public void setMusteriKayitTarihi(Date musteriKayitTarihi) {
		this.musteriKayitTarihi = musteriKayitTarihi;
	}

	public double getMusterininAlacagi() {
		return this.musterininAlacagi;
	}

	public void setMusterininAlacagi(double musterininAlacagi) {
		this.musterininAlacagi = musterininAlacagi;
	}

	public double getMusterininBorcu() {
		return this.musterininBorcu;
	}

	public void setMusterininBorcu(double musterininBorcu) {
		this.musterininBorcu = musterininBorcu;
	}

	public String getMusteriReferans() {
		return this.musteriReferans;
	}

	public void setMusteriReferans(String musteriReferans) {
		this.musteriReferans = musteriReferans;
	}

	public String getMusteriSoyadi() {
		return this.musteriSoyadi;
	}

	public void setMusteriSoyadi(String musteriSoyadi) {
		this.musteriSoyadi = musteriSoyadi;
	}

	public double getMusteriTelefon() {
		return this.musteriTelefon;
	}

	public void setMusteriTelefon(double musteriTelefon) {
		this.musteriTelefon = musteriTelefon;
	}

	public List<Dovizsatisi> getDovizsatisis() {
		return this.dovizsatisis;
	}

	public void setDovizsatisis(List<Dovizsatisi> dovizsatisis) {
		this.dovizsatisis = dovizsatisis;
	}

	public Dovizsatisi addDovizsatisi(Dovizsatisi dovizsatisi) {
		getDovizsatisis().add(dovizsatisi);
		dovizsatisi.setMusteri(this);

		return dovizsatisi;
	}

	public Dovizsatisi removeDovizsatisi(Dovizsatisi dovizsatisi) {
		getDovizsatisis().remove(dovizsatisi);
		dovizsatisi.setMusteri(null);

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
		urunalissatisi.setMusteri(this);

		return urunalissatisi;
	}

	public Urunalissatisi removeUrunalissatisi(Urunalissatisi urunalissatisi) {
		getUrunalissatisis().remove(urunalissatisi);
		urunalissatisi.setMusteri(null);

		return urunalissatisi;
	}

}