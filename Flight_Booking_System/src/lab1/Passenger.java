/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author sarim
 */
 
public abstract class Passenger {
private String name;
private int age;
public abstract double applyDiscount(double p);
public Passenger (String na, int ag){
    this.name = na;
    this.age = ag;
   
}
public String getName(){
    return name;
}
public void setName(String na){
    this.name = na;
}
public int getAge(){
    return age;
}
public void setAge(int ag){
    this.age = ag;
}



}
