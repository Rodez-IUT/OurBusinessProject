package ourbusinessproject;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Partnership {
    @NotNull
    private Date creationDate = new Date();
    @NotNull
    private Enterprise enterprise;
    @NotNull
    private Project project;
    private Long id;

    public Partnership(long id) {
        this.id = id;
    }

    public Partnership() {}

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
