package org.infosec.ismp.applet.manager.view;


import java.beans.PropertyChangeEvent;
import javax.swing.JPanel;

/**
 * This class provides the base level abstraction for views in this example. All
 * views that extend this class also extend JPanel (which is useful for performing
 * GUI manipulations on the view in NetBeans Matisse), as well as providing the 
 * modelPropertyChange() method that controllers can use to propogate model 
 * property changes.
 *
 */

public abstract class AbstractViewPanel extends JPanel {
    
	private static final long serialVersionUID = 5880117094715171503L;

	/**
     * Called by the controller when it needs to pass along a property change 
     * from a model.
     *
     * @param evt The property change event from the model
     */
    
    public abstract void modelPropertyChange(PropertyChangeEvent evt);
    
    
}
