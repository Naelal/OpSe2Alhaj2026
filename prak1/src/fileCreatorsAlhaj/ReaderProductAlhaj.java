package fileCreatorsAlhaj;

import java.io.IOException;

public abstract class ReaderProductAlhaj {

	
	public abstract String [] leseAusDatei() throws IOException; 
	public abstract void schliesseDatei() throws IOException; 
}
