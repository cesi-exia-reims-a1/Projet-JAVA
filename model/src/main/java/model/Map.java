package model;

import contract.IMap;

//This is the implement of our map
public class Map implements IMap {
	int[][] cases = new int[20][20];

	@Override
	public void setCases(int[][] cases) {
		this.cases = cases;
	}

	@Override
	public int[][] getCases() {
		return cases;
	}

}
