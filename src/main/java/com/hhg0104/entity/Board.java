package com.hhg0104.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "board")
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 12)
	private int idx;

	@Column(length = 5, nullable = false)
	private int order;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 200, nullable = false)
	private String description;

	@Column(name = "is_visible", nullable = false)
	private boolean isVisible;

	@Column(name = "user_idx", nullable = false, updatable = false)
	private int userIdx;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "board")
	private List<Field> fields;

	@Column(name = "modified_date", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@LastModifiedDate
	private Date modifiedDate;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	/**
	 * copy data for update query
	 * 
	 * @param board
	 *            new board data
	 */
	public void copyDataForUpdate(Board board) {

		this.order = board.getOrder();
		this.name = board.getName();
		this.description = board.getDescription();
		this.isVisible = board.isVisible();
	}

}
