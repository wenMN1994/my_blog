package com.dragon.base;

import com.dragon.blog.model.BlogSysUser;
import com.dragon.utils.AjaxResult;
import com.dragon.utils.DateUtils;
import com.dragon.utils.SqlUtil;
import com.dragon.utils.StringUtils;
import com.dragon.utils.page.PageDomain;
import com.dragon.utils.page.TableDataInfo;
import com.dragon.utils.page.TableSupport;
import com.dragon.utils.security.ShiroUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

/**
 * 
 * <p>Title: BaseController</p>  
 * <p>Description: 控制器基类</p>  
 * @author Dragon.Wen
 * @date Oct 17, 2018
 */
public abstract class BaseController {

	private final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	/**
	 * 统一异常处理
	 * @param request
	 * @param response
	 * @param exception
	 */
	@ExceptionHandler
	public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
		LOGGER.error("统一异常处理：", exception);
		request.setAttribute("ex", exception);
		if (null != request.getHeader("X-Requested-With") && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
			request.setAttribute("requestHeader", "ajax");
		}
		return "统一异常处理：";
	}

	/**
	 * 将前台传递过来的日期格式的字符串，自动转化为Date类型
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date 类型转换
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(DateUtils.parseDate(text));
			}
		});
	}

	/**
	 * 设置请求分页数据
	 */
	protected void startPage() {
		PageDomain pageDomain = TableSupport.buildPageRequest();
		Integer pageNum = pageDomain.getPageNum();
		Integer pageSize = pageDomain.getPageSize();
		if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
			String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
			PageHelper.startPage(pageNum, pageSize, orderBy);
		}
	}

	/**
	 * 响应请求分页数据
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	protected TableDataInfo getDataTable(List<?> list) {
		TableDataInfo rspData = new TableDataInfo();
		rspData.setCode(0);
		rspData.setRows(list);
		rspData.setTotal(new PageInfo(list).getTotal());
		return rspData;
	}

	/**
	 * 响应返回结果
	 *
	 * @param rows 影响行数
	 * @return 操作结果
	 */
	protected AjaxResult toAjax(int rows) {
		return rows > 0 ? success() : error();
	}

	/**
	 * 响应返回结果
	 *
	 * @param result 结果
	 * @return 操作结果
	 */
	protected AjaxResult toAjax(boolean result) {
		return result ? success() : error();
	}

	/**
	 * 返回成功
	 */
	public AjaxResult success() {
		return AjaxResult.success();
	}

	/**
	 * 返回失败消息
	 */
	public AjaxResult error() {
		return AjaxResult.error();
	}

	/**
	 * 返回成功消息
	 */
	public AjaxResult success(String message) {
		return AjaxResult.success(message);
	}

	/**
	 * 返回失败消息
	 */
	public AjaxResult error(String message) {
		return AjaxResult.error(message);
	}

	/**
	 * 返回错误码消息
	 */
	public AjaxResult error(int code, String message) {
		return AjaxResult.error(code, message);
	}

	/**
	 * 页面跳转
	 */
	public String redirect(String url) {
		return StringUtils.format("redirect:{}", url);
	}

	public BlogSysUser getSysUser() {
		return ShiroUtils.getSysUser();
	}

	public void setSysUser(BlogSysUser user) {
		ShiroUtils.setSysUser(user);
	}

	public Integer getUserId() {
		return getSysUser().getUserId();
	}

	public String getLoginName() {
		return getSysUser().getLoginName();
	}

}
