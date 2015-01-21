/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import database.Consumer;
import database.MySequence;
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
public class SequenceConverter implements Converter {

    /**
     * Creates a new instance of ScenarioConverter
     */
    public SequenceConverter() {
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
        //we parse the value string
        MySequence sb;
        //we get all the attributes of the sequence
        String begin = value.split(" ")[0];
        String data = value.split(" ")[1];
        String end = value.split(" ")[2];
        String pr = value.split(" ")[3];
        String rps = value.split(" ")[4];
        String cName = value.split(" ")[5];
        String pName = value.split(" ")[6];
        int beg = Integer.parseInt(begin);
        int en = Integer.parseInt(end);
        int daS = Integer.parseInt(data);
        int prT = Integer.parseInt(pr);
        int RpS = Integer.parseInt(rps);
        //we creat and open an acces to the database
        Database db = new Database();
        db.open();
        //we get the consumer and the provider using their name
        Consumer cons = db.getConsumerByName(cName);
        Provider prov = db.getProviderByName(pName);
        //we get the sequence from the database
        sb = db.getSequenceByParam(beg, daS, en, prT, RpS, prov, cons);
        //close the access
        db.close();
        //return the sequence
        return (Object) sb;
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
        //cast from an object to a sequence
        MySequence sb = (MySequence) value;
        //we then return an unique string describing the sequence
        return sb.getBegin() + " " + sb.getDataSize() + " " + sb.getEnd() + " " + sb.getProcessingTime() + " " + sb.getRequestPerSecond() + " " + sb.getConsumer().getName() + " " + sb.getProvider().getName();
    }
}
