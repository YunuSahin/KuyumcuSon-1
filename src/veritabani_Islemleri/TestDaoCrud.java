package veritabani_Islemleri;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

import model.Doviz;
import model.Musteri;
import model.Satiselemani;
import model.Urun;
import model.Urunalissatisi;

public class TestDaoCrud {

	public static void main(String[] args) throws Exception {
		
		//BorcluUyeEkleTest();
		//UyeBilgisiGuncelle();
		//musteriBilgisiGetir() ;
		//TcyeGoreMusteriBilgisiGetir();
		//TcSifreyGoreMusteriBilgisiGetir() ;
		//DovizBilgisiGir();
		//UrunSat();
		//musteriAdSoyadaGoreIdGetir();
		TarihlerArasýSatilanUrunBilgisiGetir();
	}
	
public static void BorcluUyeEkleTest() throws Exception{
	 
	 MusteriDaoClassBean musteriKayit = new MusteriDaoClassBean();
	    
	    musteriKayit.setIdMusteri(1);
	    musteriKayit.setMusteriAdi("sinan");
	    musteriKayit.setMusteriEmail("kogce@gmail");
	   
	    musteriKayit.setMusteriSoyadi("kogce");
	   musteriKayit.setMusteriReferans("yunus");
      
	   musteriKayit.setMusterininBorcu(120);
	   musteriKayit.setMusteriTelefon(05056302323);
	   
	   String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
		@SuppressWarnings("deprecation")
		java.sql.Date  musteriKayitTarihi = new java.sql.Date(Date.parse(timeStamp));
musteriKayit.setMusteriKayitTarihi(musteriKayitTarihi);

     musteriKayit.insertDaoBorcluCustomer();
}
	public static void UyeBilgisiGuncelle() throws Exception{
		 MusteriDaoClassBean musteriKayit = new MusteriDaoClassBean();
		 
		    musteriKayit.setIdMusteri(1);
		    musteriKayit.setMusteriAdi("sinan");
		    musteriKayit.setMusteriEmail("kogce@gmail");		   
		    musteriKayit.setMusteriSoyadi("kogce");
		   musteriKayit.setMusteriReferans("yunus");          
		   musteriKayit.setMusterininBorcu(130);
		   musteriKayit.setMusteriTelefon(05056302323);		   
		   String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
			@SuppressWarnings("deprecation")
			java.sql.Date  musteriKayitTarihi = new java.sql.Date(Date.parse(timeStamp));
	 musteriKayit.setMusteriKayitTarihi(musteriKayitTarihi);
	 
	      musteriKayit.UpdateDaoCustomer();
	}
	
	
	public static void musteriBilgisiGetir() throws Exception{
		JpaCrudDaoClass MusteriBilgisiAl = new JpaCrudDaoClass();
		
		List <Musteri> bilgileriListele ;
		bilgileriListele = MusteriBilgisiAl.TumMusteriBilgisiGetir();
	
		for(int i=0;i<bilgileriListele.size();i++){
		    System.out.println("adi : " + bilgileriListele.get(i).getMusteriAdi());
		    System.out.println("soyadi : "+bilgileriListele.get(i).getMusteriSoyadi());
		    System.out.println("borcu : "+ bilgileriListele.get(i).getMusterininBorcu()+" TL");
		    
		}
	
		 
	}
	
	public static void TcyeGoreMusteriBilgisiGetir() throws Exception{
		JpaCrudDaoClass TcyeGoreIsimBilgisiAl = new JpaCrudDaoClass();
		
		Musteri isimDegiskeni ;
		
		isimDegiskeni = TcyeGoreIsimBilgisiAl.TelefonGoreMusteriAdiGetir(05056302323);
		
		 System.out.println("Telefonu girilen musterinin adi : " + isimDegiskeni.getMusteriAdi());

	}
	
	public static void TcSifreyGoreMusteriBilgisiGetir() throws Exception{
		JpaCrudDaoClass TcSifreyeGorekisiBilgisiAl = new JpaCrudDaoClass();
		
		Satiselemani isimDegiskeni ;
		
		isimDegiskeni = TcSifreyeGorekisiBilgisiAl.TcSifreyeGoreSatisElemaniAdiGetir1("123456","12345");
		
		if (isimDegiskeni == null){
			 System.out.println("null");
		
		}else {
			int personelinid = isimDegiskeni.getIdSatisElemani();
			String personeladi = isimDegiskeni.getSatisElemaniAdi();
			String personelsoyadi = isimDegiskeni.getSatisElemaniSoyadi();
			
			System.out.println("id: "+ personelinid);
			System.out.println("adi: "+personeladi);
			System.out.println("soyadi: " + personelsoyadi);
		}
		 
	}
		public static void  DovizBilgisiGir() throws Exception{
			JpaCrudDaoClass DbDovizEkle = new JpaCrudDaoClass();
			
			Doviz yeniDovizTL = new Doviz();
			Doviz yeniDovizEuro = new Doviz();
			Doviz yeniDovizDolar = new Doviz();
			yeniDovizEuro.setDovizAdi("Euro");
			yeniDovizDolar.setDovizAdi("Dolar");
			yeniDovizTL.setDovizAdi("TL");
			
			DbDovizEkle.Ekle(yeniDovizEuro);
			DbDovizEkle.Ekle(yeniDovizDolar);
			
	}
		public static void DovizSatisYap(){
			
			int satisElemani_idSatisElemani;
			String doviz_DovizAdi;
			int musteri_idMusteri;
			java.util.Date dovizSatisTarihi;
			
			JpaCrudDaoClass satisYap = new JpaCrudDaoClass();
		

		}
		public static void musteriAdSoyadaGoreIdGetir() throws Exception{
			JpaCrudDaoClass TcSifreyeGorekisiBilgisiAl = new JpaCrudDaoClass();
			
			model.Musteri isimDegiskeni ;
			
			isimDegiskeni = TcSifreyeGorekisiBilgisiAl.AdSoyadaGoreMusteriidGetir("yunus","sahin");
			
			System.out.print("id: " + isimDegiskeni.getIdMusteri());
		}
		
	public static void UrunSat (){
		
		UrunSatisDaoClassBean urunsat = new UrunSatisDaoClassBean();
		
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
		@SuppressWarnings("deprecation")
		java.sql.Date  urunsatisKayitTarihi = new java.sql.Date(Date.parse(timeStamp));
		
	 
        urunsat.setUrunAlisFiyati(1000);
        urunsat.setUrunSatisTarihi(urunsatisKayitTarihi);
        urunsat.setUrunSatisFiyati(1000);
        
        urunsat.urunSatDao();
	}
	
	public static void TarihlerArasýSatilanUrunBilgisiGetir(){
		JpaCrudDaoClass tarihegoreurunbilgisigetir = new JpaCrudDaoClass();
		
	
		java.util.Date date = new java.util.Date(2014, 3, 8);
	      
	      
	      Urunalissatisi ur =tarihegoreurunbilgisigetir.TarihAralýgýnaGoreSatisBilgisiGetir(date);
	       
		
	      ur.getId();
	}
	
	
	}
	
