package model;


public class Characters {
	 private String _id;
	 private String firstName;
	 private String lastName;
	 private String picture;
	 private float age;
	 
	 // Getter Methods 
	 
	 public String get_id() {
	  return _id;
	 }

	 public String getFirstName() {
	  return firstName;
	 }

	 public String getLastName() {
	  return lastName;
	 }

	 public String getPicture() {
	  return picture;
	 }

	 public float getAge() {
	  return age;
	 }

	 // Setter Methods 
	 
	 public void set_id(String _id) {
	  this._id = _id;
	 }

	 public void setFirstName(String firstName) {
	  this.firstName = firstName;
	 }

	 public void setLastName(String lastName) {
	  this.lastName = lastName;
	 }

	 public void setPicture(String picture) {
	  this.picture = picture;
	 }

	 public void setAge(float age) {
	  this.age = age;
	 }
	}