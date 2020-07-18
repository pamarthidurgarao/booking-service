package com.freetable.freetablebookingservice.service;

import java.util.List;

import com.freetable.freetablebookingservice.entity.TableEntity;

public interface TableService {

	TableEntity create(TableEntity entity);

	TableEntity update(TableEntity entity);

	TableEntity get(String id);

	void delet(String id);

	List<TableEntity> search(double lat, double lan, int distance);

}
