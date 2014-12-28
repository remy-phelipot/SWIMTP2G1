package database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


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
                query="DELETE FROM Provider p WHERE p.name = :name")
})
public class Provider implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  @OneToMany
  private Collection<MySequence> sequences;

  private static final long serialVersionUID = 1L;

  public Provider() {
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

    public Collection<MySequence> getSequences() {
        return sequences;
    }

    public void setSequences(ArrayList<MySequence> sequences) {
        this.sequences = sequences;
    }
    @Override
    public boolean equals(Object other){
        if(other.getClass() != this.getClass()){
            return false;
        }else if(other == null){
            return false;
        }else{
            Provider otherP = (Provider)other;
            if(otherP.getName().equalsIgnoreCase(this.getName())){
                return true;
            }else{
                return false;
            }
        }
    }
}