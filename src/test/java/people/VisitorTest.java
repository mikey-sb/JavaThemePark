package people;

import attractions.*;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    ArrayList<Attraction> attractions;
    Visitor visitor;
    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollercoaster;
    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;

    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0, attractions);
        dodgems = new Dodgems("The Slam Tent", 10);
        park = new Park("Hurley Burley", 8);
        playground = new Playground("Playarama", 6);
        rollercoaster = new RollerCoaster("Whitey Machine 3000", 10);
        candyflossStall = new CandyflossStall("Augustus Gloop", "Bob from the mafia", ParkingSpot.A1);
        iceCreamStall = new IceCreamStall("Mrs. Whippy ;)", "Colignetta", ParkingSpot.A2);
        tobaccoStall = new TobaccoStall("Smokey Joe", "Helvetica", ParkingSpot.A3);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }

    @Test
    public void canVisitAttractions(){
        visitor.addVisitedAttraction(dodgems);
        visitor.addVisitedAttraction(park);
        assertEquals(2, visitor.getVisitedAttractions().size());
    }

}
