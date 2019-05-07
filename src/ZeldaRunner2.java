import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ZeldaRunner2 {
	static Player link = new Player();
	JPanel panel;
	Octorok rok = new Octorok();
	Tektite spider = new Tektite();
	
	public static void main(String[] args) {
		new ZeldaRunner2().start();
	}

	private void start() {
		JFrame frame = new JFrame("Runner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawAll(g);
			}
		};
		panel.setPreferredSize(new Dimension(800,600));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setLocation(150, 0);
		frame.setSize(1137, 622);
		mapKeyStrokesToActions(panel);
		
		
		
	}

	private void mapKeyStrokesToActions(JPanel panel) {
		ActionMap map = panel.getActionMap();
		InputMap inMap = panel.getInputMap();

		inMap.put(KeyStroke.getKeyStroke("pressed UP"), "up");
		map.put("up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hit("up");
			}

			
		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"left");
		panel.getActionMap().put("left",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("left");
			}
		});
		
		panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"right");
		panel.getActionMap().put("right",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("right");
			}
		});
		
		panel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"down");
		panel.getActionMap().put("down",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("down");
			}
		});
		
		panel.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "space");
		panel.getActionMap().put("space", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hit("space");
			}
		});
	}
	public  void hit(String s) {
		link.keyHit(s);
		panel.repaint();
	}
	
	protected void drawAll(Graphics g) {
		link.draw(g);
		rok.draw(g);
		spider.draw(g);
	}

}
