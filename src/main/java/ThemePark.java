import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.IceCreamStall;
import stalls.Stall;

import java.util.ArrayList;
import java.util.Collection;

public class ThemePark implements IReviewed {
    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;

    public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls) {
        this.attractions = new ArrayList<Attraction>();
        this.stalls = new ArrayList<Stall>();
    }

    public void addAttractions(Attraction attraction){
        attractions.add(attraction);
    }

    public void addStall(Stall stall) {
        stalls.add(stall);
    }

    @Override
    public int getRating() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public ArrayList<Stall> getStalls() {
        return stalls;
    }

    public void visit(Visitor visitor, Attraction attraction){
        visitor.addVisitedAttraction(attraction);
        attraction.incrementVisitCountBy1();
    }

}
