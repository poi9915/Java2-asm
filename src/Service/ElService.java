/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Employee;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author trung
 */
public class ElService implements Serializable{

    public static ArrayList<Employee> dsE = new ArrayList<>();
    private String path = "C:\\Users\\trung\\OneDrive\\Documents\\NetBeansProjects\\asm\\src\\File.txt";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    
    public void testData(){
        dsE.add(new Employee("p01" ,"trung" ,26,"trung01@gmail.com",60000));
        dsE.add(new Employee("p02" ,"trung" ,26,"trung01@gmail.com",60000));
        dsE.add(new Employee("p03" ,"trung" ,26,"trung01@gmail.com",60000));
        dsE.add(new Employee("p04" ,"trung" ,26,"trung01@gmail.com",60000));
    }
    public boolean updateData(Employee NV){
        boolean isFind =false;
        String name =NV.getName();
        String em = NV.getEmail();
        int t = NV.getTuoi();
        double l = NV.getLuong();
        
        for (Employee ele : dsE) {
            if (ele.getMaNV().equals(NV.getMaNV())) {
                isFind = true;
                ele.setName(name);
                ele.setTuoi(t);
                ele.setEmail(em);
                ele.setLuong(l);
            }
        }
        return isFind;
    }
    public void addData(Employee e) {
        dsE.add(e);
    }
    public void removeData(Employee e){
        dsE.remove(e);
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
        Boolean isPass = false;
        try {
            Double d = Double.parseDouble(em);
            if ( d >5000.000) {
                isPass = true;
            }   
        } catch (NumberFormatException e) {
          return isPass;
        }
        return isPass;
    }

    public boolean isBir(String em) {
        Boolean isPass = false;
        try {
            int d = Integer.parseInt(em);
            
            if (d > 16 && d < 55) {
                isPass = true;
            }
        } catch (NumberFormatException e) {
            isPass = false;
        }

        return isPass;
    }

    ///end valid func
    public void exit() {
        saveData();
        System.exit(0);

    }
    public void saveData(){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dsE);
            fos.close();
            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void openData(){
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            dsE = (ArrayList<Employee>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
        }
    }
}
