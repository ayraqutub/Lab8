package com.example.lab8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity(){
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        City city2 = new City("Calgary", "Alberta");
        assertFalse(list.hasCity(city2));
    }

    @Test
    public void testDelete(){
        list = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        list.addCity(city);
        list.delete(city);
        assertFalse(list.getCities().contains(city));
    }

    @Test
    public void testDeleteException(){
        list = MockCityList();
        City city = new City("Saskatoon", "Saskatchewan");
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(city);
        });
    }

    @Test
    public void testCountCities(){
        list = MockCityList();
        assertEquals(0, list.getCount());
        City city1 = new City("Surrey", "BC");
        City city2 = new City("Fort McMurray", "AB");
        list.addCity(city1);
        assertEquals(1, list.getCount());
        list.addCity(city2);
        assertEquals(2, list.getCount());
    }
}
