/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author frederikbraagaard
 */
public class Animal {
    
    String type;
    int birtYear;
    String sound;

    public Animal(String type, int birtYear, String sound) {
        this.type = type;
        this.birtYear = birtYear;
        this.sound = sound;
    }

    public Animal() {
    }
    
    public static void main(String[] args) {
        List<Animal> list = new ArrayList<Animal>();
        list.add(new Animal("Dog", 2012, "Bark"));
        list.add(new Animal("Cat", 2015, "Miav"));
        list.add(new Animal("Duck", 2013, "Quack"));
        list.add(new Animal("Wheezel", 2002, "wheez"));
        
        int max = 3;
        int min = 0;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min; 
        
        System.out.println(list.get(randomNum));
        
    }

    @Override
    public String toString() {
        return "Animal{" + "type=" + type + ", birtYear=" + birtYear + ", sound=" + sound + '}';
    }
    
    
    
}
