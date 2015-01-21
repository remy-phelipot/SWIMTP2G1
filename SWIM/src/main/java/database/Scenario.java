package database;

import java.io.Serializable;
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
    /**
     * field id
     */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /**
   * field name
   */
  private String name;
  /**
   * field description
   */
  private String description;

  /**
   * field sequences
   */
  @ManyToMany
  private List<MySequence> sequences;

  /**
   * field results
   */
  @OneToMany
  private List<MyResult> results;

  /**
   * field version
   */
  private static final long serialVersionUID = 1L;

  /**
   * constructor
   */
  public Scenario() {
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
   * get name
   * @return 
   */
  public String getName() {
    return this.name;
  }

  /**
   * set name
   * @param name 
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * get description
   * @return 
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * set description
   * @param description 
   */
  public void setDescription(String description) {
    this.description = description;
  }


  /**
   * set sequences
   * @param sequences 
   */
    public void setSequences(List<MySequence> sequences) {
        this.sequences = sequences;
    }

    /**
     * set results
     * @param results 
     */
    public void setResults(List<MyResult> results) {
        this.results = results;
    }

    /**
     * get sequences
     * @return 
     */
    public List<MySequence> getSequences() {
        return sequences;
    }

    /**
     * get results
     * @return 
     */
    public List<MyResult> getResults() {
        return results;
    }
    /**
     * test equality
     * @param other
     * @return 
     */
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

    /***
     * hash code
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.description);
        return hash;
    }
}
