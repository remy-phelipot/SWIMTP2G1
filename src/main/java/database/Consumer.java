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
 * JPA Entity related to the element Consumer
 * 
 * @author martin
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Consumer.selectAll",
                query="SELECT c FROM Consumer c")
})
public class Consumer implements Serializable {
 
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  @OneToMany
  private Collection<Sequence> sequences;

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

    public Collection<Sequence> getSequences() {
        return sequences;
    }

    public void setSequences(ArrayList<Sequence> sequences) {
        this.sequences = sequences;
    }

}