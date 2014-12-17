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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * JPA Entity related to the element Scenario
 * 
 * @author martin
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Scenario.findByName",
                query="SELECT s FROM Scenario s WHERE s.name = :name")
})
public class Scenario implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;
  private String description;

  @ManyToMany
  private Collection<Sequence> sequences;

  @ManyToOne
  private Collection<Result> results;

  private static final long serialVersionUID = 1L;

  public Scenario() {
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

    public void setSequences(ArrayList<Sequence> sequences) {
        this.sequences = sequences;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public Collection<Sequence> getSequences() {
        return sequences;
    }

    public Collection<Result> getResults() {
        return results;
    }

}