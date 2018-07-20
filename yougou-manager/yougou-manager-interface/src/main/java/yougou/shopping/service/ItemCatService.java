package yougou.shopping.service;

import java.util.List;


import yougou.shopping.common.pojo.EUTreeNode;

public interface ItemCatService {
	List<EUTreeNode> getCatList(Long parentId);
	
	
}
