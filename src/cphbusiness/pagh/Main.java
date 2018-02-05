package cphbusiness.pagh;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main
{
    static HashMap<String, String> indexMap;

    public static void main(String[] args)
    {
        Database db = new Database();

        try
        {
            db.dbWriter(new DataModel("1", "jeg hedder Kasper"));
            db.dbWriter(new DataModel("2", "jeg hedder Kasper"));
            db.dbWriter(new DataModel("3", "jeg hedder Kasper"));
            db.dbWriter(new DataModel("4", "jeg hedder Kasper"));
            db.dbWriter(new DataModel("5", "jeg hedder Kasper"));
            db.setIndexMap();

        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        finally
        {
        }
    }
}
