package me.longluo.android.db.greendao;

import me.longluo.android.entity.Student;

import org.greenrobot.greendao.AbstractDao;


public class StudentHelper extends BaseDbHelper<Student, Long> {

    public StudentHelper(AbstractDao dao) {
        super(dao);
    }
}
