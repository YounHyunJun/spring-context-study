package study.spring.context.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spark extends AbstractCar {

    private String name;

    private Door[] doorArray;

    private List seatList;

    private Map toolMap;

    protected void run() {
        System.out.println("스파크가 움직인다.");
    }

    public Spark() {
        populate();
    }

    public void populate() {
        Door door1 = new Door("front-left");
        Door door2 = new Door("front-right");
        Door door3 = new Door("back");

        String seat1 = "front-seat";
        String seat2= "back-seat";

        String tool1 = "zipper";
        String tool2 = "spanner";

        this.doorArray = new Door[]{door1, door2, door3};
        this.seatList = new ArrayList();
        this.toolMap = new HashMap();
        this.seatList.add(seat1);
        this.seatList.add(seat2);
        this.toolMap.put("key1", tool1);
        this.toolMap.put("key2", tool2);
    }

    public Spark(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {

    }

    public int getSize() {
        return 0;
    }

    public Door[] getDoorArray() {
        return doorArray;
    }

    public void setDoorArray(Door[] doorArray) {
        this.doorArray = doorArray;
    }

    public List getSeatList() {
        return seatList;
    }

    public void setSeatList(List seatList) {
        this.seatList = seatList;
    }

    public Map getToolMap() {
        return toolMap;
    }

    public void setToolMap(Map toolMap) {
        this.toolMap = toolMap;
    }
}