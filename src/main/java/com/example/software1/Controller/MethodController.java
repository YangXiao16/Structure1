package com.example.software1.Controller;

import com.example.software1.Method.MainSubprogram.MainSubprogram;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import static com.example.software1.Method.FileSystem.Main.FS;
import static com.example.software1.Method.Filefilter.Main.FF;
import static com.example.software1.Method.ObjectOriented.Main.OO;

@RestController
public class MethodController {

    @PostMapping("/processFile")
    public ResponseEntity<String> processFile(MultipartFile file, int method) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Error: File is empty.");
        }

        try {
            File uploadedFile = convertMultipartFileToFile(file);
            String processedContent =
                    processFileContent(uploadedFile, method);
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(processedContent);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    private File convertMultipartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        Files.copy(file.getInputStream(), convertedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return convertedFile;
    }

    public static String ReadFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(MainSubprogram.MS(file)));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        return stringBuilder.toString();
    }

    private String processFileContent(File file, int method) throws IOException {
        String processedContent = null;

        switch (method) {
            case 1:
                processedContent = MainSubprogram.MS(file);
                break;
            case 2:
                processedContent = OO(file);
                break;
            case 3:
                processedContent = FS(file);
                break;
            case 4:
                processedContent = FF(file);
                break;
            default:
                return "Error: Unknown method";
        }

        return processedContent;
    }
}