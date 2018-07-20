package yougou.shopping.mapper;

import yougou.shopping.pojo.TbItemDesc;

public interface TbItemDescMapper {
	boolean saveTbItemDesc(TbItemDesc itemDesc);

	TbItemDesc selectItemDescById(Long id);

	boolean updateTbItemDesc(TbItemDesc itemDesc);
}