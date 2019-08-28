 import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() { 

			public void run() {

				new MainFrame();

			}

		});

	}

}


// Video Start Time 40:09 to 50:46