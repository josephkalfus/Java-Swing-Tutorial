import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello World");
		
		// Good method for multiple threads, but who knows?
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				frame.setSize(600, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

			}

		});

	}

}
