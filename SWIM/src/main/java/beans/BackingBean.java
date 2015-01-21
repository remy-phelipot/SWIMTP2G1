package beans;

import java.util.logging.Logger;
import controller.MainController;
import database.Scenario;
import database.MySequence;
import database.MyResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.bind.JAXBException;
import manager.Database;
import xmlparsing.ResultsToXml;

/**
 *
 * @author Aymeric
 */
@ManagedBean
@ViewScoped
public class BackingBean {

    /**
     * field name
     */
    private String name;
    /**
     * field description
     */
    private String description;
    /**
     * field sequence
     */
    private MySequence selectedSequence;
    /**
     * field sequence to remove
     */
    private MySequence toRemoveSequence;
    /**
     * field scenario selected
     */
    private Scenario selectedScenario;
    /**
     * field result
     */
    private MyResult selectedResult;
    /**
     * field list of results
     */
    private List<MyResult> results;
    /**
     * field list sequence
     */
    private List<MySequence> listSelectedSequence;
    /**
     * field list of scenario
     */
    private List<Scenario> listScenario;

    /**
     * Creates a new instance of CreateBean
     */
    public BackingBean() {
    }

    /**
     * get the list of scenario
     *
     * @return
     */
    public List<Scenario> getListScenario() {
        // create a new database access
        Database db = new Database();
        // open it
        db.open();
        //we get all the scenrios in the db
        List<Scenario> ret = db.getScenarios();
        //close the db access
        db.close();
        return ret;

    }

    /**
     * get the results
     *
     * @return
     */
    public List<MyResult> getResults() {
        return this.selectedScenario.getResults();
    }

    /**
     * get the result selected by user
     *
     * @return
     */
    public MyResult getSelectedResult() {
        return selectedResult;
    }

    /**
     * set the result
     *
     * @param selectedResult
     */
    public void setSelectedResult(MyResult selectedResult) {
        this.selectedResult = selectedResult;
    }

    /**
     * get the scenario selected
     *
     * @return
     */
    public Scenario getSelectedScenario() {
        return selectedScenario;
    }

    /**
     * get the number of results
     *
     * @return
     */
    public int getNumberOfResults() {
        return this.selectedScenario.getResults().size();
    }

    /**
     * get the id
     *
     * @param index
     * @return
     */
    public long getResultId(int index) {
        return this.selectedScenario.getResults().get(index).getId();
    }

    /**
     * get the average response time
     *
     * @param index
     * @return
     */
    public float getResultAverageResponseTime(int index) {
        return this.selectedScenario.getResults().get(index).getAverageresponseTime();
    }

    /**
     * set the scenario
     *
     * @param selectedScenario
     */
    public void setSelectedScenario(Scenario selectedScenario) {
        this.selectedScenario = selectedScenario;
    }

    /**
     * get the name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set the name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the description
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * set the description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the sequence
     *
     * @return
     */
    public MySequence getSelectedSequence() {
        return selectedSequence;
    }

    /**
     * set the sequence
     *
     * @param selectedSequence
     */
    public void setSelectedSequence(MySequence selectedSequence) {
        this.selectedSequence = selectedSequence;
    }

    /**
     * remove the sequence
     *
     * @return
     */
    public MySequence getToRemoveSequence() {
        return toRemoveSequence;
    }

    /**
     * set the sequence
     *
     * @param toRemoveSequence
     */
    public void setToRemoveSequence(MySequence toRemoveSequence) {
        this.toRemoveSequence = toRemoveSequence;
    }

    /**
     * get the list of sequence
     *
     * @return
     */
    public List<MySequence> getListSelectedSequence() {
        return listSelectedSequence;
    }

    /**
     * set the sequences
     *
     * @param listSelectedSequence
     */
    public void setListSelectedSequence(List<MySequence> listSelectedSequence) {
        this.listSelectedSequence = listSelectedSequence;
    }

    /**
     * add a sequence
     */
    public void addSelectedSequence() {
        //if the list is not set
        if (this.listSelectedSequence == null) {
            // we create it 
            this.listSelectedSequence = new ArrayList<>();
        }
        // if the selected sequence isnot in the list
        if (!this.listSelectedSequence.contains(selectedSequence)) {
            //we add it to the list
            this.listSelectedSequence.add(selectedSequence);
        }

    }

