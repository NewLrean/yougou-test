package yougou.shopping.service.content;

import yougou.shopping.content.pojo.CatjsonResult;
import yougou.shopping.pojo.TbItemCat;

import java.util.List;

/**
 * Created by 蒋志鹏 on 2018/7/16.
 */
public interface IndexCatService {
    List<TbItemCat> queryCats(Long parentId);

    CatjsonResult getCatjsonResult();
}
