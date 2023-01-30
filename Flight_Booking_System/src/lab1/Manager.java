package lab1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.ArrayList;




/**
 *
 * @author Sarim Shahwar
 */
public class Manager {
    ArrayList<Flight> flights;
    ArrayList<Ticket> tickets;
    
    public Manager(){
        flights = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public void createFlights(){
    int fn, cap; //flight number and Capaicty
    String og, des, dt; // Origin, Destination and Departure time
    double op; //original Price

    Scanner scan1 = new Scanner(System.in); // For the Int values
    Scanner scan2 = new Scanner(System.in); // For the String Values
    Scanner scan3 = new Scanner(System.in); // For the Double Values
    
        System.out.println("What is the Designated Flight Number");
        fn = scan1.nextInt(); //Flight Number
        System.out.println("What is the Flights Designated Capacity");
        cap = scan1.nextInt(); //Capacity
        
        System.out.println("What is the Flights Designated Orgin?");
        og = scan2.nextLine(); //Orgin
        System.out.println("What is the Flights Designated Destination?");
        des = scan2.nextLine(); //Destination
        System.out.println("What is the Flights Designated Departure Time?");
        dt = scan2.nextLine(); //Departure time
        
        System.out.println("What is the Flights Original Price?");
        op = scan3.nextDouble(); // Original Price
        
        
        
        Flight fl = new Flight(fn, cap, og, des, dt, op);
        flights.add(fl);
        
        System.out.println("The following flight has been created: ");
        System.out.println(fl);
        
        
    
    
    }
    public void displayAvailableFlights(String orgin, String destination){
       
        int seats;
        String og, des;
       
        System.out.println("Here are a list of Available Flights: ");
        for (int i=0; i<flights.size(); i++) {
            og = flights.get(i).getOrgin();
            des = flights.get(i).getDestination();
            seats = flights.get(i).getNumberOfSeatsLeft();
            
            if (og.equals(orgin) && des.equals(destination) && seats>0) {
                System.out.println(flights.get(i));
                               
            } else {
                System.out.println("There are no available Flights");
            }
            
        }
    }
    
    public Flight getFlight(int flightNumber){ 

        for (int i=0; i<flights.size(); i++){
            if (flightNumber == flights.get(i).getFlightNumber()){
                return flights.get(i);
            }
        }
        return null; //gets the flight number and puts in an array

    }
    
    public void bookSeat(int flightNumber, Passenger p){
        double price;

        for (int i=0; i<flights.size(); i++){
            if (flightNumber == flights.get(i).getFlightNumber()){

                if (flights.get(i).bookASeat() == true){
                flights.get(i).bookASeat();
                price = p.applyDiscount(flights.get(i).getOriginalPrice());
                Ticket t = new Ticket(p, flights.get(i), price);
                tickets.add(t);
                    System.out.println("A booking as been made for your desired flight!" + flightNumber);
                break;

                } else {

                    System.out.println("The flight you are trying to book is full. Apoligies for the inconvience.");

                }

            } else {

                System.out.println("The Flight you are searching for does not exist. Please try again.");

            }

        }

    }  
    
    public static void main(String[] args) { //Main class
        Manager mn = new Manager();
        Flight fl;
        Passenger p;
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        String input, des, og, na;

        int option = 0, user, fn, ag, yearsOfMembership;

        while(option!=5){
            
            System.out.println("Welcome! Please select one of the following options listed below!");
            System.out.println("Enter the number 1 below to create a flight");
            System.out.println("Enter the number 2 below to display all flights with a designated orgin and destination");
            System.out.println("Enter the number 3 below for the designated flight information via flight number");
            System.out.println("Enter the number 4 to book a seat for a designated flight via Flight Number");
            System.out.println("Enter the number 5 to exit the program");

            user = scan1.nextInt();
            switch (user) {
                
                case 1:
                    mn.createFlights();
                    break;
                    
                case 2:
                    System.out.println("Enter the flight's origin below: ");
                    og = scan1.nextLine();
                   
                    
                    System.out.println("Enter the flight's destination below: ");
                    des = scan1.nextLine();

                    mn.displayAvailableFlights(og, des);

                    break;
                    
                case 3:

                    System.out.println("Enter the flight number below: ");

                    fn = scan1.nextInt();

                    fl = mn.getFlight(fn);

                    if (fl == null) {

                        System.out.println("Flight " + fn + " does not exist. Please try again.");

                    } else{

                        System.out.println("The information for your Flight " + fn + " is as followed:");

                        System.out.println(fl);

                    }

                    break;
                
                case 4:

                    System.out.println("Enter the letter 'n' for non-member passenger and the letter 'm' for member");
                    input = scan2.nextLine();
                    System.out.println("");
                    
                     System.out.println("Enter the passenger's name:");
                        na = scan3.nextLine();
                        System.out.println("");

                            System.out.println("Enter the passenger's age:");
                            ag = scan3.nextInt();
                            System.out.println("");

                                System.out.println("Enter the flight number");
                                   fn = scan3.nextInt();

                    if (input.equals("n")) {

                        p = new NonMember(na, ag);

                        mn.bookSeat(fn, p);
                        

                    } else if (input.equals("m")) {

                        System.out.println("Enter the years of membership:");

                        yearsOfMembership = scan3.nextInt();

                        p = new Member(na, ag);

                        mn.bookSeat(fn, p);

                        System.out.println("");

                    }

                    break;
                    
                case 5:
                    return ;
                    
                    default:

                    System.out.println("Invalid input...Please try again");

            }

            System.out.println("");

            }
                    
            
        }
        
        
 
        
    }
    
    



