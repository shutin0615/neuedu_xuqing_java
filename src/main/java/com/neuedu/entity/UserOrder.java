package com.neuedu.entity;

import java.io.Serializable;
/**
 * 订单实体类
 **/
public class UserOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;//订单id
	private long order_no;//订单编号
	private int user_id;//用户id
	private int shipping_id;//地址id
	private double payment;//支付金额
	private String payment_type;//支付方式
	private int postage;//邮费
	private int status;//订单状态
	private long payment_time;//支付时间
	private long send_time;//发货时间
	private long end_time;//结束时间
	private long close_time;//订单关闭时间
	private long create_time;//订单创建时间
	private long update_time;//订单修改时间
	
	public UserOrder() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getOrder_no() {
		return order_no;
	}

	public void setOrder_no(long order_no) {
		this.order_no = order_no;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getShipping_id() {
		return shipping_id;
	}

	public void setShipping_id(int shipping_id) {
		this.shipping_id = shipping_id;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public int getPostage() {
		return postage;
	}

	public void setPostage(int postage) {
		this.postage = postage;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getPayment_time() {
		return payment_time;
	}

	public void setPayment_time(long payment_time) {
		this.payment_time = payment_time;
	}

	public long getSend_time() {
		return send_time;
	}

	public void setSend_time(long send_time) {
		this.send_time = send_time;
	}

	public long getEnd_time() {
		return end_time;
	}

	public void setEnd_time(long end_time) {
		this.end_time = end_time;
	}

	public long getClose_time() {
		return close_time;
	}

	public void setClose_time(long close_time) {
		this.close_time = close_time;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public long getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}

	public UserOrder(int id, long order_no, int user_id, int shipping_id, double payment, String payment_type, int postage,
			int status, long payment_time, long send_time, long end_time, long close_time, long create_time,
			long update_time) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.shipping_id = shipping_id;
		this.payment = payment;
		this.payment_type = payment_type;
		this.postage = postage;
		this.status = status;
		this.payment_time = payment_time;
		this.send_time = send_time;
		this.end_time = end_time;
		this.close_time = close_time;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "UserOrder [id=" + id + ", order_no=" + order_no + ", user_id=" + user_id + ", shipping_id="
				+ shipping_id + ", payment=" + payment + ", payment_type=" + payment_type + ", postage=" + postage
				+ ", status=" + status + ", payment_time=" + payment_time + ", send_time=" + send_time + ", end_time="
				+ end_time + ", close_time=" + close_time + ", create_time=" + create_time + ", update_time="
				+ update_time + "]";
	}
	
	
}
