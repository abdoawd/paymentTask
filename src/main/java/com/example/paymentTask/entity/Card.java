
package com.example.paymentTask.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "Cards")
@XmlRootElement
public class Card implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	private Long id;
	@Column(name = "pan")
	private String pan;

	@Column(name = "status")
	private int status;
	

	@Column(name = "expiration_date")
	private Date expiryDate;

	@Override
	public String toString() {
		return "Card{" + " pan=" + pan + ", status=" + status + ", expiryDate=" + expiryDate + '}';
	}

	public Card() {
	}

	public Card(String pan, int status) {
		super();
		this.pan = pan;
		this.status = status;
	}



	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}
}
