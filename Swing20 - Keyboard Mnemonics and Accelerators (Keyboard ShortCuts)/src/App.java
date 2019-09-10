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

// Video Start Time 3hr:00:14 3hr:10:31

/*
 * BLUF: You can set up Mnemonics and Key Accelerators for accessibility
 * reasons. See MainFrame.java to see both and FormPanel.java. "Mnemonics" are
 * when file menus or GUI items underline a letter so you can Alt-F to open the
 * File menu (where the F here would be underlined when you press the Alt key.
 * For some reason, this doesn't work in MacOS. Key Accelerators are basically
 * keyboard short cuts where you can Ctrl-X to quit. Keyboard Accelerators do
 * work in MacOS and java will automatically put the keyboard shortcut into the
 * menu item.
 * 
 * DESIGN GUIDE FOR MAC-OS: Our program puts the menu bar into the app window,
 * but that breaks apple's design guide which the menu bar is at the top of the
 * screen
 * 
 * 
 */
