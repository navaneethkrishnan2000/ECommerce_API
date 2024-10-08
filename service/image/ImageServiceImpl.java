package com.ekart.easy_connect.service.image;

import com.ekart.easy_connect.dto.ImageDto;
import com.ekart.easy_connect.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageServiceImpl {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImages(List<MultipartFile> file, Long productId);
    void updateImage(MultipartFile file, Long imageId);

}
