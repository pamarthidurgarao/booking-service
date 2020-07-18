package com.freetable.freetablebookingservice.repository;

import java.util.List;

import org.springframework.data.geo.Box;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.freetable.freetablebookingservice.entity.TableEntity;

public interface TableRepository extends MongoRepository<TableEntity, String> {
	List<TableEntity> findByPositionWithin(Circle c);

	List<TableEntity> findByPositionWithin(Box b);

	List<TableEntity> findByPositionNear(Point p, Distance d);
}
