package com.team02.groupware.dto;

public class CommentDto {
	
	private String commentWriter;
	private String commentDate;
	private String commentContent;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "CommentDto [commentWriter=" + commentWriter + ", commentDate=" + commentDate + ", commentContent="
				+ commentContent + "]";
	}
	
	public String getCommentWriter() {
		return commentWriter;
	}
	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	

}
