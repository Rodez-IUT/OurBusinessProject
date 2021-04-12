package ourbusinessproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Partnership {
    @NotNull
    private Date creationDate;
    @NotNull @ManyToOne
    private Enterprise enterprise;
    @NotNull @ManyToOne
    private Project project;
    @Id
    @GeneratedValue
    private Long id;

    public Partnership(long id) {
        this.id = id;
    }

    public Partnership() {}

    public Partnership(Project project1E1, Enterprise enterprise2) {
        this.project = project1E1;
        this.enterprise = enterprise2;
        this.creationDate = new Date();
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
