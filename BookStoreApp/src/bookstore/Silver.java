/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

class Silver extends customerState {    
    @Override
    protected void setSilver(Customer A) { //checks if loyalty points of customer are less than 1000
        if(A.getPoints()< 1000){
            A.setStatus(new Silver());
          } 
        else 
          {
            setGold(A);
          }
    }

    @Override
    protected void setGold(Customer A) {   //checks if loyalty points of customer are equal to or greater than 1000
        if(A.getPoints()>= 1000) {
             A.setStatus(new Gold());
        } 
        else 
        {
            setSilver(A);
        }
    }

    @Override
    public String toString() {
        return "Silver";
    }
    
}
