# IY4113 Part 2 Milestone 2

| Assessment Details | Please Complete All Details                   |
| ------------------ | --------------------------------------------- |
| Group              | A                                             |
| Module Title       | IY4113                                        |
| Assessment Type    | Milestone 2                                   |
| Module Tutor Name  | Jonathan Shore                                |
| Student ID Number  | P490576                                       |
| Date of Submission | 6/4/2026                                      |
| Word Count         | 2120                                          |
| GitHub Link        | https://github.com/T0490576Eray/IY4113_part2# |

- [x] *I confirm that this assignment is my own work. Where I have referred to academic sources, I have provided in-text citations and included the sources in
  the final reference list.*

- [x] *Where I have used AI, I have cited and referenced appropriately.

------------------------------------------------------------------------------------------------------------------------------

### Research (minimum of 2, at least 3)

---

Conduct research to support your coding process, including use of code examples, tutortials, documentation and AI tools (if used).

Use the structure below to capture your evidence:

------------------------------------------------------------------------------------------------------------------------------

Title of research: Java Inheritance

Reference (link): [Inheritance in Java - GeeksforGeeks](https://www.geeksforgeeks.org/java/inheritance-in-java/)

How does the research help with coding practise?: I looked at this to understand inheritance better. At first I couldn’t apply it to my code the way I wanted. But after checking a few more sources I managed to use it in my program and added it for Part 2. It also helped me organise my code better.

Key coding ideas you could reuse in your program:

- using extends
- parent and child classes
- method overriding

Screenshot of research:

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-04-06-23-35-33-image.png)

------------------------------------------------------------------------------------------------------------------------------

Title of research: Writing Data to Files in Java

Reference (link): [Java FileWriter Class - GeeksforGeeks](https://www.geeksforgeeks.org/java/filewriter-class-in-java/)

How does the research help with coding practise?: After I checked some example codes I got how FileWriter and PrintWriter work.Then I used it in my code. Added it successfully.This helped me make a feature to export the journey summary into a text file so my program can save results of just showing them on the screen.It was helpful to export journey summary

Key coding ideas you could reuse in your program:

- creating a file using FileWriter
- writing data using PrintWriter
- closing the file after writing
- exporting summary data

Screenshot of research:

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-04-06-23-40-33-image.png)

Title of research: Reading and Writing JSON in Java

Reference (link): https://www.geeksforgeeks.org/read-and-write-json-to-a-file-in-java/

How does the research help with coding practise?: This is one of the required topics for Part 2. Even though I understood how to use it I did not include it in my code at this stage. It can be useful to save and load data, such as rider profiles so the program can keep information even after it is closed.

Key coding ideas you could reuse in your program:

- saving data into JSON
- loading data from JSON
- storing user or profile data

Screenshot of Research:

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-04-06-23-48-15-image.png)

------------------------------------------------------------------------------------------------------------------------------

### Program Code

---

import java.math.BigDecimal;  
import java.math.RoundingMode;  
import java.util.ArrayList;  
import java.util.Scanner;  
import java.io.FileWriter;  
import java.io.PrintWriter;  

class Journey  
{  
    private int id;  
    private String date;  
    private int fromZone;  
    private int toZone;  
    private String band;  
    private String type;  
    private BigDecimal fare;  

    public Journey(int id,String date,int fromZone,int toZone,String band,String type,BigDecimal fare) {  
        this.id =id;  
        this.date = date;  
        this.fromZone = fromZone;  
        this.toZone = toZone;  
        this.band = band;  
        this.type = type;  
        this.fare = fare;  
    }  
    
    public int getId(){  
        return id;  
    }  
    
    public String getType(){  
        return type;  
    }  
    
    public BigDecimal getFare(){  
        return fare;  
    }  
    
    public String getDate(){  
        return date;  
    }  
    
    public int getFromZone(){  
        return fromZone;  
    }  
    
    public int getToZone(){  
        return toZone;  
    }  
    
    public String getBand(){  
        return band;  
    }  
    
    public void setDate(String date){  
        this.date = date;  
    }  
    
    public void setFromZone(int fromZone){  
        this.fromZone = fromZone;  
    }  
    
    public void setToZone(int toZone){  
        this.toZone = toZone;  
    }  
    
    public void setBand(String band){  
        this.band = band;  
    }  
    
    public void setType(String type){  
        this.type = type;  
    }  
    
    public void setFare(BigDecimal fare){  
        this.fare = fare;  
    }  
    
