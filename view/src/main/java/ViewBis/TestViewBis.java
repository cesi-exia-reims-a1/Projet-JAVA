package ViewBis;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class TestViewBis {

	public static void main(String[] args) {
		JFrame fenetre = new JFrame();
		fenetre.setSize(1020, 1050);
		view compo = new view();
		compo.setSize(100, 100);
		fenetre.add(compo);
		fenetre.setResizable(false);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_D) {
					compo.moveRight();
					compo.moveRock();
					if (compo.monsterHere()) {
						compo.moveMonster();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_Q) {
					compo.moveLeft();
					compo.moveRock();
					if (compo.monsterHere()) {
						compo.moveMonster();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_Z) {
					compo.moveUp();
					compo.moveRock();
					if (compo.monsterHere()) {
						compo.moveMonster();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					compo.moveDown();
					compo.moveRock();
					if (compo.monsterHere()) {
						compo.moveMonster();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_D) {
					compo.moveRight();
					compo.moveRock();
					if (compo.monsterHere()) {
						compo.moveMonster();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_Q) {
					compo.moveLeft();
					compo.moveRock();
					if (compo.monsterHere()) {
						compo.moveMonster();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_Z) {
					compo.moveUp();
					compo.moveRock();
					if (compo.monsterHere()) {
						compo.moveMonster();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					compo.moveDown();
					compo.moveRock();
					if (compo.monsterHere()) {
						compo.moveMonster();
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				/*
				 * if(e.getKeyCode() == KeyEvent.VK_D) { compo.moveRight(); } if(e.getKeyCode()
				 * == KeyEvent.VK_Q) { compo.moveLeft(); } if(e.getKeyCode() == KeyEvent.VK_Z) {
				 * compo.moveUp(); } if(e.getKeyCode() == KeyEvent.VK_S) { compo.moveDown(); }
				 */

			}
		});
		fenetre.setVisible(true);
	}

}