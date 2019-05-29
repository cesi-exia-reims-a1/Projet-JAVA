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
                compo.touche();
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }
        });

        fenetre.setVisible(true);
    }

}