package com.nahian.github.io.rookiedev.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nahian.github.io.rookiedev.events.UserDeleteEvent;
import com.nahian.github.io.rookiedev.events.NoteRestEvent;
import com.nahian.github.io.rookiedev.exception.UserException;
import com.nahian.github.io.rookiedev.models.Note;
import com.nahian.github.io.rookiedev.models.User;
import com.nahian.github.io.rookiedev.objects.SuggestedIdeas;
import com.nahian.github.io.rookiedev.repositorys.NoteRepository;
import com.nahian.github.io.rookiedev.services.UserService;
import com.nahian.github.io.rookiedev.validators.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HomeApiController {

    private final UserService userService;
    private final ApplicationEventPublisher publisher;
    private final UserValidator userValidator;
    private final NoteRepository noteRepository;

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.getUsers();
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.findUser(userId);
    }

    @PostMapping("/create")
    public List<User> createUser(@RequestBody User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            throw new UserException(Objects.requireNonNull(result.getFieldError()));
        }
        userService.createUser(user);
        return userService.getUsers();
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            throw new UserException(Objects.requireNonNull(result.getFieldError()));
        }
        return userService.updateUser(user);
    }

    @GetMapping("/delete/{userId}")
    public List<User> deleteUser(@PathVariable Long userId) {
        User user = userService.findUser(userId);
        publisher.publishEvent(new UserDeleteEvent(this, user));
        return userService.getUsers();
    }

    @GetMapping("/users/{term}")
    public List<User> getUserWithAddress(@PathVariable String term) {
        return userService.findUserWithAddress(term);
    }

    @GetMapping("/test")
    public void test() throws JSONException, JsonProcessingException {
        String text = "{\"Idea ID\":{\"0\":26627,\"1\":74762,\"2\":67087,\"3\":74768,\"4\":26131,\"5\":28179},\"Idea Title\":{\"0\":\"Enhanced Participant Profiles via URL to OpenID page or other URL\",\"1\":\"See all data per campaign, not just for last weeks\\/months\",\"2\":\"Campaign-Specific Languages & Strings\",\"3\":\"Spaghetti With Fried Eggs\",\"4\":\"Poker chip: allocate votes to specific users\",\"5\":\"Provide Admins with Ideascale Update Notifications in Advance\"},\"Score\":{\"0\":0.0,\"1\":0.0,\"2\":0.0,\"3\":0.0,\"4\":0.0,\"5\":0.0},\"Idea URL\":{\"0\":\"https:\\/\\/string\\/a\\/dtd\\/26627-3339\",\"1\":\"https:\\/\\/string\\/a\\/dtd\\/74762-3339\",\"2\":\"https:\\/\\/string\\/a\\/dtd\\/67087-3339\",\"3\":\"https:\\/\\/string\\/a\\/dtd\\/74768-3339\",\"4\":\"https:\\/\\/string\\/a\\/dtd\\/26131-3339\",\"5\":\"https:\\/\\/string\\/a\\/dtd\\/28179-3339\"}}";
        JSONObject jsonObject = new JSONObject(text);
        ObjectMapper objectMapper = new ObjectMapper();
        SuggestedIdeas ideas = objectMapper.readValue(jsonObject.toString(), SuggestedIdeas.class);
        log.info(jsonObject);
        log.info(ideas);
    }

    @PostMapping("/create-note")
    public List<Note> createNote(@RequestBody Note note) {
        userService.saveNote(note);
        return noteRepository.findAll();
    }

    // Todo: only testing Transactional
    @GetMapping("/reset-note/{userId}")
    public List<Note> resetUser(@PathVariable Long userId) {
        publisher.publishEvent(new NoteRestEvent(this, userId));
        return noteRepository.findAll();
    }

    @GetMapping("/note/service")
    public Note noteService() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://rookie-service:8080/get/note";
        return restTemplate.getForObject(url, Note.class);
    }
}
