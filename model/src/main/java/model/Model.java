package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.Ground;
import entity.HelloWorld;
import entity.IElement;
import entity.Map;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private HelloWorld helloWorld;
	Map map;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.helloWorld = new HelloWorld();
		map = new Map();
		IElement[][] onTheMap = new IElement[1][4];
		onTheMap[0][0] = new Ground();
		onTheMap[0][1] = new Ground();
		onTheMap[0][2] = new Ground();
		onTheMap[0][3] = new Ground();
		map.setOnTheMap(onTheMap);
	}

	/**
	 * Gets the hello world.
	 *
	 * @return the hello world
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	@Override
	public HelloWorld getHelloWorld() {
		return this.helloWorld;
	}

	/**
	 * Sets the hello world.
	 *
	 * @param helloWorld the new hello world
	 */
	private void setHelloWorld(final HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Load hello world.
	 *
	 * @param code the code
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	@Override
	public void loadHelloWorld(final String code) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setHelloWorld(daoHelloWorld.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this;
	}

	@Override
	public Map getMap() {
		return map;
	}

}
