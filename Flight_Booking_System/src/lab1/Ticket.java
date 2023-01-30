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


public class Ticket {
     private Passenger passenger;
     private Flight flight;
     private double price;
     private int ticketnumber;
     private static int number = 1;
    
public Ticket (Passenger p, Flight flight, double price) {
    this.passenger  = p;
    this. flight = flight;
    this.price = price;
    ticketnumber = number;
    number++;
    
}
public Passenger getPassenger(){
    return passenger;
}     
     
public void setPassenger(Passenger p){
    this.passenger = p;
}
public Flight getFlight(){
    return flight;
}     
     
public void setFlight(Flight fl){
    this.flight = fl;
}

public double getPrice(){
    return price;
}     
     
public void setPrice(double p){
    this.price = p;
}
public int getRicketNumber(){
    return ticketnumber;
}     
     
public void setTicketNumber(int tn){
    this.ticketnumber = tn;
}
@Override
public String toString() {
  return passenger.getName() + "," + flight + "," + price;
}

}
