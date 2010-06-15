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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentType;

public class HDLfile {
	
	/**
	 * Tells if the specified resource is a HDL file.
	 * 
	 * @param	resource	the resource to test
	 * 
	 * @return	<code>true</code> or <code>false</code>  
	 */
	public static boolean isHDLfile(IResource resource) {
		return (resource instanceof IFile) && isHDLfile((IFile) resource);
	}

	/**
	 * Tells if the specified file is a HDL file.
	 * 
	 * @param	file	the file to test
	 * 
	 * @return	<code>true</code> or <code>false</code>  
	 */
	public static boolean isHDLfile(IFile file) {
	    String          name = file.getName();
		IContentType	contentType = Platform.getContentTypeManager().findContentTypeFor( name );
		
		return contentType != null ? contentType.getId().equals("org.gna.eclox.core.doxyfile") : false;
	}

}
