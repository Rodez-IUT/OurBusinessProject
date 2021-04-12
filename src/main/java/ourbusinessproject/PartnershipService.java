package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ourbusinessproject.repositories.PartnerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PartnershipService {

    @Autowired
    private PartnerRepository partnerRepository;

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

    public List<Partnership> findAllPartnerships() {
        String query = "select pa from Partnership pa join fetch pa.enterprise join fetch pa.project order by pa.project.title";
        TypedQuery<Partnership> typedQuery = entityManager.createQuery(query,Partnership.class);
        return typedQuery.getResultList();
    }

    public Page<Partnership> findAll(Example<Partnership> partnershipExample, Pageable pageable) {
        return partnerRepository.findAll(partnershipExample,pageable);
    }
}
