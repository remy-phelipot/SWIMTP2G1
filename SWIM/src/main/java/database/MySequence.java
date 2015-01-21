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
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private int begin;
  private int dataSize;
  private int end;
  private int processingTime;
  private int requestPerSecond;

  @ManyToOne
  private Consumer consumer;

  @ManyToOne
  private Provider provider;


  @OneToMany
  private Collection<MyResult> results;

  private static final long serialVersionUID = 1L;

  public MySequence() {
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getBegin() {
    return this.begin;
  }

  public void setBegin(int begin) {
    this.begin = begin;
  }

  public int getDataSize() {
    return this.dataSize;
  }

  public void setDataSize(int dataSize) {
    this.dataSize = dataSize;
  }

  public int getEnd() {
    return this.end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public int getProcessingTime() {
    return this.processingTime;
  }

  public void setProcessingTime(int processingTime) {
    this.processingTime = processingTime;
  }

  public int getRequestPerSecond() {
    return this.requestPerSecond;
  }

  public void setRequestPerSecond(int requestPerSecond) {
    this.requestPerSecond = requestPerSecond;
  }

    public Consumer getConsumer() {
        return consumer;
    }

    public Provider getProvider() {
        return provider;
    }

    public Collection<MyResult> getResults() {
        return results;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public void setResults(List<MyResult> results) {
        this.results = results;
    }
    
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