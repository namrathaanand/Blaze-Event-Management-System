CREATE TABLE F16_1_CLIENTS
(
	Client_ID integer NOT NULL,
	Name varchar(20) NOT NULL,
	Gender varchar(6) NOT NULL,
	Street varchar(15) NOT NULL,
	City varchar(20) NOT NULL,
	State varchar(30) NOT NULL,
	Zipcode varchar(5) NOT NULL,
	Telephone_Number varchar(10) NOT NULL,
	Date_Of_Birth date NOT NULL,
	Email_ID varchar(30) NOT NULL,
	Occupation varchar(30) NOT NULL,
	PRIMARY KEY (Client_ID)
);

CREATE TABLE F16_1_EMPLOYEES
(
	Employee_ID integer NOT NULL,
	Name varchar(20) NOT NULL,
	Gender varchar(6) NOT NULL,
	Street varchar(15) NOT NULL,
	City varchar(20) NOT NULL,
	State varchar(30) NOT NULL,
	Zipcode varchar(5) NOT NULL,
	Telephone_Number varchar(10) NOT NULL,
	Date_Of_Birth date NOT NULL,
	Email_ID varchar(30) NOT NULL,
	Salary_Per_Hour integer NOT NULL,
	PRIMARY KEY (Employee_ID)
);

CREATE TABLE F16_1_BRANCHES
(
	Branch_ID integer NOT NULL,
	Branch_Name varchar(20) NOT NULL,
	Street varchar(15) NOT NULL,
	City varchar(20) NOT NULL,
	State varchar(30) NOT NULL,
	Zipcode varchar(5) NOT NULL,
	Telephone_Number varchar(10) NOT NULL,
	Manager_ID integer NOT NULL,
	PRIMARY KEY (Branch_ID),
	FOREIGN KEY (Manager_ID) REFERENCES F16_1_EMPLOYEES (Employee_ID) ON DELETE CASCADE
);


CREATE TABLE F16_1_TYPE_OF_EVENTS
(
	Type_ID integer NOT NULL,
	Type_Name varchar(20) NOT NULL,
	PRIMARY KEY (Type_ID)
);

CREATE TABLE F16_1_EVENTS
(
	Event_ID integer NOT NULL,
	Name varchar(100) NOT NULL,
	No_Of_Guests integer NOT NULL,
	Amount_Paid integer NOT NULL,
	Scheduled_DateTime date NOT NULL,
	Loc_Name varchar(100) NOT NULL,
	Loc_City varchar(20) NOT NULL,
	Loc_Lat float NOT NULL,
	Loc_Long float NOT NULL,
	Client_ID integer NOT NULL,
	Branch_ID integer NOT NULL,
	Type_ID integer NOT NULL,
	PRIMARY KEY (Event_ID),
	FOREIGN KEY (Client_ID) REFERENCES F16_1_CLIENTS (Client_ID) ON DELETE CASCADE,
	FOREIGN KEY (Branch_ID) REFERENCES F16_1_BRANCHES (Branch_ID) ON DELETE CASCADE,
	FOREIGN KEY (Type_ID) REFERENCES F16_1_TYPE_OF_EVENTS (Type_ID) ON DELETE CASCADE
);

CREATE TABLE F16_1_SERVICES
(
	Service_ID integer NOT NULL,
	Service_Name varchar(20) NOT NULL,
	Equipment_Charge float NOT NULL,
	Service_Charge float NOT NULL,
	PRIMARY KEY (Service_ID)
);

CREATE TABLE F16_1_BRANCH_EMPLOYEE_ASS
(
	Branch_ID integer NOT NULL,
	Employee_ID integer NOT NULL,
	Service_ID integer NOT NULL,
	PRIMARY KEY (Branch_ID, Employee_ID, Service_ID),
	FOREIGN KEY (Branch_ID) REFERENCES F16_1_BRANCHES (Branch_ID) ON DELETE CASCADE,
	FOREIGN KEY (Employee_ID) REFERENCES F16_1_EMPLOYEES (Employee_ID) ON DELETE CASCADE,
	FOREIGN KEY (Service_ID) REFERENCES F16_1_SERVICES (Service_ID) ON DELETE CASCADE
);

CREATE TABLE F16_1_SERVICE_EVENT_ASS
(
	Event_ID integer NOT NULL,
	Employee_ID integer NOT NULL,
	Service_ID integer NOT NULL,
	Service_Duration float NOT NULL,
	Service_Rating float NOT NULL,
	PRIMARY KEY (Event_ID, Employee_ID, Service_ID),
	FOREIGN KEY (Event_ID) REFERENCES F16_1_EVENTS (Event_ID) ON DELETE CASCADE,
	FOREIGN KEY (Employee_ID) REFERENCES F16_1_EMPLOYEES (Employee_ID) ON DELETE CASCADE,
	FOREIGN KEY (Service_ID) REFERENCES F16_1_SERVICES (Service_ID) ON DELETE CASCADE
);

CREATE TABLE F16_1_OPERATIONS_COST
(
	Cost_ID integer NOT NULL,
	Branch_ID integer NOT NULL,
	Month varchar(10) NOT NULL,
	Year integer NOT NULL,
	Rent float NOT NULL,
	Licence_Cost float NOT NULL,
	Insurance_Cost float NOT NULL,
	Maintenance_Cost float NOT NULL,
	Advertisement_Cost float NOT NULL,
	Miscellaneous_Cost float NOT NULL,
	PRIMARY KEY (Cost_ID, Branch_ID, Month, Year),
	FOREIGN KEY (Branch_ID) REFERENCES F16_1_BRANCHES (Branch_ID) ON DELETE CASCADE
);
COMMIT;