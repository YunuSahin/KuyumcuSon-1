package jsoupParser;

public class testparser {

	public static void main(String[] args) {
	HtmlSatisFiyatParseJava s = new HtmlSatisFiyatParseJava();
	String [][] gelenveri = s.kuyumcuVeriCek();
	System.out.println(gelenveri[1][0]);
	

	}

}
