package cn.dataAnalysis.common.page;

import java.io.Serializable;
import java.util.List;

/**
 * JqGrid数据组装类
 * Created by dongdongshi on 16/2/3.
 */
public class JqGridPage {
    /** 当前页码 **/
    private int page;
    /** 总页数 **/
    private int total;
    /** 总记录数 **/
    private long records;
    /** 记录列表 **/
    private List<? extends Serializable> rows;


    public void setTotal(int total) {
        this.total = total;
    }

    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<? extends Serializable> getRows() {
        return rows;
    }

    public void setRows(List<? extends Serializable> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

}
