# IY4113 Milestone 1 Part 2

| Assessment Details | Please Complete All Details                                           |
| ------------------ | --------------------------------------------------------------------- |
| Group              | A                                                                     |
| Module Title       | 4113 Applied Software Engineering using Object-Orientated Programming |
| Assessment Type    | Part 2 Milestone 1                                                    |
| Module Tutor Name  | Jonathan Shore                                                        |
| Student ID Number  | P490576                                                               |
| Date of Submission | 22/03/2026                                                            |
| Word Count         | 779                                                                   |
| GitHub Link        |                                                                       |

- [x] *I confirm that this assignment is my own work. Where I have referred to academic sources, I have provided in-text citations and included the sources in
  the final reference list.*

- [x] *Where I have used AI, I have cited and referenced appropriately.

------------------------------------------------------------------------------------------------------------------------------

### Purpose of the Program

------------------------------------------------------------------------------------------------------------------------------

The main goal of this project is to change CityRide Lite into  transport application. Program helps people calculate travel costs, manage profiles and create official reports. It is designed for two different types of users riders and administrators.

**Core Program Functionality:**

- **User Roles:** The system has a login screen where users choose to be a rider or an admin. Admin must use a password to enter their special menu

- **Profile Management:** Riders can create a personal profile with their name, passenger type and payment method. This profile is saved in a JSON file so the user can load it later.

- **Journey Management:** Users can add new journeys manually or import many journeys at once from a CSV file. They can also edit or delete journeys if they make a mistake.

- **Smart Fare Calculation:** The app calculates prices using zones and time bands Peak or Offpeak. It automaticaly applies discounts and checks Daily Caps so  user does not pay more than the limit.

- **Data Persistence:** All settings, profiles and journeys are stored in JSON and CSV files. This means the app remembers everything even after you restart the program.

- **Detailed Reporting:** At the end of the day, the app creates a summary. It shows the total cost, average cost, and the most expensive trip. These are saved as CSV and text files.

**System Constraints:**

- **Configuration:** If the settings file is missing,  system must start with safe default values to prevent errors.

- **Data Validation:** When an Admin changes a price or a Rider adds a journey, the program must check if the numbers are correct. If the input is wrong it shows a clear error message.

- **Recalculation:** If a journey is deleted, the system must recalculate all totals and caps immediately to stay accurate.

------------------------------------------------------------------------------------------------------------------------------

### Input Process Output Table

------------------------------------------------------------------------------------------------------------------------------

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-03-22-18-51-17-image.png)

------------------------------------------------------------------------------------------------------------------------------

### Algorithm Design

---

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-03-22-20-04-12-image.png)

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-03-22-20-11-56-image.png)![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-03-22-20-18-48-image.png)

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-03-22-20-31-06-image.png)

------------------------------------------------------------------------------------------------------------------------------

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

**Reference (link):**  [https://citymapper.com](https://citymapper.com)

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

------------------------------------------------------------------------------------------------------------------------------

### Gantt Chart

------------------------------------------------------------------------------------------------------------------------------

![](C:\Users\ery70\AppData\Roaming\marktext\images\2026-03-22-19-54-10-image.png)

------------------------------------------------------------------------------------------------------------------------------

### Diary Entries

------------------------------------------------------------------------------------------------------------------------------

## **- 18/03/2026**

Today I worked on the planning part of my project. I created IPO tables for different functions like adding journey and calculating fare.  It was a bit confusing to decide what to write in process part but after thinking more I fixed it. And now I understand better how the system should work.

---

## **- 20/03/2026**

Today I focused on research. I searched some real applications like Uber and Citymapper. I looked how they show journey details and prices. I also added screenshots for them. It helped me to get ideas for my own program. Sometimes it was hard to find good screenshots because some of them were not clear. 

---

## **- 21/03/2026**

Today I started designing the system. I tried to create flowcharts to show how the program works. I found flowcharts to be the most difficult part because it was hard to clearly organize the steps generally, flowcharts are the part I struggle with the most. Now I have a better idea about how I will build the program in next stage.

------------------------------------------------------------------------------------------------------------------------------
