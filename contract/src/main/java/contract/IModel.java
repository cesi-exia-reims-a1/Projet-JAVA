package contract;

import java.util.Observable;

import entity.HelloWorld;
import entity.Map;

public interface IModel {

	HelloWorld getHelloWorld();

	void loadHelloWorld(String code);

	Observable getObservable();

	Map getMap();

}
