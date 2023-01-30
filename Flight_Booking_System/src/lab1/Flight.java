/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Sarim Shahwar
 */

public class Flight {
	  public int flightNumber, capacity, numberOfSeatsLeft;
	    public double originalPrice;
	    public String orgin, destination, departureTime;

	    //Created instant variables for the flight class
	    
public Flight(int fn, int cap, String og, String des, String dt, double op) {
    try {
    if (og.equals(des)){
        throw new IllegalArgumentException("The orgin and destination cannot be the same");
                } 
    else {
     
    flightNumber = fn;
    orgin = og;
    destination = des;
    departureTime = dt;
    numberOfSeatsLeft = cap;
    capacity = cap;
    originalPrice = op;
    }
    } catch (IllegalArgumentException e) {
		
    		System.out.println(e);
            }
    }

  public int getFlightNumber(){
	return flightNumber;
  }
  public  void setFlightNumber(int fn){
       flightNumber = fn;
  }
  //Getter and Setter for each instance variable
  
  public int getCapacity() {
	  return capacity;
}
   public void setCapacity(int cap) {
	  capacity = cap;	  
}
   //Getter and Setter for each instance variable
  
  public String getOrgin() {
	  return orgin;
  }
  public void setOrgin(String og) {
	  orgin = og;
  }
  //Getter and Setter for each instance variable
  
  public String getDestination() {
	  return destination;
  }
  public void setDestination(String des) {
	  destination = des;
  }
  //Getter and Setter for each instance variable
  
  public String getDepartureTime() {
	  return departureTime;
  }
  public void setDepartureTime(String dt) {
	  departureTime = dt;
  }
  //Getter and Setter for each instance variable
  public int getNumberOfSeatsLeft() {
	  return numberOfSeatsLeft;
  }
  public  void setNumberOfSeatsLeft(int nsl) {
	  numberOfSeatsLeft = nsl;
  }
  //Getter and Setter for each instance variable
  
  public double getOriginalPrice() {
	  return originalPrice;
  }
  public  void setOriginalPrice(double op) {
	  originalPrice = op;
  }
  //Getter and Setter for each instance variable
  
  public boolean bookASeat() {
	if (numberOfSeatsLeft > 0) {
		numberOfSeatsLeft --;
		return true;
		
	}	
return false;
}
  
  @Override
  public String toString() {
	 return "Flight " + flightNumber + ", " + orgin + " to " + destination + ", " + departureTime + ", " + originalPrice;
	  
  }
    public static void main(String[] args) { // Sample test to ensure the flight is created with the desired inputs
		// TODO Auto-generated method stub
		
		Flight test = new Flight(1030, 100, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000.00);
		
		System.out.println(test.toString());
    }
}




