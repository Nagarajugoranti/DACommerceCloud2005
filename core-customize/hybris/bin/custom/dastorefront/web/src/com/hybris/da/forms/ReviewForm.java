/**
 *
 */
package com.hybris.da.forms;

/**
 * @author nagaraju.g
 *
 */
public class ReviewForm
{

	private String headline;
	private String comment;
	private Double rating;
	private String alias;
	private String response;

	/*
	*//**
		 * @return the response
		 */
	 public String getResponse() { return response; }
	 /*
	 *//**
		  * @param response
		  *           the response to set
		  */
	 public void setResponse(final String response)
	 {
		 this.response = response;
	 }


	 /**
	  * @return the headline
	  */
	 public String getHeadline()
	 {
		 return headline;
	 }

	 /**
	  * @param headline
	  *           the headline to set
	  */
	 public void setHeadline(final String headline)
	 {
		 this.headline = headline;
	 }

	 /**
	  * @return the comment
	  */
	 public String getComment()
	 {
		 return comment;
	 }

	 /**
	  * @param comment
	  *           the comment to set
	  */
	 public void setComment(final String comment)
	 {
		 this.comment = comment;
	 }

	 /**
	  * @return the rating
	  */
	 public Double getRating()
	 {
		 return rating;
	 }

	 /**
	  * @param rating
	  *           the rating to set
	  */
	 public void setRating(final Double rating)
	 {
		 this.rating = rating;
	 }

	 public String getAlias()
	 {
		 return alias;
	 }

	 public void setAlias(final String alias)
	 {
		 this.alias = alias;
	 }

}
