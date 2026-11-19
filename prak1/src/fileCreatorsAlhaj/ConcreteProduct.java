package fileCreatorsAlhaj;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class ConcreteProduct extends ReaderProductAlhaj {

	
	private BufferedReader ein; 
	
	public ConcreteProduct() throws IOException {
		super();
		this.ein =new BufferedReader(new FileReader("Getraenk.csv")); 
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		 
		 String[] zeile = ein.readLine().split(";");
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
		
	}

	
}
