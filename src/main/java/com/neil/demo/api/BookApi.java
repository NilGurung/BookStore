package com.neil.demo.api;

import com.neil.demo.domain.Book;
import com.neil.demo.service.BookService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/book")
public class BookApi {

    private String imageName;

    @Autowired
    private BookService bookService;



    @RequestMapping(value="/add" , method=RequestMethod.POST)
    public Book addBookPost(@RequestBody Book book) {
        return bookService.save(book);
    }

    @RequestMapping(value="/update" , method=RequestMethod.POST)
    public Book updatBookPost(@RequestBody Book book) {

        return bookService.save(book);
    }

    @RequestMapping(value="/add/image" , method=RequestMethod.POST)
    public ResponseEntity updateImage(@RequestParam("id") Long id,
                            HttpServletResponse response, HttpServletRequest request) {

            try {
                Book book = bookService.findOne(id);
                MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
                Iterator<String> it = multipartHttpServletRequest.getFileNames();
                MultipartFile multipartFile = multipartHttpServletRequest.getFile(it.next());
                String fileName = id+ ".png";
                imageName = fileName;

                byte[] bytes = multipartFile.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/book/book" + fileName)));
                stream.write(bytes);
                stream.close();
                return new ResponseEntity("Upload Success!", HttpStatus.OK);
            } catch(Exception e) {
                e.printStackTrace();
                return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
            }
    }

    @RequestMapping(value="/update/image" , method=RequestMethod.POST)
    public ResponseEntity uploadImage(@RequestParam("id") Long id,
                                      HttpServletResponse response, HttpServletRequest request) {

        try {
            Book book = bookService.findOne(id);
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            Iterator<String> it = multipartHttpServletRequest.getFileNames();
            MultipartFile multipartFile = multipartHttpServletRequest.getFile(it.next());
            String fileName = id+ ".png";
            imageName = fileName;

            Files.delete(Paths.get("src/main/resources/static/image/book/book" + fileName));
            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/book/book" + fileName)));
            stream.write(bytes);
            stream.close();
            return new ResponseEntity("Upload Success!", HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/list")
    public List<Book> addBookPost() {
        return bookService.findAll();
    }

    @RequestMapping(value="/view/{id}")
    public Book getBook(@PathVariable("id") Long id) {
        Book book = bookService.findOne(id);
        return book;
    }

    @RequestMapping(value="/delete" , method=RequestMethod.POST)
    public ResponseEntity deleteBook (@RequestBody String id) throws IOException {

         bookService.removeOne(Long.parseLong(id));
        String fileName = id+ ".png";
        imageName = fileName;

        Files.delete(Paths.get("src/main/resources/static/image/book/book" + fileName));

        return  new ResponseEntity("Remove Success", HttpStatus.OK);

    }


}
