/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flying_chicken;

import java.util.LinkedList;

/**
 *
 * @author Mustafa Murat
 */
public class Physics {

    public static boolean Collision(EntityA enta, EntityB entb) {

        if (enta.getBounds().intersects(entb.getBounds())) {
            return true;
        }

        return false;
    }

    public static boolean Collision(EntityA enta, LinkedList<EntityB> entb) {
        for (int i = 0; i < entb.size(); i++) {
            if (enta.getBounds().intersects(entb.get(i).getBounds())) {
                return true;
            }
        }

        return false;
    }

    public static boolean Collision(EntityC entc, LinkedList<EntityA> enta) {
        for (int i = 0; i < enta.size(); i++) {
            if (entc.getBounds().intersects(enta.get(i).getBounds())) {
                return true;
            }
        }

        return false;
    }

    public static boolean _Collision(EntityA enta, LinkedList<EntityC> entc) {
        for (int i = 0; i < entc.size(); i++) {
            if (enta.getBounds().intersects(entc.get(i).getBounds())) {
                return true;
            }
        }

        return false;
    }
}
