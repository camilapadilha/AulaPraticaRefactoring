/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulapraticarefactoring;

import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Camila
 */
class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    private double amountFor(Rental aRental) {
        return aRental.getCharge();
    }

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrenquentRenterPoints();
        }
        return result;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getCharge()) + "\n";
            return result;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
                + " frequent renter points";
        return result;
    }
    public String htmlStatement() {
   Enumeration rentals = _rentals.elements();
   String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
   while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      // show figures for each rental
      result += each.getMovie().getTitle()+ ": " +
                String.valueOf(each.getCharge()) + "<BR>\n";
   }
   
   // add footer lines
   result +=  "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
   result += "On this rental you earned <EM>" +
          String.valueOf(getTotalFrequentRenterPoints()) +
          "</EM> frequent renter points<P>";
   return result;
}
}
