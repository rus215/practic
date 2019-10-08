package com.rusl215.service.organization;

import com.rusl215.dao.organization.OrganizationDao;
import com.rusl215.model.mapper.MapperFacade;
import com.rusl215.model.organization.Organization;
import com.rusl215.view.organization.OrganizationListFilterView;
import com.rusl215.view.organization.OrganizationListView;
import com.rusl215.view.organization.OrganizationSaveView;
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
    public List<OrganizationListView> filterOrganization(OrganizationListFilterView organizationListFilterView) {
        List<Organization> list = organizationDao.getOrganizationByFilter(organizationListFilterView.name, organizationListFilterView.inn, organizationListFilterView.isActive);
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
    public SuccessResultView updateOrganization(OrganizationView organizationView) {
        organizationDao.updateOrganization(organizationView.id,organizationView.name,organizationView.fullName,organizationView.inn,organizationView.kpp,organizationView.address,organizationView.phone,organizationView.isActive);
        return new SuccessResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public SuccessResultView saveOrganization(OrganizationSaveView organizationSaveView) {
        organizationDao.saveOrganization(organizationSaveView.name,organizationSaveView.fullName,organizationSaveView.inn,organizationSaveView.kpp,organizationSaveView.address,organizationSaveView.phone,organizationSaveView.isActive);
        return new SuccessResultView();
    }
}
