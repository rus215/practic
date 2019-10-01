package com.rusl215.dao.office;

import com.rusl215.model.office.Office;
import com.rusl215.model.office.Office_;
import com.rusl215.model.organization.Organization;
import com.rusl215.model.organization.Organization_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public class OfficeDaoImpl implements OfficeDao {

    private EntityManager entityManager;

    @Autowired
    public OfficeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> getAllOfficesByFilter(@NotNull Long orgId, String name, String phone, Boolean isActive) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Office> query = criteriaBuilder.createQuery(Office.class);
        Root<Office> root = query.from(Office.class);
        Predicate predicate = criteriaBuilder.equal(root.get(Office_.organization).get(Organization_.id), orgId);
        query.where(predicate);
        if (name != null) {
            predicate = criteriaBuilder.equal(root.get(Office_.name), name);
            query.where(criteriaBuilder.and(query.getRestriction(), predicate));
        }

        if (phone != null) {
            predicate = criteriaBuilder.equal(root.get(Office_.phone), phone);
            query.where(criteriaBuilder.and(query.getRestriction(), predicate));
        }

        if (isActive != null) {
            predicate = criteriaBuilder.equal(root.get(Office_.isActive), isActive);
            query.where(criteriaBuilder.and(query.getRestriction(), predicate));
        }

        query.select(root);
        TypedQuery<Office> typedQuery = entityManager.createQuery(query);

        return typedQuery.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office getOfficeById(@NotNull Long id) {
        Office office = entityManager.find(Office.class, id);
        if (office == null){
            throw new RuntimeException("office with id="+ id + " not found");
        }
        return office;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateOffice(@NotNull Long id, @NotNull String name, @NotNull String address, String phone, Boolean isActive) {
        Office office = entityManager.find(Office.class, id);
        office.setName(name);
        office.setAddress(address);
        if (phone != null) {
            office.setPhone(phone);
        }
        if (isActive != null) {
            office.setActive(isActive);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertOffice(@NotNull Long orgId, String name, String address, String phone, Boolean isActive) {
        Organization organization = entityManager.find(Organization.class, orgId);
        Office office = new Office(name, address, phone);
        office.setActive(isActive);
        office.setOrganization(organization);
        entityManager.persist(office);
    }
}
