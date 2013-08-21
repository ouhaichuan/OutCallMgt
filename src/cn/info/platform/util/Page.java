package cn.info.platform.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 * ����Ϊ������ҳ��,���ڲ�ѯ����ʱ��
 * 
 * @author HCOU
 * 
 * @param <T>
 */
public class Page<T> {
	// ��ҳ
	private final int firstPage = Constants.FIRST_PAGE;

	// ÿҳ��������
	private int pageData = Constants.PAGE_DATA;

	// ��ǰҳ
	private int curPage = Constants.FIRST_PAGE;

	// ��һҳ
	private int nextPage;

	// ��һҳ
	private int prePage;

	// ���һҳ
	private int endPage;

	// ��ҳ��
	private int totalPage;

	// ��������
	private int totalData;

	// ���������
	@SuppressWarnings("unchecked")
	private List<T> dataList = Collections.EMPTY_LIST;

	// ҳ��
	private List<Integer> pageList = new ArrayList<Integer>();

	/**
	 * ���������Ĺ��췽��
	 * 
	 * @param totalData
	 *            �ܹ���������
	 * @param dataList
	 *            Ҫ��ʾ������
	 */
	public Page(HttpServletRequest request, int totalData) {
		this.totalData = totalData;
		pageValue(request);
	}

	/**
	 * ���������Ĺ��췽��
	 * 
	 * @param totalData
	 *            �ܹ���������
	 * @param dataList
	 *            Ҫ��ʾ������
	 */
	public Page(HttpServletRequest request, int totalData, int pageData) {
		this.totalData = totalData;
		this.pageData = pageData;
		pageValue(request);
	}

	public int getFirstPage() {
		return firstPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getPageData() {
		return pageData;
	}

	public int getTotalData() {
		return totalData;
	}

	public List<?> getDataList() {
		return dataList;
	}

	public List<Integer> getPageList() {
		return pageList;
	}

	private void pageValue(HttpServletRequest request) {
		// �õ�Ҫ��ѯ����ҳ��ҳ��,���ַ�����ʽ����
		String strCurPage = request.getParameter(Constants.CUR_PAGE_NAME);
		// �õ�ÿһҳҪ��ʾ����������,���ַ�����ʽ����
		String strDataPage = request.getParameter(Constants.PAGE_DATA_NAME);
		if (null == strCurPage) {
			Object objCurPage = request.getAttribute(Constants.CUR_PAGE_NAME);
			strCurPage = objCurPage == null ? null : objCurPage.toString();
		}
		if (null == strDataPage) {
			Object objCurPage = request.getAttribute(Constants.PAGE_DATA_NAME);
			strDataPage = objCurPage == null ? null : objCurPage.toString();
		}

		// �жϴ�������ҳ���ǲ���Int�͵�
		if (strCurPage != null && strCurPage.matches(Constants.NUMBER_REGEX)) {
			this.curPage = Integer.valueOf(strCurPage);
		}
		// �жϴ�������ҳ���ǲ���Int�͵�
		if (strDataPage != null && strDataPage.matches(Constants.NUMBER_REGEX)) {
			this.pageData = Integer.valueOf(strDataPage);
		}
		pageList.add(Constants.FIRST_PAGE);
		if (0 != totalData) {
			// �õ���ҳ���Լ����һҳ
			this.endPage = this.totalPage = totalData % pageData == 0 ? totalData
					/ pageData
					: totalData / pageData + 1;
			for (int i = 2; i <= endPage; i++) {
				pageList.add(i);
			}

			// �жϵ�ǰҳ��ҳ���Ƿ�Ϸ�
			this.curPage = curPage > totalPage ? totalPage : curPage;
			// �õ�ǰһҳ��ҳ��
			this.prePage = curPage < 2 ? firstPage : curPage - 1;
			// �õ���һҳ��ҳ��
			this.nextPage = curPage == totalPage ? totalPage : curPage + 1;
		}
	}

	/**
	 * ��������ӽ���
	 * 
	 * @param dataList
	 *            Ҫ��ҳ������ʾ������
	 */
	public void addData(List<T> dataList) {
		if (null != dataList && !dataList.isEmpty()) {
			this.dataList = dataList;
		}
	}
}