package com.hackerrank.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RequestController {
    public static final String UPLOAD_DIR = "/home/akise/java/proj1/";

    @PostMapping("/uploader")
    public ResponseEntity<Object> uploader(@RequestParam("fileName") String fileName, @RequestParam("file") MultipartFile file) throws IOException {
        File myFile = new File(UPLOAD_DIR+fileName+file.getName());
        myFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
        return new ResponseEntity<Object>(fileName, HttpStatus.OK);
    }

    @GetMapping("/downloader")
    public ResponseEntity downloader(@RequestParam String fileName) {
        return null;
    }

    @GetMapping("/test")
    public String welcome(){
        return "Test API";

    }
}
