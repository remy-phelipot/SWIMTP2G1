package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.component.UIComponent;

/**
 *
 * @author anais
 */
@ManagedBean
@RequestScoped
public class FileUploadBean {

    private Part part;
    private String statusMessage;

    /**
     * Creates a new instance of FileUploadBean
     */
    public FileUploadBean() {
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String msg) {
        this.statusMessage = msg;
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
        //ArrayList<FacesMessage> msgs = new ArrayList<>();
        Part file = (Part) value;
        String contentType = "text/xml";
        System.out.println("content type: " + file.getContentType());
        System.out.println("size: " + file.getSize());
        
        // Pour l'instant, pas de contrainte de taille
        /*if (file.getSize() > 1024) {
            msgs.add(new FacesMessage("The selected file is too big"));
        }*/
        if (!contentType.equals(file.getContentType())) {
            statusMessage = "The selected file is not a XML file.";
            //msgs.add(new FacesMessage("The selected file is not a XML file."));
        }
        /*if (!msgs.isEmpty()) {
            throw new ValidatorException(msgs);
        }*/
    }
}
