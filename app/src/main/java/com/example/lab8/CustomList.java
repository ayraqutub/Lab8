package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    public void addCity(City city){
        cities.add(city);
    }

    /**
     * Check if a city is present in the list
     * */
    public boolean hasCity(City city){
        return cities.contains(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list, sorted by city name
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Check if a city is present in the list.
     * If it does then remove it from the list,
     * if not then **throw an exception**
     * */
    public void delete(City city){
        if (cities.contains(city)){
            cities.remove(city);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public int countCities(){
        return 0;
    }
}
