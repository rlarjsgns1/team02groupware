package com.team02.groupware.dto;

public class ChatMessage {
	
	 	private MessageType type;
	    private String content;
	    private String sender;
	    private String chatRoomCode;

	    

		public String getChatRoomCode() {
			return chatRoomCode;
		}

		public void setChatRoomCode(String chatRoomCode) {
			this.chatRoomCode = chatRoomCode;
		}

		public MessageType getType() {
	        return type;
	    }

	    public void setType(MessageType type) {
	        this.type = type;
	    }

	    public String getContent() {
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content;
	    }

	    public String getSender() {
	        return sender;
	    }

	    public void setSender(String sender) {
	        this.sender = sender;
	    }

}
