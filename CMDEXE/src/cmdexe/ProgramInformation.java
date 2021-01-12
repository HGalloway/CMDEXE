package cmdexe;

import java.io.FileNotFoundException;
import cmdexe.Methods.FilesAndFolders;

public class ProgramInformation {
	public String StylePath;
	public String ControllerPath;
	public boolean SeenWelcomePage;
	
	Methods Methods = new Methods();
	FilesAndFolders FilesAndFolders = Methods.new FilesAndFolders();
	
	public void GetSystemInformation() throws FileNotFoundException {
		
		FilesAndFolders.ReadInFile(System.getProperty("user.dir") + "\\src\\cmdexe","SystemInformation.info");
		
		//Setting StylePath Variable
		StylePath = FilesAndFolders.TakeFileValue(0);
		
		//Setting ControllerPath Variable
		ControllerPath = FilesAndFolders.TakeFileValue(1);
		
		//Calling the SetWelcomeVariable method to set SeenWelcomePage Variable
		SetWelcomePageVariable();
	}
	
	private void SetWelcomePageVariable() {
		try {
			SeenWelcomePage = Boolean.parseBoolean(FilesAndFolders.TakeFileValue(2));
		}
		catch(IndexOutOfBoundsException e) {
			SeenWelcomePage = false;
		}
	}
}
