import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase
{
    List<Station> route;
    List<Station> routeTwo;
    List<Station> routeOne;
    StationIndex stationIndex;
    RouteCalculator calculator;
    List<Station> redBlue;
    List<Station> redYellow;
    List<Station> blueYellow;



    @Override
    protected void setUp() throws Exception
    {
        stationIndex = new StationIndex();
        Line redLine = new Line(1,"Красная");
        Line blueLine = new Line(2,"Голубая");
        Line yellowLine = new Line(3,"Жултая");

        Station leninStation = new Station("Ленина",redLine);
        Station stalinStation = new Station("Сталина",redLine);
        Station brejnevStation = new Station("Брежнева",redLine);
        Station hruschStation = new Station("Хрущева",redLine);
        Station gorbStation = new Station("Горбачева",redLine);
        Station fredStation = new Station("Фредина",blueLine);
        Station eltonStation = new Station("Элтона",blueLine);
        Station chuckStation = new Station("Чака",blueLine);
        Station kevinStation = new Station("Кевина",blueLine);
        Station riverStation = new Station("Речная",yellowLine);
        Station submarineStation = new Station("Подводного флота",yellowLine);

        redBlue = new ArrayList<>();
        redBlue.add(0,stalinStation);
        redBlue.add(1,fredStation);
        redYellow = new ArrayList<>();
        redYellow.add(0,hruschStation);
        redYellow.add(1,riverStation);
        blueYellow = new ArrayList<>();
        blueYellow.add(0,chuckStation);
        blueYellow.add(1,submarineStation);

        stationIndex.addLine(redLine);
        stationIndex.addLine(blueLine);
        stationIndex.addLine(yellowLine);

        stationIndex.addConnection(redBlue);
        stationIndex.addConnection(redYellow);
        stationIndex.addConnection(blueYellow);

        stationIndex.addStation(leninStation);
        stationIndex.addStation(stalinStation);
        stationIndex.addStation(brejnevStation);
        stationIndex.addStation(hruschStation);
        stationIndex.addStation(gorbStation);
        stationIndex.addStation(fredStation);
        stationIndex.addStation(eltonStation);
        stationIndex.addStation(chuckStation);
        stationIndex.addStation(kevinStation);
        stationIndex.addStation(riverStation);
        stationIndex.addStation(submarineStation);

        redLine.addStation(leninStation);
        redLine.addStation(stalinStation);
        redLine.addStation(brejnevStation);
        redLine.addStation(hruschStation);
        redLine.addStation(gorbStation);
        blueLine.addStation(fredStation);
        blueLine.addStation(eltonStation);
        blueLine.addStation(chuckStation);
        blueLine.addStation(kevinStation);
        yellowLine.addStation(submarineStation);
        yellowLine.addStation(riverStation);

        calculator = new RouteCalculator(stationIndex);

        //============================================================

        route = new ArrayList<>();
        route.add(gorbStation);
        route.add(hruschStation);
        route.add(brejnevStation);
        route.add(stalinStation);
        route.add(leninStation);

        routeOne = new ArrayList<>();
        routeOne.add(gorbStation);
        routeOne.add(hruschStation);
        routeOne.add(brejnevStation);
        routeOne.add(stalinStation);
        routeOne.add(fredStation);
        routeOne.add(eltonStation);

        routeTwo = new ArrayList<>();
        routeTwo.add(gorbStation);
        routeTwo.add(hruschStation);
        routeTwo.add(riverStation);
        routeTwo.add(submarineStation);
        routeTwo.add(chuckStation);
        routeTwo.add(kevinStation);
    }

    public void testCalculateDuration()
    {
        double actual = RouteCalculator.calculateDuration(routeTwo);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute()
    {
        List<Station> actual = calculator.getShortestRoute(stationIndex.getStation("Горбачева"),stationIndex.getStation("Ленина"));
        assertEquals(route, actual);
        List<Station> actualOne = calculator.getShortestRoute(stationIndex.getStation("Горбачева"),stationIndex.getStation("Элтона"));
        assertEquals(actualOne, actualOne);
        List<Station> actualTwo = calculator.getShortestRoute(stationIndex.getStation("Горбачева"),stationIndex.getStation("Кевина"));
        assertEquals(routeTwo, actualTwo);
    }
}
