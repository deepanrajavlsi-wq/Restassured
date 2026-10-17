package demo;

public class Details {
	
	private String companyName;
	private String emailid;
	
	public Details(String companyName,String emailid)
	{
		this.companyName=companyName;
		this.emailid=emailid;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	

}
