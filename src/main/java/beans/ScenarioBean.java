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
     * Field part
     */
    private Part part;
    /**
     * Field statusMessage
     */
    private String statusMessage;

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
     * Getter on field part
     *
     * @return
     */
    public Part getPart() {
        return part;
    }

    /**
     * Getter on field statusMessage
     *
     * @return
     */
    public String getStatusMessage() {
        return statusMessage;
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
     * Setter on field part
     *
     * @param part
     */
    public void setPart(Part part) {
        this.part = part;
    }

    /**
     * Setter on field statusMessage
     *
     * @param statusMessage
     */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public void uploadFile() throws IOException {
        String fileName = getFileName(part);
        System.out.println("filename: " + fileName);
        // Download the file into the tmp folder of your computer
        String basePath = System.getProperty("java.io.tmpdir") + File.separator;
        System.out.println("base path: " + basePath);
        File outputFilePath = new File(basePath + fileName);

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = part.getInputStream();
            outputStream = new FileOutputStream(outputFilePath);

            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            statusMessage = "File upload successful!";

            /* TODO: parser le fichier et inserer les donnees dans la database */
        } catch (IOException ex) {
            ex.printStackTrace();
            statusMessage = "File upload failed!" + ex.toString();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    public void validateFile(FacesContext context, UIComponent comp, Object value) {
        ArrayList<FacesMessage> msgs = new ArrayList<>();
        Part file = (Part) value;
        String contentType = "text/xml";
        System.out.println("content type: " + file.getContentType());
        System.out.println("size: " + file.getSize());

        // Pour l'instant, pas de contrainte de taille
        /*if (file.getSize() > 1024) {
         msgs.add(new FacesMessage("The selected file is too big"));
         }*/
        if (!contentType.equals(file.getContentType())) {
            msgs.add(new FacesMessage("The selected file is not a XML file."));
        }
        if (!msgs.isEmpty()) {
            throw new ValidatorException(msgs);
        }
    }

}
