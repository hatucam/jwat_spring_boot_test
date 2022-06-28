package src.main.java.springboot.controllers;

import com.springboot.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")
@RestController
public class MovieController {
    @Autowired
    MovieSevice movieSevice;

    @ApiOperation(value = "Lấy danh sách phim")
    @GetMapping("")
    public ResponseEntity<?> getAllMovies(){
        return ResponseEntity.ok(movieSevice.getAllMovie());
    }

}
