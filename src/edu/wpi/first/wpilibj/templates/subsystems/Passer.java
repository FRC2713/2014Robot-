/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

/**
 *
 * @author ryanbradford
 */
public class Passer {
    static int driverStation = 1;
    public static void setNum(int num) {
        driverStation = num;
    }
    public static int getNum() {
        return driverStation;
    }
}
