package breakout;

import javax.swing.JFrame;

public class bFrame {

	public static void main(String[] args) {
	
		JFrame j1 = new JFrame();
		j1.setTitle("Breakout 2.0! RIP MY ORIGINAL ONE");
		j1.setSize(1100,600);
		j1.setLocationRelativeTo(null);
		j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j1.add(new breakoutComp());

		j1.setVisible(true);
		

	}

}
