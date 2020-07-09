package com.danny.test;/**
 * Created by danny on 2018-03-01.
 */

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author danny
 * @create 2018-03-01 14:18
 */

public class Producer {
    private final RingBuffer<PCData> ringBuffer;  //环形缓存区

    public Producer(RingBuffer<PCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer bb){
        long sequence = ringBuffer.next();  //获取下一个可用的序列号
        try {
            PCData event = ringBuffer.get(sequence);  //取出一个空闲可用的PCData
            event.set(bb.getLong(0));
        } finally {
            ringBuffer.publish(sequence);  //数据发布后，消费者才可见
        }
    }

    public static void main(String[] args) throws Exception{

        Executor executor = Executors.newCachedThreadPool();
        PCDataFactory factory = new PCDataFactory();
        int bufferSize = 1024;
        Disruptor<PCData> disruptor = new Disruptor<PCData>(factory,
                bufferSize,
                executor,
                ProducerType.MULTI,
                new YieldingWaitStrategy()
//                new BlockingWaitStrategy()
        );
        disruptor.handleEventsWithWorkerPool(
                new Consumer(),
                new Consumer(),
                new Consumer(),
                new Consumer());
        disruptor.start();

        RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();
        Producer producer = new Producer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for(long l = 0 ; true ; l++){
            bb.putLong(0,l);
            producer.pushData(bb);
            Thread.sleep(100);
            System.out.println("add data "+ l);

        }

    }
}
