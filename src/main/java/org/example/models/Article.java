package org.example.models;

public class Article {
    private int articleID;
    private String articleSubject;
    private String articleBody;
    private String authorizedRole;
    private String readStatus;

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getArticleSubject() {
        return articleSubject;
    }

    public void setArticleSubject(String articleSubject) {
        this.articleSubject = articleSubject;
    }

    public String getArticleBody() {
        return articleBody;
    }

    public void setArticleBody(String articleBody) {
        this.articleBody = articleBody;
    }

    public String getAuthorizedRole() {
        return authorizedRole;
    }

    public void setAuthorizedRole(String authorizedRole) {
        this.authorizedRole = authorizedRole;
    }

    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }
}
