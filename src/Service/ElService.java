/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Employee;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author trung
 */
public class ElService {

    ArrayList<Employee> dsE = new ArrayList<>();
    private String path = "C:\\Users\\trung\\OneDrive\\Documents\\NetBeansProjects\\asm\\src\\File.txt";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public void addData(Employee e) {
        dsE.add(e);
    }

    public ArrayList<Employee> getData() {
        return dsE;
    }

    ////valid func
    public boolean IsEmail(String em) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(em);
        return matcher.matches();
    }

    public boolean isDob(String em) {
        Boolean isPass;
        try {
            Double.parseDouble(em);
            isPass = true;
        } catch (Exception e) {
            isPass = false;
        }
        return isPass;
    }

    public boolean isBir(String em) {
        Boolean isPass = false;
        try {
            int d = Integer.parseInt(em);
            
            if (d > 16 && d < 55) {
                isPass = true;
            }else{
                isPass = false;
            }
        } catch (Exception e) {
            isPass = false;
        }

        return isPass;
    }

    ///end valid func
    public void exit() {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dsE);
            fos.close();
            oos.close();
            System.exit(0);
        } catch (Exception e) {

        }

    }
}
