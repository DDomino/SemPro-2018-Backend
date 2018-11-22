/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import facade.CarFacade;

/**
 *
 * @author Andreas
 */
public class Main {
    
    public static void main(String[] args) {
        CarFacade CF = new CarFacade();
        
        
        
        System.out.println(CF.getAllCars());
    }
    
}
