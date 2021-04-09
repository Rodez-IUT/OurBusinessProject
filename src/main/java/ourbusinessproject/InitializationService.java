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
        initEnterprise();
        project1E1 = new Project("p1E1","P1E1 desc",enterprise1);
        enterpriseProjectService.save(project1E1);
        project1E2 = new Project("p1E2","P1E2 desc",enterprise2);
        enterpriseProjectService.save(project1E2);
        project2E1 = new Project("p2E1","P2E1 desc",enterprise1);
        enterpriseProjectService.save(project2E1);
    }

    @Transactional
    public void initEnterprise() {
        // enterprise 1
        enterprise1 = new Enterprise();
        enterprise1.setName("MyComp1");
        enterprise1.setDescription("My comp1 description");
        enterprise1.setContactEmail("comp1@com.com");
        enterprise1.setContactName("comp1 contact name");
        enterpriseProjectService.save(enterprise1);
        // enterprise 2
        enterprise2 = new Enterprise();
        enterprise2.setName("MyComp2");
        enterprise2.setDescription("My comp2 description");
        enterprise2.setContactEmail("comp2@com.com");
        enterprise2.setContactName("comp2 contact name");
        enterpriseProjectService.save(enterprise2);
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
