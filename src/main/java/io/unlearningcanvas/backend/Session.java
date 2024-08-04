package io.unlearningcanvas.backend;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "Session")
public class Session {
    @Id
    private String _id;
    private String sessionId;
    private List<String> feld1;
    private List<String> feld2;
    private List<String> feld3;
    private List<String> feld4;
    private List<String> feld5;
    private List<String> feld6;
    private List<String> feld7;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<String> getFeld1() {
        return feld1;
    }

    public void setFeld1(List<String> feld1) {
        this.feld1 = feld1;
    }

    public List<String> getFeld2() {
        return feld2;
    }

    public void setFeld2(List<String> feld2) {
        this.feld2 = feld2;
    }

    public List<String> getFeld3() {
        return feld3;
    }

    public void setFeld3(List<String> feld3) {
        this.feld3 = feld3;
    }

    public List<String> getFeld4() {
        return feld4;
    }

    public void setFeld4(List<String> feld4) {
        this.feld4 = feld4;
    }

    public List<String> getFeld5() {
        return feld5;
    }

    public void setFeld5(List<String> feld5) {
        this.feld5 = feld5;
    }

    public List<String> getFeld6() {
        return feld6;
    }

    public void setFeld6(List<String> feld6) {
        this.feld6 = feld6;
    }
    public List<String> getFeld7() {
        return feld7;
    }

    public void setFeld7(List<String> feld7) {
        this.feld7 = feld7;
    }
}
