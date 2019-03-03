package com.daou.domain;

public enum Profiles {
    DEV("dev"), PROD("prod");

    private String profile;

    private Profiles(String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }
}