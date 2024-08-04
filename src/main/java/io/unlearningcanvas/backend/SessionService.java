package io.unlearningcanvas.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> allSessions() {
        return sessionRepository.findAll();
    }

    public Optional<Session> getSessionBySessionId(String sessionId) {
        return sessionRepository.findBySessionId(sessionId);
    }

    public Session createSession(String sessionId) {
        Session session = new Session();
        session.setSessionId(sessionId);
        session.setFeld1(new ArrayList<>());
        session.setFeld2(new ArrayList<>());
        session.setFeld3(new ArrayList<>());
        session.setFeld4(new ArrayList<>());
        session.setFeld5(new ArrayList<>());
        session.setFeld6(new ArrayList<>());
        session.setFeld7(new ArrayList<>());
        return sessionRepository.save(session);
    }

    public Session updateField(Session session, String fieldName, List<String> data) {
        switch (fieldName) {
            case "feld1":
                session.setFeld1(data);
                break;
            case "feld2":
                session.setFeld2(data);
                break;
            case "feld3":
                session.setFeld3(data);
                break;
            case "feld4":
                session.setFeld4(data);
                break;
            case "feld5":
                session.setFeld5(data);
                break;
            case "feld6":
                session.setFeld6(data);
                break;
            case "feld7":
                session.setFeld7(data);
                break;
            default:
                throw new IllegalArgumentException("Invalid field name: " + fieldName);
        }
        return sessionRepository.save(session);
    }

    public Session deleteFieldItem(Session session, String fieldName, int index) {
        List<String> dataList;
        switch (fieldName) {
            case "feld1":
                dataList = new ArrayList<>(session.getFeld1());
                break;
            case "feld2":
                dataList = new ArrayList<>(session.getFeld2());
                break;
            case "feld3":
                dataList = new ArrayList<>(session.getFeld3());
                break;
            case "feld4":
                dataList = new ArrayList<>(session.getFeld4());
                break;
            case "feld5":
                dataList = new ArrayList<>(session.getFeld5());
                break;
            case "feld6":
                dataList = new ArrayList<>(session.getFeld6());
                break;
            case "feld7":
                dataList = new ArrayList<>(session.getFeld7());
                break;
            default:
                throw new IllegalArgumentException("Invalid field name: " + fieldName);
        }

        if (index >= 0 && index < dataList.size()) {
            dataList.remove(index);
            switch (fieldName) {
                case "feld1":
                    session.setFeld1(dataList);
                    break;
                case "feld2":
                    session.setFeld2(dataList);
                    break;
                case "feld3":
                    session.setFeld3(dataList);
                    break;
                case "feld4":
                    session.setFeld4(dataList);
                    break;
                case "feld5":
                    session.setFeld5(dataList);
                    break;
                case "feld6":
                    session.setFeld6(dataList);
                    break;
                case "feld7":
                    session.setFeld7(dataList);
                    break;
            }
        } else {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        return sessionRepository.save(session);
    }
}