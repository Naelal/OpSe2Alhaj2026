package fileCreatorsAlhaj;

import java.io.IOException;

public class ConcreteCreator  extends ReaderCreatorAlhaj{

	@Override
	public ReaderProductAlhaj factoryMethod() throws IOException {
		
		return new ConcreteProduct();
	}

}
