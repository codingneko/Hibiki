package com.codingneko.JSON;

public class Gelbooru {
    private String source;
    private String directory;
    private String hash;
    private int height;
    private int id;
    private String image;
    private int change;
    private String owner;
    private int parent_id;
    private String rating;
    private boolean sample;
    private int sample_height;
    private int sample_width;
    private int score;
    private String tags;
    private int width;
    private String file_url;
    private String created_at;

    public Gelbooru(String source, String directory, String hash, int height, int id, String image, int change, String owner, int parent_id, String rating, boolean sample, int sample_height, int sample_width, int score, String tags, int width, String file_url, String created_at) {
        this.source = source;
        this.directory = directory;
        this.hash = hash;
        this.height = height;
        this.id = id;
        this.image = image;
        this.change = change;
        this.owner = owner;
        this.parent_id = parent_id;
        this.rating = rating;
        this.sample = sample;
        this.sample_height = sample_height;
        this.sample_width = sample_width;
        this.score = score;
        this.tags = tags;
        this.width = width;
        this.file_url = file_url;
        this.created_at = created_at;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDirectory() {
        return this.directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getChange() {
        return this.change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean isSample() {
        return this.sample;
    }

    public void setSample(boolean sample) {
        this.sample = sample;
    }

    public int getSample_height() {
        return this.sample_height;
    }

    public void setSample_height(int sample_height) {
        this.sample_height = sample_height;
    }

    public int getSample_width() {
        return this.sample_width;
    }

    public void setSample_width(int sample_width) {
        this.sample_width = sample_width;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getFile_url() {
        return this.file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
