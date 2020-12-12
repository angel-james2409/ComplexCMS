package com.hexaware.MLP211.model;
public class Vendor{
    private int id;
    private String name;
    private String address;
    private String contactPersonName;
    private ContactInfo contactInfo=new ContactInfo();
    private int rating; 
    private int ratingCount;

    public Vendor(){

    }
 public Vendor(int id,String name,String address,String contactPersonName,ContactInfo contactInfo,int rating) {
this.id=id;
this.name=name;
this.address=address;
this.contactPersonName=contactPersonName;
this.contactInfo=contactInfo;
this.rating=rating;
 }  
 public void setId(int id){
    this.id=id;
 }
  public int getId(){
     return this.id;
 }
 public void setName(String name){
    this.name=name; 
 }
 public String getName(){
     return this.name;
 }
 public void setAddress(String address){
    this.address=address;
 }
 public String getAddress(){
     return  this.address;
 }
 public void setContactPersonName(String contactPersonName){
    this.contactPersonName=contactPersonName;
 }
public String getContactPersonName(){
    return this.contactPersonName;
}
public void setContactInfo(){
    this.contactInfo=contactInfo;
}
public ContactInfo getContactInfo(){
    return this.contactInfo;
}
public void setRating(int rating){
    this.rating=rating;
 }
  public int getRating(){
     return this.rating;
 }

 public void setRatingCount(int ratingCount)
 {
     this.ratingCount=ratingCount;
 
 }
 public int getRatingCount() {
     return this.ratingCount;
 }

 @Override
public boolean equals(Object obj){
    if(this==obj)
        return true;
    if(obj==null)
        return false;
    if(!(obj instanceof Vendor))
        return false;
    boolean result=false;
    Vendor temp=(Vendor) obj;
    if(this.id==temp.id)
        result=true;
    return result;

}
@Override
public int hashCode(){
    int n=this.id;
    return n;
}
@Override
public String toString(){
    return "Vendor [ID is:"+this.id+","+"NAME IS:"+this.name+","+"ADDRESS IS:"+this.address+","+"CONTACT PERSON NAME IS:"+this.contactPersonName+","+"RATING IS:"+this.rating+","+"RATING COUNT: "+this.ratingCount+"CONTACT INFO:"+this.contactInfo+"]";
}
}