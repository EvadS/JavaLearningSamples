package com.se.sample.model;

import com.google.api.client.util.Key;

/**
 *  поля, в которых нет аннотации @Key, считаются внутренними и не анализируются и не сериализуются в JSON.
 *   видимость полей не имеет значения, равно как и существование методов получения или установки.
 *    значение аннотации @Key, чтобы сопоставить его с правильным ключом JSON.
 */
public class User {
    @Key
    private String login;

    @Key
    private long id;

    @Key("html_url")
    private String htmlUrl;

    @Key("site_admin")
    private boolean site_admin;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GithubUser [login=").append(this.login).append(", id=").append(this.id).append(", htmlUrl=")
                .append(this.htmlUrl).append(", site_admin=").append(this.site_admin).append("]").append("\n");
        return builder.toString();
    }
}
