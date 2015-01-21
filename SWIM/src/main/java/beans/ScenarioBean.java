/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

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

    /**
     * test the equality
     * @param other
     * @return 
     */
    @Override
    public boolean equals(Object other) {
        boolean res;
        //if the other object is not from the same class
        if (other.getClass() != this.getClass()) {
            //we return false
            res = false;
        }
        //if it is null
        else if (other == null) {
            //we return false
            res = false;
        }
        else {
            //else we check if it's name is the same
            ScenarioBean otherSb = (ScenarioBean) other;
            res = otherSb.getName().equalsIgnoreCase(this.getName());
        }
        //return true if the object is the same
        return res;
    }
    /**
     * function that return an unique int for each object
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.description);
        return hash;
    }
}
