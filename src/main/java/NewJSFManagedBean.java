/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author ender
 */
@Named(value = "newJSFManagedBean")
@Dependent
public class NewJSFManagedBean {

    private String name;

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public NewJSFManagedBean() {
        name = "toto";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
