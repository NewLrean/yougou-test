package yougou.shopping.rest.service;

import yougou.shopping.pojo.TbItem;

/**
 * Created by 蒋志鹏 on 2018/7/5.
 */
public interface SearchAboutService {
    TbItem selectByPrimaryKey(long id);

    String getItemDescById(long id);
}
