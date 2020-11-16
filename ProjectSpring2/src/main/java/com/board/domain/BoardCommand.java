package com.board.domain;

import java.sql.Date;
import org.springframework.web.multipart.MultipartFile;

public class BoardCommand {
	private int qna_num, qna_views, qna_ref, qna_re_step, qna_re_level, qna_category, qna_authority;
	private String mem_id, qna_content, qna_img, qna_title;
	private Date qna_date;
	private MultipartFile upload;
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public int getQna_views() {
		return qna_views;
	}
	public void setQna_views(int qna_views) {
		this.qna_views = qna_views;
	}
	public int getQna_ref() {
		return qna_ref;
	}
	public void setQna_ref(int qna_ref) {
		this.qna_ref = qna_ref;
	}
	public int getQna_re_step() {
		return qna_re_step;
	}
	public void setQna_re_step(int qna_re_step) {
		this.qna_re_step = qna_re_step;
	}
	public int getQna_re_level() {
		return qna_re_level;
	}
	public void setQna_re_level(int qna_re_level) {
		this.qna_re_level = qna_re_level;
	}
	public int getQna_category() {
		return qna_category;
	}
	public void setQna_category(int qna_category) {
		this.qna_category = qna_category;
	}
	public int getQna_authority() {
		return qna_authority;
	}
	public void setQna_authority(int qna_authority) {
		this.qna_authority = qna_authority;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public String getQna_img() {
		return qna_img;
	}
	public void setQna_img(String qna_img) {
		this.qna_img = qna_img;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public Date getQna_date() {
		return qna_date;
	}
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}

	
}
