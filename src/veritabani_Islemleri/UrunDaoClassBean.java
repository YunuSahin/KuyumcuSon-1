package veritabani_Islemleri;

import model.Musteri;
import model.Urun;

import org.eclipse.persistence.exceptions.DatabaseException;

public class UrunDaoClassBean {

	public int idUrun;

	public double urunAdeti;

	public String urunAdi;

	public double urunAgirligi;

	public double uruniscilikFiyati;

	public double urunKurFiyati;
	
	Urun Products = new Urun();
	
	  JpaCrudDaoClass urunDao = new JpaCrudDaoClass();

	public int getIdUrun() {
		return idUrun;
	}

	public void setIdUrun(int idUrun) {
		this.idUrun = idUrun;
	}

	public double getUrunAdeti() {
		return urunAdeti;
	}

	public void setUrunAdeti(double urunAdeti) {
		this.urunAdeti = urunAdeti;
	}

	public String getUrunAdi() {
		return urunAdi;
	}

	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

	public double getUrunAgirligi() {
		return urunAgirligi;
	}

	public void setUrunAgirligi(double urunAgirligi) {
		this.urunAgirligi = urunAgirligi;
	}

	public double getUruniscilikFiyati() {
		return uruniscilikFiyati;
	}

	public void setUruniscilikFiyati(double uruniscilikFiyati) {
		this.uruniscilikFiyati = uruniscilikFiyati;
	}

	public double getUrunKurFiyati() {
		return urunKurFiyati;
	}

	public void setUrunKurFiyati(double urunKurFiyati) {
		this.urunKurFiyati = urunKurFiyati;
	}
	
	public void instertUrun() throws Exception{
		

		try {
			
			Products.setIdUrun(idUrun);
			Products.setUrunAdeti(urunAdeti);
			Products.setUrunAdi(urunAdi);
			Products.setUrunAgirligi(urunAgirligi);
			Products.setUruniscilikFiyati(uruniscilikFiyati);
			Products.setUrunKurFiyati(urunKurFiyati);
			urunDao.Ekle(Products);
			
	
			
			
			
		} catch (DatabaseException e ) {
			// TODO: handle exception
		}

	}
	public void UpdateDaoUrun() throws Exception{
		

		try {
			
			Products.setIdUrun(idUrun);
			Products.setUrunAdeti(urunAdeti);
			Products.setUrunAdi(urunAdi);
			Products.setUrunAgirligi(urunAgirligi);
			Products.setUruniscilikFiyati(uruniscilikFiyati);
			Products.setUrunKurFiyati(urunKurFiyati);
			
			urunDao.guncelle(Products);
		
			
		} catch (DatabaseException e ) {
			// TODO: handle exception
		}
		
		
}
}
