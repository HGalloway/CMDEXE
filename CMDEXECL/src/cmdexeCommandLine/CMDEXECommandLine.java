package cmdexeCommandLine;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

//Command Imports
import cmdexeCommandLine.CopyEncryptionKey;

public class CMDEXECommandLine extends Application {
	CopyEncryptionKey CEK = new CopyEncryptionKey();
	public Scanner Scanner = new Scanner(System.in);
	private boolean Quit = false;
	public String[] CommandSplitArray;
	private List<String> CommandSplit; 
	
	@Override
	public void start(Stage prime) throws IOException {
		StartingMessage();
		CommandLine();
	}
	
	private void StartingMessage() {
		System.out.println("Welcome to the CMDEXE Command Line.");
		System.out.println("If you need a list of commands type help.");
	}
	
	private void CommandLine(){
		while (Quit != true) {
			System.out.print(">");
			String[] CommandSplitArray = Scanner.nextLine().split(" ");
			for (int i = 0; i < CommandSplitArray.length; i++) {
				CommandSplitArray[i] = CommandSplitArray[i].trim();
			}
			CommandSplit = Arrays.asList(CommandSplitArray);
			System.out.println(CommandSplit);
			if (CommandSplit.contains("Quit") || CommandSplit.contains("quit")) {
				GoodbyeMessage();
				Quit = true;
				Platform.exit();
			}			
			//CopyEncryptionKey
			if (CommandSplit.contains("CopyEncryptionKey")) {
				if (CommandSplit.contains("-Yeet")) {
					CEK.YeetFlag();
				}
				if (CommandSplit.contains("-U")) {
					CEK.Username(GetFlagInformation("-U"));
				}
				else if (CommandSplit.contains("-P")){
					CEK.Password(false, GetFlagInformation("-P"));
				}
				else if (CommandSplit.contains("-H")) {
					CEK.Host(GetFlagInformation("-H"));
					
				}
				CEK.Password(true, null);
				CEK.CopyEncryptionKey();

			}
			if (CommandSplit.contains("Clear") || CommandSplit.contains("clear")) {
				System.out.println("Console Cleared");
			}
		}
	}
	
	private String GetFlagInformation(String Flag){
		int FlagPosition = CommandSplit.indexOf(Flag);
		FlagPosition++;
		String FlagValue = CommandSplit.get(FlagPosition);
		if (FlagValue.contains("-")) {
			System.out.println("No value");
			return null;
		}
		return FlagValue;
		
	}
	
	private void GoodbyeMessage() {
		System.out.println("Goodbye");
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
