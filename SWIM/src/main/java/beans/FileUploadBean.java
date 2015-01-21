package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.logging.Logger;
import controller.MainController;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
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
    private String name;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

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
        Logger.getLogger(FileUploadBean.class.getName()).log(Level.INFO, "filename: {0}", fileName);
        // Download the file into the tmp folder of your computer
        String basePath = System.getProperty("java.io.tmpdir") + File.separator;
        Logger.getLogger(FileUploadBean.class.getName()).log(Level.INFO, "base path: {0}", basePath);
        File outputFilePath = new File(basePath + fileName);

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = part.getInputStream();
            outputStream = new FileOutputStream(outputFilePath);

            int read;
            final byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            statusMessage = "File upload successful!";

            /* TODO: parser le fichier et inserer les donnees dans la database */
            MainController mainController = new MainController();
            try {
                mainController.addScenario(outputFilePath, name, desc);
            } catch (Exception e) {
                statusMessage = e.getMessage();
            }
        } catch (IOException ex) {
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
        Part file = (Part) value;
        String contentType = "text/xml";
        Logger.getLogger(FileUploadBean.class.getName()).log(Level.INFO, "content type: {0}", file.getContentType());
        Logger.getLogger(FileUploadBean.class.getName()).log(Level.INFO, "size: {0}", file.getSize());

        // Pour l'instant, pas de contrainte de taille
        if (!contentType.equals(file.getContentType())) {
            statusMessage = "The selected file is not a XML file.";
        }
    }
}
