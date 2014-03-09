package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dovizsatisi database table.
 * 
 */
@Entity
@NamedQuery(name="Dovizsatisi.findAll", query="SELECT d FROM Dovizsatisi d")
public class Dovizsatisi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DovizsatisiPK id;

	private double dovizSatisFiyati;

	//bi-directional many-to-one association to Doviz
	@ManyToOne
	private Doviz doviz;

	//bi-directional many-to-one association to Musteri
	@ManyToOne
	private Musteri musteri;

	//bi-directional many-to-one association to Satiselemani
	@ManyToOne
	private Satiselemani satiselemani;

	public Dovizsatisi() {
	}

	public DovizsatisiPK getId() {
		return this.id;
	}

	public void setId(DovizsatisiPK id) {
		this.id = id;
	}

	public double getDovizSatisFiyati() {
		return this.dovizSatisFiyati;
	}

	public void setDovizSatisFiyati(double dovizSatisFiyati) {
		this.dovizSatisFiyati = dovizSatisFiyati;
	}

	public Doviz getDoviz() {
		return this.doviz;
	}

	public void setDoviz(Doviz doviz) {
		this.doviz = doviz;
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

}