    public String toString(){  
        return "ID: " +id +  
                " | Date: " +date +  
                " | From: " +fromZone +  
                " | To: " +toZone +  
                " | Band: " +band +  
                " | Type: " +type +  
                " | Charged: £" +fare.setScale(2, RoundingMode.HALF_UP);  
    }  

}  

class User  
{  
    protected String name;  

    public User(String name){  
        this.name = name;}  
    
    public String getRole(){  
        return "User";}  

}  

class Rider extends User  

{  
    public Rider(String name){  
        super(name);}  

    public String getRole(){  
        return "Rider";  
    }  

}  

class Admin extends User  
{  
    public Admin(String name){  
        super(name);}  

    public String getRole(){  
        return "Admin";}  

}  

public class CityRideLite{  

    private ArrayList<Journey>journeys = new ArrayList<Journey>();  
    private Scanner sc= new Scanner(System.in);  
    private int idCounter= 1;  
    
    private BigDecimal adultTotal = BigDecimal.ZERO;  
    private BigDecimal studentTotal = BigDecimal.ZERO;  
    private BigDecimal childTotal = BigDecimal.ZERO;  
    private BigDecimal seniorTotal = BigDecimal.ZERO;  
    
    private int adultCount = 0;  
    private int studentCount = 0;  
    private int childCount = 0;  
    private int seniorCount =0;  
    
    private Rider rider = new Rider("Main Rider");  
    private Admin admin = new Admin("System Admin");  
    
    public static void main(String[] args){  
        CityRideLite app = new CityRideLite();  
        app.start();  
    }  
    
    public void start() {  
        while (true){  
            System.out.println("\n--- CityRide Menu ---");  
            System.out.println("1- Add Journey");  
            System.out.println("2- Show All Journeys");  
            System.out.println("3- Filter by Type");  
            System.out.println("4- Remove Journey");  
            System.out.println("5- Edit Journey");  
            System.out.println("6- Show Summary");  
            System.out.println("7- Export Summary");  
            System.out.println("8- Show User Roles");  
            System.out.println("9- Reset All Data");  
            System.out.println("0- Exit");  
            System.out.print("Choice: ");  
    
            String choice = sc.nextLine();  
    
            if (choice.equals("1")){  
                addJourney();  
            }  
            else if (choice.equals("2")){  
                showJourneys();  
            }  
            else if (choice.equals("3")){  
                filterJourneys();  
            }  
            else if (choice.equals("4")){  
                removeJourney();  
            }  
            else if (choice.equals("5")){  
                editJourney();  
            }  
            else if (choice.equals("6")){  
                showSummary();  
            }  
            else if (choice.equals("7")){  
                exportSummary();  
            }  
            else if (choice.equals("8")){  
                showRoles();  
            }  
            else if (choice.equals("9")){  
                resetData();  
            }  
            else if (choice.equals("0")){  
                System.out.println("Program closed.");  
                break;  
            }  
            else{  
                System.out.println("Invalid choice.");}  
        }  
    }  
    
    private void addJourney(){  
        try {  
            System.out.print("Date (DD/MM): ");  
            String date =sc.nextLine();  
    
            System.out.print("From zone (1-5): ");  
            int from = Integer.parseInt(sc.nextLine());  
    
            System.out.print("To zone (1-5): ");  
            int to = Integer.parseInt(sc.nextLine());  
    
            if(from < CityRideDataset.MIN_ZONE || from > CityRideDataset.MAX_ZONE ||  
                    to < CityRideDataset.MIN_ZONE || to > CityRideDataset.MAX_ZONE) {  
                System.out.println("Zones must be between 1 and 5.");  
                return;  
            }  
    
            System.out.print("Band (peak/off_peak): ");  
            String bandInput =sc.nextLine().toLowerCase();  
    
            CityRideDataset.TimeBand band;  
    
            if (bandInput.equals("peak"))  {  
                band = CityRideDataset.TimeBand.PEAK;  
            }  
            else if (bandInput.equals("off_peak")){  
                band = CityRideDataset.TimeBand.OFF_PEAK;  
            }  
            else{  
                System.out.println("Invalid band.");  
                return;}  
    
            System.out.print("Type (adult/student/child/senior_citizen): ");  
            String typeInput = sc.nextLine().toLowerCase();  
    
            CityRideDataset.PassengerType type;  
    
            if (typeInput.equals("adult")){  
                type =CityRideDataset.PassengerType.ADULT;  
            }  
            else if (typeInput.equals("student")){  
                type =CityRideDataset.PassengerType.STUDENT;  
            }  
            else if (typeInput.equals("child")){  
                type =CityRideDataset.PassengerType.CHILD;  
            }  
            else if (typeInput.equals("senior_citizen")){  
                type =CityRideDataset.PassengerType.SENIOR_CITIZEN;  
            }  
            else {  
                System.out.println("Invalid type.");  
                return;  
            }  
    
            BigDecimal baseFare = CityRideDataset.getBaseFare(from, to, band);  
            BigDecimal discountRate = CityRideDataset.DISCOUNT_RATE.get(type);  
    
            BigDecimal discountedFare = baseFare.subtract(baseFare.multiply(discountRate));  
            discountedFare = discountedFare.setScale(2, RoundingMode.HALF_UP);  
    
            BigDecimal chargedFare = applyCap(discountedFare, type);  
    
            Journey j = new Journey(idCounter, date, from, to, band.name(), type.name(), chargedFare);  
            journeys.add(j);  
    
            updateTotals(type, chargedFare);  
            updateCounts(type);  
    
            idCounter++;  
    
            System.out.println("Journey added.");  
    
        }  
        catch (Exception e) {  
            System.out.println("Invalid input.");  
        }  
    }  
    
