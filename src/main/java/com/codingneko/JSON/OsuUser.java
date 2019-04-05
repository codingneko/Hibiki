package com.codingneko.JSON;

public class OsuUser {
    private String user_id;
    private String username;
    private String count300;
    private String count100;
    private String count50;
    private String playcount;
    private String ranked_score;
    private String total_score;
    private String pp_rank;
    private String level;
    private String pp_raw;
    private String accuracy;
    private String count_rank_ss;
    private String count_rank_s;
    private String count_rank_sh;
    private String count_rank_a;
    private String country;
    private String pp_country_rank;

    public OsuUser(String user_id, String username, String count300, String count100, String count50, String playcount, String ranked_score, String total_score, String pp_rank, String level, String pp_raw, String accuracy, String count_rank_ss, String count_rank_s, String count_rank_sh, String count_rank_a, String country, String pp_country_rank, String[] events) {
        this.user_id = user_id;
        this.username = username;
        this.count300 = count300;
        this.count100 = count100;
        this.count50 = count50;
        this.playcount = playcount;
        this.ranked_score = ranked_score;
        this.total_score = total_score;
        this.pp_rank = pp_rank;
        this.level = level;
        this.pp_raw = pp_raw;
        this.accuracy = accuracy;
        this.count_rank_ss = count_rank_ss;
        this.count_rank_s = count_rank_s;
        this.count_rank_sh = count_rank_sh;
        this.count_rank_a = count_rank_a;
        this.country = country;
        this.pp_country_rank = pp_country_rank;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getCount300() {
        return this.count300;
    }

    public String getCount100() {
        return this.count100;
    }

    public String getCount50() {
        return this.count50;
    }

    public String getPlayCount() {
        return this.playcount;
    }

    public String getRankedScore() {
        return this.ranked_score;
    }

    public String getTotalScore() {
        return this.total_score;
    }

    public String getPp_rank() {
        return this.pp_rank;
    }

    public String getLevel() {
        return this.level;
    }

    public String getPp_raw() {
        return this.pp_raw;
    }

    public String getAccuracy() {
        return this.accuracy;
    }

    public String getCount_rank_ss() {
        return this.count_rank_ss;
    }

    public String getCount_rank_s() {
        return this.count_rank_s;
    }

    public String getCount_rank_sh() {
        return this.count_rank_sh;
    }

    public String getCount_rank_a() {
        return this.count_rank_a;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPp_country_rank() {
        return this.pp_country_rank;
    }
}