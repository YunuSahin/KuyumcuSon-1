package veritabani_Islemleri;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtilClass {
private static EntityManager em ;
	
	private static EntityManagerFactory emf;
	
	public static EntityManager getEntityManager(String persistUnit){
		
		if(em == null){
			
			emf = Persistence.createEntityManagerFactory(persistUnit);
			
				em = emf.createEntityManager();
		}
		
		return em;
	}

}
