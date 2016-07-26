package top.fzqblog.po.enums;

public enum TextLengthEnum {
	TEXT(65535, "MYSQL TEXT的长度"), 
	MEDIUMTEXT(16777215, "MYSQL MEDIUMTEXT的长度"),
	LONGTEXT(4294967295l, "MYSQL LONGTEXT的长度");
	
	private long length;
	private String desc;
	
	
	private TextLengthEnum(long length, String desc) {
		this.length = length;
	}

	public long getLength() {
		return length;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
