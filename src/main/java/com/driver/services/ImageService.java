package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image=new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        Blog blog=blogRepository2.findById(blogId).get();
        image.setBlog(blog);

        List<Image>imageList=blog.getImageList();
        imageList.add(image);
        blogRepository2.save(blog);
        return image;

    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
          int count=0;
          String [] diaa= screenDimensions.split("X");
          Image image=imageRepository2.findById(id).get();
          String imageDia=image.getDimensions();
          String [] imgdia=imageDia.split("X");

          int imgx=Integer.parseInt(imgdia[0]);
          int imgy=Integer.parseInt(imgdia[1]);

          int diax=Integer.parseInt(diaa[0]);
          int diay=Integer.parseInt(diaa[1]);

          int countx=diax/imgx;
          int county=diay/imgy;

          count= countx*county;
   return count;

    }
}
