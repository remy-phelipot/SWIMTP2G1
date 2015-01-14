package database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

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

/*  @OneToMany
  private Collection<MySequence> sequences;*/

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

  /*  public Collection<MySequence> getSequences() {
        return sequences;
    }*/

    /*public void setSequences(ArrayList<MySequence> sequences) {
        this.sequences = sequences;
    }*/
    @Override
    public boolean equals(Object other){
        if(other.getClass() != this.getClass()){
            return false;
        }else if(other == null){
            return false;
        }else{
            Consumer otherC = (Consumer)other;
            if(otherC.getName().equalsIgnoreCase(this.getName())){
                return true;
            }else{
                return false;
            }
        }
    }
}
