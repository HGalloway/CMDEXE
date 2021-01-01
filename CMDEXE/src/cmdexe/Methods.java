package cmdexe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods{
	public class FilesAndFolders{
		public void createFolder(String FolderName, String PathName) {
			String Path = PathName + "\\" + FolderName;
			File Folder = new File(Path);
			Folder.mkdir();
		}
		
		public void setHiddenAttrib(File file) throws IOException {
			Runtime.getRuntime().exec("amittrib +H " + file.getPath());
		}
		
		public ArrayList<String> LineText = new ArrayList<String>();
		
		public void ReadInFile(String Path, String FileName) throws FileNotFoundException { 
			LineText.clear();
			
			File Filename = new File(Path + "\\" + FileName);
			Scanner ReadFileScanner = new Scanner(Filename);
					
			while(ReadFileScanner.hasNextLine()) {
				LineText.add(ReadFileScanner.nextLine());
			}
			
			ReadFileScanner.close();
		}
		
		public String TakeFileValue(int ValueInFileArray) {
			String OriginalText = LineText.get(ValueInFileArray);
			Pattern SignPattern = Pattern.compile("\"([^\"]*)\"");
			Matcher Matcher = SignPattern.matcher(OriginalText);
			Matcher.find();
			String Value = Matcher.group(1);
			
			return Value;
		}
		
		public void WriteToFile(String Path, String FileName, String ThingToWrite) throws IOException {
			File Filename = new File(Path + "\\" + FileName);
			var FileWriter = new FileWriter(Filename, true);
			FileWriter.write("\n" + ThingToWrite);
			FileWriter.close();
		}
	}
}
