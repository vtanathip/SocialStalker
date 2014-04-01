package com.martroutine.android.socialstalker.greendao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class DAOGenerator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.martroutine.android.socialstalker.greendao");

        addPeopleStalked(schema);

        new DaoGenerator().generateAll(schema, "app/src-gen");
    }

    private static void addPeopleStalked(Schema schema) {
        Entity note = schema.addEntity("People");
        note.addIdProperty();
        note.addStringProperty("name").notNull();
        note.addStringProperty("url");
    }

}
