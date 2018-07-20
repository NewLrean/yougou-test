package yougou.shopping.mapper;


import yougou.shopping.pojo.TbContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbContentMapper {
    List<TbContent> queryContentsByCid(long categoeyId);

    boolean saveOneContent(TbContent tbContent);

    boolean deleteContentList(@Param("list") List<Long> list);


    boolean updateContent(TbContent tbContent);

    TbContent selectOneContent(long id);
}