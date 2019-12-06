package model;

import java.util.ArrayList;

public class Data<T> {

	public <T> ArrayList<T> getData() {
		return (ArrayList<T>) data;
	}

	public void setData(ArrayList<T> data) {
		this.data = data;
	}

	ArrayList<T> data = new ArrayList<T>();

}
