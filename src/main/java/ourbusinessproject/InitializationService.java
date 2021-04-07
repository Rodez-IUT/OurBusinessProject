package ourbusinessproject;

import org.springframework.stereotype.Service;

@Service
public class InitializationService {
    private Project project1E1;
    private Project project1E2;
    private Project project2E1;
    private Enterprise enterprise1;
    private Enterprise enterprise2;

    public void initProjects() {
    }

    public Project getProject1E1() {
        return project1E1;
    }

    public void setProject1E1(Project project1E1) {
        this.project1E1 = project1E1;
    }

    public Project getProject1E2() {
        return project1E2;
    }

    public void setProject1E2(Project project1E2) {
        this.project1E2 = project1E2;
    }

    public Project getProject2E1() {
        return project2E1;
    }

    public void setProject2E1(Project project2E1) {
        this.project2E1 = project2E1;
    }

    public Enterprise getEnterprise1() {
        return enterprise1;
    }

    public void setEnterprise1(Enterprise enterprise1) {
        this.enterprise1 = enterprise1;
    }

    public Enterprise getEnterprise2() {
        return enterprise2;
    }

    public void setEnterprise2(Enterprise enterprise2) {
        this.enterprise2 = enterprise2;
    }
}
