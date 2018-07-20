package yougou.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yougou.shopping.common.pojo.EUTreeNode;
import yougou.shopping.mapper.TbItemCatMapper;
import yougou.shopping.pojo.TbItemCat;
import yougou.shopping.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
    TbItemCatMapper itemCatMapper;

	@Override
	public List<EUTreeNode> getCatList(Long parentId) {
		// TODO Auto-generated method stub
		List<EUTreeNode> euTreeNodes=new ArrayList<EUTreeNode>();
		List<TbItemCat> findallCatParent = itemCatMapper.getItemCatList(parentId);
		for (TbItemCat tbItemCat : findallCatParent) {
			EUTreeNode euTreeNode=new EUTreeNode();
			euTreeNode.setId(tbItemCat.getId());
			euTreeNode.setText(tbItemCat.getName());
			euTreeNode.setState(tbItemCat.getIsparent()?"closed":"open");
			euTreeNodes.add(euTreeNode);
		}
		return euTreeNodes;
	}
	
	
	

}
