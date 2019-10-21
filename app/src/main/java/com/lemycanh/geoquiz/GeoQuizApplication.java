package com.lemycanh.geoquiz;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

public class GeoQuizApplication extends Application {
    private DaoSession daoSession;
    private  static GeoQuizApplication _instance = null;
    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"users-db"); //The users-db here is the name of our database.
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    /**
     * Hàm getDaoSession trả về daoSession
     *
     */
    public DaoSession getDaoSession() {
        return daoSession;
    }
//  tạo ra hàm reference tới GeoQuizApplication
    public static GeoQuizApplication Instance() {
        return _instance;
    }
}
