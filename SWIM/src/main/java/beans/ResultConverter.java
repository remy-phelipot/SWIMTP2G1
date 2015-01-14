/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import database.Consumer;
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

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Database db = new Database();
        db.open();
        MyResult sb = db.getResultById(Long.parseLong(value));
        db.close();
        return (Object)sb;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        MyResult sb = (MyResult)value;
        return Long.toString(sb.getId());
    }
    
}
