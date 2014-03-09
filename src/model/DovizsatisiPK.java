package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the dovizsatisi database table.
 * 
 */
@Embeddable
public class DovizsatisiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int satisElemani_idSatisElemani;

	@Column(insertable=false, updatable=false)
	private String doviz_DovizAdi;

	@Column(insertable=false, updatable=false)
	private int musteri_idMusteri;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date dovizSatisTarihi;

	public DovizsatisiPK() {
	}
	public int getSatisElemani_idSatisElemani() {
		return this.satisElemani_idSatisElemani;
	}
	public void setSatisElemani_idSatisElemani(int satisElemani_idSatisElemani) {
		this.satisElemani_idSatisElemani = satisElemani_idSatisElemani;
	}
	public String getDoviz_DovizAdi() {
		return this.doviz_DovizAdi;
	}
	public void setDoviz_DovizAdi(String doviz_DovizAdi) {
		this.doviz_DovizAdi = doviz_DovizAdi;
	}
	public int getMusteri_idMusteri() {
		return this.musteri_idMusteri;
	}
	public void setMusteri_idMusteri(int musteri_idMusteri) {
		this.musteri_idMusteri = musteri_idMusteri;
	}
	public java.util.Date getDovizSatisTarihi() {
		return this.dovizSatisTarihi;
	}
	public void setDovizSatisTarihi(java.util.Date dovizSatisTarihi) {
		this.dovizSatisTarihi = dovizSatisTarihi;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DovizsatisiPK)) {
			return false;
		}
		DovizsatisiPK castOther = (DovizsatisiPK)other;
		return 
			(this.satisElemani_idSatisElemani == castOther.satisElemani_idSatisElemani)
			&& this.doviz_DovizAdi.equals(castOther.doviz_DovizAdi)
			&& (this.musteri_idMusteri == castOther.musteri_idMusteri)
			&& this.dovizSatisTarihi.equals(castOther.dovizSatisTarihi);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.satisElemani_idSatisElemani;
		hash = hash * prime + this.doviz_DovizAdi.hashCode();
		hash = hash * prime + this.musteri_idMusteri;
		hash = hash * prime + this.dovizSatisTarihi.hashCode();
		
		return hash;
	}
}