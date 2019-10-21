package com.lemycanh.geoquiz;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class GreenDaoGenerator {
    /**
     * Tự generator source code bằng hàm main
     * Link: https://www.codementor.io/sundayakinsete/integrating-greendao-into-your-android-application-yro5fzgtw
     */
    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        Schema schema = new Schema(1, "com.lemycanh.geoquiz"); // Your app package name and the (.db) is the folder where the DAO files will be generated into.
        schema.enableKeepSectionsByDefault();

        addTables(schema); // định nghĩa các table để generator ra

        try {
            new DaoGenerator().generateAll(schema,"../app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        addUserEntities(schema);
        // addPhonesEntities(schema);
    }

    // This is use to describe the colums of your table
    private static Entity addUserEntities(final Schema schema) {
        Entity user = schema.addEntity("Question");
        user.addLongProperty("id").primaryKey().autoincrement();
//        user.addIntProperty("user_id").notNull();
        user.addStringProperty("content").notNull();
        user.addBooleanProperty("answer");
//        user.addStringProperty("first_name");
//        user.addStringProperty("email");
        return user;
    }
}
