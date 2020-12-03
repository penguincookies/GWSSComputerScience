/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u4;

/**
 *
 * @author revit
 */
public class Rectangle {
    
    private int length;
    private int width;
    
    public Rectangle (int length, int width) {
        this.length = length;
        this.width = width;
    }
    
    public int getArea () {
        return length*width;
    }
    
}
