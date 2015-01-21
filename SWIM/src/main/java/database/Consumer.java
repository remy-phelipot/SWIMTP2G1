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
 * JPA Entity related to the element Consumer
 * 
 * @author martin
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Consumer.findById",
                query="SELECT c FROM Consumer c WHERE c.id = :id"),

    @NamedQuery(name="Consumer.findByName",
                query="SELECT c FROM Consumer c WHERE c.name = :name"),
    @NamedQuery(name="Consumer.getAll",
                query="SELECT c FROM Consumer c"),
    @NamedQuery(name="Consumer.deleteByName",
                query="DELETE FROM Consumer c WHERE  c.name = :name"),
     @NamedQuery(name="Consumer.del",
                query="DELETE FROM Consumer c ")
})
public class Consumer implements Serializable {
 
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  private static final long serialVersionUID = 1L;

  public Consumer() {
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

    @Override
    public boolean equals(Object other){
        if(other == null)
            return false;
        if(other.getClass() != this.getClass())
            return false;
        else{
            Consumer otherC = (Consumer)other;
            
            if((otherC.getName() != null) && (this.name != null)){
                return otherC.getName().equalsIgnoreCase(this.getName());
            } else {
                return otherC.getName() == null && this.name == null;
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }
}
