package com.rusl215.dao.user;

import com.rusl215.model.country.Country;
import com.rusl215.model.country.Country_;
import com.rusl215.model.doc.Doc;
import com.rusl215.model.doc.DocType;
import com.rusl215.model.doc.DocType_;
import com.rusl215.model.doc.Doc_;
import com.rusl215.model.office.Office;
import com.rusl215.model.office.Office_;
import com.rusl215.model.user.User;
import com.rusl215.model.user.User_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getUserList(@NotNull Long officeId, String firstName, String lastName, String middleName, String position, Long docCode, Long citizenshipCode) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        Predicate predicate = criteriaBuilder.equal(root.get(User_.office).get(Office_.id), officeId);
        query.where(predicate);

        if (firstName != null) {
            predicate = criteriaBuilder.equal(root.get(User_.firstName), firstName);
            query.where(criteriaBuilder.and(query.getRestriction(), predicate));
        }
        if (lastName != null) {
            predicate = criteriaBuilder.equal(root.get(User_.secondName), lastName);
            query.where(criteriaBuilder.and(query.getRestriction(), predicate));
        }
        if (middleName != null) {
            predicate = criteriaBuilder.equal(root.get(User_.middleName), middleName);
            query.where(criteriaBuilder.and(query.getRestriction(), predicate));
        }
        if (position != null) {
            predicate = criteriaBuilder.equal(root.get(User_.position), position);
            query.where(criteriaBuilder.and(query.getRestriction(), predicate));
        }
        if (docCode != null) {
            predicate = criteriaBuilder.equal(root.get(User_.doc).get(Doc_.docType).get(DocType_.code), docCode);
            query.where(criteriaBuilder.and(query.getRestriction(), predicate));
        }
        if (citizenshipCode != null) {
            predicate = criteriaBuilder.equal(root.get(User_.country).get(Country_.code), citizenshipCode);
            query.where(criteriaBuilder.and(query.getRestriction(), predicate));
        }

        query.select(root);

        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserById(@NotNull Long id) {
        return entityManager.find(User.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUser(@NotNull Long id, Long officeId, @NotNull String firstName, String secondName, String middleName, @NotNull String position, String phone, String docName, String docNumber, String docDate, Long citizenshipCode, Boolean isIdentified) {
        User user = entityManager.find(User.class, id);
        user.setFirstName(firstName);
        user.setPosition(position);
        if (officeId != null && officeId != user.getOffice().getId()) {
            user.getOffice().removeUser(user);
            Office office = entityManager.find(Office.class, officeId);
            user.setOffice(office);
            office.addUser(user);
        }
        if (secondName != null) {
            user.setSecondName(secondName);
        }
        if (middleName != null) {
            user.setMiddleName(middleName);
        }
        if (phone != null) {
            user.setPhone(phone);
        }
        if (docName != null && !docName.equals(user.getDoc().getDocType().getName())) {
            user.getDoc().setDocType(getDocTypeByName(docName));
        }
        if (docNumber != null) {
            user.getDoc().setDocNumber(docNumber);
        }
        if (docDate != null) {
            Date newDate = Date.valueOf(docDate);
            user.getDoc().setDocDate(newDate);
        }
        if (citizenshipCode != null && citizenshipCode != user.getCountry().getCode()) {
            Country country = entityManager.find(Country.class, citizenshipCode);
            user.setCountry(country);
        }
        if (isIdentified != null) {
            user.getDoc().setIdentified(isIdentified);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertUser(@NotNull Long officeId, @NotNull String firstName, String secondName, String middleName, @NotNull String position, String phone, String docName, String docNumber, String docDate, Long citizenshipCode, Boolean isIdentified) {
        Office office = entityManager.find(Office.class, officeId);
        User user = new User(firstName, position);

        user.setOffice(office);

        user.setSecondName(secondName);

        user.setMiddleName(middleName);

        user.setPhone(phone);

        if (citizenshipCode != null) {
            Country country = entityManager.find(Country.class, citizenshipCode);
            user.setCountry(country);
        }

        entityManager.persist(user);

        Doc userDoc = new Doc();
        userDoc.setId(user.getId());
        userDoc.setDocType(getDefaultDocType());

        user.setDoc(userDoc);

        if (docName != null) {
            user.getDoc().setDocType(getDocTypeByName(docName));
        }

        user.getDoc().setDocNumber(docNumber);

        if (docDate != null) {
            Date newDate = Date.valueOf(docDate);
            user.getDoc().setDocDate(newDate);
        }

        user.getDoc().setIdentified(isIdentified);
    }

    private DocType getDocTypeByName(String docName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DocType> query = criteriaBuilder.createQuery(DocType.class);
        Root<DocType> root = query.from(DocType.class);

        query.where(criteriaBuilder.equal(root.get(DocType_.name), docName));

        query.select(root);
        TypedQuery<DocType> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }

    private DocType getDefaultDocType() {
        return getDocTypeByName("Паспорт гражданина РФ");
    }
}
