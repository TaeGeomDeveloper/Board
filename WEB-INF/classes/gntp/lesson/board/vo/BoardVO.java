package gntp.lesson.board.vo;

import java.sql.Timestamp;

public class BoardVO {
	private int seq;
	private int writeSeq;
	private String currentSeq;
	private String title;
	private String content;
	private int readCount;
	private String nextSeq;
	private String writer;
	private String userId;
	private Timestamp writeDate;
	
	public BoardVO(){ }
	public BoardVO(int seq, int writeSeq, String currentSeq, String title, String content,
				int readCount, String nextSeq, String writer, String userId, Timestamp writeDate) {
		this.seq = seq;
		this.writeSeq = writeSeq;
		this.currentSeq = currentSeq;
		this.title = title;
		this.content = content;
		this.nextSeq = nextSeq;
		this.readCount = readCount;
		this.writer = writer;
		this.userId = userId;
		this.writeDate = writeDate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	
	public int getWriteSeq() {
		return writeSeq;
	}

	public void setWriteSeq(int writeSeq) {
		this.writeSeq = writeSeq;
	}

	public String getCurrentSeq() {
		return currentSeq;
	}

	public void setCurrentSeq(String currentSeq) {
		this.currentSeq = currentSeq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNextSeq() {
		return nextSeq;
	}

	public void setNextSeq(String nextSeq) {
		this.nextSeq = nextSeq;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}
}
