/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

import lab1.Flight;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sarim Shahwar
 */
public class FlightTest {
    
    public FlightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFlightNumber method, of class Flight.
     */
    @Test
    public void testConstructor(){

        Flight f = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);

        assertEquals(1030,f.getFlightNumber());

        assertEquals(300,f.getCapacity());

        assertEquals("Toronto", f.getOrgin());

        assertEquals("Kolkata", f.getDestination());

        assertEquals("03/02/99 7:50 pm", f.getDepartureTime());

        assertEquals(1000,f.getOriginalPrice(),0.01);

    }
     @Test (expected = IllegalArgumentException.class)

    public void testInvalidConstructor(){

        Flight f = new Flight(1030, 350, "Toronto", "Toronto", "03/02/99 7:50 pm", 520);

    }
    
    @Test
    public void testGetFlightNumber() {
        System.out.println("getFlightNumber");
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);
        int expResult = 1030;
        int result = instance.getFlightNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFlightNumber method, of class Flight.
     */
    @Test
    public void testSetFlightNumber() {
        System.out.println("setFlightNumber");
        int fn = 1030;
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);
        instance.setFlightNumber(fn);
        assertTrue(fn == instance.getFlightNumber());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCapacity method, of class Flight.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);
        int expResult = 300;
        int result = instance.getCapacity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCapacity method, of class Flight.
     */
    @Test
    public void testSetCapacity() {
        System.out.println("setCapacity");
        int cap = 300;
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);
        instance.setCapacity(cap);
        assertTrue(cap == instance.getCapacity());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrgin method, of class Flight.
     */
    @Test
    public void testGetOrgin() {
        System.out.println("getOrgin");
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);
        String expResult = "Toronto";
        String result = instance.getOrgin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrgin method, of class Flight.
     */
    @Test
    public void testSetOrgin() {
        System.out.println("setOrgin");
        String og = "Mexico";
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);
        instance.setOrgin(og);
        assertTrue(instance.getOrgin().equals(og));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDestination method, of class Flight.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);
        String expResult = "Kolkata";
        String result = instance.getDestination();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDestination method, of class Flight.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        String des = "Canada";
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);
        instance.setDestination(des);
        assertTrue(instance.getDestination().equals(des));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDepartureTime method, of class Flight.
     */
    @Test
    public void testGetDepartureTime() {
        System.out.println("getDepartureTime");
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);
        String expResult = "03/02/99 7:50 pm";
        String result = instance.getDepartureTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDepartureTime method, of class Flight.
     */
    @Test
    public void testSetDepartureTime() {
        System.out.println("setDepartureTime");
        String dt = "08/06/21 9:30 am";
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);
        instance.setDepartureTime(dt);
        assertTrue(instance.getDepartureTime().equals(dt));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testGetNumberOfSeatsLeft() {
        System.out.println("getNumberOfSeatsLeft");
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);
        int expResult = 300;
        int result = instance.getNumberOfSeatsLeft();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testSetNumberOfSeatsLeft() {
        System.out.println("setNumberOfSeatsLeft");
        int nsl = 300;
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);
        instance.setNumberOfSeatsLeft(nsl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOriginalPrice method, of class Flight.
     */
    @Test
    public void testGetOriginalPrice() {
        System.out.println("getOriginalPrice");
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000.50);
        double expResult = 1000.50;
        double result = instance.getOriginalPrice();
        assertEquals(expResult, result, 0.01);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOriginalPrice method, of class Flight.
     */
    @Test
    public void testSetOriginalPrice() {
        System.out.println("setOriginalPrice");
        double op = 1120.50;
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1120.50);
        instance.setOriginalPrice(op);
        assertTrue(instance.getOriginalPrice() == op);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bookASeat method, of class Flight.
     */
    @Test
    public void testBookASeat() {
        System.out.println("bookASeat");
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);
        instance.setNumberOfSeatsLeft(3);
        boolean expResult = true;
        boolean result = instance.bookASeat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Flight instance = new Flight(1030, 300, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000);
        String expResult = "Flight 1030, Toronto to Kolkata, 03/02/99 7:50 pm, 1000.0";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
