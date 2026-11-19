package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import fileCreatorsAlhaj.ConcreteCreator;
import fileCreatorsAlhaj.ConcreteCreatortxt;
import fileCreatorsAlhaj.ReaderCreatorAlhaj;
import fileCreatorsAlhaj.ReaderProductAlhaj;

public class GetraenkModel {
	 private Getraenk getraenk;

	 public Getraenk getGetraenk() {
		 return getraenk;
	 }

	 public void setGetraenk(Getraenk getraenk) {
		 this.getraenk = getraenk;
	 }
	 
	 public void leseAusDatei(String typ) throws IOException{
		 ReaderCreatorAlhaj a; 
		 if ("csv".equalsIgnoreCase(typ)) {
			 a = new ConcreteCreator(); 
		 }else {
			 a = new ConcreteCreatortxt(); 
		 }
		 
		 
		 
		 ReaderProductAlhaj b = a.factoryMethod(); 
		 
		 
		 String[] zeile = b.leseAusDatei();
		 this.getraenk = new Getraenk(zeile[0], 
			Float.parseFloat(zeile[1]), 
			Float.parseFloat(zeile[2]), 
			zeile[3], 
			zeile[4].split("_"));
			b.schliesseDatei();
			
	 }
	 
	public void schreibeBahnhoefeInCsvDatei()throws IOException {
		 BufferedWriter aus 
		 = new BufferedWriter(new FileWriter("GetraenkeAusgabe.csv", true));
		 aus.write(this.getraenk.gibGetraenkZurueck(';'));
		 aus.close();
	
	 }

}
