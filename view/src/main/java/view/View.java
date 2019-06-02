package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import contract.IController;
import contract.IView;

public final class View extends JFrame implements IView {
	IController controller;
	private Showboard showboard;

	public View() {
		setSize(1020, 1050);
		showboard = new Showboard();
		showboard.setSize(100, 100);
		add(showboard);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_D) {
					controller.moveRight();
				}
				if (e.getKeyCode() == KeyEvent.VK_Q) {
					controller.moveLeft();
				}
				if (e.getKeyCode() == KeyEvent.VK_Z) {
					controller.moveUp();
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					controller.moveDown();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}

	public void setController(IController controller) {
		this.controller = controller;
		showboard.setController(controller);
	}

	@Override
	public void redraw() {
		repaint();
	}

}
