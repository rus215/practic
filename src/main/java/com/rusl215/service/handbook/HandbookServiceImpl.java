package com.rusl215.service.handbook;

import com.rusl215.dao.handbook.HandbookDao;
import com.rusl215.model.country.Country;
import com.rusl215.model.doc.DocType;
import com.rusl215.model.mapper.MapperFacade;
import com.rusl215.view.handbook.HandbookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HandbookServiceImpl implements HandbookService {
    private HandbookDao handbookDao;
    private MapperFacade mapperFacade;

    @Autowired
    public HandbookServiceImpl(HandbookDao handbookDao, MapperFacade mapperFacade) {
        this.handbookDao = handbookDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<HandbookView> countries() {
        List<Country> allCountries = handbookDao.getAllCountries();
        return mapperFacade.mapAsList(allCountries, HandbookView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<HandbookView> docs() {
        List<DocType> allDocs = handbookDao.getAllDocs();
        return mapperFacade.mapAsList(allDocs, HandbookView.class);
    }
}
