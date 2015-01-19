package database;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @XmlElement(name="averageresponseTime")
  private float averageresponseTime;
  @XmlElement(name="msgCount")
  private int msgCount;
  @XmlElement(name="msgLost")
  private int msgLost;


  private static final long serialVersionUID = 1L;

  public MyResult() {
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public float getAverageresponseTime() {
    return this.averageresponseTime;
  }

  public void setAverageresponseTime(float averageresponseTime) {
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