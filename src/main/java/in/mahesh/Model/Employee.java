package in.mahesh.Model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String id;
    private String name;
    private List<Meeting> meetings = new ArrayList<>();
    
    
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String id, String name, List<Meeting> meetings) {
		super();
		this.id = id;
		this.name = name;
		this.meetings = meetings;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Meeting> getMeetings() {
		return meetings;
	}
	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}
    
    

}
