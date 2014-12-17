package database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * JPA Entity related to the element Sequence
 * 
 * @author martin
 */
@Entity
public class Sequence implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private int begin;
  private int dataSize;
  private int end;
  private int processingTime;
  private int requestPerSecond;

  @OneToMany(targetEntity=Consumer.class, mappedBy="sequences")
  private Consumer consumer;

  @OneToMany(targetEntity=Provider.class, mappedBy="sequences")
  private Provider provider;

  @ManyToMany
  private Collection<Scenario> scenarios;

  @ManyToOne
  private Collection<Result> results;

  private static final long serialVersionUID = 1L;

  public Sequence() {
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

    public Collection<Scenario> getScenarios() {
        return scenarios;
    }

    public Collection<Result> getResults() {
        return results;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public void setScenarios(ArrayList<Scenario> scenarios) {
        this.scenarios = scenarios;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }
  
}