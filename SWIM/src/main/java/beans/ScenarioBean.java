/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 * Bean establishing the link between the View and the data to store scenarios
 * objects
 *
 * @author martin
 */
@ManagedBean
@ApplicationScoped
public class ScenarioBean {

    /**
     * Field name
     */
    private String name;
    /**
     * Field description
     */
    private String description;

    /**
     * Getter on field name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Getter on field description
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter on field name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter on field description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != this.getClass()) {
            return false;
        }
        else if (other == null) {
            return false;
        }
        else {
            ScenarioBean otherSb = (ScenarioBean) other;
            if (otherSb.getName().equalsIgnoreCase(this.getName())) {
                return true;
            }
            else {
                return false;
            }
        }
    }

}
