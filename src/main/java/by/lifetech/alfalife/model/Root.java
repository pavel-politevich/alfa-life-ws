package by.lifetech.alfalife.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {

	@JsonProperty("statistics")
	public Statistics getStatistics() {
		return this.statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	Statistics statistics;

	@JsonProperty("totalRowCount")
	public int getTotalRowCount() {
		return this.totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	int totalRowCount;

	@JsonProperty("cacheKey")
	public String getCacheKey() {
		return this.cacheKey;
	}

	public void setCacheKey(String cacheKey) {
		this.cacheKey = cacheKey;
	}

	String cacheKey;

	@JsonProperty("page")
	public ArrayList<Page> getPage() {
		return this.page;
	}

	public void setPage(ArrayList<Page> page) {
		this.page = page;
	}

	ArrayList<Page> page;

	@Override
	public String toString() {
		return "Root [statistics=" + statistics + ", totalRowCount=" + totalRowCount + ", cacheKey=" + cacheKey
				+ ", page=" + page + "]";
	}
	
	
}
