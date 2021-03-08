#Find if java is installed and if so run the installer if not then install such
import os
import subprocess

JavaVersionOutput = subprocess.check_output(['java', '--version'], stderr=subprocess.STDOUT)
JavaVersionOutput.decode("utf-8") 
print(JavaVersionOutput)

JavaInstalled = JavaVersionOutput.find('SE Runtime Environment'.encode())
print(JavaInstalled)

if JavaInstalled == -1:
    print("Java Not Installed")
    CurrentWorkingDirectory = os.getcwd()
    os.system(CurrentWorkingDirectory + "\jre-8u281-windows-x64.exe")
    
else:
    print("Java Installed")
    os.system('java')