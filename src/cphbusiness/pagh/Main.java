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
            db.dbWriter(new DataModel("1", "jeg hedder KasperET"));
            db.dbWriter(new DataModel("2", "jeg hedder KasperTO"));
            db.dbWriter(new DataModel("3", "jeg hedder KasperTRE"));
            db.dbWriter(new DataModel("4", "jeg hedder KasperFIRE"));
            db.dbWriter(new DataModel("5", "jeg hedder KaspeFEMr"));
            db.dbWriter(new DataModel("52", "jeg hedder KasperToOGHalvtreds"));
            db.setIndexMap();

            System.out.println("her er find with index: " + db.findWithIndex(1));
            System.out.println("her er find with index: " + db.findWithIndex(3));
            System.out.println("her er find with index: " + db.findWithIndex(52));
            System.out.println("her er find with index: " + db.findWithIndex(1));

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
