package com.freetable.booking.service;

import java.util.List;

import com.freetable.booking.entity.Table;

public interface TableService {

	Table create(Table entity);

	Table update(Table entity);

	Table get(String id);

	void delet(String id);

	List<Table> search(double lat, double lan, double distance);

}
