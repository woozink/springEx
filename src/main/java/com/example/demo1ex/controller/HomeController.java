package com.example.demo1ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @Autowired
    private HomeService homeService;
    private Map<Integer, Person> phoneBook = new HashMap<>();

    //전화번호부 전체 조회합니다.
    @GetMapping("/persons")
    public String phoneBook(){
        return phoneBook.toString();
    }

    //전화번호부에서 특정 id 조회
    ///person/7
    @GetMapping("/persons/{id}")
    public void replacePhoneBook(@PathVariable int id, @RequestBody Person person){
        phoneBook.put(id, person);
    }

    @PostMapping("/persons")
    public void phoneBook(@RequestBody Person person){
        phoneBook.put(person.getId(), person);
    }

    @DeleteMapping("/Persons/{id}")
    public void deletePhoneBook(@PathVariable int id){
        phoneBook.remove(id);
    }
}
