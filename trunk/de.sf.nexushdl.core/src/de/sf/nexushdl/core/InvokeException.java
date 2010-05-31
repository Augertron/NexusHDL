package de.sf.nexushdl.core;

/**
 * Signals that something got wrong while trying to execute external program.
 * 
 * @author Michael Bodenbach
 */
public class InvokeException extends Exception {

	private static final long serialVersionUID = -4531804107557361202L;

	/**
	 * Constructor
	 * 
	 * @param	cause	references the cause 
	 */
	InvokeException( Throwable cause ) {
		super( cause );
	}
}