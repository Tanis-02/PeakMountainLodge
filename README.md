# Peak Mountain Lodge
CEN 3031 Resort Project

## Home Page

The HomeController and home.fxml files are used to create the first page that a user sees. They can choose one of three options: book now (new guest), current guest, and manager login.

## New Guest Page
The NewGuestController and new_guest.fxml files are used to gather the check in and check out date from the user as well as the number of guests that will be coming on the trip. Logic has been added for when a customer chooses their dates and number of guests, they will be shown the available rooms that meet their criteria. The submit button will display available rooms and add the check in and check out chosen to the database.

## Available Rooms Page
The AvailableRoomsController and available_rooms.fxml files are used to display the rooms that are available to the guest for their requested stay. It displays the price, amenities, and a photo of the room. The price of the rooms will depend on the dates chosen for the reservation. The book button will bring the customer to a page to create an account before asking for payment. 

## Create Account Page
The CreateAccountController and create_account.fxml files are used to gather the customers infomration and store it into the database. After the user information has been added, the user will continue to the payment page.

## Current Guest Page
The CurrentGuestController and current_guest.fxml files are used to verify the guests last name and phone number to match the database records to verify that they are indeed a guest and can book activities, dinner reservations, and special requests. The default values currently are guest and 1234567890 for last name and phone number. 

## Current Guest Options Page
The CurrentGuestOptionsController and current_guest_options.fxml files are used to give the customer four choices to choose from: activities, special requests, dining, and checkout. The activities button will direct them to the activities page, the special requests button will direct them to the special requests page, the dining button will direct them to the dining page, and the check out page will allow the customer to give feedback to the resort and checkout. The customer is also greeted with a label that displays their last name. A confirmation pop-up will allow the user to know that the checkout has been made.
 
## Activities Page
The ActivitiesController and activities.fxml files are used to display the available options to the customer as far as activities are concerned. Right now, the only available activities are jetskiing and snorkeling tours. The user can select the date and number of guests that will be present and can book their activity. The two method's will go to the confirmation page to confirm the guest's activity. It must have both the date and number of guests selected and the date must be within their stay which is checked with the database.

## Special Requests Page
The SpecialRequestsController and special_requests.fxml files are used to display the available options to the customer as far as special requests are concerned. Right now, the only available options are for bedding and toiletries, but a user can send a message with a request to the front office. The user can choose from the list of options (not initiliazed) and the quantity that they are requesting. They will be greeted with an alert that confirms their selection. Logic has been added to confirm requests that have been made.

## Dining Page
The DiningController and dining.fxml files are used to display the available options for dining to the customer. Right now, we only have two restaurants showing to the user. The ability to choose a date, time, and number of guests is able to be chosen. The user is met with an alert that confirms their selection. 

## Manager Login Page
The ManagerLoginController and manager_login.fxml files are used to gather the username and password of a manager and cross reference them with the database to verify they are indeed a manager. The default values currently are admin and password for username and password, respectively.

## Manager Overview Page
The ManagerOverviewController and manager_overview.fxml files are used to display all the data to the manager. The manager can see financial reports from past and present, make blackout dates (dates unavailable for booking), put promotional discounts on rooms, view customer information or search from the database for a customer, view customer feedback, view occupancy, and exit the manager overview page by clicking the exit button that will bring them to the home page. The initialize method serves the purpose of populating the textarea in the customer feedback tab each time the user (which in this case will be a manager) logs into the manager overview screen.

## Payment Page
The PaymentController and payment.fxml files are used to for the customer to enter his or her credit card information into the database. 
Logic has been added for when information has been entered incorrectly and for when the information is entered correctly and applied, a confirmation message will appear. 

## ConnManager
The ConnMannager file is connected to the database and allows the manager to select, insert, and verfiy activity reservations, all employees, all customers, and dates. When added to other files the information given and chosen will be added to the specific customers section in the database.

## Guest Feedback Page
The GuestFeedbackController and guest_feedback.fxml files are used to allow the customers to give feedback on their stay. The initialize method allows the submit button to be pressed and the text area to type in feedback to be edited again, as both are disabled when the user submits their feedback so as to prevent spam. submitFeedback is called whenever a guest clicks the "Submit Feedback" button. It sends the text from the corresponding textBox, in addition to the name of the family currently logged in, to ManagerOverviewController.

Edited by: Andrew Cavallaro on 10/20/2019
Edited by: Joseph Cisar on 11/30/2019
