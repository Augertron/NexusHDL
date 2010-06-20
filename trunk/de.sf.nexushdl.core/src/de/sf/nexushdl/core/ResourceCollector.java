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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;


/**
 * Implements a resource collector that will search for available VHDL and Verilog
 * either from the workbenck resources' root or from a given resource.
 * 
 * @author Michael Bodenbach
 */
public class ResourceCollector implements IResourceVisitor {
    
    /**
     * a collection of all collected resources
     */
    private Collection<IResource> m_hdlfiles = new ArrayList<IResource>();

    /**
     * Runs a collector from the workspace resources' root.
     * 
     * @return  a resource collector containing collected HDL files
     */
    public static ResourceCollector run() throws CoreException {
    	return run( ResourcesPlugin.getWorkspace().getRoot() );
    }
    
    /**
     * Runs a collector from the given root resource.
     * 
     * @param	resource	a resource to search for HDL files
     * 
     * @return  a resource collector containing collected HDL files
     */
	public static ResourceCollector run(IResource root) throws CoreException {
		ResourceCollector   collector = new ResourceCollector();
		root.accept( collector );
		return collector;
	}
    
    /**
     * @see org.eclipse.core.resources.IResourceVisitor#visit(org.eclipse.core.resources.IResource)
     */
    public boolean visit(IResource resource) throws CoreException {
        // Determine if the current resource is a HDL file, and if so, stores the resource
        if( resource.isAccessible() && HDLfile.isHDLfile(resource) == true ) {
            m_hdlfiles.add( resource );
        }
        return true;
    }
    
    /**
     * Tells if the collector is empty.
     * 
     * @return	true or false
     */
    public boolean isEmpty() {
    	return m_hdlfiles.isEmpty();
    }
    
    /**
     * Retrieves the first HDL file.
     * 
     * @return	the first HDL file, or null when none
     */
    public IFile getFirst() {
    	return m_hdlfiles.isEmpty() ? null : (IFile) m_hdlfiles.iterator().next();
    }
    
    /**
     * Retrieves the collection with all collected HDL resources.
     * 
     * @return  a collection with all collected HDL resources
     */
    public Collection<IResource> getHDLfiles() {
        return m_hdlfiles;
    }
    
    /**
     * Retrieves the number of collected HDL files.
     * 
     * @return	the number of collected HDL files
     */
    public int getSize() {
    	return m_hdlfiles.size();
    }
    
    /**
     * Retrieves the iterator on the collection of collected HDL resources.
     * 
     * @return  an iterator instance
     */
    public Iterator<IResource> iterator() {
        return m_hdlfiles.iterator();
    }

}