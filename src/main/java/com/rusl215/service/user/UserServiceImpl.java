package com.rusl215.service.user;

import com.rusl215.dao.user.UserDao;
import com.rusl215.model.mapper.MapperFacade;
import com.rusl215.model.user.User;
import com.rusl215.view.success.SuccessResultView;
import com.rusl215.view.user.UserListFilterView;
import com.rusl215.view.user.UserListView;
import com.rusl215.view.user.UserSaveView;
import com.rusl215.view.user.UserUpdateView;
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
    public List<UserListView> filterUser(UserListFilterView userListFilterView) {
        List<User> userList = userDao.getUserList(userListFilterView.officeId, userListFilterView.firstName, userListFilterView.lastName, userListFilterView.middleName, userListFilterView.position, userListFilterView.docCode, userListFilterView.citizenshipCode);
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
    public SuccessResultView updateUser(UserUpdateView userUpdateView) {
        userDao.updateUser(userUpdateView.id, userUpdateView.officeId, userUpdateView.firstName, userUpdateView.secondName, userUpdateView.middleName, userUpdateView.position, userUpdateView.phone, userUpdateView.docName, userUpdateView.docNumber, userUpdateView.docDate, userUpdateView.citizenshipCode, userUpdateView.isIdentified);
        return new SuccessResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public SuccessResultView saveUser(UserSaveView userSaveView) {
        userDao.insertUser(userSaveView.officeId, userSaveView.firstName, userSaveView.secondName, userSaveView.middleName, userSaveView.position, userSaveView.phone, userSaveView.docName, userSaveView.docNumber, userSaveView.docDate, userSaveView.citizenshipCode, userSaveView.isIdentified);
        return new SuccessResultView();
    }
}
