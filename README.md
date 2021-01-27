# Storytel_App_End_To_End_TestNG


This is an End-to-End test code for Storytel Application. It is written with TestNG. An html report is created after each test with Extent Report.
Test runs from "testng.xml" file.

Before running the code make sure you download the .apk file to your Android Emulator and start Appium Server. 
You can find the Storytel.apk file here. 


Test code includes below scenario;

Scenario 1
1. Open Storytel app
2. Swipe stories to left and right and verify swiping works correctly
3. Click on “Try it out” button
4. Scroll down to find “Iceland” selection
5. Select “Iceland” and click “Done”
6. Select only “English” from languages selections page and click “Done”
7. Scroll down to find “Feelgood” text from Book tips page
8. Swipe left on “Feelgood” section books and click on the 7th item from the list
9. Verify correct book is clicked
10. Click like button
11. Fill a valid email and password and click “Continue” button
12. Click I Accept button (Ég samþykki)
13. Click “No thanks” to Marketing Consent popup
14. Click Back button to close “Welcome to Storytel!” page
15. Click Like button and verify book is saved to bookshelf
16. Click ← to go back to Book tips
17. Open Side Menu
18. Click Search button
19. Swipe left to “Series” section
20. Search for “Harry”
21. Swipe up on search result to find “Advantures of Harry Stevenson” and click on it
22. Verify that page is the correct page
23. Click Filter
24. Remove Ebook from Filter list and click “Done”
25. Verify “Oops! It seems you've filtered a bit too much.” text on the screen.
