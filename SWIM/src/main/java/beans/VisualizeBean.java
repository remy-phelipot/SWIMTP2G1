package beans;

import java.util.logging.Logger;
import database.MySequence;
import database.MyResult;
import database.Scenario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import manager.Database;

/**
 *
 * @author Aymeric
 */
@ManagedBean
@RequestScoped
public class VisualizeBean {

    /**
     * field list of scenarios
     */
    private List<Scenario> listScenario;
    /**
     * field results
     */
    private List<MyResult> results;

    /**
     * field scenario
     */
    private Scenario selectedScenario;
    /**
     * field result
     */
    private MyResult selectedResult;
    /**
     * field sequence
     */
    private MySequence selectedSequence;

    /**
     * get the results
     *
     * @return
     */
    public List<MyResult> getResults() {
        return this.selectedScenario.getResults();
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
     * get the result
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
     * get the scenario
     *
     * @return
     */
    public Scenario getSelectedScenario() {
        return selectedScenario;
    }

    /**
     * set the scenario
     *
     * @param selectedScenario
     */
    public void setSelectedScenario(Scenario selectedScenario) {
        this.selectedScenario = selectedScenario;
        Logger.getLogger(VisualizeBean.class.getName()).info(this.selectedScenario.getName());
    }

    /**
     * get the list of scenario
     *
     * @return
     */
    public List<Scenario> getListScenario() {
        //create and open an access to the database
        Database db = new Database();
        db.open();
        //we get all the scenarios
        List<Scenario> ret = db.getScenarios();
        //we close the access
        db.close();
        //we return the list
        return ret;

    }

    /**
     * delete the db
     */
    public void delete() {
        //we create an access to the database and open it
        Database db = new Database();
        db.open();
        //we reset the database
        db.hardReset();
        //we close the database
        db.close();
    }

    /**
     * constructor
     */
    public VisualizeBean() {

    }

 /**
     * add a result
     * deprecated
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
    
}

