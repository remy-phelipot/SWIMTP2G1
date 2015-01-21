package database;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * JPA Entity related to the element Provider
 * 
 * @author martin
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Provider.findById",
                query="SELECT p FROM Provider p WHERE p.id = :id"),

    @NamedQuery(name="Provider.findByName",
                query="SELECT p FROM Provider p WHERE p.name = :name"),
    @NamedQuery(name="Provider.getAll",
                query="SELECT p FROM Provider p"),
    @NamedQuery(name="Provider.deleteByName",
                query="DELETE FROM Provider p WHERE p.name = :name"),
    @NamedQuery(name="Provider.del",
                query="DELETE FROM Provider p")
})
public class Provider implements Serializable {
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
   * field version
   */
  private static final long serialVersionUID = 1L;

  /**
   * constructor
   */
  public Provider() {
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
   * set nalme
   * @param name 
   */
  public void setName(String name) {
    this.name = name;
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
        if(other.getClass() != this.getClass())
            return false;
        else{
            Provider otherC = (Provider)other;
            
            if((otherC.getName() != null) && (this.name != null)){
                return otherC.getName().equalsIgnoreCase(this.getName());
            } else {
                return otherC.getName() == null && this.name == null;
            }
        }
    }

    /**
     * hash code
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }
}
