package de.sf.nexushdl.ui.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;



import de.sf.nexushdl.core.InvokeException;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.cokmmands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(
				window.getShell(),
				"Nexus HDL User Interface",
				"Build start");

		try {
			ProcessBuilder pb = new ProcessBuilder("kate");
/*		 Map<String, String> env = pb.environment();
		 env.put("VAR1", "myValue");
		 env.remove("OTHERVAR");
		 env.put("VAR2", env.get("VAR1") + "suffix");
		 pb.directory(new File("myDir"));*/
			Process p = pb.start();
		 
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}		
}
