package com.danny.apiTest.cache;/**
 * Created by danny on 2017-12-22.
 */

import com.google.common.base.MoreObjects;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author danny
 * @create 2017-12-22 16:24
 */

public class LoadingCacheTest {
    public static void main(String[] args) throws ExecutionException {
        LoadingCache<Long,AtomicLong> counter =
                CacheBuilder.newBuilder()
                    .expireAfterWrite(2,TimeUnit.SECONDS)  //设置过期时间为2秒，
                    .build(new CacheLoader<Long, AtomicLong>() {
                        @Override
                        public AtomicLong load(Long seconds) throws Exception {
                            return new AtomicLong(0);
                        }
                    });
        long limit = 1000;
        while (true){
            long currentSeconds = System.currentTimeMillis()/1000;  //得到当前秒
                System.out.println("======"+counter.get(currentSeconds));
                System.out.println("++++++"+counter.get(currentSeconds).incrementAndGet());
            if(counter.get(currentSeconds).incrementAndGet() > limit){
                System.out.println("限流了:"+currentSeconds);
                continue;
            }
            //业务处理。。。。。
        }


    }


}

