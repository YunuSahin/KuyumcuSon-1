package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the doviz database table.
 * 
 */
@Entity
@NamedQuery(name="Doviz.findAll", query="SELECT d FROM Doviz d")
public class Doviz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String dovizAdi;

	//bi-directional many-to-one association to Dovizsatisi
	@OneToMany(mappedBy="doviz")
	private List<Dovizsatisi> dovizsatisis;

	public Doviz() {
	}

	public String getDovizAdi() {
		return this.dovizAdi;
	}

	public void setDovizAdi(String dovizAdi) {
		this.dovizAdi = dovizAdi;
	}

	public List<Dovizsatisi> getDovizsatisis() {
		return this.dovizsatisis;
	}

	public void setDovizsatisis(List<Dovizsatisi> dovizsatisis) {
		this.dovizsatisis = dovizsatisis;
	}

	public Dovizsatisi addDovizsatisi(Dovizsatisi dovizsatisi) {
		getDovizsatisis().add(dovizsatisi);
		dovizsatisi.setDoviz(this);

		return dovizsatisi;
	}

	public Dovizsatisi removeDovizsatisi(Dovizsatisi dovizsatisi) {
		getDovizsatisis().remove(dovizsatisi);
		dovizsatisi.setDoviz(null);

		return dovizsatisi;
	}

}