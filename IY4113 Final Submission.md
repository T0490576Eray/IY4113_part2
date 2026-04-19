# IY4113 Final Submission

| Assessment Details | Please Complete All Details                      |
| ------------------ | ------------------------------------------------ |
| Group              | A                                                |
| Module Title       | IY4113                                           |
| Assessment Type    | Final Submisson                                  |
| Module Tutor Name  | Jonathan Shore                                   |
| Student ID Number  | P490576                                          |
| Date of Submission | 19/4/2026                                        |
| Word Count         | 7767                                             |
| GitHub Link        | https://github.com/T0490576Eray/IY4113_part2.git |

- [x] *I confirm that this assignment is my own work. Where I have referred to academic sources, I have provided in-text citations and included the sources in
  the final reference list.*

- [x] *Where I have used AI, I have cited and referenced appropriately.

------------------------------------------------------------------------------------------------------------------------------

## Introduction

This report is about the CityRide Lite program. The aim of this project is to develop a more advanced transport fare application using Java. The system is designed for two types of users rider and admin. In this part of the project the program is extended with new features. The system allows the rider to create a profile, save and load data and manage journeys. Journeys can be added, edited, deleted and also imported or exported using CSV files. Data can be stored using JSON files so it can be used again later. The program also includes an admin role. The admin can log in with a password and manage system settings such as discounts, daily caps and peak time rules. This helps keep the system organised and flexible.This report explains the CityRide Lite program and its main features.

### Analysis and IPO Table

The CityRide Lite system is a transport fare application with two main user roles rider and admin. The system must support both roles and provide different functions for each user. For the rider the system must allow profile management. Rider can create, save and load a profile with name, passenger type and payment method. The system must also allow the rider to manage journeys. Journeys can be added, edited and deleted. Each journey must include details like date, time, zones, passenger type, fare, discount and cap information. The system must calculate fares based on zones and time band. Discounts must be applied based on passenger type. Daily caps must also be applied so the total cost do not go over a limit. The system must show journey details and a daily summary, including total journeys, total cost and average cost. The system must support file handling. Data must be saved and loaded using JSON files. Journeys must also be imported and exported using CSV files. This allows the user to store and reuse data. For the admin the system must provide a secure login using a password. The admin can view and update system settings such as discounts, daily caps and peak times.  The system must be menu-driven and easy to use. It must also handle errors and show clear messages when invalid input is entered.

| **Module/Task**      | **Input**                                  | **Process**                                                                                        | **Output**                                                                                                 |
| -------------------- | ------------------------------------------ | -------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| Profile Creation     | Name, passenger type, default payment      | The entered data is checked and a new RiderProfile object is created.                              | "Profile created."                                                                                         |
| Add Journey          | Date, time, zone details                   | The system decides peak or off-peak by time calculates fare and discount and checks the daily cap. | "Journey added."                                                                                           |
| Save Data (JSON/CSV) | Journey list, profile data                 | The program writes the data into file format.                                                      | "Journeys exported to journeys.csv" / "Profile saved to profile.json" / "Day state saved to daystate.json" |
| Load Data (JSON/CSV) | File name or saved file                    | The program reads the file and converts the data back into program records.                        | "Journeys imported." / "Profile loaded." / "Day state loaded."                                             |
| Summary Statistics   | Current journey data                       | The program calculates total fare, average fare, savings and journey counts.                       | "--- Summary ---" and summary details printed                                                              |
| Edit Journey         | Journey ID and new details                 | The selected journey is found, old totals are adjusted and the new fare is calculated.             | "Journey updated."                                                                                         |
| Admin Configuration  | Admin password, new discount or cap values | The password is checked and the system settings are updated.                                       | "Discount updated." / "Cap updated." / "Peak start updated." / "Peak end updated." / "Wrong password."     |

------------------------------------------------------------------------------------------------------------------------------

#### Algorithm Design

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-04-19-20-15-10-image.png)

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-04-19-20-19-57-image.png)

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-04-19-20-49-32-image.png)

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-04-19-21-10-15-image.png)

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-04-19-21-30-52-image.png)

------------------------------------------------------------------------------------------------------------------------------

##### Test Table

| Test No | Item to be tested     | Test Description including example data                        | Expected Result                                                   | Actual Result                                         | Actions/Comments |
| ------- | --------------------- | -------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------- | ---------------- |
| 1       | Create Profile        | Enter valid data (Name: Osimhen, Type: student, Payment: card) | Profile is created successfully                                   | Profile created.                                      | Test passed      |
| 2       | Create Profile        | Enter invalid passenger type (Type: abc)                       | Program shows error message                                       | Invalid passenger type.                               | Validation works |
| 3       | Add Journey           | Enter valid journey (Date: 19/05, Time: 08:30, Zones: 1-3)     | Journey added successfully                                        | Journey added.                                        | Test passed      |
| 4       | Add Journey           | Enter invalid zone (Zone: 10)                                  | Program shows error message                                       | Zones must be between 1 and 5.                        | Validation works |
| 5       | Add Journey           | Enter invalid band (Band: abc)                                 | Program shows error message                                       | Invalid band.                                         | Validation works |
| 6       | Add Journey           | Add journey when no profile exists                             | Program prevents action                                           | Create or load a profile first.                       | Test passed      |
| 7       | Edit Journey          | Edit existing journey with valid data                          | Journey updates successfully                                      | Journey updated.                                      | Test passed      |
| 8       | Edit Journey          | Enter invalid ID (ID: 999)                                     | Program shows error                                               | Journey not found.  Invalid ID.                       | Validation works |
| 9       | Delete Journey        | Delete existing journey                                        | Journey removed successfully                                      | Journey removed.                                      | Test passed      |
| 10      | Delete Journey        | Delete non-existing journey                                    | Program shows error                                               | Invalid ID.                                           | Validation works |
| 11      | Summary               | Display summary after journeys added                           | Summary shows correct totals                                      | Summary displayed                                     | Test passed      |
| 12      | Save and Load Profile | Save profile to JSON and load it again                         | Profile is saved and loaded correctly                             | Profile saved to profile.json  Profile loaded.        | Test passed      |
| 13      | Export and Import CSV | Export journeys to CSV and import the same file                | Journey data is saved and loaded correctly                        | Journeys exported to journeys.csv  Journeys imported. | Test passed      |
| 14      | Admin Login           | Enter correct password (admin123) and wrong password           | Access granted for correct password and denied for wrong password | Admin menu opened Wrong password.                     | Validation works |
| 15      | Update Settings       | Enter valid discount (0.25) and cap (7.50)                     | Values are updated successfully                                   | Discount updated.  Cap updated.                       | Test passed      |

##### Evaluation

The CityRide Lite program meets most of the requirements. The system works correctly and allow the user to manage journeys and profiles. The rider can create a profile, add journeys, edit or delete  and view  summary. The program also supports saving and loading data using JSON and CSV files.The admin part of the program also works well. The admin can log in with a password and change settings such as discount rates, daily caps and peak times. This makes the system flexible and easy to control.One strength of the program is that it is easy to use. The menu is clear and the user can choose options without difficulty. Another strength is that the program checks user input and shows error messages. However, there are some weaknesses. The program uses a console interface so it is not very user friendly compared to a graphical interface. Also the file handling is simple . Some features, like automatic saving  could be improved.In the future, the program can be improved by adding a graphical user interface GUI to make it easier to use. More advanced file handling and better error messages can also be added. Extra features, like more detailed statistics or multiple user profiles, can improve the system further. In totall the program is successful and meets most of the requirements, but it can be improved in some areas.

