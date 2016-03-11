/*
 * Copyright 2015 Taylan Unal
 */

public class Movie {
	int year;
	String title,rating;
	public Movie(String t,String r,int y){
	title=t;
	rating=r;
	year=y;
	}
    public String getTitle(){
		return title;
	}
	public String getRating(){
		return rating;
	}
	public int getYear(){
		return year;
	}
	@Override
	public String toString(){
		return (title + "," + rating + "," + year);
	}
}

