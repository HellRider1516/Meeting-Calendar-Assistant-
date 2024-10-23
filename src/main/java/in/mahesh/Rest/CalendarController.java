package in.mahesh.Rest;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.mahesh.Model.Meeting;
import in.mahesh.Service.CalendarService;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {
 private final CalendarService calendarService;

 @Autowired
 public CalendarController(CalendarService calendarService) {
     this.calendarService = calendarService;
 }

 @PostMapping("/{employeeId}/meetings")
 public ResponseEntity<Void> bookMeeting(@PathVariable String employeeId, @RequestBody Meeting meeting) {
     calendarService.bookMeeting(employeeId, meeting);
     return ResponseEntity.ok().build();
 }

 @GetMapping("/free-slots")
 public ResponseEntity<List<LocalDateTime>> findFreeSlots(
         @RequestParam String empId1, @RequestParam String empId2, @RequestParam int duration){
     List<LocalDateTime> freeSlots = calendarService.findFreeSlots(empId1, empId2, Duration.ofMinutes(duration));
     return ResponseEntity.ok(freeSlots);
 }

 @PostMapping("/check-conflicts")
 public ResponseEntity<List<String>> checkConflicts(@RequestBody Meeting meeting) {
     List<String> conflicts = calendarService.checkConflicts(meeting);
     return ResponseEntity.ok(null);

