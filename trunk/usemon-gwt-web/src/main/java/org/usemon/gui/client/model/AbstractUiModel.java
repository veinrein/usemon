/**
 * Created 29. jan.. 2008 13.09.06 by Steinar Overbeck Cook
 */
package org.usemon.gui.client.model;

/**
 * @author t547116 (Steinar Overbeck Cook)
 *
 */

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class provides base level functionality for all models, including a 
 * support for a property change mechanism (using the PropertyChangeSupport class),
 * as well as a convenience method that other objects can use to reset model state.
 * @author Robert Eckstein
 */
public abstract class AbstractUiModel
{
    
    /**
     * Convenience class that allow others to observe changes to the model properties
     */
    protected PropertyChangeSupport propertyChangeSupport;

    /**
     * Default constructor. Instantiates the PropertyChangeSupport class.
     */
    
    public AbstractUiModel() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    
    /**
     * Adds a property change listener to the observer list.
     * @param l The property change listener
     */
    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }
    
    /**
     * Removes a property change listener from the observer list.
     * @param l The property change listener
     */
    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    
    
    /**
     * Fires an event to all registered listeners informing them that a property in
     * this model has changed.
     * @param propertyName The name of the property
     * @param oldValue The previous value of the property before the change
     * @param newValue The new property value after the change
     */
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
        
  
}
    
