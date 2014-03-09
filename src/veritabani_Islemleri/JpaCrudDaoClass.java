package veritabani_Islemleri;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;











import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import model.Musteri;
import model.Satiselemani;
import model.Urun;
import model.Urunalissatisi;



	public class JpaCrudDaoClass {
	private EntityManager em = 
			
			JpaUtilClass.getEntityManager("KuyumcuSon");

//---------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------	
	public void Ekle (Object c)throws Exception {
       
	EntityTransaction tx = em.getTransaction();
	
	tx.begin();
	
	em.persist(c);
	
	tx.commit();
	
	}
	//---------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------	
	public void guncelle (Object c)throws Exception{
 		
 		EntityTransaction tx = em.getTransaction();
 		tx.begin();
 		em.merge(c);
 		tx.commit();
 		
 		
 	}
//---------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------	
 	public void sil (Object c)throws Exception{
 		
 		EntityTransaction tx = em.getTransaction();
 		tx.begin();
 		c = em.merge(c);
 		em.remove(c);
 		tx.commit();
 		
 	}
 	//---------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------	
 	public List<Satiselemani> UserEpostaSifreGetir (){
 		
		String queryString ="SELECT k FROM Satiselemani k";
		
		javax.persistence.Query query = em.createQuery(queryString);		
	
		return query.getResultList();
				
}
 //---------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------	
 	//veritabanýndaki tüm müsteri bilgisini getir
 	 public List<Musteri> TumMusteriBilgisiGetir() throws Exception {
        
 		 Query query =em.createQuery("SELECT m from Musteri as m");
         
         return query.getResultList();
     }
	//---------------------------------------------------------------------------
 	//-----------------------------------------------------------------------------------------------------	
 	 // Telefon numarasi parametre olarak girilen musterinin bilgilerini getir
 	 public Musteri TelefonGoreMusteriAdiGetir(double musteriTelefon) {
 	    
 		 TypedQuery<Musteri> query = em.createQuery(
 	      
 				 "SELECT c FROM Musteri c WHERE c.musteriTelefon = :musteriTelefon", Musteri.class);
 		 
 	    return query.setParameter("musteriTelefon", musteriTelefon).getSingleResult();
 	  } 
 	 
 	//--------------------------------------------------------------------------------------------------
 	//-----------------------------------------------------------------------------------------------------	
	// Adý ve Soyadý parametre olarak girilen musterinin bilgilerini getir 
 	 public Musteri AdSoyadaGoreMusteriidGetir(String musteriAdi,String musteriSoyadi) {
	 	    
 		  Musteri bilgiler = null;
 		 TypedQuery<Musteri> query = em.createQuery(	      
 			 	
 			 	"SELECT c FROM Musteri c "
 			 	+ "WHERE c.musteriAdi = :musteriAdi AND c.musteriSoyadi = :musteriSoyadi", Musteri.class);
 		 
 	     query.setParameter("musteriAdi", musteriAdi);
 	     query.setParameter("musteriSoyadi", musteriSoyadi);
 	    
 	    try{
	    	  bilgiler =query.getSingleResult();

	    	  } catch (NoResultException nre){
	    		 return null;
		 //Ignore this because as per your logic this is ok!
		 }

		return bilgiler;
 	 	  
 	 } 
 	 
 	//-----------------------------------------------------------------------------------------------------	
 	//-----------------------------------------------------------------------------------------------------	
	//Tc Kimlik numarasý ve sifresi girilen musterinin bilgilerini getir
	public Satiselemani TcSifreyeGoreSatisElemaniAdiGetir1(String satisElemaniTcno,String satisElemaniSifre) {
  	    
 		 TypedQuery<Satiselemani> query = em.createQuery(
 	
 	"SELECT c FROM Satiselemani c "
 	+ "WHERE c.satisElemaniTcno = :satisElemaniTcno AND c.satisElemaniSifre = :satisElemaniSifre",
 	Satiselemani.class);
 		 
 		 Satiselemani bilgiler = null;
 		 
 	    query.setParameter("satisElemaniTcno", satisElemaniTcno);
 	    query.setParameter("satisElemaniSifre", satisElemaniSifre);
 	   
 	    try{
 	    	  bilgiler =query.getSingleResult();

 	    	  } catch (NoResultException nre){
 	    		 return null;
 		 //Ignore this because as per your logic this is ok!
 		 }
 
		return bilgiler;
		
 	  
	}
	
	//---------------------------------------------------------------------------------------------------------
	
	//Girilen baslangýc ve bitis tarih aralýgýndaki urun alis satis bilgilerini getir
	
	public Urunalissatisi TarihAralýgýnaGoreSatisBilgisiGetir(java.util.Date urunSatisTarihi) {
  	    
		 TypedQuery<Urunalissatisi> query = em.createQuery(
		 "SELECT ust FROM Urunalissatisi ust WHERE ust.id.UrunSatisTarihi =:urunSatisTarihi"
		 ,Urunalissatisi.class);
		 
		/* as ur join urunalissatisi ust 
		 on ust.Urun_idUrun = ur.idUrun and ust.UrunSatisTarihi >= '2014-03-23 22:33:22' 
		 and  ust.UrunSatisTarihi <= '2016-03-23 22:33:22';*/
		 
		 
		/* select ust.UrunSatisFiyati from urunalissatisi as ust
		 where ust.UrunSatisTarihi >= '2014-03-23 22:33:22' 
		 and  ust.UrunSatisTarihi <= '2016-03-23 22:33:22' ;*/
		 
		 Urunalissatisi bilgiler = null;
		 
	    query.setParameter("urunSatisTarihi", urunSatisTarihi);
	 
	   
	    try{
	    	  bilgiler =query.getSingleResult();

	    	  } catch (NoResultException nre){
	    		 return null;
		 //Ignore this because as per your logic this is ok!
		 }

		return bilgiler;
		
	  
	}
	public Date Listele(){		
		
 		Query query = em.createQuery(
 				"SELECT t.tarih FROM Tarih t WHERE t.tarihid=1");
 		
 		java.util.Date zaman = (java.util.Date) query.getSingleResult();
 		java.sql.Date tarih = new java.sql.Date(zaman.getTime());
 					
 		 
 		return  tarih;
 	}
	
	
	
	
   
}
