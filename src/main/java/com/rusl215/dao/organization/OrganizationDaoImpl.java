package com.rusl215.dao.organization;

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
public class OrganizationDaoImpl implements OrganizationDao {

    private EntityManager entityManager;

    @Autowired
    public OrganizationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> getOrganizationByFilter(@NotNull String name, String inn, Boolean isActive) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Organization> query = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> root = query.from(Organization.class);

        Predicate predicate = criteriaBuilder.equal(root.get(Organization_.name), name);
        query.where(predicate);


        if (inn != null) {
            predicate = criteriaBuilder.equal(root.get(Organization_.inn), inn);
            query.where(criteriaBuilder.and(query.getRestriction(), predicate));
        }

        if (isActive != null) {
            predicate = criteriaBuilder.equal(root.get(Organization_.isActive), isActive);
            query.where(criteriaBuilder.and(query.getRestriction(), predicate));
        }


        query.select(root);
        TypedQuery<Organization> typedQuery = entityManager.createQuery(query);

        return typedQuery.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization getOrganizationById(@NotNull Long id) {
        return entityManager.find(Organization.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateOrganization(@NotNull Long id, @NotNull String name, @NotNull String fullName, @NotNull String inn, @NotNull String kpp, @NotNull String address, String phone, Boolean isActive) {
        Organization organization = entityManager.find(Organization.class, id);
        organization.setName(name);
        organization.setFullName(fullName);
        organization.setInn(inn);
        organization.setKpp(kpp);
        organization.setAddress(address);
        if (phone != null) {
            organization.setPhone(phone);
        }
        if (isActive != null) {
            organization.setActive(isActive);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveOrganization(@NotNull String name, @NotNull String fullName, @NotNull String inn, @NotNull String kpp, @NotNull String address, String phone, Boolean isActive) {
        Organization organization = new Organization(name, fullName, inn, kpp, address);
        organization.setPhone(phone);
        organization.setActive(isActive);
        entityManager.persist(organization);
    }
}
