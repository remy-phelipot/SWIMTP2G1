/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import database.MyResult;
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
public class ResultConverter implements Converter {

    /**
     * Creates a new instance of ScenarioConverter
     */
    public ResultConverter() {
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
        //we create and open an acce to the database
        Database db = new Database();
        db.open();
        //we get the result using its Id
        MyResult sb = db.getResultById(Long.parseLong(value));
        db.close();
        //we return the result
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
        //cast of the object to a result
        MyResult sb = (MyResult)value;
        //return the id of the result
        return Long.toString(sb.getId());
    }
    
}
