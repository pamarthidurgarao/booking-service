package com.freetable.freetablebookingservice.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tables")
public class TableEntity {

	@Id
	private String id;
	private String restId;
	private Date createdAt;
	private GeoJsonPoint position;
	private String restName;
	private String tableId;
	private int tableFor;
	private String cuisine;
	private String pushedBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRestId() {
		return restId;
	}

	public void setRestId(String restId) {
		this.restId = restId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public GeoJsonPoint getPosition() {
		return position;
	}

	public void setPosition(GeoJsonPoint position) {
		this.position = position;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public int getTableFor() {
		return tableFor;
	}

	public void setTableFor(int tableFor) {
		this.tableFor = tableFor;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getPushedBy() {
		return pushedBy;
	}

	public void setPushedBy(String pushedBy) {
		this.pushedBy = pushedBy;
	}

}
