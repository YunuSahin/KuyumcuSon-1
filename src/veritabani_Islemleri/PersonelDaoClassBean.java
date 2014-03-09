package veritabani_Islemleri;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.exceptions.DatabaseException;




import model.Satiselemani;

   
public class PersonelDaoClassBean {
	
	public int id;
	
	public String satisElemaniAdi;
	
	public String satisElemaniAdres;
	
	public String satisElemaniCinsiyet;
	
	public String satisElemaniSifre;
	
	public String satisElemaniSoyadi;
	
	public String satisElemaniTcno;
	
	public double satisElemaniTelefon;
	
	public String satisElemaniSubeAdi;
	
	Satiselemani yeniSatisElemani = new Satiselemani();
	
	 JpaCrudDaoClass personelIslemleri = new JpaCrudDaoClass();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSatisElemaniAdi() {
		return satisElemaniAdi;
	}
	public void setSatisElemaniAdi(String satisElemaniAdi) {
		this.satisElemaniAdi = satisElemaniAdi;
	}
	public String getSatisElemaniAdres() {
		return satisElemaniAdres;
	}
	public void setSatisElemaniAdres(String satisElemaniAdres) {
		this.satisElemaniAdres = satisElemaniAdres;
	}
	public String getSatisElemaniCinsiyet() {
		return satisElemaniCinsiyet;
	}
	public void setSatisElemaniCinsiyet(String satisElemaniCinsiyet) {
		this.satisElemaniCinsiyet = satisElemaniCinsiyet;
	}
	public String getSatisElemaniSifre() {
		return satisElemaniSifre;
	}
	public void setSatisElemaniSifre(String satisElemaniSifre) {
		this.satisElemaniSifre = satisElemaniSifre;
	}
	public String getSatisElemaniSoyadi() {
		return satisElemaniSoyadi;
	}
	public void setSatisElemaniSoyadi(String satisElemaniSoyadi) {
		this.satisElemaniSoyadi = satisElemaniSoyadi;
	}
	public String getSatisElemaniTcno() {
		return satisElemaniTcno;
	}
	public void setSatisElemaniTcno(String satisElemaniTcno) {
		this.satisElemaniTcno = satisElemaniTcno;
	}
	public double getSatisElemaniTelefon() {
		return satisElemaniTelefon;
	}
	public void setSatisElemaniTelefon(double satisElemaniTelefon) {
		this.satisElemaniTelefon = satisElemaniTelefon;
	}
	
	
	public String getSatisElemaniSubeAdi() {
		return satisElemaniSubeAdi;
	}
	public void setSatisElemaniSubeAdi(String satisElemaniSubeAdi) {
		this.satisElemaniSubeAdi = satisElemaniSubeAdi;
	}
	
	
	public void instertDaoPersonel() throws Exception{
			try {
	
				
		yeniSatisElemani.setSatisElemaniAdi(satisElemaniAdi);
		yeniSatisElemani.setSatisElemaniAdres(satisElemaniAdres);
		
		yeniSatisElemani.setSatisElemaniCinsiyet(satisElemaniCinsiyet);
		yeniSatisElemani.setSatisElemaniTelefon(satisElemaniTelefon);
		
		yeniSatisElemani.setSatisElemaniSifre(satisElemaniSifre);
	 	yeniSatisElemani.setSatisElemaniTcno(satisElemaniTcno);
	   
		yeniSatisElemani.setSatisElemaniSubeAdi(satisElemaniSubeAdi);
		
		yeniSatisElemani.setSatisElemaniSoyadi(satisElemaniSoyadi);
		
		yeniSatisElemani.setIdSatisElemani(id);
		
		personelIslemleri.Ekle(yeniSatisElemani);
		
			
			
		} catch (DatabaseException e ) {
			// TODO: handle exception
		}

	}
			public void UpdateDaoPersonel() throws Exception{
				try {
		
					
			yeniSatisElemani.setSatisElemaniAdi(satisElemaniAdi);
			yeniSatisElemani.setSatisElemaniAdres(satisElemaniAdres);
			
			yeniSatisElemani.setSatisElemaniCinsiyet(satisElemaniCinsiyet);
			yeniSatisElemani.setSatisElemaniTelefon(satisElemaniTelefon);
			
			yeniSatisElemani.setSatisElemaniSifre(satisElemaniSifre);
		 	yeniSatisElemani.setSatisElemaniTcno(satisElemaniTcno);
		   
			yeniSatisElemani.setSatisElemaniSubeAdi(satisElemaniSubeAdi);
			
			
			yeniSatisElemani.setIdSatisElemani(id);
			
			personelIslemleri.guncelle(yeniSatisElemani);
			
				
				
			} catch (DatabaseException e ) {
				// TODO: handle exception
			}
				
			}
			}
