/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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
        if (other.getClass() != this.getClass()) {
            res = false;
        }
        else if (other == null) {
            res = false;
        }
        else {
            ScenarioBean otherSb = (ScenarioBean) other;
            res = otherSb.getName().equalsIgnoreCase(this.getName());
        }
        return res;
    }
}
