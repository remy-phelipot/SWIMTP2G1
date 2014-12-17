package database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * JPA Entity related to the element Consumer
 * 
 * @author martin
 */
@Entity
public class Consumer implements Serializable {
 
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  @ManyToOne
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