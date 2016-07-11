package top.fzqblog.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper<T, Q>  extends BaseMapper<T, Q>{
	
}