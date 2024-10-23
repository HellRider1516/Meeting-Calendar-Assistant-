package in.mahesh.Model;

import java.time.LocalDateTime;
import java.util.List;

public class Meeting {
	
	private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<String> participants;
    
    
	public Meeting() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Meeting(String id, LocalDateTime startTime, LocalDateTime endTime, List<String> participants) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.participants = participants;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public List<String> getParticipants() {
		return participants;
	}
	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}

    
}
