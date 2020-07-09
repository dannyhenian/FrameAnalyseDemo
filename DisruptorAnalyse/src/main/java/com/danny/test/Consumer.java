package com.danny.test;/**
 * Created by danny on 2018-03-01.
 */

import com.lmax.disruptor.WorkHandler;

/**
 * @author danny
 * @create 2018-03-01 11:50
 */

public class Consumer implements WorkHandler<PCData> {

    public void onEvent(PCData event) throws Exception {
        
        System.out.println(Thread.currentThread().getId() + ":Event: --" + event.get() * event.get() + "--");

    }
}
