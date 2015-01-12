package database;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * JPA Entity related to the element MyResult
 * 
 * @author martin
 */
@Entity
@NamedQueries({
    @NamedQuery(name="MyResult.findById",
                query="SELECT r FROM MyResult r WHERE r.id = :id"),   
    @NamedQuery(name="MyResult.deleteById",
                query="DELETE FROM MyResult r WHERE  r.id = :id"),
    @NamedQuery(name="MyResult.del",
                query="DELETE FROM MyResult r")
})
public class MyResult implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private int averageresponseTime;
  private int msgCount;
  private int msgLost;

  @ManyToOne
  private MySequence sequence;
 
  @ManyToOne
  private Scenario scenario;

  private static final long serialVersionUID = 1L;

  public MyResult() {
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

    public MySequence getSequence() {
        return sequence;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setSequence(MySequence sequence) {
        this.sequence = sequence;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyResult other = (MyResult) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return true;
    }

}