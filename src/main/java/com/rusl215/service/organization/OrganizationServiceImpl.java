package com.rusl215.service.organization;

import com.rusl215.dao.organization.OrganizationDao;
import com.rusl215.model.mapper.MapperFacade;
import com.rusl215.model.organization.Organization;
import com.rusl215.view.organization.OrganizationListView;
import com.rusl215.view.organization.OrganizationView;
import com.rusl215.view.success.SuccessResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationDao organizationDao;
    private MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OrganizationListView> filterOrganization(String name, String inn, Boolean isActive) {
        List<Organization> list = organizationDao.getOrganizationByFilter(name, inn, isActive);
        return mapperFacade.mapAsList(list, OrganizationListView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OrganizationView organizationById(Long id) {
        return mapperFacade.map(organizationDao.getOrganizationById(id), OrganizationView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public SuccessResultView updateOrganization(Long id, String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        organizationDao.updateOrganization(id, name, fullName, inn, kpp, address, phone, isActive);
        return new SuccessResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public SuccessResultView saveOrganization(String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        organizationDao.saveOrganization(name, fullName, inn, kpp, address, phone, isActive);
        return new SuccessResultView();
    }
}
