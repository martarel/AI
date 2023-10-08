package tour;

import search.*;
import java.util.Set;

public class MinMaxDistanceHeuristicFunction implements NodeFunction {
    private Cities cities;
    private City startCity;
    public MinMaxDistanceHeuristicFunction( Cities cities, City startCity) {
        this.cities = cities;
        this.startCity = startCity;
    }
    public int value(Node node) {
        TourState tourState = (TourState) node.state;
        City city = tourState.currentCity;
        int maxDistance = Integer.MIN_VALUE;
        Set<City> citiesToVisit = cities.getAllCities();
        citiesToVisit.removeAll(tourState.visitedCities);
        for (City otherCity : citiesToVisit) {
            int distance = city.getShortestDistanceTo(otherCity) + otherCity.getShortestDistanceTo(startCity);
            if (distance > maxDistance)
                maxDistance = distance;
        }
        return maxDistance;
    }
}
