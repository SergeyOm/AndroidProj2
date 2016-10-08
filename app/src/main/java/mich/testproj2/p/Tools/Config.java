package mich.testproj2.p.Tools;

import java.util.ArrayList;
import java.util.List;

import mich.testproj2.p.model.Person;

/**
 * Created by michigan on 10/07/2016.
 */

public class Config {
    public static final String LOG_TAG = "myLogs";

    public static final String KEY_ID = "id";
    public static final String KEY_NAME_COLUMN = "NAME_COLUMN";
    public static final String KEY_SURNAME_COLUMN = "SURNAME_COLUMN";
    public static final String KEY_AGE_COLUMN = "AGE_COLUMN";

    public static final int DB_VERSION = 10;
    public static final String DB_NAME = "myDB";

    public List<Person> persons = new ArrayList<Person>();
}
