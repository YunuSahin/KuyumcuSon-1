package veritabani_Islemleri;

import model.Musteri;
import model.Satiselemani;
import model.Urun;
import model.Urunalissatisi;
import model.UrunalissatisiPK;

public class UrunSatisDaoClassBean {
	
	public double urunAlisFiyati;

	public double urunSatisFiyati;
    
	public int satisElemani_idSatisElemani;
	
	public int urun_idUrun;
	
	public int musteri_idMusteri;
	
	public java.util.Date urunSatisTarihi;
	
	JpaCrudDaoClass yeniurunsatisEkle = new JpaCrudDaoClass();
    
	Urunalissatisi urunalissatisbilgisi = new Urunalissatisi();
	UrunalissatisiPK urunalissatisPkbilgisi = new UrunalissatisiPK();
	Musteri musteriIdbilgisi = new Musteri();
	Satiselemani satiselemaniIdbilgisi = new Satiselemani();
	Urun urunIdBilgisi = new Urun();
	
	public int getSatisElemani_idSatisElemani() {
		return satisElemani_idSatisElemani;
	}

	public void setSatisElemani_idSatisElemani(int satisElemani_idSatisElemani) {
		this.satisElemani_idSatisElemani = satisElemani_idSatisElemani;
	}

	public int getUrun_idUrun() {
		return urun_idUrun;
	}

	public void setUrun_idUrun(int urun_idUrun) {
		this.urun_idUrun = urun_idUrun;
	}

	public int getMusteri_idMusteri() {
		return musteri_idMusteri;
	}

	public void setMusteri_idMusteri(int musteri_idMusteri) {
		this.musteri_idMusteri = musteri_idMusteri;
	}

	public java.util.Date getUrunSatisTarihi() {
		return urunSatisTarihi;
	}

	public void setUrunSatisTarihi(java.util.Date urunSatisTarihi) {
		this.urunSatisTarihi = urunSatisTarihi;
	}

	
	public double getUrunAlisFiyati() {
		return urunAlisFiyati;
	}

	public void setUrunAlisFiyati(double urunAlisFiyati) {
		this.urunAlisFiyati = urunAlisFiyati;
	}

	public double getUrunSatisFiyati() {
		return urunSatisFiyati;
	}

	public void setUrunSatisFiyati(double urunSatisFiyati) {
		this.urunSatisFiyati = urunSatisFiyati;
	}

	
	
	public void urunSatDao(){
				try {
			
			urunalissatisPkbilgisi.setUrunSatisTarihi(urunSatisTarihi);
			
			musteriIdbilgisi.setIdMusteri(musteri_idMusteri);
			urunIdBilgisi.setIdUrun(urun_idUrun);
			satiselemaniIdbilgisi.setIdSatisElemani(satisElemani_idSatisElemani);
			
			urunalissatisPkbilgisi.setUrun_idUrun(urunIdBilgisi.getIdUrun());
			urunalissatisPkbilgisi.setSatisElemani_idSatisElemani(satiselemaniIdbilgisi.getIdSatisElemani());
			urunalissatisPkbilgisi.setMusteri_idMusteri(musteriIdbilgisi.getIdMusteri());
			urunalissatisPkbilgisi.setUrunSatisTarihi(urunSatisTarihi);
			
			urunalissatisbilgisi.setUrunAlisFiyati(urunAlisFiyati);
			urunalissatisbilgisi.setUrunSatisFiyati(urunSatisFiyati);
			urunalissatisbilgisi.setMusteri(musteriIdbilgisi);
			urunalissatisbilgisi.setUrun(urunIdBilgisi);
			urunalissatisbilgisi.setSatiselemani(satiselemaniIdbilgisi);
			urunalissatisbilgisi.setId(urunalissatisPkbilgisi);
			
			yeniurunsatisEkle.Ekle(urunalissatisbilgisi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
