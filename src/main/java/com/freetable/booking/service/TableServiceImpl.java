package com.freetable.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.freetable.booking.entity.Table;
import com.freetable.booking.repository.TableRepository;

@Service
public class TableServiceImpl implements TableService {

	@Autowired
	private TableRepository repository;

	@Override
	public Table create(Table entity) {
		return repository.save(entity);
	}

	@Override
	public Table update(Table entity) {
		return repository.insert(entity);
	}

	@Override
	public Table get(String id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void delet(String id) {
		repository.deleteById(id);
	}

	@Override
	public List<Table> search(double lat, double lan, double distance) {
		Point point = new Point(lat, lan);
		Distance distance2 = new Distance(distance);
		distance2.in(Metrics.KILOMETERS);
		Circle c = new Circle(point, distance2);
		return repository.findByPositionWithin(c);
	}

}