------------------------------------------------------------------------------------------------------------------------------

##### Code Listing

import java.math.BigDecimal;  
import java.math.RoundingMode;  
import java.util.ArrayList;  
import java.util.Scanner;  
import java.io.File;  
import java.io.FileWriter;  
import java.io.PrintWriter;  
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.util.HashMap;  
import java.util.Map;  

class Journey{  
    private int id;  
    private String date;  
    private String time;  
    private int fromZone;  
    private int toZone;  
    private String band;  
    private String type;  
    private int zonesCrossed;  
    private BigDecimal baseFare;  
    private BigDecimal discountApplied;  
    private BigDecimal fare;  
    private boolean capApplied;  

    public Journey(int id,String date,String time,int fromZone,int toZone,String band,String type,  
                   int zonesCrossed,BigDecimal baseFare,BigDecimal discountApplied,BigDecimal fare,boolean capApplied) {  
        this.id =id;  
        this.date = date;  
        this.time = time;  
        this.fromZone = fromZone;  
        this.toZone = toZone;  
        this.band = band;  
        this.type = type;  
        this.zonesCrossed = zonesCrossed;  
        this.baseFare = baseFare;  
        this.discountApplied = discountApplied;  
        this.fare = fare;  
        this.capApplied = capApplied;  
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
    
    public String getTime(){  
        return time;  
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
    
    public int getZonesCrossed(){  
        return zonesCrossed;  
    }  
    
    public BigDecimal getBaseFare(){  
        return baseFare;  
    }  
    
    public BigDecimal getDiscountApplied(){  
        return discountApplied;  
    }  
    
    public boolean isCapApplied(){  
        return capApplied;  
    }  
    
    public void setDate(String date){  
        this.date = date;  
    }  
    
    public void setTime(String time){  
        this.time = time;  
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
    
    public void setZonesCrossed(int zonesCrossed){  
        this.zonesCrossed = zonesCrossed;  
    }  
    
    public void setBaseFare(BigDecimal baseFare){  
        this.baseFare = baseFare;  
    }  
    
    public void setDiscountApplied(BigDecimal discountApplied){  
        this.discountApplied = discountApplied;  
    }  
    
    public void setFare(BigDecimal fare){  
        this.fare = fare;  
    }  
    
    public void setCapApplied(boolean capApplied){  
        this.capApplied = capApplied;  
    }  
    
    public String toString(){  
        return "ID: " +id +  
                " | Date: " +date +  
                " | Time: " +time +  
                " | From: " +fromZone +  
                " | To: " +toZone +  
                " | Band: " +band +  
                " | Type: " +type +  
                " | Zones: " +zonesCrossed +  
                " | Base: £" +baseFare.setScale(2, RoundingMode.HALF_UP) +  
                " | Discount: £" +discountApplied.setScale(2, RoundingMode.HALF_UP) +  
                " | Charged: £" +fare.setScale(2, RoundingMode.HALF_UP) +  
                " | Cap: " +capApplied;  
    }  
    
    public String toCsv(){  
        return id + "," + date + "," + time + "," + fromZone + "," + toZone + "," + band + "," + type + "," +  
                zonesCrossed + "," + baseFare + "," + discountApplied + "," + fare + "," + capApplied;  
    }  

}  

class User  
{  
    protected String name;  

    public User(String name){  
        this.name = name;  
    }  
    
    public String getRole(){  
        return "User";  
    }  

}  

class Rider extends User  
{  
    public Rider(String name){  
        super(name);  
    }  

    public String getRole(){  
        return "Rider";  
    }  

}  

class Admin extends User  
{  
    private String password;  

    public Admin(String name,String password){  
        super(name);  
        this.password = password;  
    }  
    
    public String getRole(){  
        return "Admin";  
    }  
    
    public boolean checkPassword(String input){  
        return password.equals(input);  
    }  

}  

class RiderProfile{  
    private String name;  
    private String passengerType;  
    private String defaultPayment;  

    public RiderProfile(String name,String passengerType,String defaultPayment){  
        this.name = name;  
        this.passengerType = passengerType;  
        this.defaultPayment = defaultPayment;  
    }  
    
    public String getName(){  
        return name;  
    }  
    
    public String getPassengerType(){  
        return passengerType;  
    }  
    
    public String getDefaultPayment(){  
        return defaultPayment;  
    }  
    
    public String toString(){  
        return "Name: " + name + " | Passenger Type: " + passengerType + " | Default Payment: " + defaultPayment;  
    }  

}  

public class CityRideLite{  

    private ArrayList<Journey> journeys = new ArrayList<Journey>();  
    private Scanner sc = new Scanner(System.in);  
    private int idCounter = 1;  
    
    private BigDecimal adultTotal = BigDecimal.ZERO;  
    private BigDecimal studentTotal = BigDecimal.ZERO;  
    private BigDecimal childTotal = BigDecimal.ZERO;  
    private BigDecimal seniorTotal = BigDecimal.ZERO;  
    
    private int adultCount = 0;  
    private int studentCount = 0;  
    private int childCount = 0;  
    private int seniorCount =0;  
    
    private Rider rider = new Rider("Main Rider");  
    private Admin admin = new Admin("System Admin","admin123");  
    private RiderProfile activeProfile = null;  
    
    private HashMap<String, BigDecimal> discountRates = new HashMap<String, BigDecimal>();  
    private HashMap<String, BigDecimal> dailyCaps = new HashMap<String, BigDecimal>();  
    private String peakStart = "06:30";  
    private String peakEnd = "09:30";  
    
    public static void main(String[] args){  
        CityRideLite app = new CityRideLite();  
        app.start();  
    }  
    
    public void start() {  
        loadConfig();  
    
        while (true){  
            System.out.println("\n--- CityRide Lite ---");  
            System.out.println("1- Rider Menu");  
            System.out.println("2- Admin Menu");  
            System.out.println("3- Show User Roles");  
            System.out.println("0- Exit");  
            System.out.print("Choice: ");  
    
            String choice = sc.nextLine();  
    
            if (choice.equals("1")){  
                riderMenu();  
            }  
            else if (choice.equals("2")){  
                adminMenu();  
            }  
            else if (choice.equals("3")){  
                showRoles();  
            }  
            else if (choice.equals("0")){  
                askSaveOnExit();  
                System.out.println("Program closed.");  
                break;  
            }  
            else{  
                System.out.println("Invalid choice.");  
            }  
        }  
    }  
    
    private void riderMenu(){  
        while (true){  
            System.out.println("\n--- Rider Menu ---");  
            System.out.println("1- Create Profile");  
            System.out.println("2- Show Profile");  
            System.out.println("3- Save Profile JSON");  
            System.out.println("4- Load Profile JSON");  
            System.out.println("5- Add Journey");  
            System.out.println("6- Show All Journeys");  
            System.out.println("7- Filter by Type");  
            System.out.println("8- Remove Journey");  
            System.out.println("9- Edit Journey");  
            System.out.println("10- Show Summary");  
            System.out.println("11- Export Summary");  
            System.out.println("12- Export Journeys CSV");  
            System.out.println("13- Import Journeys CSV");  
            System.out.println("14- Save Day State JSON");  
            System.out.println("15- Load Day State JSON");  
            System.out.println("16- Reset All Data");  
            System.out.println("0- Back");  
            System.out.print("Choice: ");  
    
            String choice = sc.nextLine();  
    
            if (choice.equals("1")){  
                createProfile();  
            }  
            else if (choice.equals("2")){  
                showProfile();  
            }  
            else if (choice.equals("3")){  
                saveProfileJson();  
            }  
            else if (choice.equals("4")){  
                loadProfileJson();  
            }  
            else if (choice.equals("5")){  
                addJourney();  
            }  
            else if (choice.equals("6")){  
                showJourneys();  
            }  
            else if (choice.equals("7")){  
                filterJourneys();  
            }  
            else if (choice.equals("8")){  
                removeJourney();  
            }  
            else if (choice.equals("9")){  
                editJourney();  
            }  
            else if (choice.equals("10")){  
                showSummary();  
            }  
            else if (choice.equals("11")){  
                exportSummary();  
            }  
            else if (choice.equals("12")){  
                exportJourneysCsv();  
            }  
            else if (choice.equals("13")){  
                importJourneysCsv();  
            }  
            else if (choice.equals("14")){  
                saveDayStateJson();  
            }  
            else if (choice.equals("15")){  
                loadDayStateJson();  
            }  
            else if (choice.equals("16")){  
                resetData();  
            }  
            else if (choice.equals("0")){  
                break;  
            }  
            else{  
                System.out.println("Invalid choice.");  
            }  
        }  
    }  
    
    private void adminMenu(){  
        System.out.print("Admin password: ");  
        String password = sc.nextLine();  
    
        if (!admin.checkPassword(password)){  
            System.out.println("Wrong password.");  
            return;  
        }  
    
        while (true){  
            System.out.println("\n--- Admin Menu ---");  
            System.out.println("1- Show Config");  
            System.out.println("2- Update Discount");  
            System.out.println("3- Update Daily Cap");  
            System.out.println("4- Update Peak Start");  
            System.out.println("5- Update Peak End");  
            System.out.println("6- Save Config");  
            System.out.println("0- Back");  
            System.out.print("Choice: ");  
    
            String choice = sc.nextLine();  
    
            if (choice.equals("1")){  
                showConfig();  
            }  
            else if (choice.equals("2")){  
                updateDiscount();  
            }  
            else if (choice.equals("3")){  
                updateCap();  
            }  
            else if (choice.equals("4")){  
                updatePeakStart();  
            }  
            else if (choice.equals("5")){  
                updatePeakEnd();  
            }  
            else if (choice.equals("6")){  
                saveConfig();  
            }  
            else if (choice.equals("0")){  
                break;  
            }  
            else{  
                System.out.println("Invalid choice.");  
            }  
        }  
    }  
    
    private void createProfile(){  
        System.out.print("Name (example Eray): ");  
        String name = sc.nextLine();  
    
        System.out.print("Passenger type (adult/student/child/senior_citizen): ");  
        String type = sc.nextLine().toUpperCase();  
    
        if (!discountRates.containsKey(type)){  
            System.out.println("Invalid passenger type.");  
            return;  
        }  
    
        System.out.print("Default payment (example card/contactless): ");  
        String payment = sc.nextLine();  
    
        activeProfile = new RiderProfile(name,type,payment);  
        System.out.println("Profile created.");  
    }  
    
    private void showProfile(){  
        if (activeProfile == null){  
            System.out.println("No active profile.");  
            return;  
        }  
    
        System.out.println(activeProfile);  
    }  
    
    private Journey findJourneyById(int id){  
        for (Journey j : journeys) {  
            if (j.getId() == id) {  
                return j;  
            }  
        }  
        return null;  
    }  
    
    private CityRideDataset.TimeBand getBandFromInput(String bandInput){  
        if (bandInput.equals("peak"))  {  
            return CityRideDataset.TimeBand.PEAK;  
        }  
        else if (bandInput.equals("off_peak")){  
            return CityRideDataset.TimeBand.OFF_PEAK;  
        }  
        return null;  
    }  
    
    private CityRideDataset.PassengerType getTypeFromInput(String typeInput){  
        if (typeInput.equals("adult")){  
            return CityRideDataset.PassengerType.ADULT;  
        }  
        else if (typeInput.equals("student")){  
            return CityRideDataset.PassengerType.STUDENT;  
        }  
        else if (typeInput.equals("child")){  
            return CityRideDataset.PassengerType.CHILD;  
        }  
        else if (typeInput.equals("senior_citizen")){  
            return CityRideDataset.PassengerType.SENIOR_CITIZEN;  
        }  
        return null;  
    }  
    
    private String getBandByTime(String time){  
        try {  
            int value = Integer.parseInt(time.replace(":", ""));  
            int start = Integer.parseInt(peakStart.replace(":", ""));  
            int end = Integer.parseInt(peakEnd.replace(":", ""));  
    
            if (value >= start && value <= end){  
                return "peak";  
            }  
        }  
        catch (Exception e){  
            return "off_peak";  
        }  
    
        return "off_peak";  
    }  
    
    private BigDecimal getDiscountRate(CityRideDataset.PassengerType type){  
        return discountRates.get(type.name());  
    }  
    
    private BigDecimal getCap(CityRideDataset.PassengerType type){  
        return dailyCaps.get(type.name());  
    }  
    
    // apply daily cap if limit is reached  
    private BigDecimal applyCap(BigDecimal price, CityRideDataset.PassengerType type) {  
        BigDecimal cap = getCap(type);  
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
    
    private void subtractTotalsAndCounts(String type,BigDecimal fare){  
        if (type.equals("ADULT")) {  
            adultTotal = adultTotal.subtract(fare);  
            adultCount--;  
        }  
        else if (type.equals("STUDENT")) {  
            studentTotal = studentTotal.subtract(fare);  
            studentCount--;  
        }  
        else if (type.equals("CHILD")) {  
            childTotal = childTotal.subtract(fare);  
            childCount--;  
        }  
        else {  
            seniorTotal = seniorTotal.subtract(fare);  
            seniorCount--;  
        }  
    }  
    
    private void addJourney(){  
        try {  
            if (activeProfile == null){  
                System.out.println("Create or load a profile first.");  
                return;  
            }  
    
            System.out.print("Date (DD/MM example 19/04): ");  
            String date = sc.nextLine();  
    
            System.out.print("Time (HH:MM example 08:30): ");  
            String time = sc.nextLine();  
    
            System.out.print("From zone (1-5): ");  
            int from = Integer.parseInt(sc.nextLine());  
    
            System.out.print("To zone (1-5): ");  
            int to = Integer.parseInt(sc.nextLine());  
    
            if(from < CityRideDataset.MIN_ZONE || from > CityRideDataset.MAX_ZONE ||  
                    to < CityRideDataset.MIN_ZONE || to > CityRideDataset.MAX_ZONE) {  
                System.out.println("Zones must be between 1 and 5.");  
                return;  
            }  
    
            System.out.print("Band (peak/off_peak) or press Enter for auto: ");  
            String bandInput = sc.nextLine().toLowerCase();  
    
            if (bandInput.equals("")){  
                bandInput = getBandByTime(time);  
            }  
    
            CityRideDataset.TimeBand band = getBandFromInput(bandInput);  
    
            if (band == null){  
                System.out.println("Invalid band.");  
                return;  
            }  
    
            System.out.print("Type (adult/student/child/senior_citizen) or press Enter for profile type: ");  
            String typeInput = sc.nextLine().toLowerCase();  
    
            if (typeInput.equals("")){  
                typeInput = activeProfile.getPassengerType().toLowerCase();  
            }  
    
            CityRideDataset.PassengerType type = getTypeFromInput(typeInput);  
    
            if (type == null) {  
                System.out.println("Invalid type.");  
                return;  
            }  
    
            // calculate fare with discount  
            BigDecimal baseFare = CityRideDataset.getBaseFare(from, to, band);  
            BigDecimal discountRate = getDiscountRate(type);  
            BigDecimal discountApplied = baseFare.multiply(discountRate).setScale(2, RoundingMode.HALF_UP);  
            BigDecimal discountedFare = baseFare.subtract(discountApplied).setScale(2, RoundingMode.HALF_UP);  
    
            // apply cap after discount  
            BigDecimal chargedFare = applyCap(discountedFare, type);  
            boolean capApplied = chargedFare.compareTo(discountedFare) < 0;  
    
            int zonesCrossed = Math.abs(to - from) + 1;  
    
            Journey j = new Journey(idCounter,date,time,from,to,band.name(),type.name(),  
                    zonesCrossed,baseFare,discountApplied,chargedFare,capApplied);  
    
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
    
        if (!found) {  
            System.out.println("No journeys found.");  
        }  
    }  
    
    private void removeJourney() {  
        try {  
            System.out.print("Enter ID: ");  
            int id = Integer.parseInt(sc.nextLine());  
    
            Journey found = findJourneyById(id);  
    
            if (found == null) {  
                System.out.println("Invalid ID.");  
                return;  
            }  
    
            subtractTotalsAndCounts(found.getType(), found.getFare());  
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
    
            Journey found = findJourneyById(id);  
    
            if (found == null) {  
                System.out.println("Journey not found.");  
                return;  
            }  
    
            subtractTotalsAndCounts(found.getType(), found.getFare());  
    
            System.out.print("New date (DD/MM example 19/04): ");  
            String date = sc.nextLine();  
    
            System.out.print("New time (HH:MM example 08:30): ");  
            String time = sc.nextLine();  
    
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
    
            CityRideDataset.TimeBand band = getBandFromInput(bandInput);  
    
            if (band == null) {  
                System.out.println("Invalid band.");  
                return;  
            }  
    
            System.out.print("New type (adult/student/child/senior_citizen): ");  
            String typeInput = sc.nextLine().toLowerCase();  
    
            CityRideDataset.PassengerType type = getTypeFromInput(typeInput);  
    
            if (type == null) {  
                System.out.println("Invalid type.");  
                return;  
            }  
    
            BigDecimal baseFare = CityRideDataset.getBaseFare(from, to, band);  
            BigDecimal discountRate = getDiscountRate(type);  
            BigDecimal discountApplied = baseFare.multiply(discountRate).setScale(2, RoundingMode.HALF_UP);  
            BigDecimal discountedFare = baseFare.subtract(discountApplied).setScale(2, RoundingMode.HALF_UP);  
    
            BigDecimal chargedFare = applyCap(discountedFare, type);  
            boolean capApplied = chargedFare.compareTo(discountedFare) < 0;  
    
            int zonesCrossed = Math.abs(to - from) + 1;  
    
            found.setDate(date);  
            found.setTime(time);  
            found.setFromZone(from);  
            found.setToZone(to);  
            found.setBand(band.name());  
            found.setType(type.name());  
            found.setZonesCrossed(zonesCrossed);  
            found.setBaseFare(baseFare);  
            found.setDiscountApplied(discountApplied);  
            found.setFare(chargedFare);  
            found.setCapApplied(capApplied);  
    
            updateTotals(type, chargedFare);  
            updateCounts(type);  
    
            System.out.println("Journey updated.");  
        }  
        catch (Exception e) {  
            System.out.println("Invalid input.");  
        }  
    }  
    
    private Journey getMostExpensiveJourney(){  
        if (journeys.size() == 0){  
            return null;  
        }  
    
        Journey mostExpensive = journeys.get(0);  
    
        for (Journey j : journeys){  
            if (j.getFare().compareTo(mostExpensive.getFare()) > 0){  
                mostExpensive = j;  
            }  
        }  
    
        return mostExpensive;  
    }  
    
    // calculate total without daily cap (for savings)  
    private BigDecimal getUncappedTotal(){  
        BigDecimal total = BigDecimal.ZERO;  
    
        for (Journey j : journeys){  
            BigDecimal uncappedFare = j.getBaseFare().subtract(j.getDiscountApplied());  
            total = total.add(uncappedFare);  
        }  
    
        return total.setScale(2, RoundingMode.HALF_UP);  
    }  
    
    private void showSummary() {  
        BigDecimal total = adultTotal.add(studentTotal).add(childTotal).add(seniorTotal);  
        int totalCount = adultCount + studentCount + childCount + seniorCount;  
    
        BigDecimal average = BigDecimal.ZERO;  
    
        if (totalCount > 0) {  
            average = total.divide(BigDecimal.valueOf(totalCount), 2, RoundingMode.HALF_UP);  
        }  
    
        Journey mostExpensive = getMostExpensiveJourney();  
    
        int peakCount = 0;  
        int offPeakCount = 0;  
        int capReachedCount = 0;  
    
        HashMap<String, Integer> zonePairCounts = new HashMap<String, Integer>();  
    
        // count peak, off-peak and zone pairs  
        for (Journey j : journeys){  
            if (j.getBand().equals("PEAK")){  
                peakCount++;  
            }  
            else{  
                offPeakCount++;  
            }  
    
            if (j.isCapApplied()){  
                capReachedCount++;  
            }  
    
            String pair = j.getFromZone() + "-" + j.getToZone();  
    
            if (zonePairCounts.containsKey(pair)){  
                zonePairCounts.put(pair, zonePairCounts.get(pair) + 1);  
            }  
            else{  
                zonePairCounts.put(pair, 1);  
            }  
        }  
    
        BigDecimal uncappedTotal = getUncappedTotal();  
        BigDecimal savings = uncappedTotal.subtract(total).setScale(2, RoundingMode.HALF_UP);  
    
        System.out.println("\n--- Summary ---");  
        System.out.println("Total journeys: " + totalCount);  
        System.out.println("Total income: £" + total.setScale(2, RoundingMode.HALF_UP));  
        System.out.println("Average fare: £" + average);  
        System.out.println("Adult journeys: " +adultCount + " | £" +adultTotal.setScale(2, RoundingMode.HALF_UP));  
        System.out.println("Student journeys: " +studentCount + " | £" +studentTotal.setScale(2, RoundingMode.HALF_UP));  
        System.out.println("Child journeys: " +childCount + " | £" +childTotal.setScale(2, RoundingMode.HALF_UP));  
        System.out.println("Senior journeys: " +seniorCount + " | £" +seniorTotal.setScale(2, RoundingMode.HALF_UP));  
        System.out.println("Peak journeys: " + peakCount);  
        System.out.println("Off-peak journeys: " + offPeakCount);  
        System.out.println("Journeys where cap affected fare: " + capReachedCount);  
        System.out.println("Savings compared to uncapped fares: £" + savings);  
    
        System.out.println("Zone pair counts:");  
        for (Map.Entry<String, Integer> entry : zonePairCounts.entrySet()){  
            System.out.println(entry.getKey() + " -> " + entry.getValue());  
        }  
    
        if (mostExpensive != null){  
            System.out.println("Most expensive journey: ID " + mostExpensive.getId() +  
                    " | £" + mostExpensive.getFare().setScale(2, RoundingMode.HALF_UP));  
        }  
    }  
    
    private void exportSummary() {  
        try {  
            BigDecimal total = adultTotal.add(studentTotal).add(childTotal).add(seniorTotal);  
            int totalCount = adultCount + studentCount + childCount + seniorCount;  
    
            BigDecimal average = BigDecimal.ZERO;  
    
            if (totalCount > 0) {  
                average = total.divide(BigDecimal.valueOf(totalCount), 2, RoundingMode.HALF_UP);  
            }  
    
            String fileName = "summary.txt";  
            if (activeProfile != null){  
                fileName = activeProfile.getName().replace(" ","_") + "_summary.txt";  
            }  
    
            Journey mostExpensive = getMostExpensiveJourney();  
    
            int peakCount = 0;  
            int offPeakCount = 0;  
            int capReachedCount = 0;  
    
            HashMap<String, Integer> zonePairCounts = new HashMap<String, Integer>();  
    
            // prepare same stats for export  
            for (Journey j : journeys){  
                if (j.getBand().equals("PEAK")){  
                    peakCount++;  
                }  
                else{  
                    offPeakCount++;  
                }  
    
                if (j.isCapApplied()){  
                    capReachedCount++;  
                }  
    
                String pair = j.getFromZone() + "-" + j.getToZone();  
    
                if (zonePairCounts.containsKey(pair)){  
                    zonePairCounts.put(pair, zonePairCounts.get(pair) + 1);  
                }  
                else{  
                    zonePairCounts.put(pair, 1);  
                }  
            }  
    
            BigDecimal uncappedTotal = getUncappedTotal();  
            BigDecimal savings = uncappedTotal.subtract(total).setScale(2, RoundingMode.HALF_UP);  
    
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));  
    
            writer.println("--- CityRide Summary ---");  
    
            if (activeProfile != null){  
                writer.println("Rider: " + activeProfile.getName());  
                writer.println("Passenger Type: " + activeProfile.getPassengerType());  
                writer.println("Default Payment: " + activeProfile.getDefaultPayment());  
            }  
    
            writer.println("Total journeys: " + totalCount);  
            writer.println("Total income: £" + total.setScale(2, RoundingMode.HALF_UP));  
            writer.println("Average fare: £" + average);  
            writer.println("Adult journeys: " +adultCount + " | £" +adultTotal.setScale(2, RoundingMode.HALF_UP));  
            writer.println("Student journeys: " +studentCount + " | £" +studentTotal.setScale(2, RoundingMode.HALF_UP));  
            writer.println("Child journeys: " +childCount + " | £" +childTotal.setScale(2, RoundingMode.HALF_UP));  
            writer.println("Senior journeys: " +seniorCount + " | £" +seniorTotal.setScale(2, RoundingMode.HALF_UP));  
            writer.println("Peak journeys: " + peakCount);  
            writer.println("Off-peak journeys: " + offPeakCount);  
            writer.println("Journeys where cap affected fare: " + capReachedCount);  
            writer.println("Savings compared to uncapped fares: £" + savings);  
    
            writer.println("Zone pair counts:");  
            for (Map.Entry<String, Integer> entry : zonePairCounts.entrySet()){  
                writer.println(entry.getKey() + " -> " + entry.getValue());  
            }  
    
            if (mostExpensive != null){  
                writer.println("Most expensive journey: ID " + mostExpensive.getId() +  
                        " | £" + mostExpensive.getFare().setScale(2, RoundingMode.HALF_UP));  
            }  
    
            writer.close();  
    
            System.out.println("Summary exported to " + fileName);  
        }  
        catch (Exception e) {  
            System.out.println("File export error.");  
        }  
    }  
    
    private void exportJourneysCsv(){  
        try {  
            PrintWriter writer = new PrintWriter(new FileWriter("journeys.csv"));  
            writer.println("id,date,time,fromZone,toZone,band,type,zonesCrossed,baseFare,discountApplied,fare,capApplied");  
    
            for (Journey j : journeys){  
                writer.println(j.toCsv());  
            }  
    
            writer.close();  
            System.out.println("Journeys exported to journeys.csv");  
        }  
        catch (Exception e){  
            System.out.println("CSV export error.");  
        }  
    }  
    
    private void importJourneysCsv(){  
        try {  
            System.out.print("CSV file name (example journeys.csv): ");  
            String fileName = sc.nextLine();  
    
            BufferedReader reader = new BufferedReader(new FileReader(fileName));  
            String line;  
    
            journeys.clear();  
            resetTotalsOnly();  
            idCounter = 1;  
    
            while ((line = reader.readLine()) != null){  
                if (line.trim().equals("") || line.startsWith("id")){  
                    continue;  
                }  
    
                String[] parts = line.split(",");  
    
                if (parts.length < 12){  
                    continue;  
                }  
    
                int id = Integer.parseInt(parts[0]);  
                String date = parts[1];  
                String time = parts[2];  
                int fromZone = Integer.parseInt(parts[3]);  
                int toZone = Integer.parseInt(parts[4]);  
                String band = parts[5];  
                String type = parts[6];  
                int zonesCrossed = Integer.parseInt(parts[7]);  
                BigDecimal baseFare = new BigDecimal(parts[8]);  
                BigDecimal discountApplied = new BigDecimal(parts[9]);  
                BigDecimal fare = new BigDecimal(parts[10]);  
                boolean capApplied = Boolean.parseBoolean(parts[11]);  
    
                Journey j = new Journey(id,date,time,fromZone,toZone,band,type,zonesCrossed,baseFare,discountApplied,fare,capApplied);  
                journeys.add(j);  
    
                CityRideDataset.PassengerType pType = CityRideDataset.PassengerType.valueOf(type);  
                updateTotals(pType, fare);  
                updateCounts(pType);  
    
                if (id >= idCounter){  
                    idCounter = id + 1;  
                }  
            }  
    
            reader.close();  
            System.out.println("Journeys imported.");  
        }  
        catch (Exception e){  
            System.out.println("CSV import error.");  
        }  
    }  
    
    private void saveProfileJson(){  
        try {  
            if (activeProfile == null){  
                System.out.println("No active profile.");  
                return;  
            }  
    
            PrintWriter writer = new PrintWriter(new FileWriter("profile.json"));  
            writer.println("{");  
            writer.println("\"name\":\"" + activeProfile.getName() + "\",");  
            writer.println("\"passengerType\":\"" + activeProfile.getPassengerType() + "\",");  
            writer.println("\"defaultPayment\":\"" + activeProfile.getDefaultPayment() + "\"");  
            writer.println("}");  
            writer.close();  
    
            System.out.println("Profile saved to profile.json");  
        }  
        catch (Exception e){  
            System.out.println("Profile save error.");  
        }  
    }  
    
    private void loadProfileJson(){  
        try {  
            BufferedReader reader = new BufferedReader(new FileReader("profile.json"));  
            String line;  
            String name = "";  
            String passengerType = "";  
            String defaultPayment = "";  
    
            while ((line = reader.readLine()) != null){  
                line = line.trim();  
    
                if (line.startsWith("\"name\"")){  
                    name = getJsonValue(line);  
                }  
                else if (line.startsWith("\"passengerType\"")){  
                    passengerType = getJsonValue(line);  
                }  
                else if (line.startsWith("\"defaultPayment\"")){  
                    defaultPayment = getJsonValue(line);  
                }  
            }  
    
            reader.close();  
    
            activeProfile = new RiderProfile(name,passengerType,defaultPayment);  
            System.out.println("Profile loaded.");  
        }  
        catch (Exception e){  
            System.out.println("Profile load error.");  
        }  
    }  
    
    private void saveDayStateJson(){  
        try {  
            PrintWriter writer = new PrintWriter(new FileWriter("daystate.json"));  
    
            writer.println("{");  
    
            if (activeProfile != null){  
                writer.println("\"profileName\":\"" + activeProfile.getName() + "\",");  
                writer.println("\"profileType\":\"" + activeProfile.getPassengerType() + "\",");  
                writer.println("\"profilePayment\":\"" + activeProfile.getDefaultPayment() + "\",");  
            }  
            else{  
                writer.println("\"profileName\":\"\",");  
                writer.println("\"profileType\":\"\",");  
                writer.println("\"profilePayment\":\"\",");  
            }  
    
            writer.println("\"journeys\":[");  
    
            for (int i = 0; i < journeys.size(); i++){  
                Journey j = journeys.get(i);  
    
                writer.print("{");  
                writer.print("\"id\":\"" + j.getId() + "\",");  
                writer.print("\"date\":\"" + j.getDate() + "\",");  
                writer.print("\"time\":\"" + j.getTime() + "\",");  
                writer.print("\"fromZone\":\"" + j.getFromZone() + "\",");  
                writer.print("\"toZone\":\"" + j.getToZone() + "\",");  
                writer.print("\"band\":\"" + j.getBand() + "\",");  
                writer.print("\"type\":\"" + j.getType() + "\",");  
                writer.print("\"zonesCrossed\":\"" + j.getZonesCrossed() + "\",");  
                writer.print("\"baseFare\":\"" + j.getBaseFare() + "\",");  
                writer.print("\"discountApplied\":\"" + j.getDiscountApplied() + "\",");  
                writer.print("\"fare\":\"" + j.getFare() + "\",");  
                writer.print("\"capApplied\":\"" + j.isCapApplied() + "\"");  
                writer.print("}");  
    
                if (i < journeys.size() - 1){  
                    writer.println(",");  
                }  
                else{  
                    writer.println();  
                }  
            }  
    
            writer.println("]");  
            writer.println("}");  
            writer.close();  
    
            System.out.println("Day state saved to daystate.json");  
        }  
        catch (Exception e){  
            System.out.println("State save error.");  
        }  
    }  
    
    private void loadDayStateJson(){  
        try {  
            BufferedReader reader = new BufferedReader(new FileReader("daystate.json"));  
            String line;  
    
            journeys.clear();  
            resetTotalsOnly();  
            idCounter = 1;  
    
            String profileName = "";  
            String profileType = "";  
            String profilePayment = "";  
    
            while ((line = reader.readLine()) != null){  
                line = line.trim();  
    
                if (line.startsWith("\"profileName\"")){  
                    profileName = getJsonValue(line);  
                }  
                else if (line.startsWith("\"profileType\"")){  
                    profileType = getJsonValue(line);  
                }  
                else if (line.startsWith("\"profilePayment\"")){  
                    profilePayment = getJsonValue(line);  
                }  
                else if (line.startsWith("{\"id\"")){  
                    String clean = line;  
    
                    if (clean.endsWith(",")){  
                        clean = clean.substring(0, clean.length() - 1);  
                    }  
    
                    clean = clean.replace("{","").replace("}","");  
                    String[] parts = clean.split(",");  
    
                    HashMap<String, String> map = new HashMap<String, String>();  
    
                    for (String p : parts){  
                        String[] kv = p.split(":");  
                        if (kv.length == 2){  
                            String key = kv[0].replace("\"","").trim();  
                            String value = kv[1].replace("\"","").trim();  
                            map.put(key, value);  
                        }  
                    }  
    
                    Journey j = new Journey(  
                            Integer.parseInt(map.get("id")),  
                            map.get("date"),  
                            map.get("time"),  
                            Integer.parseInt(map.get("fromZone")),  
                            Integer.parseInt(map.get("toZone")),  
                            map.get("band"),  
                            map.get("type"),  
                            Integer.parseInt(map.get("zonesCrossed")),  
                            new BigDecimal(map.get("baseFare")),  
                            new BigDecimal(map.get("discountApplied")),  
                            new BigDecimal(map.get("fare")),  
                            Boolean.parseBoolean(map.get("capApplied"))  
                    );  
    
                    journeys.add(j);  
    
                    CityRideDataset.PassengerType pType = CityRideDataset.PassengerType.valueOf(j.getType());  
                    updateTotals(pType, j.getFare());  
                    updateCounts(pType);  
    
                    if (j.getId() >= idCounter){  
                        idCounter = j.getId() + 1;  
                    }  
                }  
            }  
    
            reader.close();  
    
            if (!profileName.equals("")){  
                activeProfile = new RiderProfile(profileName,profileType,profilePayment);  
            }  
    
            System.out.println("Day state loaded.");  
        }  
        catch (Exception e){  
            System.out.println("State load error.");  
        }  
    }  
    
    private String getJsonValue(String line){  
        String value = line.substring(line.indexOf(":") + 1).trim();  
        value = value.replace(",", "");  
        value = value.replace("\"", "");  
        return value;  
    }  
    
    private void loadConfig(){  
        try {  
            File file = new File("config.txt");  
    
            if (!file.exists()){  
                setSafeDefaults();  
                System.out.println("Config file not found. Safe defaults loaded.");  
                return;  
            }  
    
            setSafeDefaults();  
    
            BufferedReader reader = new BufferedReader(new FileReader(file));  
            String line;  
    
            while ((line = reader.readLine()) != null){  
                String[] parts = line.split("=");  
    
                if (parts.length != 2){  
                    continue;  
                }  
    
                String key = parts[0];  
                String value = parts[1];  
    
                if (key.equals("PEAK_START")){  
                    peakStart = value;  
                }  
                else if (key.equals("PEAK_END")){  
                    peakEnd = value;  
                }  
                else if (discountRates.containsKey(key)){  
                    discountRates.put(key,new BigDecimal(value));  
                }  
                else if (dailyCaps.containsKey(key)){  
                    dailyCaps.put(key,new BigDecimal(value));  
                }  
            }  
    
            reader.close();  
            System.out.println("Config loaded.");  
        }  
        catch (Exception e){  
            setSafeDefaults();  
            System.out.println("Config error. Safe defaults loaded.");  
        }  
    }  
    
    private void saveConfig(){  
        try {  
            PrintWriter writer = new PrintWriter(new FileWriter("config.txt"));  
    
            for (Map.Entry<String, BigDecimal> entry : discountRates.entrySet()){  
                writer.println(entry.getKey() + "=" + entry.getValue());  
            }  
    
            for (Map.Entry<String, BigDecimal> entry : dailyCaps.entrySet()){  
                writer.println(entry.getKey() + "=" + entry.getValue());  
            }  
    
            writer.println("PEAK_START=" + peakStart);  
            writer.println("PEAK_END=" + peakEnd);  
    
            writer.close();  
            System.out.println("Config saved.");  
        }  
        catch (Exception e){  
            System.out.println("Config save error.");  
        }  
    }  
    
    private void setSafeDefaults(){  
        discountRates.clear();  
        dailyCaps.clear();  
    
        discountRates.put("ADULT", new BigDecimal("0.00"));  
        discountRates.put("STUDENT", new BigDecimal("0.25"));  
        discountRates.put("CHILD", new BigDecimal("0.50"));  
        discountRates.put("SENIOR_CITIZEN", new BigDecimal("0.30"));  
    
        dailyCaps.put("ADULT", new BigDecimal("8.00"));  
        dailyCaps.put("STUDENT", new BigDecimal("6.00"));  
        dailyCaps.put("CHILD", new BigDecimal("4.00"));  
        dailyCaps.put("SENIOR_CITIZEN", new BigDecimal("5.00"));  
    }  
    
    private void showConfig(){  
        System.out.println("\n--- Active Config ---");  
        System.out.println("Discounts:");  
        for (Map.Entry<String, BigDecimal> entry : discountRates.entrySet()){  
            System.out.println(entry.getKey() + " -> " + entry.getValue());  
        }  
    
        System.out.println("Daily Caps:");  
        for (Map.Entry<String, BigDecimal> entry : dailyCaps.entrySet()){  
            System.out.println(entry.getKey() + " -> " + entry.getValue());  
        }  
    
        System.out.println("Peak Start: " + peakStart);  
        System.out.println("Peak End: " + peakEnd);  
    }  
    
    private void updateDiscount(){  
        try {  
            System.out.print("Passenger type (ADULT/STUDENT/CHILD/SENIOR_CITIZEN): ");  
            String type = sc.nextLine().toUpperCase();  
    
            if (!discountRates.containsKey(type)){  
                System.out.println("Invalid type.");  
                return;  
            }  
    
            System.out.print("New discount rate (example 0.25): ");  
            BigDecimal value = new BigDecimal(sc.nextLine());  
    
            if (value.compareTo(BigDecimal.ZERO) < 0 || value.compareTo(BigDecimal.ONE) > 0){  
                System.out.println("Discount must be between 0 and 1.");  
                return;  
            }  
    
            discountRates.put(type, value);  
            System.out.println("Discount updated.");  
        }  
        catch (Exception e){  
            System.out.println("Invalid input.");  
        }  
    }  
    
    private void updateCap(){  
        try {  
            System.out.print("Passenger type (ADULT/STUDENT/CHILD/SENIOR_CITIZEN): ");  
            String type = sc.nextLine().toUpperCase();  
    
            if (!dailyCaps.containsKey(type)){  
                System.out.println("Invalid type.");  
                return;  
            }  
    
            System.out.print("New daily cap (example 7.50): ");  
            BigDecimal value = new BigDecimal(sc.nextLine());  
    
            if (value.compareTo(BigDecimal.ZERO) < 0){  
                System.out.println("Cap cannot be negative.");  
                return;  
            }  
    
            dailyCaps.put(type, value);  
            System.out.println("Cap updated.");  
        }  
        catch (Exception e){  
            System.out.println("Invalid input.");  
        }  
    }  
    
    private void updatePeakStart(){  
        System.out.print("New peak start (HH:MM example 06:30): ");  
        String value = sc.nextLine();  
    
        if (value.length() != 5 || !value.contains(":")){  
            System.out.println("Invalid time format.");  
            return;  
        }  
    
        peakStart = value;  
        System.out.println("Peak start updated.");  
    }  
    
    private void updatePeakEnd(){  
        System.out.print("New peak end (HH:MM example 09:30): ");  
        String value = sc.nextLine();  
    
        if (value.length() != 5 || !value.contains(":")){  
            System.out.println("Invalid time format.");  
            return;  
        }  
    
        peakEnd = value;  
        System.out.println("Peak end updated.");  
    }  
    
    private void showRoles() {  
        System.out.println("Rider role: " + rider.getRole());  
        System.out.println("Admin role: " + admin.getRole());  
    }  
    
    private void askSaveOnExit(){  
        System.out.print("Save current day state before exit? (yes/no): ");  
        String answer = sc.nextLine().toLowerCase();  
    
        if (answer.equals("yes")){  
            saveDayStateJson();  
        }  
    }  
    
    private void resetTotalsOnly(){  
        adultTotal = BigDecimal.ZERO;  
        studentTotal = BigDecimal.ZERO;  
        childTotal = BigDecimal.ZERO;  
        seniorTotal = BigDecimal.ZERO;  
    
        adultCount = 0;  
        studentCount = 0;  
        childCount = 0;  
        seniorCount = 0;  
    }  
    
    private void resetData() {  
        journeys.clear();  
        resetTotalsOnly();  
        idCounter = 1;  
        System.out.println("All data reset.");  
    }  

}

------------------------------------------------------------------------------------------------------------------------------

##### References

GeeksforGeeks. (n.d.). *Object Oriented Programming in Java*. Retrieved from: [Java OOP(Object Oriented Programming) Concepts - GeeksforGeeks](https://www.geeksforgeeks.org/object-oriented-programming-oops-concept-in-java/) [Accessed 16 March 2026]

GeeksforGeeks. (n.d.). *JSON in Java*. Retrieved from: https://www.geeksforgeeks.org/json-in-java/ [Accessed 1 April 2026]

GeeksforGeeks. (n.d.). *Reading and Writing CSV Files in Java*. Retrieved from: https://www.geeksforgeeks.org/reading-csv-file-java/  [Accessed 1 April 2026]

Bro Code. (2025, January 2).*Java Full Course for free* . [YouTube video]. Retrieved from: [Java Full Course for free ☕ - YouTube](https://www.youtube.com/watch?v=xTtL8E4LzTQ) [Accessed 20 March 2026]

Caleb Curry. (2023, December 8). *Object Oriented Programming in Java - All-in-One Tutorial Series!.* [YouTube video]. Retrieved from: [Object Oriented Programming in Java - All-in-One Tutorial Series! - YouTube](https://www.youtube.com/watch?v=Af3s3KsxStY) [Accessed 20 March 2026]

GeeksforGeeks. (n.d.). *BigDecimal in Java*. Retrieved from: https://www.geeksforgeeks.org/bigdecimal-class-in-java/ [Accessed 25 March 2026]

Java Code Geeks. (2020, July 29). *Java Console Application Tutorial*. [YouTube video]. Retrieved from: https://www.youtube.com/watch?v=QUZx3LTH7nU [Accessed 28 March 2026]

------------------------------------------------------------------------------------------------------------------------------

##### Appendices

**IY4113 Milestone 1 Part 2**

Purpose of the Program

---

The main goal of this project is to change CityRide Lite into transport application. Program helps people calculate travel costs, manage profiles and create official reports. It is designed for two different types of users riders and administrators.

**Core Program Functionality:**

**User Roles:** The system has a login screen where users choose to be a rider or an admin. Admin must use a password to enter their special menu

**Profile Management:** Riders can create a personal profile with their name, passenger type and payment method. This profile is saved in a JSON file so the user can load it later.

**Journey Management:** Users can add new journeys manually or import many journeys at once from a CSV file. They can also edit or delete journeys if they make a mistake.

**Smart Fare Calculation:** The app calculates prices using zones and time bands Peak or Offpeak. It automaticaly applies discounts and checks Daily Caps so user does not pay more than the limit.

**Data Persistence:** All settings, profiles and journeys are stored in JSON and CSV files. This means the app remembers everything even after you restart the program.

**Detailed Reporting:** At the end of the day, the app creates a summary. It shows the total cost, average cost, and the most expensive trip. These are saved as CSV and text files.

**System Constraints:**

**Configuration:** If the settings file is missing, system must start with safe default values to prevent errors.

**Data Validation:** When an Admin changes a price or a Rider adds a journey, the program must check if the numbers are correct. If the input is wrong it shows a clear error message.

**Recalculation:** If a journey is deleted, the system must recalculate all totals and caps immediately to stay accurate.

---

### Input Process Output Table

---

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-03-22-18-51-17-image.png)

---

### Algorithm Design

---

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-03-22-20-04-12-image.png)

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-03-22-20-11-56-image.png)

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-03-22-20-18-48-image.png)

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-03-22-20-31-06-image.png)

---

### Research (minimum of 1 required, preferrebly 2)

-----------------------------------------------------------------------------------------------------------------------------**Name of program:** Uber ride cost system

**Reference (link):** https://www.uber.com/gb/en/

**What it does well:**

Shows estimated price before confirming the trip

Provides trip history and receipts

Simple and user-friendly interface

**What it does poorly :**

Prices can change due to surge pricing

Not always transparent how final price is calculated

**Key design ideas you could reuse:**

Clear summary of each journey

Showing total cost and trip details

**Screenshot (showing the interface/output):**

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-03-22-19-16-24-image.png)

