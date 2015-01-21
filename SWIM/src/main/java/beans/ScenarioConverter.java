/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import database.Scenario;
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
public class ScenarioConverter implements Converter {

    /**
     * Creates a new instance of ScenarioConverter
     */
    public ScenarioConverter() {
    }

    /**
     * get as object
     * @param context
     * @param component
     * @param value
     * @return 
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        //we create and open an access to the dtabase
        Database db = new Database();
        db.open();
        //we get the scenario using its name
        Scenario sb = db.getScenarioByName(value.split(" ")[0]);
        //we close the db acces
        db.close();
        //we return the scenario
        return (Object)sb;
    }

    /**
     * get as string
     * @param context
     * @param component
     * @param value
     * @return 
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        //cast the object to a scenrio
        Scenario sb = (Scenario)value;
        //we return its name and description
        return sb.getName() + " - " + sb.getDescription();
    }
    
}
