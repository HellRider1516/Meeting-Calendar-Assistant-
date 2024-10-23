package in.mahesh.Service;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mahesh.Dao.CalendarDao;
import in.mahesh.Model.Employee;
import in.mahesh.Model.Meeting;

@Service
public class CalendarService {
 private final CalendarDao calendarDao;

 @Autowired
 public CalendarService(CalendarDao calendarDao) {
     this.calendarDao = calendarDao;
 }

 public void bookMeeting(String employeeId, Meeting meeting) {
     Employee employee = calendarDao.getEmployee(employeeId);
     employee.getMeetings().add(meeting);
 }

 public List<LocalDateTime> findFreeSlots(String empId1, String empId2, Duration duration) {
     Employee emp1 = calendarDao.getEmployee(empId1);
     Employee emp2 = calendarDao.getEmployee(empId2);
     List<LocalDateTime> freeSlots = new ArrayList<>();

     // Assume working hours from 9 AM to 5 PM
     LocalDateTime start = LocalDateTime.now().withHour(9).withMinute(0);
     LocalDateTime end = LocalDateTime.now().withHour(17).withMinute(0);

     LocalDateTime currentTime = start;
     while (currentTime.plus(duration).isBefore(end)) {
         boolean isBusy = emp1.getMeetings().stream().anyMatch(m -> 
             (m.getStartTime().isBefore(currentTime.plus(duration)) && m.getEndTime().isAfter(currentTime))) ||
             emp2.getMeetings().stream().anyMatch(m -> 
             (m.getStartTime().isBefore(currentTime.plus(duration)) && m.getEndTime().isAfter(currentTime)));
         if (!isBusy) {
             freeSlots.add(currentTime);
         }
         currentTime = currentTime.plusMinutes(30); // Move in 30-minute intervals
     }
     return freeSlots;
 }

 public List<String> checkConflicts(Meeting meeting) {
     List<String> conflictingParticipants = new ArrayList<>();
     for (String participantId : meeting.getParticipants()) {
         Employee participant = calendarDao.getEmployee(participantId);
         if (participant != null) {
             for (Meeting empMeeting : participant.getMeetings()) {
                 if ((empMeeting.getStartTime().isBefore(meeting.getEndTime()) &&
                         empMeeting.getEndTime().isAfter(meeting.getStartTime()))) {
                     conflictingParticipants.add(participantId);
                 }
             }
         }
     }
     return conflictingParticipants;
 }
}


