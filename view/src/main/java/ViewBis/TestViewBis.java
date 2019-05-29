package ViewBis;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class TestViewBis {

    public static void main(String[] args) {
        JFrame fenetre = new JFrame();
        fenetre.setSize(1000, 1000);
        view compo = new view();
        compo.setSize(100, 100);
        fenetre.add(compo);

        fenetre.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            	if(e.getKeyCode() == KeyEvent.VK_D) {
					compo.moveRight();
				}
				if(e.getKeyCode() == KeyEvent.VK_Q) {
					compo.moveLeft();
				}
				if(e.getKeyCode() == KeyEvent.VK_Z) {
					compo.moveUp();
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					compo.moveDown();
				}
            }

            @Override
            public void keyReleased(KeyEvent e) {
            	if(e.getKeyCode() == KeyEvent.VK_D) {
					compo.moveRight();
				}
				if(e.getKeyCode() == KeyEvent.VK_Q) {
					compo.moveLeft();
				}
				if(e.getKeyCode() == KeyEvent.VK_Z) {
					compo.moveUp();
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					compo.moveDown();
				}
            }

            @Override
            public void keyPressed(KeyEvent e) {
            	/*if(e.getKeyCode() == KeyEvent.VK_D) {
					compo.moveRight();
				}
				if(e.getKeyCode() == KeyEvent.VK_Q) {
					compo.moveLeft();
				}
				if(e.getKeyCode() == KeyEvent.VK_Z) {
					compo.moveUp();
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					compo.moveDown();
				}*/

            }
        });

        fenetre.setVisible(true);
    }

}