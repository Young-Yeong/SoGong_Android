package com.example.sogong.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RecipePost {
    @SerializedName("post_id")
    private int post_id;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("title")
    private String title;

    @SerializedName("category")
    private String category;

    @SerializedName("degree_of_spicy")
    private int degree_of_spicy;

    @SerializedName("description")
    private String description;

    @SerializedName("views")
    private int views;

    @SerializedName("like_count")
    private int like_count;

    @SerializedName("comment_count")
    private int comment_count;

    @SerializedName("upload_time")
    private String upload_time;

    @SerializedName("Recipe_Ingredients")
    private ArrayList<Ingredients> Recipe_Ingredients;

    @SerializedName("comments")
    private ArrayList<Comment> comments;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDegree_of_spicy() {
        return degree_of_spicy;
    }

    public void setDegree_of_spicy(int degree_of_spicy) {
        this.degree_of_spicy = degree_of_spicy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public ArrayList<Ingredients> getRecipe_Ingredients() {
        return Recipe_Ingredients;
    }

    public void setRecipe_Ingredients(ArrayList<Ingredients> recipe_Ingredients) {
        Recipe_Ingredients = recipe_Ingredients;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public RecipePost(int post_id, String nickname, String title, String category, int degree_of_spicy, String description, int views, int like_count, int comment_count, String upload_time, ArrayList<Ingredients> recipe_Ingredients, ArrayList<Comment> comments) {
        this.post_id = post_id;
        this.nickname = nickname;
        this.title = title;
        this.category = category;
        this.degree_of_spicy = degree_of_spicy;
        this.description = description;
        this.views = views;
        this.like_count = like_count;
        this.comment_count = comment_count;
        this.upload_time = upload_time;
        Recipe_Ingredients = recipe_Ingredients;
        this.comments = comments;
    }
}

/*
{
	"post_id": 19,
	"nickname": "test",
	"title": "test0",
	"category": "test0",
	"degree_of_spicy": 1,
	"description": "test0",
	"views": 6,
	"like_count": 1,
	"comment_count": 0,
	"upload_time": "2022-11-14T21:28:04.029119+09:00",
	"Recipe_Ingredients": [
		{
			"id": 18,
			"name": "asparagus",
			"post_id": 19,
			"unit": "T",
			"amount": 30.0
		},
		{
			"id": 19,
			"name": "kkochu",
			"post_id": 19,
			"unit": "kg",
			"amount": 30.0
		}
	],
	"comments": [
		{
			"comment_id": 2,
			"nickname": "test",
			"post_id": 19,
			"comments": "test",
			"comment_time": "2000-01-01T09:00:00+09:00"
		}
	]
}
 */