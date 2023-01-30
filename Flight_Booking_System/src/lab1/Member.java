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
public class Member extends Passenger{
     int yearsOfMembership;
    

    public Member(String na, int ag){
        super(na, ag);
       
    }
    @Override
    public double applyDiscount(double p){
        if (yearsOfMembership > 5 ) {
            return (p*0.5);
        }
        else if (yearsOfMembership > 1 && yearsOfMembership <= 5) {
            return (p*0.1);
        }
        else {
            return p;
        }
}

}