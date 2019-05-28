package contract;

import java.util.Observable;

import entity.HelloWorld;

public interface IModel {

	HelloWorld getHelloWorld();

	void loadHelloWorld(String code);

	Observable getObservable();
}
