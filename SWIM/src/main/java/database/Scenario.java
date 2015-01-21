package database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * JPA Entity related to the element Scenario
 * 
 * @author martin
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Scenario.findByName",
                query="SELECT s FROM Scenario s WHERE s.name = :name"),
    @NamedQuery(name="Scenario.getAll",
                query="SELECT s FROM Scenario s"),
    @NamedQuery(name="Scenario.del",
            query="DELETE FROM Scenario s WHERE NOT(s.id =0)")
})
public class Scenario implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;
  private String description;

  @ManyToMany
  private List<MySequence> sequences;

  @OneToMany
  private List<MyResult> results;

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


    public void setSequences(ArrayList<MySequence> sequences) {
        this.sequences = sequences;
    }

    public void setResults(List<MyResult> results) {
        this.results = results;
    }

    public List<MySequence> getSequences() {
        return sequences;
    }

    public List<MyResult> getResults() {
        return results;
    }
   @Override
    public boolean equals(Object other){
        if(other == null)
            return false;
        if(other.getClass() != this.getClass()){
            return false;
        }else{
            Scenario otherC = (Scenario)other;
            return  Objects.equals(name, otherC.name) && 
                    Objects.equals(description, otherC.description);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.description);
        return hash;
    }
}
