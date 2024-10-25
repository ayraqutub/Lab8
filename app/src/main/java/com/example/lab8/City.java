package com.example.lab8;

import java.util.Objects;

public class City implements Comparable {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return Objects.equals(city, city1.city) && Objects.equals(province, city1.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }

    @Override
    public int compareTo(Object o) {
        City city1 = (City) o;
        return this.city.compareTo(city1.city);
    }
}
