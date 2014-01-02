package org.telegram.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import org.telegram.dao.User;
import org.telegram.dao.Dialog;

import org.telegram.dao.UserDao;
import org.telegram.dao.DialogDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig dialogDaoConfig;

    private final UserDao userDao;
    private final DialogDao dialogDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        dialogDaoConfig = daoConfigMap.get(DialogDao.class).clone();
        dialogDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        dialogDao = new DialogDao(dialogDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Dialog.class, dialogDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        dialogDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public DialogDao getDialogDao() {
        return dialogDao;
    }

}