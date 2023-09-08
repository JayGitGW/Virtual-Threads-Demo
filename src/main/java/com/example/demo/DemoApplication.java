package com.example.demo;

import com.example.demo.service.TraditionalThreadsService;
import com.example.demo.service.VirtualThreadsService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);

    /* Creating max no. of threads */

     //VirtualThreadsService.demo1();
     //TraditionalThreadsService.demo1();

    /*--------------------------------------------*/

    /* Throughput */

    //VirtualThreadsService.demo2();
    //TraditionalThreadsService.demo2();
  }
}
