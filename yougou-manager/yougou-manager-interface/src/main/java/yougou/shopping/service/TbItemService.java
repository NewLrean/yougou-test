package yougou.shopping.service;

import java.util.ArrayList;

import yougou.shopping.common.pojo.EazyUIDataGridResult;
import yougou.shopping.common.pojo.TaotaoResult;
import yougou.shopping.pojo.TbItem;
import yougou.shopping.pojo.TbItemDesc;

public interface TbItemService {
	TbItem selectByPrimaryKey(Long id);
	
	EazyUIDataGridResult selectAllItem(int pageNum, int pageSize);
	
	TaotaoResult saveitem(TbItem item, TbItemDesc itemDesc, String itemParams);
	
	TaotaoResult deleteItems(ArrayList<Long> list);
	
	TaotaoResult reshelfItems(ArrayList<Long> list);
	
	TaotaoResult theshelvesItems(ArrayList<Long> list);

	TbItemDesc selectItemDescById(Long id);

	TaotaoResult updateItem(TbItem item, TbItemDesc itemDesc,String itemParams,Long itemParamId);
}
