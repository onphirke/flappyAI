import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class FlappyFrame extends JFrame {

	public final static int WIDTH = 800, HEIGHT = 830;
	public final static int TIMESPEED = 10;
	public final static int FPS = 60;
	public final static double DELTASPEED = TIMESPEED * 30.0 / FPS;
	public final static int DELTATIME = 1000 / FlappyFrame.FPS;

	FlappyPanel fp;

	public FlappyFrame() {

		fp = new FlappyPanel(this);
		setup();

	}

	private void setup() {

		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		add(fp);

		setVisible(true);
		
		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				for(Bird bird : fp.birds) {
					
					bird.jump();
					
				}
				
			}
			
		});

		new Thread(fp).start();

	}

	public static void main(String[] args) {

		new FlappyFrame();

	}

}
