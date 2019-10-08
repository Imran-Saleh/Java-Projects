import javax.swing.JFrame;

public class sFrame {

	public static void main(String[] args) {
		
		JFrame j1 = new JFrame();
		
		j1.setTitle("Snake");
		j1.setSize(800, 600);
		j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j1.setLocationRelativeTo(null);
		j1.add(new snakeComp());
		
		j1.setVisible(true);
		
		
		

	}

}
