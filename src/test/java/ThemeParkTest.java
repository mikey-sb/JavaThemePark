import attractions.*;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Attr;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    ThemePark themepark;
    ArrayList<Attraction> attractions;
    ArrayList<Stall> stalls;
    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollercoaster;
    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;
    Visitor visitor;
    ArrayList<Attraction> visitedAttractions;

    @Before
    public void before(){
        themepark = new ThemePark(attractions, stalls);
        dodgems = new Dodgems("The Slam Tent", 10);
        park = new Park("Hurley Burley", 8);
        playground = new Playground("Playarama", 6);
        rollercoaster = new RollerCoaster("Whitey Machine 3000", 10);
        candyflossStall = new CandyflossStall("Augustus Gloop", "Bob from the mafia", ParkingSpot.A1);
        iceCreamStall = new IceCreamStall("Mrs. Whippy ;)", "Colinetta", ParkingSpot.A2);
        tobaccoStall = new TobaccoStall("Smokey Joe", "Helvetica", ParkingSpot.A3);
        visitedAttractions = new ArrayList<>();
        visitor = new Visitor(25, 180, 100, visitedAttractions);
    }

    @Test
    public void hasAttractionsLoaded() {
        themepark.addAttractions(dodgems);
        themepark.addAttractions(park);
        themepark.addAttractions(playground);
        themepark.addAttractions(rollercoaster);
        assertEquals(4, themepark.getAttractions().size());
    }

    @Test
    public void hasStallsLoaded() {
        themepark.addStall(candyflossStall);
        themepark.addStall(iceCreamStall);
        themepark.addStall(tobaccoStall);
        assertEquals(3, themepark.getStalls().size());
    }

    @Test
    public void attractionsCanBeVisitedAndIncremented() {
        themepark.addAttractions(dodgems);
        themepark.addAttractions(park);
        themepark.addAttractions(playground);
        themepark.addAttractions(rollercoaster);
        themepark.addStall(candyflossStall);
        themepark.addStall(iceCreamStall);
        themepark.addStall(tobaccoStall);
        themepark.visit(visitor, dodgems);
        assertEquals(1, visitor.getVisitedAttractions().size());
        assertEquals(1, dodgems.getVisitCount());
    }

}
