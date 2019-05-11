package sample;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class FileIO {
    static final String accountFile = "src\\sample\\userAccounts.txt";
    static final String orderFile = "src\\sample\\orderHistory.txt";
    static final String restaurantFile = "src\\sample\\restaurants.txt";

    public static String readFile(String fileName) {
        String content = "";
        FileReader accounts = null;
        try {
            accounts = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner parse = new Scanner(accounts);
        while (parse.hasNextLine()) {
            content += parse.nextLine();
        }
        try {
            accounts.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static String getOrderHis() {
        String result = "";
        String temp = readFile(orderFile);
        result = "[" + temp + "]";
        return result;
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

    public static boolean pwCorrect(String name, String pw) {
        String[] lines = readFile(accountFile).split(";");
        for (String s : lines) {
            if (s.split(",")[0].equals(name) && s.split(",")[1].equals(pw)) {
                return true;
            }
        }
        return false;
    }

    public static void writeFile(String content, String file) {

        try {
            BufferedWriter outFile = new BufferedWriter(new FileWriter(file, true));
            outFile.write(content + "\n");
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void register(String name, String pw, String ph, String add, String code, String email) {
        String line = ";" + name + "," + pw + "," + ph + "," + add + "," + code + "," + email + "";
        writeFile(line, accountFile);
    }

    public static void placeOrder(String line) {
        writeFile("," + line, orderFile);
    }

    public static String getRestInfo(String key, int i) {
        String result = "";

        try {
            JSONArray restList = new JSONArray(readFile(restaurantFile));
            if (i < restList.length()) {
                result = restList.getJSONObject(i).getString(key);

            } else
                result = "";

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getRestMenu(String restName) {
        String allFoodName = "";
        try {
            JSONArray restList = new JSONArray(readFile(restaurantFile));
            int i = 0;
            while (i < restList.length()) {
                if (getRestInfo("name", i).equals(restName)) {
                    JSONArray menuArr = restList.getJSONObject(i).getJSONArray("menu");
                    int j = 0;
                    while (j < menuArr.length()) {
                        allFoodName += menuArr.getJSONObject(j).getString("foodName") + "\n";
                        j++;
                    }
                    break;
                }
                i++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return allFoodName;
    }

    public static String[] getAllRestName() {
        String result = "";
        int i = 0;

        while (!getRestInfo("name", i).equals("")) {
            result += getRestInfo("name", i) + "\n";
            i++;
        }

        return result.split("\n");
    }

    public static JSONObject getRestObj(String restName) {
        JSONObject rest = new JSONObject();
        try {
            JSONArray restList = new JSONArray(readFile(restaurantFile));
            for (int i = 0; i < restList.length(); i++) {
                if (restList.getJSONObject(i).getString("name").equals(restName)) {
                    rest = restList.getJSONObject(i);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rest;
    }

    public static JSONObject getFoodObj(String foodName, String restName) {
        JSONObject food = new JSONObject();
        try {
            JSONArray foodList = getRestObj(restName).getJSONArray("menu");
            for (int i = 0; i < foodList.length(); i++) {
                if (foodList.getJSONObject(i).getString("foodName").equals(foodName)) {
                    food = foodList.getJSONObject(i);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return food;
    }


    public String[] getAllFoodName() {
        String result = "";
        int i = 0;

        while (!getRestInfo("food", i).equals("")) {
            result += getRestInfo("name", i) + ";";
            i++;
        }

        return result.split("\n");

    }

    public static String getUserInfo(String name) {
        String result = "";
        String[] lines = readFile(accountFile).split(";");
        for (String s : lines) {
            if (s.split(",")[0].equals(name)) {
                result = s;
            }
        }
        return result;

    }

    public static void deleteUser(String name) {

        String[] lines = readFile(accountFile).split(";");
        for (String s : lines) {
            if (s.split(",")[0].equals(name)) {
                try {
                    System.out.println(s);
                    removeLine(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void removeLine(String lineContent) throws IOException {
        File file = new File(accountFile);
        File temp = new File("_temp_");
        PrintWriter out = new PrintWriter(new FileWriter(temp));
        Files.lines(file.toPath())
                .filter(line -> !line.contains(lineContent))
                .forEach(out::println);
        out.flush();
        out.close();
        temp.renameTo(file);
    }

    public static void updateUser(String name, String content) {
        String[] lines = readFile(accountFile).split(";");
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].split(",")[0].equals(name)) {
                lines[i] = content;
                break;
            }
        }
        String newfile = String.join(";", lines);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(accountFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.println(newfile);
        pw.close();
    }
}
