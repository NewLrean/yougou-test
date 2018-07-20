package yougou.shopping.mapper.rest;

import yougou.shopping.pojo.TbItem;

public interface TbItemMapper {
    TbItem selectByPrimaryKey(Long id);

}