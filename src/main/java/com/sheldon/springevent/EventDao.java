package com.sheldon.springevent;

import org.springframework.data.repository.CrudRepository;

public interface EventDao extends CrudRepository<Event, Integer> {

}