package io.unlearningcanvas.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value={"api/about", "api/canvas"})
@CrossOrigin(origins = "https://unlearning-canvas.netlify.app")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/{sessionId}")
    public Session getSessionBySessionId(@PathVariable String sessionId) {
        return sessionService.getSessionBySessionId(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }

    @PutMapping("/{sessionId}/{fieldName}")
    public ResponseEntity<Session> updateField(@PathVariable String sessionId, @PathVariable String fieldName, @RequestBody List<String> data) {
        Optional<Session> optionalSession = sessionService.getSessionBySessionId(sessionId);
        if (optionalSession.isPresent()) {
            Session session = optionalSession.get();
            try {
                Session updatedSession = sessionService.updateField(session, fieldName, data);
                return new ResponseEntity<>(updatedSession, HttpStatus.OK);
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{sessionId}/{fieldName}/{index}")
    public ResponseEntity<Session> deleteFieldItem(@PathVariable String sessionId, @PathVariable String fieldName, @PathVariable int index) {
        Optional<Session> optionalSession = sessionService.getSessionBySessionId(sessionId);
        if (optionalSession.isPresent()) {
            Session session = optionalSession.get();
            try {
                Session updatedSession = sessionService.deleteFieldItem(session, fieldName, index);
                return new ResponseEntity<>(updatedSession, HttpStatus.OK);
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Session> createSession(@RequestBody Map<String, String> request) {
        try {
            String sessionId = request.get("sessionId");
            if (sessionId == null || sessionId.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Session session = sessionService.createSession(sessionId);
            return new ResponseEntity<>(session, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
