package com.se.sample.model;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

public class GitHubUrl extends GenericUrl {

    public GitHubUrl(String encodedUrl) {
        super(encodedUrl);
    }

    @Key
    public int per_page;

}
