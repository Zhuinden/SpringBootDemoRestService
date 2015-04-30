package springpetserver.repository;

import org.springframework.stereotype.Repository;
import springpetserver.entity.HelloWorldEntity;

/**
 * Created by Zhuinden on 2015.04.30..
 */
@Repository
public interface HelloWorldRepository extends BaseRepository<HelloWorldEntity, Long> {
}
