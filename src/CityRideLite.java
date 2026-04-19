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

            BigDecimal baseFare = CityRideDataset.getBaseFare(from, to, band);
            BigDecimal discountRate = getDiscountRate(type);
            BigDecimal discountApplied = baseFare.multiply(discountRate).setScale(2, RoundingMode.HALF_UP);
            BigDecimal discountedFare = baseFare.subtract(discountApplied).setScale(2, RoundingMode.HALF_UP);

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