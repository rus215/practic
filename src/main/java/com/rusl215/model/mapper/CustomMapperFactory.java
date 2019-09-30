package com.rusl215.model.mapper;

import com.rusl215.model.user.User;
import com.rusl215.view.user.UserView;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

/**
 * Фабрика для создания MapperFactory
 */
@Service
public class CustomMapperFactory implements FactoryBean<MapperFactory> {
    @Override
    public MapperFactory getObject() throws Exception {
        DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder()
                .constructorResolverStrategy(null)
                .build();

        mapperFactory.classMap(User.class, UserView.class)
                .field("doc.docType.name", "docName")
                .field("doc.docNumber", "docNumber")
                .field("doc.docDate", "docDate")
                .field("doc.isIdentified", "isIdentified")
                .field("country.code", "citizenshipCode")
                .field("country.name", "citizenshipName")
                .byDefault()
                .register();

        return mapperFactory;
    }

    @Override
    public Class<?> getObjectType() {
        return MapperFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