**Name of program:** Citymapper

**Reference (link):** [https://citymapper.com](https://citymapper.com)

**What it does well:**

Provides real time transport information and route planning

Combines multiple transport types

Shows estimated travel time and different route options

**What it does poorly:**

It focuses more on route planning than fare calculation

**Key design ideas you could reuse:**

Showing multiple journey options

Clear and simple user interface

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-03-22-19-25-47-image.png)

---

### Gantt Chart

---

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-03-22-19-54-10-image.png)

---

### Diary Entries

---

## **- 18/03/2026**

Today I worked on the planning part of my project. I created IPO tables for different functions like adding journey and calculating fare. It was a bit confusing to decide what to write in process part but after thinking more I fixed it. And now I understand better how the system should work.

---

## **- 20/03/2026**

Today I focused on research. I searched some real applications like Uber and Citymapper. I looked how they show journey details and prices. I also added screenshots for them. It helped me to get ideas for my own program. Sometimes it was hard to find good screenshots because some of them were not clear.

---

## **- 21/03/2026**

Today I started designing the system. I tried to create flowcharts to show how the program works. I found flowcharts to be the most difficult part because it was hard to clearly organize the steps generally, flowcharts are the part I struggle with the most. Now I have a better idea about how I will build the program in next stage.

------------------------------------------------------------------------------------------------------------------------------

