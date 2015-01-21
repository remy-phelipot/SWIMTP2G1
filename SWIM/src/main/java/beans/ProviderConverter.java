/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import database.Consumer;
import database.Provider;
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
public class ProviderConverter implements Converter {

    /**
     * Creates a new instance of ScenarioConverter
     */
    public ProviderConverter() {
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
        Provider sb = db.getProviderByName(value);
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
        Provider sb = (Provider)value;
        return sb.getName();
    }
    
}
