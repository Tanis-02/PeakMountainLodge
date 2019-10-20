# Peak Mountain Lodge
CEN 3031 Resort Project

## Home Page

The HomeController and home.fxml files are used to create the first page that a user sees. They can choose one of three options: book now (new guest), current guest, and manager login.

## New Guest Page
The NewGuestController and new_guest.fxml files are used to gather the check in and check out date from the user as well as the number of guests that will be coming on the trip. There is no logic yet behind this screen. The submit button will display available rooms.

## Available Rooms Page
The AvailableRoomsController and available_rooms.fxml files are used to display the rooms that are available to the guest for their requested stay. It displays the price, amenities, and a photo of the room. The book button will bring the customer to a page to create an account before asking for payment.

## Create Account Page
The CreateAccountController and create_account.fxml files are used to gather the customers infomration and store it into the database. The payment page should follow this, but it has not been created to this point.

## Current Guest Page
The CurrentGuestController and current_guest.fxml files are used to verify the guests last name and phone number to match the database records to verify that they are indeed a guest and can book activities, dinner reservations, and special requests. The default values currently are guest and 1234567890 for last name and phone number.

## Current Guest Options Page
The CurrentGuestOptionsController and current_guest_options.fxml files are used to give the customer three choices to choose from: activities, special requests, and dining. The activities button will direct them to the activities page, the special requests button will direct them to the special requests page, and the dining button will direct them to the dining page. The customer is also greeted with a label that displays their last name.

## Activities Page
The ActivitiesController and activities.fxml files are used to display the available options to the customer as far as activities are concerned. Right now, the only available activities are jetskiing and snorkeling tours. The user can select the date and number of guests that will be present and can book their activity. They will be greeted with an alert that confirms their selection. There is no logic behind this screen yet.

## Special Requests Page
The SpecialRequestsController and special_requests.fxml files are used to display the available options to the customer as far as special requests are concerned. Right now, the only available options are for bedding and toiletries, but a user can send a message with a request to the front office. The user can choose from the list of options (not initiliazed) and the quantity that they are requesting. They will be greeted with an alert that confirms their selection. There is no logic behind this screen yet.

## Dining Page
The DiningController and dining.fxml files are used to display the available options for dining to the customer. Right now, we only have two restaurants showing to the user. More will be added later and the ability to choose a date, time, and number of guests will also be added. The user is met with an alert that confirms their selection. There is no logic behind this screen yet.

## Manager Login Page
The ManagerLoginController and manager_login.fxml files are used to gather the username and password of a manager and cross reference them with the database to verify they are indeed a manager. The default values currently are admin and password for username and password, respectively.

## Manager Overview Page
The ManagerOverviewController and manager_overview.fxml files are used to display all the data to the manager. The manager can see financial reports from past and present, make blackout dates (dates unavailable for booking), put promotional discounts on rooms, view customer information or search from the database for a customer, view customer feedback, view occupancy, and exit the manager overview page by clicking the exit button that will bring them to the home page. There is no logic behind this screen yet, but will be done shortly.

Edited by: Andrew Cavallaro on 10/20/2019
