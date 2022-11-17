package com.example.sogong.Model;

import com.google.gson.annotations.SerializedName;

public class Comment {
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("comment_id")
    private int comment_id;
    @SerializedName("post_id")
    private int post_id;
    @SerializedName("comments")
    private String comments;
    @SerializedName("comment_time")
    private String comment_time;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }


    public Comment(String nickname, int comment_id, int post_id, String comments, String comment_time) {
        this.nickname = nickname;
        this.comment_id = comment_id;
        this.post_id = post_id;
        this.comments = comments;
        this.comment_time = comment_time;
    }
}
