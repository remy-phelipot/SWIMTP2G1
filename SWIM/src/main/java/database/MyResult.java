package database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="results")
public class MyResult implements Serializable {
    /**
     * field id
     */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /**
   * field response time
   */
  @XmlElement(name="averageresponseTime")
  private float averageresponseTime;
  /**
   * field msgcount
   */
  @XmlElement(name="msgCount")
  /**
   * field msg lost
   */
  private int msgCount;
  @XmlElement(name="msgLost")
  private int msgLost;

/**
 * field version
 */
  private static final long serialVersionUID = 1L;

  /**
   * constructor
   */
  public MyResult() {
  }

  /**
   * get id
   * @return 
   */
  public long getId() {
    return this.id;
  }

  /**
   * set id
   * @param id 
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * get the response time
   * @return 
   */
  public float getAverageresponseTime() {
    return this.averageresponseTime;
  }

  /**
   * set the response time
   * @param averageresponseTime 
   */
  public void setAverageresponseTime(float averageresponseTime) {
    this.averageresponseTime = averageresponseTime;
  }

  /**
   * get the msg count
   * @return 
   */
  public int getMsgCount() {
    return this.msgCount;
  }

  /**
   * set the msg count
   * @param msgCount 
   */
  public void setMsgCount(int msgCount) {
    this.msgCount = msgCount;
  }

  /**
   * get the msg lost
   * @return 
   */
  public int getMsgLost() {
    return this.msgLost;
  }

  /**
   * set the msg lost
   * @param msgLost 
   */
  public void setMsgLost(int msgLost) {
    this.msgLost = msgLost;
  }

  /**
   * test equality
   * @param obj
   * @return 
   */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyResult other = (MyResult) obj;
        return this.id == other.getId();
    }

    /**
     * hash code
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

}