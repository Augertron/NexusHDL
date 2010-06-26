package de.sf.nexushdl.ui.editors;


import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.editor.FormEditor;


/**
 * Implements the overview page.
 * 
 * @author Michael Bodenbach
 */
public class Page1 extends FormPage {
	
    /**
     * The page identifier.
     */
    public static final String ID = "basic";
    
    /**
     * the doxyfile being edited
     */
    //private Doxyfile doxyfile;
    
    /**
	 * Constructor.
	 */
	public Page1(FormEditor editor) {
		super(editor, Page1.ID, "Basic");
		
		//doxyfile = editor.getDoxyfile();
	}
	

	/**
	 * @see org.eclipse.ui.forms.editor.FormPage#createFormContent(org.eclipse.ui.forms.IManagedForm)
	 */
/*	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit	toolkit = managedForm.getToolkit();
		Composite	parent	= managedForm.getForm().getBody();
		
		managedForm.getForm().setText(this.getTitle());

		// Creates all parts of the form.
		ProjectPart		projectPart		= new ProjectPart( parent, toolkit, doxyfile );
		OutputPart		outputPart		= new OutputPart( parent, toolkit, doxyfile );
		ModePart		modePart		= new ModePart( parent, toolkit, doxyfile );
		DiagramsPart	diagramsPart	= new DiagramsPart( parent, toolkit, doxyfile );
		
		managedForm.addPart(projectPart);
		managedForm.addPart(outputPart);
		managedForm.addPart(modePart);
		managedForm.addPart(diagramsPart);
		
		// Creates the layout.
		FormLayout	layout = new FormLayout();
		layout.marginWidth = 16;
		layout.marginHeight = 16;
		layout.spacing = 20;
		parent.setLayout(layout);
		
		FormData	data;

		data = new FormData();
		data.top = new FormAttachment(0);
		data.right = new FormAttachment(50);
		data.bottom = new FormAttachment(modePart.getSection(), 0, SWT.TOP);
		data.left = new FormAttachment(0);
		projectPart.getSection().setLayoutData(data);
		
		data = new FormData();
		data.top = new FormAttachment(0);
		data.right = new FormAttachment(100);
		data.bottom = new FormAttachment(diagramsPart.getSection(), 0, SWT.TOP);
		data.left = new FormAttachment(projectPart.getSection(), 0, SWT.RIGHT);
		outputPart.getSection().setLayoutData(data);

		data = new FormData();
		data.right = new FormAttachment(50);
		data.bottom = new FormAttachment(100);
		data.left = new FormAttachment(0);
		modePart.getSection().setLayoutData(data);
		
		data = new FormData();
		data.top = new FormAttachment(outputPart.getSection(), 0, SWT.BOTTOM);
		data.right = new FormAttachment(100);
		data.left = new FormAttachment(modePart.getSection(), 0, SWT.RIGHT);
		diagramsPart.getSection().setLayoutData(data);
		
		super.createFormContent(managedForm);
	}*/
}