    private BigDecimal applyCap(BigDecimal price, CityRideDataset.PassengerType type) {  
        BigDecimal cap = CityRideDataset.DAILY_CAP.get(type);  
        BigDecimal current = getTotal(type);  
    
        if (current.compareTo(cap) >= 0) {  
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);  
        }  
    
        if (current.add(price).compareTo(cap) > 0) {  
            return cap.subtract(current).setScale(2, RoundingMode.HALF_UP);  
        }  
    
        return price.setScale(2, RoundingMode.HALF_UP);  
    }  
    
    private BigDecimal getTotal(CityRideDataset.PassengerType type) {  
        if (type == CityRideDataset.PassengerType.ADULT) {  
            return adultTotal;  
        }  
        else if (type == CityRideDataset.PassengerType.STUDENT) {  
            return studentTotal;  
        }  
        else if (type == CityRideDataset.PassengerType.CHILD) {  
            return childTotal;  
        }  
        else {  
            return seniorTotal;  
        }  
    }  
    
    private void updateTotals(CityRideDataset.PassengerType type, BigDecimal fare) {  
        if (type == CityRideDataset.PassengerType.ADULT) {  
            adultTotal = adultTotal.add(fare);  
        }  
        else if (type == CityRideDataset.PassengerType.STUDENT) {  
            studentTotal = studentTotal.add(fare);  
        }  
        else if (type == CityRideDataset.PassengerType.CHILD) {  
            childTotal = childTotal.add(fare);  
        }  
        else {  
            seniorTotal = seniorTotal.add(fare);  
        }  
    }  
    
    private void updateCounts(CityRideDataset.PassengerType type) {  
        if (type == CityRideDataset.PassengerType.ADULT) {  
            adultCount++;  
        }  
        else if (type == CityRideDataset.PassengerType.STUDENT) {  
            studentCount++;  
        }  
        else if (type == CityRideDataset.PassengerType.CHILD) {  
            childCount++;  
        }  
        else {  
            seniorCount++;  
        }  
    }  
    
    private void showJourneys() {  
        if (journeys.size() == 0) {  
            System.out.println("No journeys yet.");  
            return;  
        }  
    
        for (Journey j : journeys) {  
            System.out.println(j);  
        }  
    }  
    
    private void filterJourneys() {  
        System.out.print("Enter type: ");  
        String type = sc.nextLine().toUpperCase();  
    
        boolean found = false;  
    
        for (Journey j : journeys) {  
            if (j.getType().equals(type)) {  
                System.out.println(j);  
                found = true;  
            }  
        }  
    
        if (found == false) {  
            System.out.println("No journeys found.");  
        }  
    }  
    
    private void removeJourney() {  
        try {  
            System.out.print("Enter ID: ");  
            int id = Integer.parseInt(sc.nextLine());  
    
            Journey found = null;  
    
            for (Journey j : journeys) {  
                if (j.getId() == id) {  
                    found = j;  
                    break;  
                }  
            }  
    
            if (found == null) {  
                System.out.println("Not found.");  
                return;  
            }  
    
            if (found.getType().equals("ADULT")) {  
                adultTotal = adultTotal.subtract(found.getFare());  
                adultCount--;  
            }  
            else if (found.getType().equals("STUDENT")) {  
                studentTotal = studentTotal.subtract(found.getFare());  
                studentCount--;  
            }  
            else if (found.getType().equals("CHILD")) {  
                childTotal = childTotal.subtract(found.getFare());  
                childCount--;  
            }  
            else {  
                seniorTotal = seniorTotal.subtract(found.getFare());  
                seniorCount--;  
            }  
    
            journeys.remove(found);  
            System.out.println("Journey removed.");  
        }  
        catch (Exception e) {  
            System.out.println("Invalid ID.");  
        }  
    }  
    
    private void editJourney() {  
        try {  
            System.out.print("Enter ID to edit: ");  
            int id = Integer.parseInt(sc.nextLine());  
    
            Journey found = null;  
    
            for (Journey j : journeys) {  
                if (j.getId() == id) {  
                    found = j;  
                    break;  
                }  
            }  
    
            if (found == null) {  
                System.out.println("Journey not found.");  
                return;  
            }  
    
            if (found.getType().equals("ADULT")) {  
                adultTotal = adultTotal.subtract(found.getFare());  
                adultCount--;  
            }  
            else if (found.getType().equals("STUDENT")) {  
                studentTotal = studentTotal.subtract(found.getFare());  
                studentCount--;  
            }  
            else if (found.getType().equals("CHILD")) {  
                childTotal = childTotal.subtract(found.getFare());  
                childCount--;  
            }  
            else {  
                seniorTotal = seniorTotal.subtract(found.getFare());  
                seniorCount--;  
            }  
    
            System.out.print("New date (DD/MM): ");  
            String date = sc.nextLine();  
    
            System.out.print("New from zone (1-5): ");  
            int from = Integer.parseInt(sc.nextLine());  
    
            System.out.print("New to zone (1-5): ");  
            int to = Integer.parseInt(sc.nextLine());  
    
            if(from < CityRideDataset.MIN_ZONE || from > CityRideDataset.MAX_ZONE ||  
                    to < CityRideDataset.MIN_ZONE || to > CityRideDataset.MAX_ZONE) {  
                System.out.println("Zones must be between 1 and 5.");  
                return;  
            }  
    
            System.out.print("New band (peak/off_peak): ");  
            String bandInput = sc.nextLine().toLowerCase();  
    
            CityRideDataset.TimeBand band;  
    
            if (bandInput.equals("peak")) {  
                band = CityRideDataset.TimeBand.PEAK;  
            }  
            else if (bandInput.equals("off_peak")) {  
                band = CityRideDataset.TimeBand.OFF_PEAK;  
            }  
            else {  
                System.out.println("Invalid band.");  
                return;  
            }  
    
            System.out.print("New type (adult/student/child/senior_citizen): ");  
            String typeInput = sc.nextLine().toLowerCase();  
    
            CityRideDataset.PassengerType type;  
    
            if (typeInput.equals("adult")) {  
                type = CityRideDataset.PassengerType.ADULT;  
            }  
            else if (typeInput.equals("student")) {  
                type = CityRideDataset.PassengerType.STUDENT;  
            }  
            else if (typeInput.equals("child")) {  
                type = CityRideDataset.PassengerType.CHILD;  
            }  
            else if (typeInput.equals("senior_citizen")) {  
                type = CityRideDataset.PassengerType.SENIOR_CITIZEN;  
            }  
            else {  
                System.out.println("Invalid type.");  
                return;  
            }  
    
            BigDecimal baseFare = CityRideDataset.getBaseFare(from, to, band);  
            BigDecimal discountRate = CityRideDataset.DISCOUNT_RATE.get(type);  
    
            BigDecimal discountedFare = baseFare.subtract(baseFare.multiply(discountRate));  
            discountedFare = discountedFare.setScale(2, RoundingMode.HALF_UP);  
    
            BigDecimal chargedFare = applyCap(discountedFare, type);  
    
            found.setDate(date);  
            found.setFromZone(from);  
            found.setToZone(to);  
            found.setBand(band.name());  
            found.setType(type.name());  
            found.setFare(chargedFare);  
    
            updateTotals(type, chargedFare);  
            updateCounts(type);  
    
            System.out.println("Journey updated.");  
        }  
        catch (Exception e) {  
            System.out.println("Invalid input.");  
        }  
    }  
    
    private void showSummary() {  
        BigDecimal total = adultTotal.add(studentTotal).add(childTotal).add(seniorTotal);  
        int totalCount = adultCount + studentCount + childCount + seniorCount;  
    
        BigDecimal average = BigDecimal.ZERO;  
    
        if (totalCount > 0) {  
            average = total.divide(BigDecimal.valueOf(totalCount), 2, RoundingMode.HALF_UP);  
        }  
    
        System.out.println("\n--- Summary ---");  
        System.out.println("Total journeys: " + totalCount);  
        System.out.println("Total income: £" + total.setScale(2, RoundingMode.HALF_UP));  
        System.out.println("Average fare: £" + average);  
        System.out.println("Adult journeys: " +adultCount + " | £" +adultTotal.setScale(2, RoundingMode.HALF_UP));  
        System.out.println("Student journeys: " +studentCount + " | £" +studentTotal.setScale(2, RoundingMode.HALF_UP));  
        System.out.println("Child journeys: " +childCount + " | £" +childTotal.setScale(2, RoundingMode.HALF_UP));  
        System.out.println("Senior journeys: " +seniorCount + " | £" +seniorTotal.setScale(2, RoundingMode.HALF_UP));  
    }  
    
    private void exportSummary() {  
        try {  
            BigDecimal total = adultTotal.add(studentTotal).add(childTotal).add(seniorTotal);  
            int totalCount = adultCount + studentCount + childCount + seniorCount;  
    
            BigDecimal average = BigDecimal.ZERO;  
    
            if (totalCount > 0) {  
                average = total.divide(BigDecimal.valueOf(totalCount), 2, RoundingMode.HALF_UP);  
            }  
    
            PrintWriter writer = new PrintWriter(new FileWriter("summary.txt"));  
    
            writer.println("--- CityRide Summary ---");  
            writer.println("Total journeys: " + totalCount);  
            writer.println("Total income: £" + total.setScale(2, RoundingMode.HALF_UP));  
            writer.println("Average fare: £" + average);  
            writer.println("Adult journeys: " +adultCount + " | £" +adultTotal.setScale(2, RoundingMode.HALF_UP));  
            writer.println("Student journeys: " +studentCount + " | £" +studentTotal.setScale(2, RoundingMode.HALF_UP));  
            writer.println("Child journeys: " +childCount + " | £" +childTotal.setScale(2, RoundingMode.HALF_UP));  
            writer.println("Senior journeys: " +seniorCount + " | £" +seniorTotal.setScale(2, RoundingMode.HALF_UP));  
    
            writer.close();  
    
            System.out.println("Summary exported to summary.txt");  
        }  
        catch (Exception e) {  
            System.out.println("File export error.");  
        }  
    }  
    
    private void showRoles() {  
        System.out.println("Rider role: " +rider.getRole());  
        System.out.println("Admin role: " +admin.getRole());  
    }  
    
    private void resetData() {  
        journeys.clear();  
    
        adultTotal = BigDecimal.ZERO;  
        studentTotal = BigDecimal.ZERO;  
        childTotal = BigDecimal.ZERO;  
        seniorTotal = BigDecimal.ZERO;  
    
        adultCount = 0;  
        studentCount = 0;  
        childCount = 0;  
        seniorCount = 0;  
    
        idCounter = 1;  
    
        System.out.println("All data reset.");  
    }  

}

