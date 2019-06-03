   package controller;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.Constants;
import contract.IMap;
import controller.Controller;

public class ControllerTest {

	IMap map;
	int[][] cases = map.getCases();

	@Test
	public void appliqueMovement(int x1, int y1, int x2, int y2){
		try {
			cases[y2][x2] = Constants.WALL;
			//map.moveRight();	
		} catch (Exception e) {
			final String expected = "Index 20 out of bounds for length 20";
			assertEquals(expected, e.getMessage());
		}
	}



}
