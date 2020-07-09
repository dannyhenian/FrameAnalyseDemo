package com.danny.test;/**
 * Created by danny on 2018-03-01.
 */

import com.lmax.disruptor.EventFactory;

/**
 * @author danny
 * @create 2018-03-01 14:16
 */

public class PCDataFactory implements EventFactory<PCData> {
    public PCData newInstance() {
        return new PCData();
    }
}
