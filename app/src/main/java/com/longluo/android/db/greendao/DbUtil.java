package com.longluo.android.db.greendao;

import com.longluo.android.dao.gen.StudentDao;


public class DbUtil {
    private static StudentHelper sStudentHelper;

    private static StudentDao getDriverDao() {
        return DbCore.getDaoSession().getStudentDao();
    }

    public static StudentHelper getDriverHelper() {
        if (sStudentHelper == null) {
            sStudentHelper = new StudentHelper(getDriverDao());
        }

        return sStudentHelper;
    }
}
