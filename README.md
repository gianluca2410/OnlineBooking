# OnlineBooking
This Repository contains my first assignment in Advanced Software Systems.

All the informations here showed are too in a seperate .pdf in the documents.


Requirements Achieved :
Recyclerview + Cardview is used to show the books data which is stored in the database which the user can see when they login the list will be displayed there .
Sql database is used to store the data . when the admin add the data of books it will be stored in the sql database and also when the user login data is displayed in the cardview which comes from the local database .
Use of text file : text is stored in the strings file and getting access from there .
Local notifications are used to inform the admin that data is successfully stored in the database . it will come after adding the required filed and press the save button.
Comments are added in the code .
Dialogs are used when the user click click on the cardview a dialog box will be shown with some text in it .
Fragments are used In the app and designed is done on the constraint layout so the different size of screens will not affect the design of the app .
Application is multilanguage app ( English and Italian)
For the styles of buttons files are created the drawable folder to give it customized backgrounds etc . 
Implicit intents are used in the user side user can access the contacts when the press the button the contact from mobile will be accessed .
 
 
 
Manual :
 
Admin Password : 123456
When the user opens the app on the first screen three buttons are displayed one the user login second for the admin and third to access the contacts .
Contact button : When user click it it will get contacts from the phone .
Admin Button: when it will be clicked it goes to admin login page admin will enter the password and then it goes to admin dashboard .
On the dashboard there are three buttons Insert , Update , Delete .
On the insert it will go to activity on which admin will add the information about the books to be added . admin will add author name , book code , price , total pages etc .
When the admin hits the save buttons data will be stored in the database and local notification used there .
When it clicks on the update then click on any card it goes to detail activity from there admin can open the detail activity and then he can update the data.
Same goes for the delete buttons admin can delete any book data from there .
 
User side :
User can click on the user buttons it will go to next activity which will display all the data of the books in the cardview and when the user clicks on the card dialog box will show with info about order .
 
Classes used :
Notification Service class:
This class is used with extend of broadcast receiver . it is used for the local notification which informs about data is stored .
Databse Class:
This class is used with the extend of sql lite open helper . It used for the insertion of data to update data , to delete data from database and also it helps to retrieve data from the database .
Constant  Class:
It used to declare variable and functions which we can access in the whole app without declaring the object.
Model Class (Book):
We have the getter and constructor to retrieve and send data to the database . 
