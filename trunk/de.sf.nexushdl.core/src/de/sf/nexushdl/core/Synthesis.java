/*
 * NexusHDL : FPGA/ASIC Build plug-in for Eclipse.
 * Copyright (C) 2010 Michael Bodenbach
 *
 * This file is part of NexusHDL.
 *
 * NexusHDL is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * any later version.
 *
 * NexusHDL is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with NexusHDL; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA	
 */

package de.sf.nexushdl.core;

import java.io.*;
import java.util.*;

/**
 * blablabla
 * 
 * @author Michael Bodenbach
 */
public class Synthesis {
	
	/**
	 * The constructor.
	 */
	public Synthesis() {
	}

	/**
	 * Run Xilinx XST for synthesis
	 */
	public void Use_XST () throws InvokeException {
		try {
			String[]	command = new String[2];
			
			command[0] = "/opt/Xilinx/12.1/ISE_DS/ISE/bin/lin/xst";
			command[1] = "--help";
			//command[2] = file.getLocation().makeAbsolute().toOSString();
	
			ProcessBuilder pb = new ProcessBuilder(command);
			Process p = pb.start();
			
		    InputStream is = p.getInputStream();
 	        InputStreamReader isr = new InputStreamReader(is);
		    BufferedReader br = new BufferedReader(isr);
		    String line;

		    while ((line = br.readLine()) != null) {
		      System.out.println(line);
		    }			
		 
		}
		catch(IOException ioException) {
			throw new InvokeException(ioException);
		}
	}
}
