package springpetserver.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Zhuinden on 2015.04.30..
 */
@Entity
@Table(name="HELLO_WORLD")
public class HelloWorldEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="HELLO_ID")
    private Long id;

    @Column(name="HELLO_NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
