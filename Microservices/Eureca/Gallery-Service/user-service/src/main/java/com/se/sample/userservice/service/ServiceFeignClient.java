package com.se.sample.userservice.service;


import com.se.sample.userservice.model.Bucket;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.hystrix.FallbackFactory;
import feign.hystrix.HystrixFeign;
import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

@FeignClient(name = "gallery-service", url = "http://localhost:8081/", fallback = Fallback.class)
public interface ServiceFeignClient {

    class FeignHolder {
        public static ServiceFeignClient create() {
            return HystrixFeign.builder()
                    .encoder(new GsonEncoder())
                    .decoder(new GsonDecoder())
                    .target(ServiceFeignClient.class, "http://localhost:8081/", new FallbackFactory<ServiceFeignClient>() {
                @Override
                public ServiceFeignClient create(Throwable throwable) {
                    return new ServiceFeignClient() {
                        @Override
                        public List<Bucket> getAllEmployeesList() {
                            System.out.println(throwable.getMessage());
                            return null;
                        }
                    };
                }
            });
        }
    }

    /**
     * Метод должен иметь возвращаемое значение и по сигнатуре быть точно таким же как и метод на gallery-service,
     * который мы вызываем, а именно метод по пути /show
     * @return
     */
    @RequestLine("GET /show")
    List<Bucket> getAllEmployeesList();

}