package cn.dataAnalysis.common.page;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.common.utils.bean.PageBean;
import org.common.utils.bean.PageParameters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 * Created by dongdongshi on 16/2/3.
 */
public class PageUtils {

    /**
     * 获取分页的bean
     * @param request
     * @return
     */
    public static Pageable getPageable(HttpServletRequest request){
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer rows = Integer.parseInt(request.getParameter("rows"));
        String sidx = request.getParameter("sidx");
        String sord = request.getParameter("sord");

        // 获取排序的字段
        Sort sort = null;
        if(StringUtils.isNotBlank(sidx)){
            sort = new Sort(Sort.Direction.fromString(sord),  sidx);
        }
        // Pageable 创建，提供页数，
        // 注意spring data pageable是第一页是从0开始的，所以此处-1了
        Pageable pageable = new PageRequest(page - 1, rows, sort);
        return pageable;
    }

    public static JqGridPage toJqGridPage(Page<? extends Serializable> pagess){
        JqGridPage jqGridPage = new JqGridPage();
        // 注意spring data pagess是第一页是从0开始的，所以此处+1了
        jqGridPage.setPage(pagess.getNumber() + 1);
        jqGridPage.setTotal(pagess.getTotalPages());
        jqGridPage.setRecords(pagess.getTotalElements());
        jqGridPage.setRows(pagess.getContent());
        return jqGridPage;
    }

    public static JqGridPage toJqGridPage(PageInfo<? extends Serializable> pageInfo){
        JqGridPage jqGridPage = new JqGridPage();
        // 注意spring data pagess是第一页是从0开始的，所以此处+1了
        /*jqGridPage.setPage(pagess.getNumber() + 1);
        jqGridPage.setTotal(pagess.getTotalPages());
        jqGridPage.setRecords(pagess.getTotalElements());
        jqGridPage.setRows(pagess.getContent());*/
        jqGridPage.setPage(pageInfo.getPageNum());
        jqGridPage.setTotal((int)pageInfo.getTotal());
        jqGridPage.setRecords(pageInfo.getTotal());
        jqGridPage.setRows(pageInfo.getList());
        return jqGridPage;
    }
    
    public static JqGridPage toJqGridPage(PageBean<? extends Serializable> pageBean){
    	JqGridPage jqGridPage = new JqGridPage();
        jqGridPage.setPage(pageBean.getPage());
        jqGridPage.setTotal(pageBean.getTotal());
        jqGridPage.setRecords(pageBean.getRecords());
        jqGridPage.setRows(pageBean.getRows());
        return jqGridPage;
    }
    
    public static JqGridPage setListToJqGridPage(List<? extends Serializable> pageBean, int page, int total,int rows){
        JqGridPage jqGridPage = new JqGridPage();
        
        /*jqGridPage.setPage(page);
    	jqGridPage.setRecords(total);
    	jqGridPage.setTotal(total % page == 0 ? total / page : total / page+ 1);
    	jqGridPage.setRows(pageBean);*/
    	
        jqGridPage.setPage(page);
        jqGridPage.setTotal(total % rows == 0 ? 1 : total / rows+ 1);
        jqGridPage.setRecords(total);
        jqGridPage.setRows(pageBean);
        return jqGridPage;
    }
    
    public static Pageable toPageable(PageParameters bean) {
		Integer page = bean.getPage();
		Integer rows = bean.getRows();
		String sidx = bean.getSidx();
		String sord = bean.getSord();

		// 获取排序的字段
		Sort sort = null;
		if (StringUtils.isNotBlank(sidx)) {
			sort = new Sort(Sort.Direction.fromString(sord), sidx);
		}
		// Pageable 创建，提供页数，
		// 注意spring data pageable是第一页是从0开始的，所以此处-1了
		Pageable pageable = new PageRequest(page - 1, rows, sort);
		return pageable;
	}
}
