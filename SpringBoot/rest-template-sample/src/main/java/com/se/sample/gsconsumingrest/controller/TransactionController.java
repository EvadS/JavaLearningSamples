package com.se.sample.gsconsumingrest.controller;

import com.se.sample.gsconsumingrest.exception.ResourceNotFoundException;
import com.se.sample.gsconsumingrest.model.TransactionItemResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.function.Function;


@RestController("/transfer")
public class TransactionController {

    private static List<TransactionItemResponse> list = Arrays.asList(
            new TransactionItemResponse("1", 1, false, true),
            new TransactionItemResponse("2", 1, false, true),
            new TransactionItemResponse("3", 1, false, true),
            new TransactionItemResponse("4", 1, false, true),
            new TransactionItemResponse("5", 1, false, true)
    );
    Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }


    // api/foos?id=abc
    @GetMapping("/api/foos")
    @ResponseBody
    public String getFoos(@RequestParam(required = false) String id) {
        return "ID: " + id;
    }

//    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody
//    ResponseEntity<Object> all()  {
//
//        List<JSONObject> entities = new ArrayList<JSONObject>();
//        for (TransactionItemResponse n : list) {
//
//            JSONObject entity = new JSONObject();
//            entity.put("encodedTransaction", n.getEncodedTransaction());
//            entity.put("executedTime", n.getExecutedTime());
//            entities.add(entity);
//        }
//        return new ResponseEntity<Object>(entities, HttpStatus.OK);
//    }

    @GetMapping("/all2")
    public ResponseEntity<List<TransactionItemResponse>> all2() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "MyController");

        return ResponseEntity.ok().headers(headers).body(list);
    }

    @GetMapping("/all3")
    @ResponseBody
    public List<TransactionItemResponse> all3() {
        return list;
    }

    @GetMapping(path = "/all-page")
    public Page<TransactionItemResponse> readPageable(@NotNull final Pageable pageable) {
        Page<TransactionItemResponse> response = getTransactionItemResponses();

        return response;
    }

    @GetMapping("get/{id}")
    @ResponseBody
    public String getFoos(@PathVariable("id") int id) {
        return "ID: " + id;
    }


    @GetMapping("get2/{id}")
    @ResponseBody
    public ResponseEntity<TransactionItemResponse> gettrans(@PathVariable("id") int id) {

        logger.info("get : id  " + id );
        HttpHeaders responseHeaders = new HttpHeaders();
        // ...
        return new ResponseEntity<>(list.get(0), responseHeaders, HttpStatus.OK);
    }



    // HOW TO CREATE
    @PostMapping("/create")
    public void createTransaction(@RequestBody TransactionItemResponse transaction) {
        list.add(transaction);
    }

    @PostMapping("/create2")
    public ResponseEntity<?> createTransaction2(@RequestBody TransactionItemResponse transaction) {
        if (!transaction.isSuccess()) {
            return new ResponseEntity<>(
                    "transaction Not executed",
                    HttpStatus.BAD_REQUEST);
        }

        list.add(transaction);

        return new ResponseEntity<>("completed ", HttpStatus.OK);
    }


    @PostMapping(path="/create-list")
    @ResponseBody
    public List<TransactionItemResponse> generatePersonList(@RequestBody List<TransactionItemResponse> person){
        return list;
    }

    @PutMapping("/update")
    public void updateTransaction(TransactionItemResponse transaction) {
        logger.info("put " + transaction.toString());
        Optional<TransactionItemResponse> res2 = list.stream().filter(x -> x == transaction).findFirst();

        if (!res2.isPresent()) {
            throw new ResourceNotFoundException(transaction.toString());
        }

        updateTransaction(transaction, res2);
    }

    private void updateTransaction(TransactionItemResponse transaction, Optional<TransactionItemResponse> res) {
        list.remove(res.get());
        list.add(transaction);
    }

    @PutMapping("/update2")
    public ResponseEntity<?> updateTransaction2(TransactionItemResponse transaction) {
        logger.info("/update2 " + transaction.toString());
        Optional<TransactionItemResponse> res = list.stream().filter(x -> x == transaction).findFirst();

        if (!res.isPresent()) {
            throw new ResourceNotFoundException(transaction.toString());
        }

        updateTransaction(transaction, res);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }


    @DeleteMapping("/del/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteFoos(@PathVariable("id") int id) {

        logger.info("/del " + id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/del2/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        logger.info(" DeleteMapping /del/{id}" + id);
        Optional<TransactionItemResponse> taskSaved = list.stream().filter(x -> x.getExecutedTime() < id).findFirst();
        if (taskSaved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        list.remove(taskSaved);
        return ResponseEntity.ok().build();
    }


    private Page<TransactionItemResponse> getTransactionItemResponses() {
        return new Page<TransactionItemResponse>() {
            @Override
            public int getTotalPages() {
                return 1;
            }

            @Override
            public long getTotalElements() {
                return 10;
            }

            @Override
            public <U> Page<U> map(Function<? super TransactionItemResponse, ? extends U> function) {
                return null;
            }

            @Override
            public int getNumber() {
                return 0;
            }

            @Override
            public int getSize() {
                return 1;
            }

            @Override
            public int getNumberOfElements() {
                return 5;
            }

            @Override
            public List<TransactionItemResponse> getContent() {
                return list;
            }

            @Override
            public boolean hasContent() {
                return true;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public boolean isFirst() {
                return false;
            }

            @Override
            public boolean isLast() {
                return false;
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Pageable nextPageable() {
                return null;
            }

            @Override
            public Pageable previousPageable() {
                return null;
            }

            @Override
            public Iterator<TransactionItemResponse> iterator() {
                return list.iterator();
            }
        };
    }

//    public boolean delete(Long id) {
//        var isRemoved = this.posts.removeIf(post -> post.getId().equals(id));
//    }

}
