package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the urunalissatisi database table.
 * 
 */
@Embeddable
public class UrunalissatisiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int satisElemani_idSatisElemani;

	@Column(insertable=false, updatable=false)
	private int urun_idUrun;

	@Column(insertable=false, updatable=false)
	private int musteri_idMusteri;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date urunSatisTarihi;

	public UrunalissatisiPK() {
	}
	public int getSatisElemani_idSatisElemani() {
		return this.satisElemani_idSatisElemani;
	}
	public void setSatisElemani_idSatisElemani(int satisElemani_idSatisElemani) {
		this.satisElemani_idSatisElemani = satisElemani_idSatisElemani;
	}
	public int getUrun_idUrun() {
		return this.urun_idUrun;
	}
	public void setUrun_idUrun(int urun_idUrun) {
		this.urun_idUrun = urun_idUrun;
	}
	public int getMusteri_idMusteri() {
		return this.musteri_idMusteri;
	}
	public void setMusteri_idMusteri(int musteri_idMusteri) {
		this.musteri_idMusteri = musteri_idMusteri;
	}
	public java.util.Date getUrunSatisTarihi() {
		return this.urunSatisTarihi;
	}
	public void setUrunSatisTarihi(java.util.Date urunSatisTarihi) {
		this.urunSatisTarihi = urunSatisTarihi;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UrunalissatisiPK)) {
			return false;
		}
		UrunalissatisiPK castOther = (UrunalissatisiPK)other;
		return 
			(this.satisElemani_idSatisElemani == castOther.satisElemani_idSatisElemani)
			&& (this.urun_idUrun == castOther.urun_idUrun)
			&& (this.musteri_idMusteri == castOther.musteri_idMusteri)
			&& this.urunSatisTarihi.equals(castOther.urunSatisTarihi);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.satisElemani_idSatisElemani;
		hash = hash * prime + this.urun_idUrun;
		hash = hash * prime + this.musteri_idMusteri;
		hash = hash * prime + this.urunSatisTarihi.hashCode();
		
		return hash;
	}
}