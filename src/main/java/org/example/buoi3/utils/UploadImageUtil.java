package org.example.buoi3.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.example.buoi3.exception.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UploadImageUtil {
    private final Cloudinary cloudinary;
    
    public UploadImageUtil(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }
    
    public String getUrlFromFile(MultipartFile multipartFile) {
        try {
            Map<?, ?> map = cloudinary.uploader().upload(multipartFile.getBytes(),
                                                         ObjectUtils.emptyMap());
            return map.get("secure_url").toString();
        } catch (IOException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
    
    public List<String> getMultiUrl(List<MultipartFile> multipartFiles) {
        try {
            List<String> urls = new ArrayList<>();
            for (MultipartFile file : multipartFiles) {
                Map<?, ?> map = cloudinary.uploader().upload(file.getBytes(),
                                                             ObjectUtils.emptyMap());
                urls.add(map.get("secure_url").toString());
            }
            return urls;
        } catch (IOException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
