package database;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * JPA Entity related to the element MySequence
 * 
 * @author martin
 */
@Entity
@NamedQueries({
    

    @NamedQuery(name="MySequence.getByConsumer",
                query="SELECT s FROM MySequence s WHERE s.consumer = :consumer"),
    @NamedQuery(name="MySequence.getByProvider",
                query="SELECT s FROM MySequence s WHERE s.provider = :provider"),
    @NamedQuery(name="MySequence.getAll",
                query="SELECT s FROM MySequence s"),
    @NamedQuery(name="MySequence.del",
                query="DELETE FROM MySequence s"),
    @NamedQuery(name="MySequence.delete",
                query="DELETE FROM MySequence s WHERE  s.end = :end AND s.begin = :begin AND s.consumer = :consumer AND s.dataSize = :dataSize AND s.processingTime = :processingTime AND s.provider = :provider AND s.requestPerSecond = :requestPerSecond  "),
     @NamedQuery(name="MySequence.getOne",
                query="SELECT s FROM MySequence s WHERE  s.end = :end AND s.begin = :begin AND s.consumer = :consumer AND s.dataSize = :dataSize AND s.processingTime = :processingTime AND s.provider = :provider AND s.requestPerSecond = :requestPerSecond  ")
})
public class MySequence implements Serializable {
    /**
     * field id
     */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  /**
   * field begin
   */
  private int begin;
  /**
   * field data size
   */
  private int dataSize;
  /**
   * field end
   */
  private int end;
  /**
   * field processing time
   */
  private int processingTime;
  /**
   * field request per second
   */
  private int requestPerSecond;

  /**
   * field consumer
   */
  @ManyToOne
  private Consumer consumer;

  /**
   * field provider
   */
  @ManyToOne
  private Provider provider;


  /**
   * field results
   */
  @OneToMany
  private Collection<MyResult> results;

  /**
   * field version
   */
  private static final long serialVersionUID = 1L;

  /**
   * constructor
   */
  public MySequence() {
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
   * get begin
   * @return 
   */
  public int getBegin() {
    return this.begin;
  }

  /**
   * set begin
   * @param begin 
   */
  public void setBegin(int begin) {
    this.begin = begin;
  }

  /**
   * get data size
   * @return 
   */
  public int getDataSize() {
    return this.dataSize;
  }

  /**
   * set data size
   * @param dataSize 
   */
  public void setDataSize(int dataSize) {
    this.dataSize = dataSize;
  }

  /**
   * get end
   * @return 
   */
  public int getEnd() {
    return this.end;
  }

  /**
   * set end
   * @param end 
   */
  public void setEnd(int end) {
    this.end = end;
  }

  /**
   * get processing time
   * @return 
   */
  public int getProcessingTime() {
    return this.processingTime;
  }

  /**
   * set processing time
   * @param processingTime 
   */
  public void setProcessingTime(int processingTime) {
    this.processingTime = processingTime;
  }

  /**
   * get request
   * @return 
   */
  public int getRequestPerSecond() {
    return this.requestPerSecond;
  }

  /**
   * set request
   * @param requestPerSecond 
   */
  public void setRequestPerSecond(int requestPerSecond) {
    this.requestPerSecond = requestPerSecond;
  }

  /**
   * get consumer
   * @return 
   */
    public Consumer getConsumer() {
        return consumer;
    }

    /**
     * get provider
     * @return 
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * get results
     * @return 
     */
    public Collection<MyResult> getResults() {
        return results;
    }

    /**
     * set consumer
     * @param consumer 
     */
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    /**
     * set provider
     * @param provider 
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    /**
     * set results
     * @param results 
     */
    public void setResults(List<MyResult> results) {
        this.results = results;
    }
    
    /**
     * test equality
     * @param other
     * @return 
     */
   @Override
    public boolean equals(Object other){
        if(other == null){ 
            return false;
        }
        if(other.getClass() != this.getClass()){
            return false;
        } 
        MySequence otherC = (MySequence)other;
        boolean cnameEqual;
        if(otherC.getConsumer() != null && this.consumer != null)
            if((otherC.getConsumer().getName() != null) && (this.consumer.getName() != null)){
                cnameEqual = otherC.getConsumer().getName().equalsIgnoreCase(this.consumer.getName());
            } else {
                cnameEqual = otherC.getConsumer().getName() == null && this.consumer.getName() == null;
            }
        else
            cnameEqual = otherC.getConsumer() == this.consumer;
        
        boolean pnameEqual;
        if(otherC.getProvider() != null && this.provider != null)
            if((otherC.getProvider().getName() != null) && (this.provider.getName() != null)){
                pnameEqual = otherC.getProvider().getName().equalsIgnoreCase(this.provider.getName());
            } else {
                pnameEqual = otherC.getProvider().getName() == null && this.provider.getName() == null;
            }
        else
            pnameEqual = otherC.getProvider() == this.provider;
        
        return this.begin == otherC.getBegin() 
                && cnameEqual
                && otherC.getDataSize() == this.dataSize
                && otherC.getEnd() == this.end
                && otherC.getProcessingTime() == this.processingTime
                && pnameEqual
                && otherC.getRequestPerSecond() == this.requestPerSecond;
    }

    /**
     * hash code
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.begin;
        hash = 83 * hash + this.dataSize;
        hash = 83 * hash + this.end;
        hash = 83 * hash + this.processingTime;
        hash = 83 * hash + this.requestPerSecond;
        hash = 83 * hash + Objects.hashCode(this.consumer);
        hash = 83 * hash + Objects.hashCode(this.provider);
        return hash;
    }
}