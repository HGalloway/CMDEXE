package cmdexeCommandLine;

import java.io.Console;
import java.util.HashMap;

public class CopyEncryptionKey {
	private HashMap<String, String> Credentials = new HashMap<String, String>();
	public void CopyEncryptionKey() {
		System.out.println(Credentials.get("Username"));
		System.out.println(Credentials.get("Password"));
		System.out.println(Credentials.get("Host"));
		System.out.println("Key Copied");
	}
	
	public void YeetFlag() {
		System.out.println("Yeet");
	}
	
	public void Username(String Username) {
		if (Username == null) {
			System.out.println("Please put in a username for the reciving system");
		}
		Credentials.put("Username", Username);
	}
	
	public void Password(boolean NeedPassword, String Password) {
		if (NeedPassword == true) {
			Console console = System.console();
			char[] PasswordChar = console.readPassword();
			Credentials.put("Password", new String(PasswordChar));
		}
		else {
			Credentials.put("Password", Password);
		}
	}
	
	public void Host(String Host) {
		Credentials.put("Host", Host);
		
	}
}
