package fri.diplomska.diplomska.controllers;

import fri.diplomska.diplomska.docker.ImageBuilder;
import fri.diplomska.diplomska.helpers.Helper;
import fri.diplomska.diplomska.kubernetes.Deployer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {
    @PostMapping("/uploadDockerImage")
    public String index(@RequestParam("file") MultipartFile file) {
        try {
            ImageBuilder imageBuilder = new ImageBuilder();
            String filePathToSave = Helper.getProjectPath() + "docker\\";
            file.transferTo(new File(filePathToSave + file.getOriginalFilename()));
            String imageId = imageBuilder.build(filePathToSave);
            Deployer deployer = new Deployer();
            deployer.deploy(imageId);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return "home";
    }
}
