package ourbusinessproject;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(Project project) {
        Enterprise enterprise = project.getEnterprise();
        if (enterprise != null) {
            enterprise.addProject(project);
            entityManager.persist(enterprise);
        }
        entityManager.persist(project);
        entityManager.flush();
    }

    public void save(Enterprise enterprise) {
        entityManager.persist(enterprise);
        entityManager.flush();
    }

    public Project findProjectById(Long anId) {
        return entityManager.find(Project.class,anId);
    }

    public Enterprise findEnterpriseById(Long anId) {
        return entityManager.find(Enterprise.class,anId);
    }

    public List<Project> findAllProjects() {
        String query = "select p from Project p order by p.title";
        TypedQuery<Project> typedQuery = entityManager.createQuery(query,Project.class);
        return typedQuery.getResultList();
    }
}
