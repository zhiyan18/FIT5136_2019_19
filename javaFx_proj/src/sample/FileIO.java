package sample;

import java.io.*;
import java.util.Scanner;

public class FileIO {

    public static String readAccount(){
        String content = "";
        FileReader accounts =null;
        try {
            accounts= new FileReader("src\\sample\\userAccounts.txt");
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
        String[] lines = readAccount().split(";");
        for (String s : lines) {
            if (s.split(",")[0].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean pwCorrect(String name,String pw) {
        String[] lines = readAccount().split(";");
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
            BufferedWriter outFile = new BufferedWriter(new FileWriter("src\\sample\\userAccounts.txt",true)) ;
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

    }