------------------------------------------------------------------------------------------------------------------------------

### Updated Gantt Chart

------------------------------------------------------------------------------------------------------------------------------

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-04-07-00-08-07-image.png)

------------------------------------------------------------------------------------------------------------------------------

### Diary Entries (at least 4)

------------------------------------------------------------------------------------------------------------------------------

**Diary Entry 1**  30/03/2026
Today I looked at my Part 1 code again after feedback. I saw that from feedback some features were missing like filtering and remove. I started to fix these parts and improve the menu.

**Diary Entry 2** 01/04/2026 
Today I improved my code more based on feedback. I added reset, category counts and better summary. Now my program looks more complete and more organised.

**Diary Entry 3**  03/04/2026
Today I did research about inheritance and file writing . I checked some examples and tried to understand how they work. This helped me plan what to add next.

**Diary Entry 4**  03/04/2026
Today I started improving my code for Part 2. I added inheritance and also a feature to export summary to a file. It was a bit difficult but I managed to make it work.

**Diary Entry 5**  06/04/2026

Today I continued working on my program and focused more on Part 2. I added the edit journey feature and tested the program to make sure everything works correctly. I also started to understand my code better by spending more time studying and practicing. So far I have added features like inheritance, file export and editing journeys.However, there are still some parts missing like JSON and more advanced file handling which I plan to add later.

------------------------------------------------------------------------------------------------------------------------------
