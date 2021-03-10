#Find if java is installed and if so run the installer if not then install such
import os
import subprocess
import ctypes

CurrentWorkingDirectory = os.getcwd()
InstallerClasspath = CurrentWorkingDirectory + "\\InstallationFiles\\bin\\"
LibraryPath = CurrentWorkingDirectory + "\\Libraries\\\javafx-sdk-11.0.2\\lib\\"
InstallerFile = "CMDEXEInstaller.java"
JREFile = "jre-8u281-windows-x64.exe"
JavaInstallPath = "C:\\\"Program Files\"\\Java"

NORM_FONT= ("Verdana", 10)

JavaVersionOutput = subprocess.check_output(['java', '--version'], stderr=subprocess.STDOUT)
JavaVersionOutput.decode("utf-8")

JavaInstalled = JavaVersionOutput.find('SE Runtime Environment'.encode())

if JavaInstalled == -1:
    JavaInstallPathExist = os.path.isdir(JavaInstallPath)
    print("Java install path exist check")
    if JavaInstallPathExist == False:
        MakeJavaInstallPath = subprocess.Popen(["mkdir", JavaInstallPath], shell=True)
    JavaInstallProcess = subprocess.Popen(["start", "/wait" ,CurrentWorkingDirectory + "\\InstallationFiles\\" + JREFile, "INSTALLCFG=C:\\Users\\hdg11\\OneDrive\\Documents\\CMDEXE\\InstallationFiles\\JREInstallConfig.cfg"], shell=True)
    JavaInstallProcess.wait()
    JavaInstalled = JavaVersionOutput.find('SE Runtime Environment'.encode())
    if JavaInstalled == -1:
        print("Java Installed check 2")
        ctypes.windll.user32.MessageBoxW(0, "Java install failed. Please run installer again and install java.", "Installation Failed.",6)
        quit
    else:
        print("Java no installed launch installer")
        os.chdir(".\\InstallationFiles\\cmdexeinst")
        LaunchingInstaller = subprocess.Popen(["java", "--module-path " + LibraryPath, "--add-modules=javafx.controls,javafx.fxml", "-classpath " + InstallerClasspath, "cmdexeinst.CMDEXEInstaller", "& pause"], shell=True)
        LaunchingInstaller.wait()
else:
    print("Java Installed launch Installer")
    os.chdir(".\\InstallationFiles\\cmdexeinst")
    subprocess.Popen(["java", "--module-path " + LibraryPath, "--add-modules=javafx.controls,javafx.fxml", "-classpath " + InstallerClasspath, "cmdexeinst.CMDEXEInstaller", "& pause"], shell=True)
