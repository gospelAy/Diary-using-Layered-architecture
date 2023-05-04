package dtos.response;

public class EntryRegisterResponse {
    private int diaryIid;
    private String subject;
    private String body;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EntryRegisterResponse{");
        sb.append("diaryIid=").append(diaryIid);
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
