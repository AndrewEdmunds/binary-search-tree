package com.binary_search_tree.main;

import com.binary_search_tree.main.Entity.InputNumbersEntity;
import com.binary_search_tree.main.Entity.TreeStructureEntity;
import com.binary_search_tree.main.Repo.InputNumbersRepository;
import com.binary_search_tree.main.Repo.TreeStructureRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BinarySearchTreeService {

    @Autowired
    private TreeStructureRepository treeStructureRepository;

    @Autowired
    private InputNumbersRepository inputNumbersRepository;

    private final ObjectMapper objectMapper;

    public BinarySearchTreeService() {
        this.objectMapper = new ObjectMapper();
    }

    public void saveInputNumbers(List<Integer> numbers) {
        String numbersString = numbers.stream()
                                     .map(Object::toString)
                                     .collect(Collectors.joining(","));
        InputNumbersEntity entity = new InputNumbersEntity(numbersString);
        inputNumbersRepository.save(entity);
    }

    public void constructAndSaveBinarySearchTree() {
        List<InputNumbersEntity> latestEntry = inputNumbersRepository.findTopByOrderByCreatedAtDesc();
        if (latestEntry.isEmpty()) {
            return;
        }

        List<String> numberStrings = Arrays.asList(latestEntry.get(0).getNumbers().split(","));
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString.trim()));
        }

        BinarySearchTree bst = new BinarySearchTree();
        for (Integer number : numbers) {
            bst.insert(number);
        }

        String jsonRepresentation = bst.toJSON();

        TreeStructureEntity treeStructureEntity = new TreeStructureEntity(jsonRepresentation);
        treeStructureRepository.save(treeStructureEntity);
    }
}
