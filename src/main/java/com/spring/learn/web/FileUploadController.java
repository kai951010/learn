package com.spring.learn.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by rock on 2017/6/26.
 */

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    @RequestMapping(method = RequestMethod.GET)
    public String upload(){
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file){
        File target = new File("/Users/rock/Desktop/a.jpg");
        try {
            file.transferTo(target);
        }catch (IOException e){
            e.printStackTrace();
        }
        return "success";
    }
}
