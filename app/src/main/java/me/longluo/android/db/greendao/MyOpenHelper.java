package me.longluo.android.db.greendao;

import android.content.Context;
import android.util.Log;

import me.longluo.android.dao.DaoMaster;
import me.longluo.android.dao.StudentDao;

import org.greenrobot.greendao.database.Database;


public class MyOpenHelper extends DaoMaster.OpenHelper {

    public MyOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.d("Test", "db version update from " + oldVersion + " to " + newVersion);

        switch (oldVersion) {
            case 1:
                StudentDao.createTable(db, true);
                db.execSQL("ALTER TABLE 'STUDENT' ADD 'SCORE' TEXT;");
                break;

            default:
                break;
        }
    }
}
