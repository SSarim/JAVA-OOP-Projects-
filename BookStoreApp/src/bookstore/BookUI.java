/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.CheckBox;

public class BookUI {
    
    public class book {

        private String title;
        private int price;
        private CheckBox selected;

        private book(int p, String t){
            this.title = t;
            this.price = p;
            this.selected = new CheckBox();

        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public CheckBox getSelected() {
            return selected;
        }

        public void setSelected(CheckBox selected) {
            this.selected = selected;
        }
        
        @Override
        public String toString(){
            return ""+price+"#$"+title+"\n";
        }
    }
    
    ArrayList<book> bookDB;

    private BookUI(){
        bookDB = new ArrayList<book>();
        reload();
    }
    
    static BookUI instance;
    
    public static BookUI getInstance() {
        if (instance == null)
            instance = new BookUI();
        return instance;
    }

    public boolean reload(){
        try {
            BufferedReader read = new BufferedReader(new FileReader("books.txt"));
            String s;
            while((s = read.readLine()) != null){
                createBook(Integer.parseInt(s.split("#\\$")[0]), s.split("#\\$")[1]);
            }
            read.close();
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean export(){
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter("books.txt", false));
            for(book x: bookDB){
                write.append(x.toString(), 0, x.toString().length());
                System.out.println(x.toString());
            }
            write.close();
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }
    
    public void createBook(int p, String t){
        bookDB.add(new book(p,t));
    }
    
    public void removeBook(int p, String t){
        int index = -1;
        for(book x: bookDB){
                if (x.getPrice() == p && x.getTitle().equals(t)){
                    index = bookDB.indexOf(x);
                }
            }
        bookDB.remove(bookDB.get(index));
    }
    
    public ArrayList<book> getBookDB(){
        //expose the rep
        return bookDB;
    }   
}