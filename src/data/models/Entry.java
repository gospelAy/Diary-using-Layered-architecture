package data.models;

public class Entry {
    private int id;
    private int diaryIid;
    private String subject;
    private String body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiaryIid() {
        return diaryIid;
    }

    public void setDiaryIid(int diaryIid) {
        this.diaryIid = diaryIid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
