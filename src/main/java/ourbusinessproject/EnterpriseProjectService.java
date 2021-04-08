package ourbusinessproject;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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
            Enterprise managedEnterprise = entityManager.merge(enterprise);
            managedEnterprise.addProject(project);
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

    public Project findProjectByTitle(String title) {
        String query = "select p from Project p where p.title = :title";
        TypedQuery<Project> typedQuery = entityManager.createQuery(query,Project.class);
        typedQuery.setParameter("title",title);
        return DataAccessUtils.singleResult(typedQuery.getResultList());
    }

    public Enterprise findEnterpriseByName(String name) {
        String query = "select e from Enterprise e where e.name = :name";
        TypedQuery<Enterprise> typedQuery = entityManager.createQuery(query,Enterprise.class);
        typedQuery.setParameter("name",name);
        return DataAccessUtils.singleResult(typedQuery.getResultList());
    }
}
