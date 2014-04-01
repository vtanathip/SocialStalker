package com.martroutine.android.socialstalker.greendao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.martroutine.android.socialstalker.greendao.People;

import com.martroutine.android.socialstalker.greendao.PeopleDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig peopleDaoConfig;

    private final PeopleDao peopleDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        peopleDaoConfig = daoConfigMap.get(PeopleDao.class).clone();
        peopleDaoConfig.initIdentityScope(type);

        peopleDao = new PeopleDao(peopleDaoConfig, this);

        registerDao(People.class, peopleDao);
    }
    
    public void clear() {
        peopleDaoConfig.getIdentityScope().clear();
    }

    public PeopleDao getPeopleDao() {
        return peopleDao;
    }

}
