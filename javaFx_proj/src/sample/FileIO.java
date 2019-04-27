package sample;

import java.io.*;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class FileIO {
static final String accountFile = "src\\sample\\userAccounts.txt";
    static final String restaurantFile = "src\\sample\\restaurants.txt";
    public static String readFile(String fileName){
        String content = "";
        FileReader accounts =null;
        try {
            accounts= new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner parse = new Scanner(accounts);
        while(parse.hasNextLine()){
            content +=parse.nextLine();
        }
        try {
            accounts.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static boolean accountExist(String name) {
        String[] lines = readFile(accountFile).split(";");
        for (String s : lines) {
            if (s.split(",")[0].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean pwCorrect(String name,String pw) {
        String[] lines = readFile(accountFile).split(";");
        for (String s : lines) {
            if (s.split(",")[0].equals(name) && s.split(",")[1].equals(pw)) {
                return true;
            }
        }
        return false;
    }

    public static void writeFile(String content)
    {

        try {
            BufferedWriter outFile = new BufferedWriter(new FileWriter(accountFile,true)) ;
            outFile.write(content+"\n");
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void register(String name,String pw,String ph,String add,String code)
    {
        String line = ""+name +","+pw+","+ph+","+add+","+code+";";
        writeFile(line);
    }

    public static String getRestName()
    {
        String names = "";

        try {
            JSONArray restList = new JSONArray(readFile(restaurantFile));
            int i = 0;
            while (i<restList.length())
            {
               names += restList.getJSONObject(i).getString("name")+"\n";
               i++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
         return names;
    }


    }


