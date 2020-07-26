package com.freetable.booking.repository;

import java.util.List;

import org.springframework.data.geo.Box;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.freetable.booking.entity.Table;

public interface TableRepository extends MongoRepository<Table, String> {
	List<Table> findByPositionWithin(Circle c);

	List<Table> findByPositionWithin(Box b);

	List<Table> findByPositionNear(Point p, Distance d);
}
