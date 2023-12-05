package me.longluo.android.db.greendao;

import me.longluo.android.dao.StudentDao;


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
