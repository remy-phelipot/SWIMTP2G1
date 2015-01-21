/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        Database db = new Database();
        db.open();
        List<Scenario> ret = db.getScenarios();
        db.close();
        return ret;

    }

    /**
     * delete the db
     */
    public void delete() {
        Database db = new Database();
        db.open();
        db.hardReset();
        db.close();
    }

    /**
     * constructor
     */
    public VisualizeBean() {

    }

    /**
     * add a result
     */
    public void addResult() {
        if (this.selectedScenario.getResults() == null) {
            this.selectedScenario.setResults(new ArrayList<MyResult>());

        }
        List<MyResult> alr;
        alr = this.selectedScenario.getResults();
        MyResult tmp = new MyResult();
        tmp.setAverageresponseTime((int) (Math.random() * 1000));
        tmp.setMsgCount(500 + (int) (Math.random() * 1000));
        tmp.setMsgLost((int) (Math.random() * 500));
        Database db = new Database();
        db.open();
        db.addResult(tmp);
        alr.add(tmp);
        db.updateScenarioResult(this.selectedScenario.getName(), alr);
        db.close();

        this.selectedScenario.setResults(alr);
    }

    /**
     * delete a result
     */
    public void deleteResult() {
        Database db = new Database();
        db.open();
        MyResult rt = db.getResultById(selectedResult.getId());
        Scenario sce = db.getScenarioByName(selectedScenario.getName());
        sce.getResults().remove(rt);
        this.selectedScenario = sce;
        this.results = sce.getResults();
        db.deleteResult(rt.getId());
        db.close();

    }
}
