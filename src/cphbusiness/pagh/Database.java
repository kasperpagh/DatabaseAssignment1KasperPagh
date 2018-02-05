package cphbusiness.pagh;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Database
{
    HashMap<String, String> indexMap = Main.indexMap;

    public boolean dbWriter(DataModel data)
    {
        File file;
        file = new File("data");
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        try (FileOutputStream fop = new FileOutputStream(file, true))
        {
            if (finder(Integer.parseInt(data.getKey())) == null)
            {
                String sData = data.toString();
                byte[] bytes = sData.getBytes("US-ASCII");
                StringBuilder binary = new StringBuilder();
                for (byte b : bytes)
                {
                    int val = b;
                    for (int i = 0; i < 8; i++)
                    {
                        binary.append((val & 128) == 0 ? 0 : 1);
                        val <<= 1;
                    }
                }
                fop.write(binary.toString().getBytes("US-ASCII"));
                fop.flush();
                fop.close();
            }
            else
            {
                return false;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return true;

    }


    public String dbReader() throws UnsupportedEncodingException
    {
        File file;
        file = new File("data");

        System.out.println("her er len: " + file.length());
        byte[] result = new byte[(int) file.length()];
        try
        {
            InputStream input = null;
            try
            {
                int totalBytesRead = 0;
                input = new BufferedInputStream(new FileInputStream(file));
                while (totalBytesRead < result.length)
                {
                    int bytesRemaining = result.length - totalBytesRead;
                    int bytesRead = input.read(result, totalBytesRead, bytesRemaining);
                    if (bytesRead > 0)
                    {
                        totalBytesRead = totalBytesRead + bytesRead;
                    }
                }
            }
            finally
            {
                input.close();
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        String res = new String(result, "US-ASCII");
        int splitSize = 8;

        if (res.length() % splitSize == 0) //tjekker om antallet af bits, går op med 8 (altså bytes)
        {
            int index = 0;
            int position = 0;

            byte[] resultByteArray = new byte[res.length() / splitSize];
            StringBuilder text = new StringBuilder(res);

            while (index < text.length())
            {
                String binaryStringChunk = text.substring(index, Math.min(index + splitSize, text.length()));
                Integer byteAsInt = Integer.parseInt(binaryStringChunk, 2);
                resultByteArray[position] = byteAsInt.byteValue();
                index += splitSize;
                position++;
            }

            return new String(resultByteArray, "US-ASCII");
        }
        else
        {
            return "not mod 8";
        }

    }

    public String finder(int key) throws UnsupportedEncodingException
    {
        Pattern pattern = Pattern.compile("#" + key + ",(.*?)#");
        String toMatch = dbReader();
        Matcher m = pattern.matcher(toMatch);
        String retS = null;
        while (m.find())
        {
            retS = m.group(0);
        }

        if (retS == null || retS.equalsIgnoreCase(""))
        {
            return null;
        }
        else
        {
            return retS;
        }
    }

    public String findWithIndex(int key)
    {
//        int index = indexMap.get("" + key);
//        dbReader();
        return "";
    }


    public void setIndexMap() throws UnsupportedEncodingException
    {
        String db = dbReader();
        indexMap = new HashMap<>();
        List<String> keys = new ArrayList<>();
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(db);
        System.out.println("her er bob " + db);

        while (m.find())
        {
            keys.add(m.group());
        }

        char[] chars = db.toCharArray(); //FUUUUUUUUUUUUUUUUUUUUUUUUUUUCKKK

        for (int i = 0; i < keys.size(); i++)
        {
            for (int a = 0; a < chars.length; a++)
            {
                if (keys.get(i).charAt(0) == chars[a])
                {
                    System.out.println("first if");
                    indexMap.put(keys.get(i), (a * 8) - 8 + "");
                    if (i > 0)
                    {

                }
                }
            }
        }


        System.out.println("her er keys: " + indexMap.toString() + " llama " + indexMap.get("2"));

    }
}
