# Cinemark System

The Cinemark System is a comprehensive platform designed to manage and oversee all aspects related to operating a movie theater chain. This tool offers a complete and efficient solution for managing cinema halls, scheduling movies, ticket sales, online reservations, and much more.

| Index | Title          |
|-------|----------------|
| 1     | Introduction   |
| 2     | Characteristics|
| 3     | Requirements   |
| 4     | Installation   |
| 5     | Uses           |
| 6     | License        |
| 7     | Contact        |

## Introduction
The Cinemark System is a versatile platform designed to streamline operations for any movie theater, catering to both ticketing staff and administrators. This system facilitates inventory management, invoice generation, and cinema ticket sales, among other functions.

Key features include dynamic user registration for invoice generation, hall occupancy tracking, and the sale of tickets and combos. Additionally, the system supports membership sales, allowing for discount applications.

Designed for ticketing staff and administrators, the Cinemark System leverages Java, JDBC, Java Swing, and SQL to deliver a robust desktop application. The system's numerous enhancements and functionalities ensure that users need not directly interact with the database for tasks such as creating combos or calculating product expenses—everything can be managed seamlessly through the system.

## Characteristics

The Cinemark System offers a range of robust features designed to enhance the management and operation of movie theaters. Key characteristics include:

1. Inventory Management: Efficiently track and manage inventory levels, ensuring that stock is always up-to-date.

2. Invoice Generation: Automatically generate and manage invoices, streamlining the billing process.

3. Ticket Sales: Facilitate the sale of cinema tickets with a user-friendly interface for both online and in-person transactions.

4. Reservations: Manage seat reservations dynamically, allowing customers to book their preferred seats with ease.

5. Hall Occupancy Tracking: Monitor and manage the occupancy of cinema halls in real-time.

6. User Registration: Enable dynamic user registration for streamlined and personalized service.

7. Combo Sales: Support the creation and sale of combo packages, including tickets and concessions.

8. Membership Management: Sell and manage memberships, applying discounts and benefits for loyal customers.

9. Expense Calculation: Automatically calculate expenses per product, aiding in financial management.

10. Administrative Controls: Provide robust tools for administrators to oversee operations and make informed decisions.

11. Technology Integration: Utilize Java, JDBC, Java Swing, and SQL to deliver a powerful and reliable desktop application.

These features combine to offer a comprehensive solution for managing the complex operations of a movie theater, making the Cinemark System an indispensable tool for both ticketing staff and administrators.

## Requirements

To run the Cinemark System smoothly, the following minimum requirements must be met:

* **Operating System:**

Windows

* **Software Dependencies:**

iText library

Maven SQL connector

* **Database Setup:**

A folder named DB must be imported into SQL, either through the console or using tools like Workbench/DBVeer.

* **Java Development Kit:**

Latest version of JDK (Java Development Kit) 23

With these requirements in place, you'll be able to fully utilize the features and functionalities of the Cinemark System.

## Installation

Follow these steps to install and set up the Cinemark System using your preferred Integrated Development Environment (IDE):

Clone the Repository
Open your terminal or command prompt.

Clone the repository using the following command:

sh

git clone [https://github.com/Adrian-ortiz0/CinemarkSystem]
Navigate to the project directory:


`cd [Cinemark]](https://github.com/Adrian-ortiz0/CinemarkSystem)`

Install Dependencies
Ensure you have Maven installed on your system.

Install the required dependencies by running:

` ( mvn install )`

Set Up the Database
Open your preferred SQL management tool (Workbench, or console).

Import the DB folder into your SQL database. This can typically be done by executing SQL scripts or using the import feature of your tool.

Configure Database Connection
Open the configuration file located in the project directory (e.g., config.properties).

Update the database connection settings with your specific details:

properties

`db.url=jdbc:mysql://localhost:3306/[Cinemark]
db.username=[user]
db.password=[password]`

**Run the Application**

1. Using IntelliJ IDEA
    Open IntelliJ IDEA.
    
    Select File > Open and navigate to the project directory.

    Ensure that the project SDK is set to JDK 23.
    
    Build the project using Build > Build Project.
    
    Run the application by selecting the main class (e.g., com.example.Main) and clicking Run.
    
2. Using NetBeans
    Open NetBeans.
    
    Select File > Open Project and navigate to the project directory.
    
    Ensure that the project JDK is set to JDK 23.
    
    Right-click the project and select Build.
    
    Run the application by right-clicking the main class (e.g., com.example.Main) and selecting Run.

3. Using Eclipse
   Open Eclipse.
    
    Select File > Import and choose Existing Maven Projects.
    
    Navigate to the project directory and click Finish.
    
    Ensure that the project JDK is set to JDK 23.
    
    Build the project by selecting Project > Build All.
    
    Run the application by selecting the main class (e.g., com.example.Main), right-clicking it, and choosing Run As > Java Application.

With these steps, you should have the Cinemark System up and running on your preferred IDE.

## Uses

The Cinemark System offers a range of functionalities designed to streamline the operations of movie theaters. Here are the primary uses of the system:

1. Logging In
   Ticketing Staff and Administrators can log into the system using their unique credentials. The login process ensures secure access to the various functionalities of the system.

2. Movie Management
   Add New Movies: Administrators can add new movies to the system, including details like title, genre, duration, and screening times.

Update Movie Information: Easily update movie details as needed, ensuring that the information displayed to customers is always accurate.

Remove Movies: Remove movies from the system once they are no longer being screened.

3. Ticket Sales and Reservations
   Sell Tickets: Facilitate the sale of cinema tickets, both online and at the box office, with a user-friendly interface.

Seat Reservations: Allow customers to reserve their preferred seats, ensuring an organized and efficient seating arrangement.

Combo Sales: Offer combo packages that include tickets and concessions, enhancing the customer experience.

4. Inventory Management
   Track Inventory: Monitor stock levels of concessions and other items, ensuring that inventory is always up-to-date.

Reorder Stock: Automatically generate reorder notifications when inventory levels are low.

5. Invoice Generation
   Automatic Invoicing: Generate invoices for ticket sales, combo packages, and other transactions, streamlining the billing process.

Invoice Management: Keep track of all invoices, ensuring accurate and organized financial records.

6. Membership Management
   Sell Memberships: Offer and manage membership packages that provide discounts and other benefits to loyal customers.

Apply Discounts: Automatically apply membership discounts to eligible transactions.

7. Administrative Controls
   User Management: Administrators can manage user accounts, including adding new users, updating user information, and removing users.

Reporting: Generate reports on sales, inventory, and other key metrics to make informed decisions.

8. Expense Calculation
   Product Expenses: Automatically calculate expenses for products sold, aiding in financial management and budgeting.

These uses combine to offer a comprehensive solution for managing the day-to-day operations of a movie theater, making the Cinemark System an indispensable tool for both ticketing staff and administrators.

ahora ayudame con licensia
¡Claro! Aquí tienes una sección de licencia para tu README:

## License

This project is licensed under the MIT License. See the LICENSE file for more details.

A continuación, te dejo un ejemplo de cómo podría verse un archivo de licencia con los términos de la MIT License:

`MIT License

Copyright (c) [Año] [Nombre del Propietario]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.`

## Contact

If you have any questions, suggestions, or issues, please feel free to reach out to us:

Email: dxniel7328@gmail.com

Phone: +57 317 310 9599