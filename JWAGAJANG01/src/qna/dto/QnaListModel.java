package qna.dto;

import java.util.List;

public class QnaListModel {
	
	private List<QnaVO> qnaList;
	private Paging paging;

	public List<QnaVO> getNoticeList() {
		return qnaList;
	}
	
	public void setNoticeList(List<QnaVO> noticeList) {
		this.qnaList = noticeList;
	}

	public boolean isHasBoard() {
		return ! qnaList.isEmpty();
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}
}