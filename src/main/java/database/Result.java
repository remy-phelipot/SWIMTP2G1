package database;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * JPA Entity related to the element Result
 * 
 * @author martin
 */
@Entity
public class Result implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private int averageresponseTime;
  private int msgCount;
  private int msgLost;

  @OneToMany
  private Sequence sequence;
 
  @OneToMany
  private Scenario scenario;

  private static final long serialVersionUID = 1L;

  public Result() {
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getAverageresponseTime() {
    return this.averageresponseTime;
  }

  public void setAverageresponseTime(int averageresponseTime) {
    this.averageresponseTime = averageresponseTime;
  }

  public int getMsgCount() {
    return this.msgCount;
  }

  public void setMsgCount(int msgCount) {
    this.msgCount = msgCount;
  }

  public int getMsgLost() {
    return this.msgLost;
  }

  public void setMsgLost(int msgLost) {
    this.msgLost = msgLost;
  }

    public Sequence getSequence() {
        return sequence;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

}