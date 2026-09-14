package com.springboot.app.common;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private int status;
    private String method;
    private String path;
    private LocalDateTime timestamp;
    private T data;

    public ApiResponse(int status, String method, String path, T data) {
        this.status = status;
        this.method = method;
        this.path = path;
        this.timestamp = LocalDateTime.now();
        this.data = data;
    }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

    
}