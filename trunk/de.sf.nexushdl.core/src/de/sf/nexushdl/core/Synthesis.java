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
import java.util.Iterator;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;


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

	private IResource	root = null;			///< The root resource that is that will be starting point for doxyfiles search.
	private IResource	m_hdlfile;
	private String		m_hdlfile_extension;
	private String		m_hdlfile_path;
	private String		m_hdlfile_type;
	private String		m_hdlfile_ws_path;
	

	/**
	 * Run Xilinx XST for synthesis
	 * 
	 * @throws CoreException, InvokeException 
	 * @throws IOException 
	 */
	public void Use_XST () throws CoreException, InvokeException, IOException {
		try {
			ResourceCollector	collector = root != null ? ResourceCollector.run(root) : ResourceCollector.run();
			
			if( collector.isEmpty() == true ) {
				System.out.println("No HDL files found!");
			}
			else {
				m_hdlfile_ws_path = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
				
			    File xst_prj_file;
			    xst_prj_file = new File(m_hdlfile_ws_path, "nexushdl.prj");
			    
			    if (!xst_prj_file.exists())
			    	xst_prj_file.createNewFile();
			    else {
			    	xst_prj_file.delete();
			    	xst_prj_file.createNewFile();
			    }
			    
			    FileWriter fstream = new FileWriter(xst_prj_file);
		        BufferedWriter out = new BufferedWriter(fstream);
				
				Iterator<IResource> it = collector.iterator();
				
				while (it.hasNext()) {
					
					m_hdlfile = it.next();
					m_hdlfile_path = m_hdlfile.getFullPath().toOSString();
					m_hdlfile_extension = m_hdlfile.getFileExtension();
					
					if (m_hdlfile_extension.startsWith("vhd"))
						m_hdlfile_type = "vhdl";
					else
						m_hdlfile_type = "verilog";
					
					System.out.printf("%s work %s\r\n", m_hdlfile_type, m_hdlfile_path);
			        out.write(m_hdlfile_type);
			        out.write(" work .");
			        out.write(m_hdlfile_path);
			        out.newLine();

				}
		        out.close();
			
				String[]	command = new String[7];
				
				StringBuffer xilinx_tool_location = new StringBuffer(0);
				xilinx_tool_location.insert(0, PreferenceConstants.XILINX_PATH);
				xilinx_tool_location.append("/xst");
				
				command[0] = xilinx_tool_location.toString();
				command[1] = "-ifn";
				
				StringBuffer synthesisfile_location = new StringBuffer(0);
				synthesisfile_location.insert(0, m_hdlfile_ws_path);
				synthesisfile_location.append("/nexushdl.xst");
				command[2] = synthesisfile_location.toString();

				StringBuffer synthesis_logfile_location = new StringBuffer(0);
				synthesis_logfile_location.insert(0, m_hdlfile_ws_path);
				synthesis_logfile_location.append("/nexushdl.srp");
				command[3] = "-ofn";
				command[4] = synthesis_logfile_location.toString();
				
				command[5] = "-intstyle";
				command[6] = "xflow";
			
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
		 
		}
		catch(IOException ioException) {
			throw new InvokeException(ioException);
		}
	}
}
