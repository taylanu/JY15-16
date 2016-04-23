package reference;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class fileChooser {
	public static void chooseFile(){
		System.out.println("Choose a file to read");
	JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(chooser);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
	    }
	}
}
