package com.rusl215.service.office;

import com.rusl215.dao.office.OfficeDao;
import com.rusl215.model.mapper.MapperFacade;
import com.rusl215.model.office.Office;
import com.rusl215.view.office.OfficeListView;
import com.rusl215.view.office.OfficeView;
import com.rusl215.view.success.SuccessResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {
    private OfficeDao officeDao;
    private MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OfficeListView> filterOffice(Long orgId, String name, String phone, Boolean isActive) {
        List<Office> allOfficesByOrgId = officeDao.getAllOfficesByFilter(orgId, name, phone, isActive);
        return mapperFacade.mapAsList(allOfficesByOrgId, OfficeListView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OfficeView officeById(Long id) {
        return mapperFacade.map(officeDao.getOfficeById(id), OfficeView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public SuccessResultView updateOffice(Long id, String name, String address, String phone, Boolean isActive) {
        officeDao.updateOffice(id, name, address, phone, isActive);
        return new SuccessResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public SuccessResultView saveOffice(Long orgId, String name, String address, String phone, Boolean isActive) {
        officeDao.insertOffice(orgId, name, address, phone, isActive);
        return new SuccessResultView();
    }
}
