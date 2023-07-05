package fun.timu.wiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.timu.wiki.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author zhengke
 * @description 针对表【user(用户)】的数据库操作Mapper
 * @createDate 2023-07-05 15:25:33
 * @Entity wiki.entity.User
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}




