package cphbusiness.pagh;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Db2
{
    FileOutputStream fout;
    FileInputStream fin;

    AppendingObjectOutputStream oos;
    ObjectInputStream ois;

    public void writer(List<DataModel> dat) throws IOException
    {
        fout = new FileOutputStream("data");
        oos = new AppendingObjectOutputStream(fout);
        try
        {

            for (int i = 0; i < dat.size(); i++)
            {
                oos.writeObject(dat);
            }

            oos.close();
            fout.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public HashMap indexer()
    {
        HashMap<String, String> indexMap = null;
        try
        {
            indexMap = new HashMap();

            List<DataModel> ret;
            ret = (List<DataModel>) ois.readObject();

            System.out.println("her er ret: " + ret);
            return indexMap;
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }

    }
}
