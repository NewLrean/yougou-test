package yougou.shopping.mapper;

import java.util.List;

import yougou.shopping.pojo.TbItemCat;

public interface TbItemCatMapper {
	List<TbItemCat> getItemCatList(Long id);
	
	
}