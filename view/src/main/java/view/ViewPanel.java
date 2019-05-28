package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import entity.IElement;
import entity.Map;

class ViewPanel extends JPanel implements Observer {

	private ViewFrame viewFrame;
	private static final long serialVersionUID = -998294702363713521L;
	Map map;

	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	@Override
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		// graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		graphics.drawString(this.getViewFrame().getModel().getHelloWorld().getMessage(), 10, 20);

		if (map != null) {
			for (int y = 0; y < map.getHeight(); y++) {
				for (int x = 0; x < map.getWidth(); x++) {
					IElement element = map.getOnTheMapXY(x, y);
					graphics.drawString(element.getClass().getSimpleName(), 10 + 50 * x, 100);

				}
			}

		}

	}

	public void afficheCarte(Map map) {
		this.map = map;
		this.repaint();
	}
}
