package speedrun;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class SpeedrunSwing {

	private JFrame frmRandom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpeedrunSwing window = new SpeedrunSwing();
					window.frmRandom.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SpeedrunSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Random r = new Random();
		frmRandom = new JFrame();
		frmRandom.setTitle("Random");
		frmRandom.setBounds(100, 100, 450, 300);
		frmRandom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnClicc = new JButton("CLICC");
		btnClicc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicc.setText(String.valueOf(r.nextDouble()));
			}
		});
		frmRandom.getContentPane().setLayout(new MigLayout("", "[434px]", "[261px]"));
		frmRandom.getContentPane().add(btnClicc, "cell 0 0,alignx center");
	}

}
