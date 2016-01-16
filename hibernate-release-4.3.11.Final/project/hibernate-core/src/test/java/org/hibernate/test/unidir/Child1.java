package org.hibernate.test.unidir;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CHILD1")
public class Child1 {
    @Id
    @Column(name = "ID")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHILD1_ID", nullable = false)
    private List<Parent1> parents = new ArrayList<Parent1>();

    public Long getId() {
        return this.id;
    }

    public List<Parent1> getParents() {
        return this.parents;
    }

    public void setParents(List<Parent1> parents) {
        this.parents = parents;
    }
}
