package org.e792a8.coderunner.launch;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.externaltools.internal.IExternalToolConstants;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;

@SuppressWarnings("restriction")
public class LaunchHandler implements IExternalToolConstants {
	public static Object executeCmd(String executable, String workingDir, String execArgs) throws ExecutionException {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = manager.getLaunchConfigurationType(ID_PROGRAM_LAUNCH_CONFIGURATION_TYPE);
		try {
			ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null, "Code Runner");
//			workingCopy.setAttribute(ATTR_SHOW_CONSOLE, true);
//			workingCopy.setAttribute(ATTR_BUILDER_ENABLED, false);
			workingCopy.setAttribute(ATTR_LOCATION, executable);
			workingCopy.setAttribute(ATTR_WORKING_DIRECTORY, workingDir);
			workingCopy.setAttribute(ATTR_TOOL_ARGUMENTS, execArgs);
			ILaunchConfiguration configuration = workingCopy.doSave();
			DebugUITools.launch(configuration, ILaunchManager.RUN_MODE);
//			configuration.delete();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
