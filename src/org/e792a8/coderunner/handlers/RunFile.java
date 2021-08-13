package org.e792a8.coderunner.handlers;

import org.e792a8.coderunner.launch.LaunchHandler;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class RunFile extends AbstractHandler {

	public RunFile() {
	}

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		String executable = "C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\powershell.exe";
		String args = "g++ ${resource_loc} -o ${project_loc}${resource_name}.exe ; if ($?) { ${project_loc}${resource_name}.exe } ; rm ${project_loc}${resource_name}.exe";
		LaunchHandler.executeCmd(executable, null, args);
		return null;
	}

}
