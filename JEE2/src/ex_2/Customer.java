package ex_2;

public class Customer {
	private int cusid;
    private String cusname,cusphone;
    public Customer(){
    	
    }
    public Customer(int cusid,String cusname,String cusphone){
    	this.cusid=cusid;
    	this.cusname=cusname;
    	this.cusphone=cusphone;   			
    }
	public void setCusid(int cusid) {
		this.cusid=cusid;		
	}
	public void setCusname(String cusname) {
		this.cusname=cusname;		
	}
	public void setCusphone(String cusphone) {
		this.cusphone=cusphone;   			
	}
	public int getCusid() {
		
		return this.cusid;
	}
	public String getCusname() {

		return this.cusname;
	}
	public String getCusphone() {

		return this.cusphone;
	}

}
