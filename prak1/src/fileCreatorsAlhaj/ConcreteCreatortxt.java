package fileCreatorsAlhaj;

import java.io.IOException;

public class ConcreteCreatortxt extends ReaderCreatorAlhaj {

	@Override
	public ReaderProductAlhaj factoryMethod() throws IOException {
		
		return new ConcreteProductTxt();
	}

}
