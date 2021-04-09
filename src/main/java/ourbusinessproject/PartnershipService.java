package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class PartnershipService {

    @PersistenceContext
    private EntityManager entityManager;

    public Partnership save(Partnership partnership) {
        entityManager.persist(partnership);
        return partnership;
    }

    public Partnership findPartnershipById(Long id) {
        return entityManager.find(Partnership.class,id);
    }

    public void remove(Partnership partnership) {
        Partnership toRemove = entityManager.merge(partnership);
        entityManager.remove(toRemove);
    }
}
