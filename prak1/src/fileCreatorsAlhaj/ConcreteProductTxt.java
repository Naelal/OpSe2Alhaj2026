package fileCreatorsAlhaj;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductTxt extends ReaderProductAlhaj {

	
	private BufferedReader ein; 
	
	
	public ConcreteProductTxt() throws IOException {
		super();
		this.ein = new BufferedReader(new FileReader("Getraenk.txt"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String [] ergebnisZeile = new String [5]; 
		String zeile = ein.readLine(); 
		int i =0; 
		while (i < ergebnisZeile.length) {
			ergebnisZeile[i] = zeile; 
			zeile = ein.readLine(); 
			i++; 
		}
		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();

	}

}
