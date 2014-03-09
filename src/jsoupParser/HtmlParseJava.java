package jsoupParser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParseJava {
	
	public String[][] kuyumcuVeriCek (){
	
		Document doc;
	
	 String[][] trtd= null ;
	
	try{
			doc= Jsoup.connect("http://www.malatyakuyumcular.com").get();
			
			Elements tables = doc.select("body table  ");
			
			for(Element table : tables){
				
				//System.out.println(table.text());				
				Elements trs =  table.select("tbody");
				
				 trtd = new String[trs.size()][];				
			    
				for (int i = 0; i < trs.size(); i++) {
					
			        Elements tds = trs.get(i).select("strong");
			        
			        trtd[i] = new String[tds.size()];
			       
			        for (int j = 0; j < tds.size(); j++) {
			        	
			            trtd[i][j] = tds.get(j).text(); 
			            
			            //System.out.println("i: "+ i +" j: " +j);		            
			      	
			        }
			        		        
			    }
				  // trtd now contains the desired array for this table tbody tr td  strong
	
	}} catch(IOException e){	
		
	}	
	return trtd;
	

	
}
	
}
