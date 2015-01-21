/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import database.Consumer;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import manager.Database;

/**
 *
 * @author Aymeric
 */
@ManagedBean
@RequestScoped
public class ConsumerConverter implements Converter {

    /**
     * Creates a new instance of ScenarioConverter
     */
    public ConsumerConverter() {
    }
    
    /**
     * get the object
     * @param context
     * @param component
     * @param value
     * @return 
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Database db = new Database();
        db.open();
        Consumer sb = db.getConsumerByName(value);
        db.close();
        return (Object)sb;
    }

    /**
     * get the string
     * @param context
     * @param component
     * @param value
     * @return 
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Consumer sb = (Consumer)value;
        return sb.getName();
    }
    
}
