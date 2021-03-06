package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

import javax.swing.JFrame;
import org.jnativehook.GlobalScreen;

public class Window extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	private static final String defaultImgPath = "\\img\\defaultIcon.png";

	public Window() {
		setTitle("Macro Recorder");
		setSize(385, 425);
		setResizable(false);
		setUndecorated(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);		
		resetIcon();		
		addWindowListener(this);
	}
	
	public void resetIcon() {
		ImageIcon img = new ImageIcon(System.getProperty("user.dir") + defaultImgPath);
		setIconImage(img.getImage());		
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		if (GlobalScreen.isNativeHookRegistered()) {
			GlobalScreen.unregisterNativeHook();
		}
        System.runFinalization();
        System.exit(0);
	}

	@Override
	public void windowClosing(WindowEvent arg0) {	
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {    
	}
}