    /**
     * remove a sequence
     */
    public void removeSelectedSequence() {
        //if the list is not set
        if (this.listSelectedSequence == null) {
            // we create it 

            this.listSelectedSequence = new ArrayList<>();
        }
        //we remove the sequence to remove
        this.listSelectedSequence.remove(toRemoveSequence);
    }

    public void createScenario() {
        //create a new database access
        Database db = new Database();
        //open it
        db.open();
        //we create a scenarioBean
        ScenarioBean scenarioBean = new ScenarioBean();
        //we set its description and name
        scenarioBean.setDescription(description);
        scenarioBean.setName(name);
        //if the scenario is not in the db
        if (db.getScenarioByName(name) == null) {
            //we add it to the db
            db.createScenario(scenarioBean);
        }
        //we update the scenario in the db with the list of sequence
        db.updateScenario(name, listSelectedSequence);
        //we close the access
        db.close();
    }

    /**
     * add a result deprecated
     */
    public void addResult() {
        // THIS FONCTION IS NOT TO BE  USED ANYMORE
        // TEST FUNCTION
        //if the scenario has not any result
        if (this.selectedScenario.getResults() == null) {
            //we create the list
            this.selectedScenario.setResults(new ArrayList<MyResult>());

        }
        //we create a new list of result
        List<MyResult> alr;
        //the list is set to the current scenario's list
        alr = this.selectedScenario.getResults();
        //we create some new random results
        MyResult tmp = new MyResult();
        tmp.setAverageresponseTime((int) (Math.random() * 1000));
        tmp.setMsgCount(500 + (int) (Math.random() * 1000));
        tmp.setMsgLost((int) (Math.random() * 500));
        //we create a new db access
        Database db = new Database();
        //we open it
        db.open();
        //we then add the result to the db
        db.addResult(tmp);
        //we add the result to the list
        alr.add(tmp);
        //we update the scenario with the new list of result
        db.updateScenarioResult(this.selectedScenario.getName(), alr);
        //we close the access to the db
        db.close();
        //we save the list in the bean's scenario
        this.selectedScenario.setResults(alr);
    }

    /**
     * delete a result
     */
    public void deleteResult() {
        //access to the db
        Database db = new Database();
        //we open the access
        db.open();
        //we get the result using its id
        MyResult rt = db.getResultById(selectedResult.getId());
        //we get the scenario by its name
        Scenario sce = db.getScenarioByName(selectedScenario.getName());
        //we remove the result from the scenario
        sce.getResults().remove(rt);
        //we save the scenario and its results in the bean
        this.selectedScenario = sce;
        this.results = sce.getResults();
        //we delete the result from the db
        db.deleteResult(rt.getId());
        //we cloe the access
        db.close();

    }

    /**
     * Called when user click on "Download as XML"
     *
     * Launch the process of XML writing of the result on the specified file
     */
    public void downloadXML() {
        try {
            String basePath = System.getProperty("java.io.tmpdir") + File.separator;
            Logger.getLogger(BackingBean.class.getName()).info("base path: " + basePath);
            String outputFilePath = basePath + "results.xml";
            ResultsToXml.generateXml(selectedResult, outputFilePath);
        } catch (JAXBException ex) {
            Logger.getLogger(BackingBean.class.getName()).severe(ex.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BackingBean.class.getName()).severe(ex.toString());
        }
    }

    /**
     * called on launching, set the controller
     */
    public void onLaunching() {
        MainController controller = new MainController();
        controller.launchScenario(selectedScenario);
    }

    /*
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     v










































































































































































































































     */
    /*
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     v










































































































































































































































     */
    /*
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a



     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     v
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     v
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     v
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     v
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     v
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     v
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     v
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     v
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     v
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     v
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     v
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a


     v
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     a
     a
     aa
     a
     aa
     a
     a
     */
    /**
     * set a scenario
     *
     * @param sce
     */
    public void setSce(Scenario sce) {
        this.selectedScenario = sce;
    }

}
