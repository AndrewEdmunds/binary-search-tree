package com.binary_search_tree.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class BinarySearchTreeController {

    @Autowired
    private BinarySearchTreeService bstService;

    @PostMapping("/enter-numbers")
    public ResponseEntity<String> enterNumbers(@RequestBody List<Integer> numbers) {
        bstService.saveInputNumbers(numbers);
        return ResponseEntity.ok("Numbers saved successfully");
    }

    @PostMapping("/process-numbers")
    public ResponseEntity<String> processNumbers() {
        bstService.constructAndSaveBinarySearchTree();
        return ResponseEntity.ok("Binary search tree constructed and saved successfully");
    }
    
}
