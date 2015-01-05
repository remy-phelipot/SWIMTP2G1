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

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Database db = new Database();
        db.open();
        Scenario sb = db.getScenarioByName(value.split(" ")[0]);
        
        return (Object)sb;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Scenario sb = (Scenario)value;
        return sb.getName() + " - " + sb.getDescription();
    }
    
}
