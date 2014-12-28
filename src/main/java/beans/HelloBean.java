package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author anais
 */
@ManagedBean
@RequestScoped
public class HelloBean {
    private String name;
    private String message;
    
    public void createMessage() {
        message = "Hello " + name + "!";
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getMessage() {
        return message;
    }

    /**
     * Creates a new instance of HelloBean
     */
    public HelloBean() {
    }
    
}
