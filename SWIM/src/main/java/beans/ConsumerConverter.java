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
        //we open an access to the db
        Database db = new Database();
        db.open();
        //we get the consumer in the db using its name
        Consumer sb = db.getConsumerByName(value);
        //we close the access
        db.close();
        //we return the consumer
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
        //cast from object to consumer
        Consumer sb = (Consumer)value;
        //return the name of the consumer
        return sb.getName();
    }
    
}
