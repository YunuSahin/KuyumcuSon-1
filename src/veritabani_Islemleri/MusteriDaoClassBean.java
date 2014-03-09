package veritabani_Islemleri;

import java.util.Date;

import model.Musteri;

import org.eclipse.persistence.exceptions.DatabaseException;


public class MusteriDaoClassBean {
	
			Musteri newCustomer = new Musteri();
			
			JpaCrudDaoClass yenimusteriEkle = new JpaCrudDaoClass();
			
	public int idMusteri;

	public String musteriAdi;

	public String musteriEmail;

	public Date musteriKayitTarihi;
	
	public String musteriReferans;

	public String musteriSoyadi;

	public double musteriTelefon;
	
	public double musterininAlacagi;

	public double musterininBorcu;

	
	public double getMusterininAlacagi() {
		return musterininAlacagi;
	}

	public void setMusterininAlacagi(double musterininAlacagi) {
		this.musterininAlacagi = musterininAlacagi;
	}

	public double getMusterininBorcu() {
		return musterininBorcu;
	}

	public void setMusterininBorcu(double musterininBorcu) {
		this.musterininBorcu = musterininBorcu;
	}

	public int getIdMusteri() {
		return idMusteri;
	}

	public void setIdMusteri(int idMusteri) {
		this.idMusteri = idMusteri;
	}

	public String getMusteriAdi() {
		return musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}

	public String getMusteriEmail() {
		return musteriEmail;
	}

	public void setMusteriEmail(String musteriEmail) {
		this.musteriEmail = musteriEmail;
	}

	public Date getMusteriKayitTarihi() {
		return musteriKayitTarihi;
	}

	public void setMusteriKayitTarihi(Date musteriKayitTarihi) {
		this.musteriKayitTarihi = musteriKayitTarihi;
	}

	public String getMusteriReferans() {
		return musteriReferans;
	}

	public void setMusteriReferans(String musteriReferans) {
		this.musteriReferans = musteriReferans;
	}

	public String getMusteriSoyadi() {
		return musteriSoyadi;
	}

	public void setMusteriSoyadi(String musteriSoyadi) {
		this.musteriSoyadi = musteriSoyadi;
	}

	public double getMusteriTelefon() {
		return musteriTelefon;
	}

	public void setMusteriTelefon(double musteriTelefon) {
		this.musteriTelefon = musteriTelefon;
	}
public void insertDaoAlacakliCustomer() throws Exception{
	

		try {
			
			newCustomer.setIdMusteri(idMusteri);
			newCustomer.setMusteriAdi(musteriAdi);
			newCustomer.setMusteriEmail(musteriEmail);
			newCustomer.setMusteriKayitTarihi(musteriKayitTarihi);
			newCustomer.setMusteriReferans(musteriReferans);
			newCustomer.setMusteriSoyadi(musteriSoyadi);
			newCustomer.setMusteriTelefon(musteriTelefon);
			newCustomer.setMusterininBorcu(0);
			newCustomer.setMusterininAlacagi(musterininAlacagi);
			
			yenimusteriEkle.Ekle(newCustomer);
			
			
			
		} catch (DatabaseException e ) {
			// TODO: handle exception
		}
}
		public void insertDaoBorcluCustomer() throws Exception{
			

			try {
				
				newCustomer.setIdMusteri(idMusteri);
				newCustomer.setMusteriAdi(musteriAdi);
				newCustomer.setMusteriEmail(musteriEmail);
				newCustomer.setMusteriKayitTarihi(musteriKayitTarihi);
				newCustomer.setMusteriReferans(musteriReferans);
				newCustomer.setMusteriSoyadi(musteriSoyadi);
				newCustomer.setMusteriTelefon(musteriTelefon);
				newCustomer.setMusterininBorcu(musterininBorcu);
				newCustomer.setMusterininAlacagi(0);
				
				yenimusteriEkle.Ekle(newCustomer);
				
				
				
			} catch (DatabaseException e ) {
				// TODO: handle exception
			}
		}
			public void UpdateDaoCustomer() throws Exception{
				

				try {
					
					newCustomer.setIdMusteri(idMusteri);
					newCustomer.setMusteriAdi(musteriAdi);
					newCustomer.setMusteriEmail(musteriEmail);
					newCustomer.setMusteriKayitTarihi(musteriKayitTarihi);
					newCustomer.setMusteriReferans(musteriReferans);
					newCustomer.setMusteriSoyadi(musteriSoyadi);
					newCustomer.setMusteriTelefon(musteriTelefon);
					newCustomer.setMusterininBorcu(musterininBorcu);
					newCustomer.setMusterininAlacagi(0);
					
					yenimusteriEkle.guncelle(newCustomer);
					
					
					
				} catch (DatabaseException e ) {
					// TODO: handle exception
			
				}
}

}
