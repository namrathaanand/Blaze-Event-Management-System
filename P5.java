//package pack;
/*
 * 
 * 
 * DBMS CSE5330 Project on 'BLAZE EVENT MANAGEMENT'
 * (Phase 5)
 * 
 * 
 * By
 * PARTH DESAI, NAMRATHA ANAND
 * 
 * 
*/

import java.sql.*;
import java.util.Date;
import java.io.*;
import java.util.*;
import java.lang.*;


public class P5
{
    public static Connection conn=null;
    Statement stmt=null;
    PreparedStatement ps = null;
    
    
    //constructor
    public P5(){} 

    //Function for Database connectivity.
    public static void DBConnection()
    {
        String unirl = "jdbc:oracle:thin:@localhost:1521:CSE1";
        String id="nxa5760"; // Replace with Network ID
        String pwd="Welcome2016";//Replace with Oracle Password
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn=DriverManager.getConnection(unirl, id, pwd);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Error loading the class :"+e.toString());
        }
        catch(SQLException se)
        {
            System.out.println("DB Didn't connect : "+se.toString());               
        }
        catch(Exception ee)
        {
            System.out.println("Connection threw an exception : "+ee.toString());
            
        }


    }

    
    public static void main(String args[]) throws IOException
    {
        P5 j = new P5();
        String Ch = "", table = "", column1 = "", column2 = "", new_value_str="";
        int scase = 0,scase2 =0, scase3 =0, id=0, max = 0, col_index = 0, new_value_int = 0;
        double new_value_float = 1.5;
        int flag = 0;
            
        InputStreamReader i = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(i);
        do
        {
            System.out.println("\n **********Blaze Event Management System**********\n");
            System.out.println("\n Please select from the following options : ");
            System.out.println("\n 1. View Existing Records");
            System.out.println("\n 2. Insert Records");
            System.out.println("\n 3. Delete Records");
            System.out.println("\n 4. Update Existing Records");
            System.out.println("\n 5. Extract Reports");
            System.out.println("\n 6. Exit ");
            
            System.out.println("\n\n PLEASE ENTER YOUR CHOICE :");
            try 
            {
				Ch=stdin.readLine();
				scase=Integer.parseInt(Ch);
			} 
            catch (NumberFormatException e1) 
            {
				System.out.println("\n Invalid Choice");
			}
            
            try
            {
            	switch(scase)
                {
	            	case 1: 
	            	 {
	            		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	            		j.DBConnection();	
	            		
	            		do{
		            		System.out.println("\n\n 1.  Display contents of CLIENTS table");
		            		System.out.println("\n\n 2.  Display contents of EVENTS table ");
		            		System.out.println("\n\n 3.  Display contents of EMPLOYEES table");
		            		System.out.println("\n\n 4.  Display contents of BRANCHES table");
		            		System.out.println("\n\n 5. Go to previous menu ");
		            		
		            		System.out.println("\n\n PLEASE ENTER YOUR CHOICE :");
		            		
		            		scase2=Integer.parseInt(input.readLine());
		            		
		            		switch(scase2)
		            		{
		            			case 1:
		            			{
		            				j.display_table_clients(); 
		            				break;// end of displaying clients
		            			}
		            			
		            			case 2:
		            			{
		            				j.display_table_events(); 
		            				break;// end of displaying events
		            			}
		            			
		            			case 3:
		            			{
		            				j.display_table_employee(); 
		            				break;// end of displaying employees
		            			}
		            			
		            			case 4:
		            			{
		            				j.display_table_branches(); 
		            				break;// end of displaying branches
		            			}
		            			case 5:
		            			{
		            				break;
		            			}
		            			
		            			default:
		            			{
		            				System.out.println("\n\n Wrong Selection!");
		            				break;
		            			}
		            			
		            			
		            			
		            			
		            		} // end of switch cases for view tables
	            		
	            		} while(scase2!=5); // end of view tables
	            		//continue;
	            		break; // come out of while loop after Case 1
	            		
	            	}// End of case 1 : view tables
	            	case 2:
	            	{
	            		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	            		j.DBConnection();
	            		
	            		do
	            		{
	            			System.out.println("\n Tables available for Inserting records are : ");
		            		System.out.println("\n\n 1. Type of Events table ");
		            		System.out.println("\n\n 2. Go back to previous menu ");
		            		
		            		System.out.println("\n\n PLEASE ENTER YOUR CHOICE :");
		            		scase2=Integer.parseInt(input.readLine());
		            		
		            		switch(scase2)
		            		{
		            			case 1:
		            			{
		            				table = "F16_1_TYPE_OF_EVENTS";
		            				column1 = "Type_ID";
		            				
		            				String col2 = "tempserv",ty_Name="one";
		            				float col3 = 0, col5 = 0;
		            				int col6 = 1, iflag = 1, temp = 1;
		            				System.out.println("\n\n .................Inserting record into TYPE OF EVENTS table...............\n");
		            				max = j.cal_max(table,column1);
		            				max = max+1;
		            				
		            				do 
		            				{
			            				System.out.println("\n\n Valid TYPE ID are from "+max+" to 999:");
			    	                    System.out.println("\nPlease Enter valid TYPE ID from above which you want to insert: ");
			    	                    id=Integer.parseInt(input.readLine());
			    	                    
		            				}while (id < max || id > 999); // validating TYPE ID
		            				
		            				while (iflag == 1)
		            				{
		            					System.out.println("\n\n Please enter the Type Name:");
		            					col2 = stdin.readLine();
			            				
		            					col2.toString().trim();
			            				
			            				if (col2.length() < 0 || col2.length() > 20)
			            				{
			            					System.out.println("\n\n Length of the name can be 1 to 20 charecters long!");
			            				}
			            				
			            				else if (!col2.matches("[a-zA-Z]*"))
			            				{
			            					System.out.println("\n\n Name should contain only alphabets!!");
			            				}
			            				else
			            				{
			            					iflag = 0;
			            					ty_Name=col2;
			            				}
			            					
			            				
		            				}// End of while: validating Type Name field
		            				
		            				table = "F16_1_TYPE_OF_EVENTS";
		            				
		            				System.out.println("\n\n Inserting new record in Type Of Event table........");
		            				j.insert_into_type(table,id,ty_Name);
		            				
		            				break; // Break out of case1 and display the menu inside Insert Record
		            				
		            			}// end of case 1 in scase2: Inserting value
		            			
		            			case 2:
		            			{
		            				break;// Break out of case2 and display the menu inside Insert Record
		            			}// end of case 1 in scase2: Go back to previous menu
		            			
		            			default:
		            			{
		            				System.out.println("\n\n Wrong Selection!");
		            				break;
		            			}
		            			
		            		} // end of switch case for scase2
		            		
	            		} while (scase2 != 2); // end of Insert into table iteration.
	            		
	            		break; // break out of insert menu and go to previous menu 
	            	} // End of case 2 of switch case 1: end of inserting values!
	            	case 3:
	            	{
	            		
	            		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	            		j.DBConnection();
	            		
	            		do
	            		{
		            		System.out.println("\n Tables available for Deleting records are : ");
		            		System.out.println("\n\n 1. Operations Cost table ");
		            		System.out.println("\n\n 2. Go back to previous menu ");
		            		
		            		System.out.println("\n\n PLEASE ENTER YOUR CHOICE :");
		            		scase2=Integer.parseInt(input.readLine());
		            		
		            		switch(scase2)
		            		{
			            		case 1:
		            			{
		            				table = "F16_1_OPERATIONS_COST";
		            				column1 = "Cost_ID";
		            				System.out.println("\n\n .................Deleting record from Operations Cost table...............\n");
		            				max = j.cal_max(table,column1);
		            				do 
		            				{
			            				System.out.println("\n\n Valid Cost ID are between 1 and "+max+":");
			    	                    System.out.println("\nPlease Enter valid Cost ID from above which you want to delete: ");
			    	                    id=Integer.parseInt(input.readLine());
			    	                    
		            				}while (id < 1 | id > max );
		            				
		            				System.out.println("\n\n Existing Values for selected Cost ID:");
		            				j.display_table_cost_on_id(id);
		            				
		            				System.out.println("\n\n Do you want to delete the record with Cost ID:"+id);
		            				System.out.println("\n\n To delete, press Y");
		            				System.out.println("\n\n To abort, press any other key");
		            				Ch=stdin.readLine();
		            				
		            				System.out.println("\n\n Choice:"+Ch);
		            				
		            				if (Ch.toString().trim().equalsIgnoreCase("y"))
		            				{
			            				System.out.println("\n\n Deleting the selected Cost ID:"+id);
			            				j.delete_from_table_on_id(table, column1, id);
			            				System.out.println("\n\n Record successfully deleted");
			            				j.display_table_cost();
			            				break;
		            				}
		            				
		            				System.out.println("\n\n Deletion aborted!");
		            				break;
		            			
		            			} // End of case for deleting passenger
		            		
			            		case 2:
		            			{
		            				break;// Go to previous menu
		            			}
		            			
			            		default:
		            			{
		            				System.out.println("\n\n Wrong Selection!");
		            				break;
		            			}
		            			
		            		} // end of switch case
		            		
	            		} while(scase2!=2); // end of delete record iteration
	            		
	            		break;	            		
	            	}	// End of case 3 : Delete values from table
	            	case 4:
	            	{
	            		
	            		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	            		j.DBConnection();
	            		do
	            		{
		            		System.out.println("\n***** Update Table *****\n");
		            		System.out.println("\n Table available for Update: ");
		            		System.out.println("\n\n 1. SERVICES table");
		            		System.out.println("\n\n\n 2. Go back to previous menu ");
		            		
		            		System.out.println("\n\n PLEASE ENTER YOUR CHOICE :");
		            		Ch = stdin.readLine();
		            		Ch.toString().trim();
		            		scase2=Integer.parseInt(Ch);
	            		
		            		switch(scase2)
		            		{
			            		case 1:
		            			{
		            				table = "F16_1_SERVICES";
		            				column1 = "Service_ID";
		            				System.out.println("\n\n .................Updating SERVICES table...............\n");
		            				
		            				max = j.cal_max(table,column1);
		            				
		            				System.out.println("\n\n Existing Values of SERVICES table are:");
		            				j.display_table_services();
		            				
		            				do 
		            				{
			            				System.out.println("\n\n Valid SERVICE ID are between 1 and "+max+":");
			    	                    System.out.println("\nPlease Enter valid SERVICE ID from above which you want to update: ");
			    	                    Ch = stdin.readLine();
			    	                    id=Integer.parseInt(Ch);
			    	                    
		            				} while (id < 1 | id > max );
		            				
		            				System.out.println("\n\n You can update columns:");
		            				
		            				int temp1 = 0;
		            				
		            				while (temp1 == 0)
		            				{
		            					System.out.println("\n\n 1. Service_Name:");
			            				System.out.println("\n\n 2. Equipment_Charge:");
			            				System.out.println("\n\n 3. Service_Charge:");
		            					System.out.println("\n\n PLEASE ENTER YOUR CHOICE :");
		            					Ch=stdin.readLine();
		            					scase3=Integer.parseInt(Ch);
		            					
		            					if (scase3 == 1 || scase3 == 2 || scase3 == 3)
		            					{
		            						temp1 = 1;
		            					}
		            				}

				            		switch(scase3)
				            		{
					            		case 1:
				            			{
				            				column2 = "Service_Name";
				            				col_index = 2;
				            				System.out.println("\n\n New Service Name can be 20 charecters long. It should be Unique!");
				            				
				            				do
				            				{
				            					System.out.println("\n\n Please enter the New Service Name for SERVICE:");
					            				new_value_str=stdin.readLine();
					            				
					            				new_value_str.toString().trim();
					            				
					            				if (new_value_str.length() < 0 || new_value_str.length() >20)
					            				{
					            					System.out.println("\n\n Length of the name can be 1 to 20 charecters long!");
					            					flag = 1;
					            				}
					            				
					            				else if (!new_value_str.matches("[a-zA-Z]+"))
					            				{
					            					System.out.println("\n\n Service Name should contain only alphabets!!");
					            					flag = 1;
					            				}
					            				
					            				else if (j.does_item_exist(table, new_value_str, col_index) == 1)
					            				{
					            					System.out.println("\n\n Entered Name already exists. Please chose a unique name!");
					            					flag = 1;
					            				}
					            				
					            				else
					            				{
					            					flag = 0;
					            				}
				            				
				            				} while (flag == 1); // Valid New name for Service Name
				            				
				            				j.update_table_str(table, column2, new_value_str, column1, id);
				            				System.out.println("\n\n Record successfully updated!!");
				            				j.display_table_service_on_id(id);
				            				System.out.println("Before break");
				            				break; // break out of update SERVICE NAME and display UPDATE Table menu
				            				
				            			} // End of Case 1 inside switch case 3
					            		case 2:
				            			{
				            				column2 = "Equipment_Charge";
				            				//col_index = 3;
				            				System.out.println("\n\n Number of Equipment Charge can be greater than zero");
				            				
				            				do
				            				{
				            					System.out.println("\n\n Please enter the New Equipment Charge:");
				            					new_value_str=stdin.readLine();
				            					new_value_str.toString().trim();
					            				new_value_float=Float.parseFloat(new_value_str);
					            				
					            				
					            				if (new_value_float <= 0 )
					            				{
					            					System.out.println("\n\n Equipment Charge shall be greater than zero!!");
					            					flag = 1;
					            				}
					            				else if (!new_value_str.matches("[0-9]+.[0-9]*"))
					            				{
					            					System.out.println("\n\n Equipment Charge should contain only Numbers!!");
					            					flag = 1;
					            				}
					            				else
					            				{
					            					flag = 0;
					            				}
					            								            				
				            				} while (flag == 1); // Valid New Equipment Charge for SERVICE
				            				
				            				j.update_table_float(table, column2, new_value_float, column1, id);
				            				System.out.println("\n\n Record successfully updated!!");
				            				j.display_table_service_on_id(id);
				            				break;// break out of update Equipment Charge and display SERVICE Table menu
				            				
				            			}	// End of Case 2 inside switch case 3
					            		case 3:
				            			{
				            				column2 = "Service_Charge";
				            				//col_index = 3;
				            				System.out.println("\n\n Number of Service Charge shall be greater than 0!");
				            				
				            				do
				            				{
				            					System.out.println("\n\n Please enter the New Service Charge:");
				            					new_value_str=stdin.readLine();
				            					new_value_str.toString().trim();
					            				new_value_float=Float.parseFloat(new_value_str);
					            				
					            				
					            				if (new_value_float <= 0)
					            				{
					            					System.out.println("\n\n Service Charge shall be greater than 0!!");
					            					flag = 1;
					            				}
					            				
					            				else if (!new_value_str.matches("[0-9]+.[0-9]*"))
					            				{
					            					System.out.println("\n\n Service Charge should contain only Numbers!!");
					            					flag = 1;
					            				}
					            				
					            				else
					            				{
					            					flag = 0;
					            				}
					            								            				
				            				} while (flag == 1); // Valid New PF_NO for station
				            				
				            				j.update_table_float(table, column2, new_value_float, column1, id);
				            				System.out.println("\n\n Record successfully updated!!");
				            				j.display_table_service_on_id(id);
				            				break;// break out of update Service Charge and display UPDATE Table menu
				            				
				            			}	// End of Case 3 inside switch case 3
				            			
					            		default:
				            			{
				            				System.out.println("\n\n Wrong Selection!");
				            				break;
				            			}
				            			
				            		} 

				            		
				            		break; //break out of update table and display UPDATE Table menu
				            		
				            	} // End of Case 1, Update Service table
		            			
		            			
		            			case 2:
		            			{
		            				break;// break out of update table and display UDATE Table menu
		            			}
		            			
		            			default:
		            			{
		            				System.out.println("\n\n Wrong Selection!");
		            				break;
		            			}
		            		}// end of switch cases 2 for update tables
		            		
		            	
	            		} while(scase2!=2); // end of update tables iteration
	            		
	            		break; // come out of while loop after Case 4 Display 1st menu
	            	
	            	}// End of case 4 of Switch Case 1: update tables
	            	case 5:
	            	{
	            		
	            		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	            		j.DBConnection();
	            		do
	            		{
	            			System.out.println("\n\n1. Extract Sales Report.");
	            			System.out.println("\n\n2. Extract Most Planned Event.");
	            			System.out.println("\n\n3. Extract Small Scale Events & Large Scale Events");
	            			System.out.println("\n\n4. Extract Type Of Event generating most revenue.");
	            			System.out.println("\n\n5. Extract Most and Least popular locations among the events hosted.");
	            			System.out.println("\n\n6. Extract Most popular month for a particular event type.");
	            			System.out.println("\n\n7. Extract Most popular day for events in a particular city.");
	            			System.out.println("\n\n8. Extract Most and least indemand services.");
	            			System.out.println("\n\n9. Extract Expense Statement.");
	            			System.out.println("\n\n10. Monitor Upcoming events.");
	            			System.out.println("\n\n11. Monitor Outstanding monetary due for events.");
	            			System.out.println("\n\n12. Monitor Employee ratings.");
	            			System.out.println("\n\n13. Go to Previous Menu.");
	            			System.out.println("\n\n PLEASE ENTER YOUR CHOICE:");
	            			scase2=Integer.parseInt(input.readLine());

	            			switch(scase2)
	            			{
	            				case 1:
	            				{
	        	            		System.out.println("\nBelow are the available Branch Name");
	        	            		j.display_branchname();
	            	        		System.out.println("\n");
	            					j.monthly_sales_report();
	            					break;// end of Extract Sales Report.
	            				}
	            				
	            				case 2:
	            				{
	            					j.annual_report_planned_events();
	            					break;// end of Extract Most Planned Event.
	            				}
	            				
	            				case 3:
	            				{
	        	            		System.out.println("\nBelow are the available Branch Name");
	        	            		j.display_branchname();
	        	            		System.out.println("\n");
	            					j.small_large_scale();
	            					break;// end of Extract Small Scale Events & Large Scale Events
	            				}
	            				
	            				case 4:
	            				{
	            					j.most_revenue_generate();
	            					break;// end of Extract Type Of Event generating most revenue.
	            				}
	            				
	            				case 5:
	            				{
	        	            		System.out.println("\nBelow are the available City Name");
	        	            		j.display_branchname();
	        	            		System.out.println("\n");
	            					j.most_least_popular_loc();
	            					break;// End of Extract Most and Least popular locations among the events hosted.
	            				}
	            				
	            				case 6:
	            				{
	        	            		System.out.println("\nBelow are the available Branch Name");
	        	            		j.display_branchname();
	        	            		System.out.println("\n");
	            	                System.out.println("\nBelow are the available Event Types");
	            	                System.out.println("\n");
	            	        		j.display_type();
	            	        		System.out.println("\n");
	            					j.popular_month_for_event();
	            					break;// end of Extract Most popular month for a particular event type.
	            				}
	            				
	            				case 7:
	            				{
	        	            		System.out.println("\nBelow are the available Branch Name");
	        	            		j.display_branchname();
	        	            		System.out.println("\n");
	            					j.popular_week_in_branch();
	            					break;// end of Extract Most popular day for events in a particular city.
	            				}
	            				
	            				case 8:
	            				{
	            					j.most_least_popular_service();
	            					break;// end of Extract Most and least indemand services.
	            				}
	            				
	            				case 9:
	            				{
	        	            		System.out.println("\nBelow are the available Branch Name");
	        	            		j.display_branchname();
	        	            		System.out.println("\n");
	            					j.expense_statement();
	            					break;// end of Extract Expense Statement.
	            				}
	            				
	            				case 10:
	            				{
	            					j.monitor_upcoming_events();
	            					break;// end of Monitor Upcoming events.
	            				}
	            				
	            				case 11:
	            				{
	            					j.check_outstanding_dues();
	            					break;// end of Monitor Outstanding monetary due for events.
	            				}
	            				
	            				case 12:
	            				{
	            					j.check_employee_rating();
	            					break;// end of  Monitor Employee ratings.
	            				}            				
	            				case 13:
	            				{
	            					break;
	            				}
	            				
	            				default:
	            				{
	            					System.out.println("\n\n Wrong Selection!");
	            					break;
	            				}
	            			}// end of switch cases for Generate Reports
	            			
	            		} while (scase2 != 13);
	            		
	            		break; // break out of Functionality menu and display Main Menu
	            		
	            	} // End of case 5 : Business Goals
	            	case 6:
	                {   
	                	break;
	                }// end of 6. Exit 
	
	                default:
	                {    
	                    System.out.println("\nWrong selection! please select from above choices");
	                    
	                    break;
	                }
	            		
	            }// End of main switch
            	
            } // end of main try
            
            catch(Exception e)
            {
            }
            
        } 
        while(scase!=6);
    } // End of main function
    
    private void display_table_clients() 
	{
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM F16_1_CLIENTS");
			System.out.println("\nDisplaying table CLIENTS:");
			System.out.println("\n\nClient_ID\t Name\t Gender\t Street\t City\t State\t Zipcode\t Telephone_Number\t Date_Of_Birth\t Email_ID\t Occupation\t");
			
			while (rs.next()) 
            {
                // Get the data from the row using the column index
				 System.out.println("\n"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getDate(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getFloat(8)+"\t"+rs.getFloat(9)+"\t"+rs.getInt(10)+"\t"+rs.getInt(11)+"\t"+rs.getInt(12));
            }
			stmt.close();
			
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
		
	}// end of display_table
    
    private void display_table_events() 
	{
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM F16_1_EVENTS ORDER BY EVENT_ID");
			System.out.println("\nDisplaying table EVENTS:");
			System.out.println("\nEvent_ID\t Name\t No_Of_Guests\t Amount_Paid\t Scheduled_DateTime\t Loc_Name\t Loc_City\t Loc_Lat\t Loc_Long\t Client_ID\t Branch_ID\t Type_ID\t");
			
			while (rs.next()) 
            {
                // Get the data from the row using the column index
				 System.out.println("\n"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getDate(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getFloat(9)+"\t"+rs.getInt(10)+"\t"+rs.getInt(11)+"\t"+rs.getInt(12));
            }
			stmt.close();
			
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
		
	}// end of display_table
    
    
    private void display_table_employee() 
	{
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM F16_1_EMPLOYEES ORDER BY Employee_ID");
			System.out.println("\nDisplaying table EMPLOYEES:");
			System.out.println("\nEmployee_ID\t Name\t Gender\t Street\t City\t State\t Zipcode\t Telephone_Number\t Date_Of_Birth\t Email_ID\t Salary_Per_Hour");
			
			while (rs.next()) 
            {
                // Get the data from the row using the column index
				 System.out.println("\n"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getDate(9)+"\t"+rs.getString(10)+"\t"+rs.getInt(11));
            }
			stmt.close();
			
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
		
	}// end of display_table
    
    
    private void display_table_branches() 
	{
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM F16_1_BRANCHES ORDER BY Branch_ID");
			System.out.println("\nDisplaying table BRANCHES:");
			System.out.println("\nBranch_ID\t Branch_Name\t Street\t City\t State\t Zipcode\t Telephone_Number\t Manager_ID");
			
			while (rs.next()) 
            {
                // Get the data from the row using the column index
				 System.out.println("\n"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getInt(8));
            }
			stmt.close();
			
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
		
	}// end of display_table   
    
    
    
    private void display_branchname() 
	{
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM F16_1_BRANCHES ORDER BY Branch_ID");
			System.out.println("\n");
			
			while (rs.next()) 
            {
                // Get the data from the row using the column index
				 System.out.println("\n"+rs.getString(2));
            }
			stmt.close();
			
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
		
	}// end of display_table  
    
    
    
    
    
    private int cal_max(String tab, String col) 
	{
		try 
		{
			stmt = conn.createStatement();
			String temp1 = "";
			ResultSet rs = stmt.executeQuery("SELECT max("+col+") FROM "+tab+"");
			while (rs.next()) 
			{
				temp1 = rs.getString(1);
			}
			int max1 = Integer.parseInt(temp1);
			stmt.close();
					
			return max1;
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
		return 0;
		
	}
    
    
    private void insert_into_type(String table, int id, String col2) 
    {
    	try 
		{
			stmt = conn.createStatement();
			
			stmt.executeQuery("INSERT INTO "+table+" VALUES("+id+",'"+col2+"')");
						
			stmt.close();
			
		} 
		
		catch (SQLException e) {
			System.out.println(e.toString());
		}
		
    }
    
    private void display_type() 
    {
    	try 
		{
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM F16_1_TYPE_OF_EVENTS");
			System.out.println("\n");

	while (rs.next()) {
		// Get the data from the row using the column index
		System.out.println("\n " + rs.getString(2));
	}
	
			stmt.close();
			
		} 
		
		catch (Exception e) {
			System.out.println(e.toString());
		}
		
    }
    
    
    
    
    
	private void display_table_cost_on_id(int id) {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM F16_1_OPERATIONS_COST where Cost_ID = "
							+ id);
			System.out
					.println("\n\nCost_ID  Branch_ID  Month  Year  Rent   Licence_Cost  Insurance_Cost  Maintenance_Cost  Advertisement_Cost  Miscellaneous_Cost");

			while (rs.next()) {
				// Get the data from the row using the column index
				System.out.println("\n " + rs.getString(1) + "\t "
						+ rs.getInt(2) + "\t " + rs.getString(3) + "\t "
						+ rs.getInt(4) + "\t" + rs.getFloat(5) + "\t"
						+ rs.getFloat(6) + "\t" + rs.getFloat(7) + "\t"
						+ rs.getFloat(8) + "\t" + rs.getFloat(9) + "\t"
						+ rs.getFloat(10));
			}
			stmt.close();

		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}

	}
	
	
	private void display_table_cost() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM F16_1_OPERATIONS_COST");
			System.out
					.println("\n\nCost_ID  Branch_ID  Month  Year  Rent   Licence_Cost  Insurance_Cost  Maintenance_Cost  Advertisement_Cost  Miscellaneous_Cost");

			while (rs.next()) {
				// Get the data from the row using the column index
				System.out.println("\n " + rs.getString(1) + "\t "
						+ rs.getInt(2) + "\t " + rs.getString(3) + "\t "
						+ rs.getInt(4) + "\t" + rs.getFloat(5) + "\t"
						+ rs.getFloat(6) + "\t" + rs.getFloat(7) + "\t"
						+ rs.getFloat(8) + "\t" + rs.getFloat(9) + "\t"
						+ rs.getFloat(10));
			}
			stmt.close();

		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}

	}
	
	
	
	public int does_item_exist(String table, String new_value, int col_index)
    {
        int flag=0;
        try 
        {
            // Create a result set containing all data from my_table
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+table+"");
            
            // Fetch each row from the result set
            while (rs.next()) 
            {
                // Get the data from the row using the column index
                
                if(rs.getString(col_index).equals(new_value))
                {
                       flag=1;
                       break;
                }
    
            }
            stmt.close();
        } 
        catch (SQLException e) 
        {
        	System.out.println(e.toString());
        }     
        return flag;
    } // end of does_employee_exist()
	
	
	
	
	
	
	private void delete_from_table_on_id(String table, String column1, int id) 
    {
    	try 
		{
			stmt = conn.createStatement();
			
			stmt.executeQuery("DELETE FROM "+table+" WHERE "+column1+"="+id);
			
			stmt.close();
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
		
    }
	
	private void update_table_str(String table, String column2, String new_value_str,
			String column1, int id) 
    {
    	try 
		{
			stmt = conn.createStatement();
			
			stmt.executeQuery("UPDATE "+table+" SET "+column2+" = '" +new_value_str+ "' WHERE "+column1+"="+id);
			stmt.close();
			
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
    
	}
    
	
	private void display_table_service_on_id(int id) 
	{
		 try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM F16_1_SERVICES where Service_ID = "+id);
			System.out.println("\n\nService_ID   Service_Name    Equipment_Charge    Service_Charge");
			
			while (rs.next()) 
            {
                // Get the data from the row using the column index
				 System.out.println("\n  "+rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getFloat(3)+"\t\t"+rs.getFloat(4));
				 
            }
			stmt.close();
			
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
		
	}
	
	private void update_table_int(String table, String column2,
			int new_value_int, String column1, int id) 
    {
    	try 
		{
			stmt = conn.createStatement();
			
			stmt.executeQuery("UPDATE "+table+" SET "+column2+" = " +new_value_int+ " WHERE "+column1+"="+id);
			
			stmt.close();
			
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
		
    }
	
	private void update_table_float(String table, String column2,
			double new_value_float, String column1, int id) 
    {
    	try 
		{
			stmt = conn.createStatement();
			
			stmt.executeQuery("UPDATE "+table+" SET "+column2+" = " +new_value_float+ " WHERE "+column1+"="+id);
			
			stmt.close();
			
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
		
    }
	
	
	
	
	private void display_table_services() 
	{
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM F16_1_SERVICES");
			System.out.println("\nDisplaying table SERVICES:");
			System.out.println("\n\nService_ID   Service_Name    Equipment_Charge    Service_Charge");
			
			while (rs.next()) 
            {
                // Get the data from the row using the column index
				 System.out.println("\n  "+rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getFloat(3)+"\t\t"+rs.getFloat(4));      
            }
			stmt.close();
			
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
		
	}// end of display_table
	
    
// Query functions
	
	 
	private void monthly_sales_report()
    {
        String query1 = "SELECT COUNT(*) AS NO_OF_EVENTS_PLANNED" +
                        " FROM F16_1_EVENTS E" +
                        " WHERE BRANCH_ID IN (SELECT BRANCH_ID FROM F16_1_BRANCHES B WHERE B.BRANCH_NAME=?)" +
                        " AND TO_CHAR(E.SCHEDULED_DATETIME, 'MON-YYYY') =?";

        String query2 = "SELECT SUM(REVENUE) AS TOTAL_REVENUE FROM (SELECT EVENT_ID,EVENT_NAME,REVENUE FROM (SELECT EVENT_ID,NAME AS EVENT_NAME,BRANCH_ID ,(B.AMT_CHARGED - A.SALARY_PAID) AS REVENUE" +
                        " FROM ( SELECT SEA.EVENT_ID AS EVENT_ID, SUM(E.SALARY_PER_HOUR * SEA.SERVICE_DURATION) AS SALARY_PAID" +
                        " FROM F16_1_EMPLOYEES E" +
                        " NATURAL JOIN F16_1_SERVICE_EVENT_ASS SEA" +
                        " GROUP BY SEA.EVENT_ID) A" +
                        " NATURAL JOIN" +
                        " (SELECT SEA.EVENT_ID AS EVENT_ID, SUM((S.SERVICE_CHARGE * SEA.SERVICE_DURATION) - S.EQUIPMENT_CHARGE) AS AMT_CHARGED" +
                        " FROM F16_1_SERVICES S" +
                        " NATURAL JOIN F16_1_SERVICE_EVENT_ASS SEA" +
                        " GROUP BY SEA.EVENT_ID) B" +
                        " NATURAL JOIN F16_1_EVENTS E WHERE TO_CHAR(E.SCHEDULED_DATETIME,'MON-YYYY')=?)" +
                        " NATURAL JOIN F16_1_BRANCHES WHERE BRANCH_NAME=?)";
        
        
        String query3 = "SELECT EVENT_ID,EVENT_NAME,REVENUE AS REVENUE_PER_EVENT FROM (SELECT EVENT_ID,NAME AS EVENT_NAME,BRANCH_ID ,(B.AMT_CHARGED - A.SALARY_PAID) AS REVENUE" +
                        " FROM ( SELECT SEA.EVENT_ID AS EVENT_ID, SUM(E.SALARY_PER_HOUR * SEA.SERVICE_DURATION) AS SALARY_PAID" +
                        " FROM F16_1_EMPLOYEES E NATURAL JOIN F16_1_SERVICE_EVENT_ASS SEA GROUP BY SEA.EVENT_ID) A" +
                        " NATURAL JOIN (SELECT SEA.EVENT_ID AS EVENT_ID, SUM((S.SERVICE_CHARGE * SEA.SERVICE_DURATION) - S.EQUIPMENT_CHARGE) AS AMT_CHARGED" +
                        " FROM F16_1_SERVICES S NATURAL JOIN F16_1_SERVICE_EVENT_ASS SEA GROUP BY SEA.EVENT_ID) B" +
                        " NATURAL JOIN F16_1_EVENTS E WHERE TO_CHAR(E.SCHEDULED_DATETIME,'MON-YYYY')=?) NATURAL JOIN F16_1_BRANCHES WHERE BRANCH_NAME =?";
        try {
                
                InputStreamReader i = new InputStreamReader(System.in);
                BufferedReader input = new BufferedReader(i);

                String monthYear, branchName;

                do{
                System.out.println("Enter Month and year in the format MON-YYYY");
                monthYear=input.readLine().toUpperCase();
    
            }while(!monthYear.matches("[a-zA-Z][a-zA-Z][a-zA-Z]-[0-9][0-9][0-9][0-9]"));
                
                do{
                System.out.println("Enter the branch name");
                branchName=input.readLine().toUpperCase();    
            }while(!branchName.matches("[a-zA-Z]+"));
                


                PreparedStatement ps1 = conn.prepareStatement(query1);
                ps1.setString(1, branchName);
                ps1.setString(2, monthYear);

                ResultSet rs1 = ps1.executeQuery();
                if (!rs1.isBeforeFirst())
                {
                    System.out.println("\n No Records found.");
                    return;
                }
                else
                {    
                    System.out.println("No_of_Events_Planned\n");

                    while(rs1.next())
                    {
                        if(rs1.getInt(1)==0)
                        {
                            return;
                        }
                         System.out.println(rs1.getInt(1));
                    }
                }
                 
                

                PreparedStatement ps2 = conn.prepareStatement(query2);
                ps2.setString(1, monthYear);
                ps2.setString(2, branchName);

                ResultSet rs2 = ps2.executeQuery();
                
                System.out.println("Total_Revenue\n");
                
                while(rs2.next())
                {
                    System.out.println(rs2.getString(1));
                } 



                PreparedStatement ps3 = conn.prepareStatement(query3);
                ps3.setString(1, monthYear);
                ps3.setString(2, branchName);

                ResultSet rs3 = ps3.executeQuery();
            
                System.out.println("Event_ID\t Event_Name\t Revenue_Per_Event\n");
                
                while(rs3.next())
                {
                    System.out.println(rs3.getInt(1) + "\t" + rs3.getString(2) + "\t" + rs3.getString(3));
                }
            }

        catch (SQLException e) 
        {
 
            System.out.println("erro in accessing the relation");
            e.printStackTrace();
            return;
 
        } 
        catch(IOException e)
        {
        System.out.println(e.toString());
        }  
    }




    



    private void annual_report_planned_events()
    {
        
        String query1 = "SELECT TE.TYPE_NAME AS TYPE_OF_EVENT, A.EVENT_COUNT AS EVENT_COUNT, B.TOTAL_EVENTS,((A.EVENT_COUNT/B.TOTAL_EVENTS) * 100 ) AS PERCENTAGE" +
                        " FROM ( SELECT E.TYPE_ID AS TYPE_ID, COUNT(E.TYPE_ID) AS EVENT_COUNT" +
                        " FROM F16_1_EVENTS E WHERE TO_CHAR(E.SCHEDULED_DATETIME,'YYYY')=? GROUP BY E.TYPE_ID ORDER BY EVENT_COUNT DESC) A" +
                        " NATURAL JOIN F16_1_TYPE_OF_EVENTS TE" +
                        " NATURAL JOIN (SELECT COUNT(*) AS TOTAL_EVENTS FROM F16_1_EVENTS EV WHERE TO_CHAR(EV.SCHEDULED_DATETIME,'YYYY')=? ) B";

        
        try {
                
                InputStreamReader i = new InputStreamReader(System.in);
                BufferedReader input = new BufferedReader(i);
                String year;
               int temp=0;
                PreparedStatement ps1 =null;
                ResultSet rs1 =null;
                do{
                	 System.out.println("Enter year in YYYY format to fetch the report");
                     year=input.readLine();
                	ps1= conn.prepareStatement(query1);
                    ps1.setString(1, year);
                    ps1.setString(2, year);
                    rs1= ps1.executeQuery();
                    	if(rs1.isBeforeFirst())
                    	{
                    		temp=1;
                    	}
                    	System.out.println("No records found or input invalid. Please re-enter correct year in YYYY format.\n");
                }while(temp!=1);

                    System.out.println("Type_of_Event\t Event_Count\t Total_No_Of_Events_in_Year\t Percentage\n");
                
                    while(rs1.next())
                    {
                        System.out.println(rs1.getString(1) + "\t" + rs1.getInt(2) + "\t" + rs1.getInt(3) + "\t" + rs1.getFloat(4));
                    } 

            }

        catch (SQLException e) 
        {
 
            System.out.println("erro in accessing the relation");
            e.printStackTrace();
            return;
 
        } 
        catch(IOException e)
        {
        System.out.println(e.toString());
        }  
    }






    private void small_large_scale()
    {
        
        String query1 = "SELECT NO_OF_LARGE_EVENTS FROM (SELECT COUNT(*) AS NO_OF_LARGE_EVENTS" +
                        " FROM F16_1_EVENTS E NATURAL JOIN F16_1_BRANCHES B WHERE E.NO_OF_GUESTS>100 AND B.BRANCH_NAME=?)";

        String query2 = "SELECT NO_OF_SMALL_EVENTS FROM (SELECT COUNT(*) AS NO_OF_SMALL_EVENTS" +
                        " FROM F16_1_EVENTS E NATURAL JOIN F16_1_BRANCHES B WHERE E.NO_OF_GUESTS<100 AND B.BRANCH_NAME=?)";
        
        
    
        try {
                
                InputStreamReader i = new InputStreamReader(System.in);
                BufferedReader input = new BufferedReader(i);
 
          
            
                String branchName;
                
                
                do{
                System.out.println("Enter the branch name");
                branchName=input.readLine().toUpperCase();
                }while(!branchName.matches("[a-zA-Z]+"));

                PreparedStatement ps1 = conn.prepareStatement(query1);
                ps1.setString(1, branchName);
                

                ResultSet rs1 = ps1.executeQuery();
                if (!rs1.isBeforeFirst())
                {
                    System.out.println("No Records Found.");
                    return;
                }
                else
                {
                    System.out.println("No_of_Large_Events_Planned\n");
                
                    while(rs1.next())
                    {
                    	if (rs1.getInt(1)==0)
                    	{
                        System.out.println("No Records Found.");
                        return;
                    	}
                        System.out.println(rs1.getInt(1));
                    }   
                }
                 
                
                PreparedStatement ps2 = conn.prepareStatement(query2);
                ps2.setString(1, branchName);

                ResultSet rs2 = ps2.executeQuery();
            
                System.out.println("No_of_Small_Events_Planned\n");
                
                while(rs2.next())
                {
                    System.out.println(rs2.getInt(1));
                } 

            }

        catch (SQLException e) 
        {
 
            System.out.println("erro in accessing the relation");
            e.printStackTrace();
            return;
 
        } 
        catch(IOException e)
        {
        System.out.println(e.toString());
        }  
    }



    private void most_revenue_generate()
    {
                
        String query1 = "SELECT TYPE_NAME, REVENUE FROM (SELECT SUM(TOTAL) AS REVENUE,TYPE_ID FROM (SELECT B.AMT_CHARGED-A.SALARY_PAID AS TOTAL,TYPE_ID,TYPE_NAME" +
                        " FROM ( SELECT SEA.EVENT_ID AS F16_1_EVENT_ID, SUM(E.SALARY_PER_HOUR * SEA.SERVICE_DURATION) AS SALARY_PAID FROM F16_1_EMPLOYEES E" +
                        " NATURAL JOIN F16_1_SERVICE_EVENT_ASS SEA GROUP BY SEA.EVENT_ID) A" +
                        " NATURAL JOIN (SELECT SEA.EVENT_ID AS EVENT_ID, SUM((S.SERVICE_CHARGE * SEA.SERVICE_DURATION)-S.EQUIPMENT_CHARGE)  AS AMT_CHARGED" +
                        " FROM F16_1_SERVICES S NATURAL JOIN F16_1_SERVICE_EVENT_ASS SEA GROUP BY SEA.EVENT_ID) B" +
                        " NATURAL JOIN F16_1_EVENTS E NATURAL JOIN F16_1_TYPE_OF_EVENTS TE) GROUP BY TYPE_ID) NATURAL JOIN F16_1_TYPE_OF_EVENTS ORDER BY REVENUE DESC";

        
        try {
               
                PreparedStatement ps1 = conn.prepareStatement(query1);
               
                ResultSet rs1 = ps1.executeQuery();
                
                
                System.out.println("Type_of_Event\t Revenue\n");
                if (!rs1.isBeforeFirst())
                {
                    System.out.println("No Records Found.");
                    return;
                }
                
                while(rs1.next())
                {
                    System.out.println(rs1.getString(1) + "\t" + rs1.getFloat(2));
                } 
                
            }

        catch (SQLException e) 
        {
 
            System.out.println("error in accessing the relation");
            e.printStackTrace();
            return;
 
        } 
  
    }




    private void most_least_popular_loc()
    {
        
        String query1 = "SELECT * FROM ( SELECT E.LOC_NAME AS MOSTPOPULAR, COUNT(E.LOC_NAME) AS COUNT FROM F16_1_EVENTS E NATURAL JOIN F16_1_BRANCHES B WHERE B.CITY=?" +
                        " GROUP BY E.LOC_NAME ORDER BY COUNT desc) WHERE ROWNUM=1";

        String query2 = "SELECT * FROM ( SELECT E.LOC_NAME AS MOSTPOPULAR, COUNT(E.LOC_NAME) AS COUNT FROM F16_1_EVENTS E NATURAL JOIN F16_1_BRANCHES B WHERE B.CITY=?" +
                        " GROUP BY E.LOC_NAME ORDER BY COUNT) WHERE ROWNUM=1";
        
        
    
        try {
                
                InputStreamReader i = new InputStreamReader(System.in);
                BufferedReader input = new BufferedReader(i);
                String branchCity;
                
                do{
                System.out.println("Enter the city name");
                branchCity=input.readLine().toUpperCase();
                }while(!branchCity.matches("[a-zA-Z]+"));

               PreparedStatement ps1 = conn.prepareStatement(query1);
                ps1.setString(1, branchCity);
                

                ResultSet rs1 = ps1.executeQuery();
            
                if (!rs1.isBeforeFirst())
                {
                    System.out.println("City Name Incorrect. No Records Found.\n");
                    return;
                }
                else
                {
                    System.out.println("Most_Popular_Location\t Count\n");
                
                    while(rs1.next())
                    {
                        System.out.println(rs1.getString(1) + "\t" + rs1.getInt(2) + "\n");
                    }    
                }
                 
                

                PreparedStatement ps2 = conn.prepareStatement(query2);
                ps2.setString(1, branchCity);

                ResultSet rs2 = ps2.executeQuery();
            
                System.out.println("Least_Popular_Location\t Count\n");
                
                while(rs2.next())
                {
                    System.out.println(rs2.getString(1) + "\t" + rs2.getInt(2) + "\n");
                } 

            }

        catch (SQLException e) 
        {
 
            System.out.println("error in accessing the relation");
            e.printStackTrace();
            return;
 
        } 
        catch(IOException e)
        {
        System.out.println(e.toString());
        }  
    }



    private void popular_month_for_event()
    {
        
        String query1 = "SELECT * FROM ( SELECT TYPE_OF_EVENT, MONTH_OF_EVENT AS POPULAR_MONTH,COUNT" +
                        " FROM (SELECT TYPE_OF_EVENT,MONTH_OF_EVENT,COUNT(*) AS COUNT" +
                        " FROM (SELECT TE.TYPE_NAME AS TYPE_OF_EVENT,TO_CHAR(E.SCHEDULED_DATETIME,'MON') AS MONTH_OF_EVENT" +
                        " FROM F16_1_EVENTS E NATURAL JOIN F16_1_TYPE_OF_EVENTS TE) GROUP BY TYPE_OF_EVENT,MONTH_OF_EVENT) A" +
                        " NATURAL JOIN F16_1_BRANCHES B WHERE A.TYPE_OF_EVENT=? AND B.BRANCH_NAME=? ORDER BY COUNT DESC) WHERE ROWNUM=1";

        
        try {
                
                InputStreamReader i = new InputStreamReader(System.in);
                BufferedReader input = new BufferedReader(i);
                String eventType, branchName;
                do{
                System.out.println("Enter the event type");
                eventType=input.readLine().toUpperCase();
                }while(!eventType.matches("[a-zA-Z]+"));
                
                
                do{
                System.out.println("Enter the branch name");
                branchName=input.readLine().toUpperCase();
                }while(!branchName.matches("[a-zA-Z]+"));
                
                
                
               PreparedStatement ps1 = conn.prepareStatement(query1);
                ps1.setString(1, eventType);
                ps1.setString(2, branchName);

                ResultSet rs1 = ps1.executeQuery();
                
                if (!rs1.isBeforeFirst())
                {
                    System.out.println("The event type or branch name is incorrect. No Records found.\n");
                    return;
                }

                else
                {
                    System.out.println("Type_of_Event\t Popular_Month \t Count\n");
                
                    while(rs1.next())
                    {
                        System.out.println(rs1.getString(1) + "\t" + rs1.getString(2) + "\t" +  rs1.getInt(3) + "\n");
                    }       
                }
                 
                
            }

        catch (SQLException e) 
        {
 
            System.out.println("Error in accessing the relation");
            e.printStackTrace();
            return;
 
        } 
        catch(IOException e)
        {
        System.out.println(e.toString());
        }  
    }



    private void popular_week_in_branch()
    {
        
        String query1 = "SELECT * FROM (SELECT BRANCH_NAME, DAY_OF_EVENT AS POPULAR_DAY FROM (SELECT BRANCH_NAME,DAY_OF_EVENT,COUNT(*) AS COUNT" +
                        " FROM(SELECT B.BRANCH_NAME AS BRANCH_NAME,TO_DATE(E.SCHEDULED_DATETIME,'DD-MON-YYYY')AS DATE_OF_EVENT,TO_CHAR(E.SCHEDULED_DATETIME,'DY') AS DAY_OF_EVENT" +
                        " FROM F16_1_EVENTS E NATURAL JOIN F16_1_BRANCHES B) GROUP BY BRANCH_NAME,DAY_OF_EVENT)" +
                        " WHERE BRANCH_NAME=? ORDER BY COUNT DESC) ALPHA WHERE ROWNUM=1";

        
        try {
                
                InputStreamReader i = new InputStreamReader(System.in);
                BufferedReader input = new BufferedReader(i);
                String eventType, branchName;
                                
                do{
                System.out.println("Enter the branch name");
                branchName=input.readLine().toUpperCase();
                }while(!branchName.matches("[a-zA-Z]+"));
                
                PreparedStatement ps1 = conn.prepareStatement(query1);
                ps1.setString(1, branchName);

                ResultSet rs1 = ps1.executeQuery();
                if (!rs1.isBeforeFirst())
                {
                    System.out.println("Branch name entered is incorrect. No Records Found\n ");
                    return;
                }

                else
                {
                    System.out.println("Branch_Name\t Popular_Day\n");
                
                    while(rs1.next())
                    {
                        System.out.println(rs1.getString(1) + "\t" + rs1.getString(2) + "\n");
                    }    
                }
                 
                
            }

        catch (SQLException e) 
        {
 
            System.out.println("Error in accessing the relation");
            e.printStackTrace();
            return;
 
        } 
        catch(IOException e)
        {
        System.out.println(e.toString());
        }  
    }


    private void most_least_popular_service()
    {
                
        String query1 = "SELECT SERVICE_NAME AS MOST_IN_DEMAND ,COUNT FROM ( SELECT * FROM ( SELECT SEA.SERVICE_ID, COUNT(SEA.SERVICE_ID) AS COUNT" +
                        " FROM F16_1_SERVICE_EVENT_ASS SEA GROUP BY SEA.SERVICE_ID ORDER BY COUNT DESC) WHERE ROWNUM=1) NATURAL JOIN F16_1_SERVICES";

        String query2 = "SELECT SERVICE_NAME AS LEAST_IN_DEMAND ,COUNT FROM ( SELECT * FROM ( SELECT SEA.SERVICE_ID, COUNT(SEA.SERVICE_ID) AS COUNT" +
                        " FROM F16_1_SERVICE_EVENT_ASS SEA GROUP BY SEA.SERVICE_ID ORDER BY COUNT ) WHERE ROWNUM=1) NATURAL JOIN F16_1_SERVICES";
        
        try {
               
                PreparedStatement ps1 = conn.prepareStatement(query1);
               
                ResultSet rs1 = ps1.executeQuery();
                
            
                 System.out.println("Most_in_demand_service \t Count\n");
                 if (!rs1.isBeforeFirst())
                 {
                     System.out.println("No Records Found\n ");
                     return;
                 }
                
                while(rs1.next())
                {
                    System.out.println(rs1.getString(1) + "\t" + rs1.getInt(2) + "\n");
                } 


                PreparedStatement ps2 = conn.prepareStatement(query2);
               
                ResultSet rs2 = ps2.executeQuery();
            
                 System.out.println("Most_in_demand_service\n");
                
                while(rs2.next())
                {
                    System.out.println(rs2.getString(1) + "\t" + rs2.getInt(2) + "\n");
                } 

                
            }

        catch (SQLException e) 
        {
 
            System.out.println("error in accessing the relation");
            e.printStackTrace();
            return;
 
        } 
  
    }



    private void expense_statement()
    {
                
        String query1 = "SELECT SUM(TOTAL_ANNUAL_EXPENSE) AS TOTAL_ANNUAL_EXPENSE,YEAR FROM (SELECT (RENT+LICENCE_COST+INSURANCE_COST+MAINTENANCE_COST+ADVERTISEMENT_COST+MISCELLANEOUS_COST) AS TOTAL_ANNUAL_EXPENSE,YEAR" +
                        " FROM F16_1_OPERATIONS_COST WHERE BRANCH_ID IN (SELECT BRANCH_ID FROM F16_1_BRANCHES WHERE BRANCH_NAME=?) AND YEAR=?) GROUP BY YEAR";

        String query2 = "SELECT MONTH,RENT,LICENCE_COST,INSURANCE_COST,MAINTENANCE_COST,ADVERTISEMENT_COST,MISCELLANEOUS_COST, (RENT+LICENCE_COST+INSURANCE_COST+MAINTENANCE_COST+ADVERTISEMENT_COST+MISCELLANEOUS_COST) AS TOTAL_COST" +
                        " FROM F16_1_OPERATIONS_COST WHERE BRANCH_ID IN (SELECT BRANCH_ID FROM F16_1_BRANCHES WHERE BRANCH_NAME=?) AND YEAR=?";
        
        try {
               
                InputStreamReader i = new InputStreamReader(System.in);
                BufferedReader input = new BufferedReader(i);
                String branchName, year;
                                
                do{
                System.out.println("Enter the branch name");
                branchName=input.readLine().toUpperCase();
                }while(!branchName.matches("[a-zA-Z]+"));
                
                do{
                System.out.println("Enter the year");
                year=input.readLine();
                }while(!year.matches("[0-9][0-9][0-9][0-9]"));
                

                PreparedStatement ps1 = conn.prepareStatement(query1);
                ps1.setString(1, branchName);
                ps1.setString(2, year);


                ResultSet rs1 = ps1.executeQuery();

                if (!rs1.isBeforeFirst())
                {
                    System.out.println("The branchName or Year is invalid. No Records Found.");
                    return;
                }
                else
                {
                    System.out.println("Total_Annual_Expense \t Year\n");
                
                    while(rs1.next())
                    {
                    System.out.println(rs1.getString(1) + "\t" + rs1.getString(2) + "\n");
                    } 
                }

                PreparedStatement ps2 = conn.prepareStatement(query2);
                ps2.setString(1, branchName);
                ps2.setString(2, year);

                
                
                ResultSet rs2 = ps2.executeQuery();
                
                System.out.println("MONTH\t RENT\t LICENCE_COST\t INSURANCE_COST\t MAINTENANCE_COST\t ADVERTISEMENT_COST\t MISCELLANEOUS_COST\t TOTAL_COST\n");
                
                while(rs2.next())
                {
                    System.out.println(rs2.getString(1) + "\t" + rs2.getString(2) + "\t" + rs2.getString(3) + "\t" + rs2.getString(4) + "\t" + rs2.getString(5) + "\t" + rs2.getString(6) + "\t" + rs2.getString(7) + "\t" + rs2.getString(8) + "\n");
                }
                
                
            }

        catch (SQLException e) 
        {
 
            System.out.println("error in accessing the relation");
            e.printStackTrace();
            return;
 
        }

        catch(IOException e)
        {
        System.out.println(e.toString());
        }  
  
    }


    private void monitor_upcoming_events()
    {
                
        String query1 = "SELECT C.NAME AS CLIENT_NAME,E.NAME AS EVENT_NAME, E.LOC_NAME AS LOCATION, E.LOC_CITY AS CITY, E.SCHEDULED_DATETIME AS EVENT_DATE" +
                        " FROM F16_1_EVENTS E , F16_1_CLIENTS C" +
                        " WHERE E.CLIENT_ID=C.CLIENT_ID AND E.SCHEDULED_DATETIME > SYSDATE";

        
        
        try {
               
                PreparedStatement ps1 = conn.prepareStatement(query1);
               
                ResultSet rs1 = ps1.executeQuery();
                if (!rs1.isBeforeFirst())
                {
                    System.out.println("No Records Found.");
                    return;
                }
                System.out.println("Client_Name \t Event_Name \t Location \t City \t Event_Date \n");
                
                while(rs1.next())
                {
                    System.out.println(rs1.getString(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t" + rs1.getString(4) + "\t" + rs1.getDate(5) + "\n");
                } 
                
            }

        catch (SQLException e) 
        {
 
            System.out.println("error in accessing the relation");
            e.printStackTrace();
            return;
 
        } 
  
    }



    private void check_outstanding_dues()
    {
                
        String query1 = "SELECT * FROM (SELECT EVENT_ID,C.NAME AS CLIENT_NAME, E.NAME AS EVENT_NAME,SCHEDULED_DATETIME,SCHEDULED_DATETIME-20 AS DUE_DATE,(A.AMT_CHARGED - E.AMOUNT_PAID) AS OUTSTANDING_DUE" +
                        " FROM (SELECT SEA.EVENT_ID AS EVENT_ID,SUM(S.SERVICE_CHARGE * SEA.SERVICE_DURATION ) AS AMT_CHARGED" +
                        " FROM F16_1_SERVICES S NATURAL JOIN F16_1_SERVICE_EVENT_ASS SEA GROUP BY SEA.EVENT_ID) A" +
                        " NATURAL JOIN F16_1_EVENTS E JOIN F16_1_CLIENTS C USING (CLIENT_ID,CLIENT_ID))" +
                        " WHERE DUE_DATE>=SYSDATE ORDER BY DUE_DATE";

        
        
        try {
               
                PreparedStatement ps1 = conn.prepareStatement(query1);
               
                ResultSet rs1 = ps1.executeQuery();
                if (!rs1.isBeforeFirst())
                {
                    System.out.println("No Records Found.");
                    return;
                }
            
                System.out.println("Event_ID \t Client_Name \t Event_Name \t Event_Scheduled_Date \t Amount_Due_Date \t Outstanding_Due \n");
                
                while(rs1.next())
                {
                    System.out.println(rs1.getInt(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t" + rs1.getDate(4) + "\t" + rs1.getDate(5) + "\t" + rs1.getString(6) + "\n");
                } 
                
            }

        catch (SQLException e) 
        {
 
            System.out.println("error in accessing the relation");
            e.printStackTrace();
            return;
 
        } 
  
    }


    private void check_employee_rating()
    {
                
        String query1 = "SELECT EMPLOYEE_ID,EMPLOYEE_NAME,BRANCH_NAME,AVG_RATING FROM" +
                        " (SELECT E.NAME AS EMPLOYEE_NAME,EMPLOYEE_ID,BEA.BRANCH_ID ,A.AVERAGERATING AS AVG_RATING" +
                        " FROM( SELECT SEA.EMPLOYEE_ID AS EMPLOYEE_ID, AVG(SEA.SERVICE_RATING) AS AVERAGERATING" +
                        " FROM F16_1_SERVICE_EVENT_ASS SEA GROUP BY SEA.EMPLOYEE_ID ORDER BY AVERAGERATING DESC) A" +
                        " NATURAL JOIN F16_1_EMPLOYEES E NATURAL JOIN F16_1_BRANCH_EMPLOYEE_ASS BEA) JOIN F16_1_BRANCHES USING(BRANCH_ID,BRANCH_ID)";

        
        
        try {
               
                PreparedStatement ps1 = conn.prepareStatement(query1);
               
                ResultSet rs1 = ps1.executeQuery();
                if (!rs1.isBeforeFirst())
                {
                    System.out.println("No Records Found.");
                    return;
                }
            
                System.out.println("Employee_ID \t Employee_Name \t Branch_Name \t Average_Rating \n");
                
                while(rs1.next())
                {
                    System.out.println(rs1.getInt(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t" + rs1.getFloat(4) + "\n");
                } 
                
            }

        catch (SQLException e) 
        {
 
            System.out.println("error in accessing the relation");
            e.printStackTrace();
            return;
 
        } 
  
    }
    
   
	
} // end of P5 class

