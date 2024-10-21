package com.sheldon.springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.Duration;

/**
 * Description of this file
 *
 * @author Sheldon.Wei.Xiaodong
 * @since 21/10/24 15:40
 */
@Service
public class EventService {
    @Autowired
    private EventDao eventDao;

    @Transactional
    public void serve() {
        Event e1 = eventDao.save(new Event("event" + System.currentTimeMillis()));
        try {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    System.out.println(Thread.currentThread().getName() + " -- " + e1.getId());
                }
            });
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Event e2 = eventDao.save(new Event("event" + System.currentTimeMillis()));
        System.out.println(Thread.currentThread().getName());
        System.out.println(e2.getId());
    }
}
