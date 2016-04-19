package model.tweet;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class MyTweet {

	@SerializedName("created_at")
	@Expose
	private String createdAt;

	@Expose
	private Entities entities;

	@Expose
	private List<Long> contributors = new ArrayList<Long>();

	@Expose
	private String text;

	@SerializedName("retweet_count")
	@Expose
	private Long retweetCount;

	@Expose
	private Long id;

	@Expose
	private User user;

	@Expose
	private String source;

	/**
	 * 
	 * @return The createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * 
	 * @param createdAt
	 *            The created_at
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * 
	 * @return The entities
	 */
	public Entities getEntities() {
		return entities;
	}

	/**
	 * 
	 * @param entities
	 *            The entities
	 */
	public void setEntities(Entities entities) {
		this.entities = entities;
	}

	/**
	 * 
	 * @return The contributors
	 */
	public List<Long> getContributors() {
		return contributors;
	}

	/**
	 * 
	 * @param contributors
	 *            The contributors
	 */
	public void setContributors(List<Long> contributors) {
		this.contributors = contributors;
	}

	/**
	 * 
	 * @return The text
	 */
	public String getText() {
		return text;
	}

	/**
	 * 
	 * @param text
	 *            The text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 
	 * @return The retweetCount
	 */
	public Long getRetweetCount() {
		return retweetCount;
	}

	/**
	 * 
	 * @param retweetCount
	 *            The retweet_count
	 */
	public void setRetweetCount(Long retweetCount) {
		this.retweetCount = retweetCount;
	}

	/**
	 * 
	 * @return The id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 
	 * @param user
	 *            The user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 
	 * @return The source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * 
	 * @param source
	 *            The source
	 */
	public void setSource(String source) {
		this.source = source;
	}

}
