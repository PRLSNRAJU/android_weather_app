package com.prlsnraju.weatherapp.network;

public class Main{
	private float temp;
	private float tempMin;
	private int grndLevel;
	private int humidity;
	private int pressure;
	private int seaLevel;
	private float feelsLike;
	private float tempMax;

	public void setTemp(float temp){
		this.temp = temp;
	}

	public float getTemp(){
		return temp;
	}

	public void setTempMin(float tempMin){
		this.tempMin = tempMin;
	}

	public float getTempMin(){
		return tempMin;
	}

	public void setGrndLevel(int grndLevel){
		this.grndLevel = grndLevel;
	}

	public int getGrndLevel(){
		return grndLevel;
	}

	public void setHumidity(int humidity){
		this.humidity = humidity;
	}

	public int getHumidity(){
		return humidity;
	}

	public void setPressure(int pressure){
		this.pressure = pressure;
	}

	public int getPressure(){
		return pressure;
	}

	public void setSeaLevel(int seaLevel){
		this.seaLevel = seaLevel;
	}

	public int getSeaLevel(){
		return seaLevel;
	}

	public void setFeelsLike(float feelsLike){
		this.feelsLike = feelsLike;
	}

	public float getFeelsLike(){
		return feelsLike;
	}

	public void setTempMax(float tempMax){
		this.tempMax = tempMax;
	}

	public float getTempMax(){
		return tempMax;
	}
}