**4113 Milestone 2 Part 2**

Research (minimum of 2, at least 3)

---

Conduct research to support your coding process, including use of code examples, tutortials, documentation and AI tools (if used).

Use the structure below to capture your evidence:

---

Title of research: Java Inheritance

Reference (link): [Inheritance in Java - GeeksforGeeks](https://www.geeksforgeeks.org/java/inheritance-in-java/)

How does the research help with coding practise?: I looked at this to understand inheritance better. At first I couldn’t apply it to my code the way I wanted. But after checking a few more sources I managed to use it in my program and added it for Part 2. It also helped me organise my code better.

Key coding ideas you could reuse in your program:

- using extends
- parent and child classes
- method overriding

Screenshot of research:

---

Title of research: Writing Data to Files in Java

Reference (link): [Java FileWriter Class - GeeksforGeeks](https://www.geeksforgeeks.org/java/filewriter-class-in-java/)

How does the research help with coding practise?: After I checked some example codes I got how FileWriter and PrintWriter work.Then I used it in my code. Added it successfully.This helped me make a feature to export the journey summary into a text file so my program can save results of just showing them on the screen.It was helpful to export journey summary

Key coding ideas you could reuse in your program:![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-04-06-23-35-33-image.png)

- creating a file using FileWriter
- writing data using PrintWriter
- closing the file after writing
- exporting summary data

Screenshot of research:![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-04-06-23-40-33-image.png)

Title of research: Reading and Writing JSON in Java

Reference (link): [GeeksforGeeks | 404](https://www.geeksforgeeks.org/read-and-write-json-to-a-file-in-java/)

How does the research help with coding practise?: This is one of the required topics for Part 2. Even though I understood how to use it I did not include it in my code at this stage. It can be useful to save and load data, such as rider profiles so the program can keep information even after it is closed.

Key coding ideas you could reuse in your program:

- saving data into JSON
- loading data from JSON
- storing user or profile data

Screenshot of Research:![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-04-06-23-48-15-image.png)

---

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

```
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
```

}

class User  
{  
protected String name;

```
public User(String name){  
    this.name = name;}  

public String getRole(){  
    return "User";}  
```

}

class Rider extends User

{  
public Rider(String name){  
super(name);}

```
public String getRole(){  
    return "Rider";  
}  
```

}

class Admin extends User  
{  
public Admin(String name){  
super(name);}

```
public String getRole(){  
    return "Admin";}  
```

}

public class CityRideLite{

```
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
```

}

---

### Updated Gantt Chart

---

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-04-07-00-08-07-image.png)

---

### Diary Entries (at least 4)

---

**Diary Entry 1** 30/03/2026
Today I looked at my Part 1 code again after feedback. I saw that from feedback some features were missing like filtering and remove. I started to fix these parts and improve the menu.

**Diary Entry 2** 01/04/2026 
Today I improved my code more based on feedback. I added reset, category counts and better summary. Now my program looks more complete and more organised.

**Diary Entry 3** 03/04/2026
Today I did research about inheritance and file writing . I checked some examples and tried to understand how they work. This helped me plan what to add next.

**Diary Entry 4** 03/04/2026
Today I started improving my code for Part 2. I added inheritance and also a feature to export summary to a file. It was a bit difficult but I managed to make it work.

**Diary Entry 5** 06/04/2026

Today I continued working on my program and focused more on Part 2. I added the edit journey feature and tested the program to make sure everything works correctly. I also started to understand my code better by spending more time studying and practicing. So far I have added features like inheritance, file export and editing journeys.However, there are still some parts missing like JSON and more advanced file handling which I plan to add later.
