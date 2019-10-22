package com.rusl215.service.office;

import com.rusl215.dao.office.OfficeDao;
import com.rusl215.model.mapper.MapperFacade;
import com.rusl215.model.office.Office;
import com.rusl215.view.office.OfficeListFilterView;
import com.rusl215.view.office.OfficeListView;
import com.rusl215.view.office.OfficeSaveView;
import com.rusl215.view.office.OfficeView;
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
    public List<OfficeListView> filterOffice(OfficeListFilterView filterView) {
        List<Office> allOfficesByOrgId = officeDao.getAllOfficesByFilter(filterView.orgId,filterView.name,filterView.phone,filterView.isActive);
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
    public void updateOffice(OfficeView officeView) {
        officeDao.updateOffice(officeView.id, officeView.name, officeView.address, officeView.phone, officeView.isActive);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveOffice(OfficeSaveView officeSaveView) {
        officeDao.insertOffice(officeSaveView.orgId, officeSaveView.name, officeSaveView.address, officeSaveView.phone, officeSaveView.isActive);
    }
}
