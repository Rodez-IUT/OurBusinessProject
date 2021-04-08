package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class InitializationService {

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    private Project project1E1;
    private Project project1E2;
    private Project project2E1;
    private Enterprise enterprise1;
    private Enterprise enterprise2;

    @Transactional
    public void initProjects() {
        enterprise1 = new Enterprise();
        enterprise1.setName("MyComp1");
        enterprise1.setDescription("My comp1 description");
        enterprise1.setContactEmail("comp1@com.com");
        enterprise1.setContactName("comp1 contact name");

        project1E1 = new Project();
        project1E1.setTitle("p1E1");
        project1E1.setDescription("Project 1 description");
        project1E1.setEnterprise(enterprise1);

        enterpriseProjectService.save(project1E1);
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
