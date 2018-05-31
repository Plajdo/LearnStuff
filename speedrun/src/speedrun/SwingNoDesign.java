package speedrun;

import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingNoDesign extends JFrame{
	
	public static void main(String[] args) {
		new SwingNoDesign();
	}
	
	public SwingNoDesign() {
		this.setSize(800, 600);
		this.setTitle("raradsa");
		
		Random r = new Random();
		JButton btn = new JButton("CLICC");
		btn.addActionListener((e) -> {
			btn.setText(String.valueOf(r.nextDouble()));
		});
		
		getContentPane().add(btn);
		
		this.setVisible(true);
		
	}
	
}
