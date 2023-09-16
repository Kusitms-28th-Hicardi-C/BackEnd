package com.example.hicardi.domain.FileUpload.controller;

import com.amazonaws.services.s3.AmazonS3;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class S3FileDownloadController {


    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;



    @GetMapping("/test")
    public ResponseEntity<UrlResource> downloadImage(String originalFilename) {

        originalFilename = "aws test.txt.txt";
        UrlResource urlResource = new UrlResource(amazonS3.getUrl(bucket, originalFilename));

        String contentDisposition = "attachment; filename=\"" +  originalFilename + "\"";

        // header에 CONTENT_DISPOSITION 설정을 통해 클릭 시 다운로드 진행
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(urlResource);

    }
}
