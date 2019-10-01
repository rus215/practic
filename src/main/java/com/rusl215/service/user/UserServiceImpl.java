package com.rusl215.service.user;

import com.rusl215.dao.user.UserDao;
import com.rusl215.model.mapper.MapperFacade;
import com.rusl215.model.user.User;
import com.rusl215.view.success.SuccessResultView;
import com.rusl215.view.user.UserListView;
import com.rusl215.view.user.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private MapperFacade mapperFacade;

    @Autowired
    public UserServiceImpl(UserDao userDao, MapperFacade mapperFacade) {
        this.userDao = userDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserListView> filterUser(Long officeId, String firstName, String lastName, String middleName, String position, Long docCode, Long citizenshipCode) {
        List<User> userList = userDao.getUserList(officeId, firstName, lastName, middleName, position, docCode, citizenshipCode);
        return mapperFacade.mapAsList(userList, UserListView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public UserView userById(Long id) {
        return mapperFacade.map(userDao.getUserById(id), UserView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public SuccessResultView updateUser(Long id, Long officeId, String firstName, String secondName, String middleName, String position, String phone, String docName, String docNumber, String docDate, Long citizenshipCode, Boolean isIdentified) {
        userDao.updateUser(id,officeId, firstName,secondName,middleName,position,phone,docName,docNumber,docDate,citizenshipCode,isIdentified);
        return new SuccessResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public SuccessResultView saveUser(Long officeId, String firstName, String secondName, String middleName, String position, String phone, String docName, String docNumber, String docDate, Long citizenshipCode, Boolean isIdentified) {
        userDao.insertUser(officeId, firstName,secondName,middleName,position,phone,docName,docNumber,docDate,citizenshipCode,isIdentified);
        return new SuccessResultView();
    }
}
