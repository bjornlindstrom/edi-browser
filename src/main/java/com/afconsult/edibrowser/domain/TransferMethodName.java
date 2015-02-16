package com.afconsult.edibrowser.domain;

public enum TransferMethodName {

	FTP(1, "ftp"), SMTP(2, "stmp"), FILECOPY(3, "filecopy"), WEBDAV(4, "webdav"), SFTP(4, "sftp");
	
	private Integer id;
	private String name;
	
	private TransferMethodName(Integer id, String name){
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
