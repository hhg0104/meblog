package com.hhg0104.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "field")
public class Field {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 12)
	private int idx;

	@Column(length = 5, nullable = false)
	private int order;

	@Column(length = 20, nullable = false)
	private String name;

	@Column(name = "view_name", length = 40, nullable = false)
	private String viewName;

	@Column(name = "value_format", length = 40)
	private String valueFormat;

	@Column(name = "is_visible_in_list", nullable = false)
	private boolean isVisibleInList;

	@Column(name = "is_required", nullable = false)
	private boolean isRequired;

	@Column(name = "is_public", nullable = false)
	private boolean isPublic;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "type_idx", nullable = false, updatable = false)
	private FieldType type;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "board_idx", nullable = false)
	private Board board;

	@Column(name = "user_idx", nullable = false, updatable = false)
	private int userIdx;

	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "modified_date", nullable = false)
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

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getValueFormat() {
		return valueFormat;
	}

	public void setValueFormat(String valueFormat) {
		this.valueFormat = valueFormat;
	}

	public boolean isVisibleInList() {
		return isVisibleInList;
	}

	public void setVisibleInList(boolean isVisibleInList) {
		this.isVisibleInList = isVisibleInList;
	}

	public boolean isRequired() {
		return isRequired;
	}

	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public FieldType getType() {
		return type;
	}

	public void setType(FieldType type) {
		this.type = type;
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

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
