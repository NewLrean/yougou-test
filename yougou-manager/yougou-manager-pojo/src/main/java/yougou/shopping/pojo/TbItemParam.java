package yougou.shopping.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbItemParam implements Serializable{
    private Long id;

    private Long itemCatId;

    private Date created;

    private Date updated;

    private String paramData;

    private String itemCatName;

    private TbItemCat tbItemCat;

    public String getItemCatName() {
        return itemCatName;
    }

    public void setItemCatName(String itemCatName) {
        this.itemCatName = itemCatName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    public TbItemCat getTbItemCat() {
        return tbItemCat;
    }

    public void setTbItemCat(TbItemCat tbItemCat) {
        this.tbItemCat = tbItemCat;
    }

    @Override
    public String toString() {
        return "TbItemParam{" +
                "id=" + id +
                ", itemCatId=" + itemCatId +
                ", created=" + created +
                ", updated=" + updated +
                ", paramData='" + paramData + '\'' +
                ", itemCatName='" + itemCatName + '\'' +
                ", tbItemCat=" + tbItemCat +
                '}';
    }
}