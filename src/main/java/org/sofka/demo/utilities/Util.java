package org.sofka.demo.utilities;

import org.sofka.demo.mappers.Mapper;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Util {


    public static <D,E> Function<D,Mono<D>> save (ReactiveMongoRepository<E,String> repository,Mapper<E,D> mapper ){

        return dto ->repository
                .save(mapper
                        .convertDtoToEntity()
                        .apply(dto))
                .map(country1 -> mapper
                        .convertEntityToDto()
                        .apply(country1));

    }


}
