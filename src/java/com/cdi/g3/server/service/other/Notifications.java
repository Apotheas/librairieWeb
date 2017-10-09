/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.service.other;

import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.server.domain.customers.Appreciation;
import com.cdi.g3.server.domain.orders.Orders;
import com.cdi.g3.server.service.customers.AppreciationService;
import com.cdi.g3.server.service.orders.OrderService;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Apotheas
 */
public class Notifications {

    private static int nbCommentsWaiting;
    private static int nbOrders;
    private static AppreciationService appreciationService = new AppreciationService();
    private static OrderService orderService = new OrderService();

    public int initNotifOrders() {
        try {
            for (Iterator it = orderService.findOrdersByStatus("NAMEINFOSTATUSORDER", "PROCESSING").iterator(); it.hasNext();) {
                it.next();
                nbOrders += 1;
            }
        } catch (ObjectNotFoundException ex) {

        }
        return nbOrders;
    }

    public int initNotifComments() {

        try {
            for (Iterator it = appreciationService.findWaitingAppreciate().iterator(); it.hasNext();) {
                it.next();
                nbCommentsWaiting += 1;
            }
        } catch (ObjectNotFoundException ex) {
        }
        return nbCommentsWaiting;
    }

}
