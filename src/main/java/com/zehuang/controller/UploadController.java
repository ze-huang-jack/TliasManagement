package com.zehuang.controller;

import com.zehuang.pojo.Result;
import com.zehuang.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {

    @Autowired
    private AliyunOSSOperator ossOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("上传文件: {}", file);
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String url = ossOperator.upload(file.getBytes(), originalFilename);
            return Result.success(url);
        }
        return Result.error("上传失败");
    }
}




