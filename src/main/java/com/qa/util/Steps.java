package com.qa.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.google.common.base.Verify;

import org.openqa.selenium.interactions.Actions;
import com.qa.util.ReadDataFile;

public class Steps {
	public String strAbsolutepath = new File("").getAbsolutePath();

	//Screenshot screen = new Screenshot();

	ReadDataFile readData = new ReadDataFile();
	int rownumber= 1;
	public String strStartTime = null;
	private String am_pm;
	private boolean running = false;
	public long startTime;
	long stopTime;
	private int hour;
	private int min;
	private int sec;

	public String strExestartTime = null;
	public long exestartTime;

	long exestopTime;
	
	

	public void OpenUrl(WebDriver driver, String strDataFileName , String strElement, String Methodname ) throws Exception
	{
		try
		{
			Thread.sleep(2000);

			String	 strData = readData.readDataFile(strDataFileName, rownumber, strElement , Methodname);

			driver.get(strData);

		}

		catch (Exception e)
		{
			System.out.println("URL hasn't navigated");
			
			logger("Steps","openUrl", e);

		}
	}


	public void EnterText(By locator, WebDriver driver, String strDataFileName, String strElement, String Methodname)
	{
		try
		{
			int rowNumber = 1;

			String	 strData = readData.readDataFile(strDataFileName, rowNumber, strElement , Methodname);

			waitForElement(locator, driver);

			driver.findElement(locator).sendKeys(strData);
		}

		catch (Exception e)
		{
			System.out.println("Not Able to Enter Text");
			
			//logger("Steps","EnterText", "Not Able to Enter Text : " + e);
			logger("Steps","EnterText",  e);


		}
	}

	public void EnterText(By locator, WebDriver driver, String strElement, String Methodname)
	{
		try
		{
			int rowNumber = 1;

			//String strData = readData.readDataFile(strDataFileName, rowNumber, strElement , Methodname);

			waitForElement(locator, driver);

			driver.findElement(locator).sendKeys(strElement);
		}

		catch (Exception e)
		{
			System.out.println("Not Able to Enter Text");
			
			logger("Steps","EnterText", e);

		}
	}

	public void EnterJSText(By locator, WebDriver driver, String strDataFileName, String strElement, String Methodname)
	{
		try
		{
			int rowNumber = 1;

			String strData = readData.readDataFile(strDataFileName, rowNumber, strElement , Methodname);

			waitForElement(locator, driver);

			WebElement locat = driver.findElement(locator);

			((JavascriptExecutor)driver).executeScript("arguments[0].value = '" + strData + "'", locat);
			
		//	String str = (String) ((JavascriptExecutor)driver).executeScript("return document.title");


		}

		catch (Exception e)
		{
			System.out.println("Not Able to Enter Text");
			
			logger("Steps","EnterJSText", e);

		}
	}



	public void clickButton(By locator ,WebDriver driver , String screenName) throws Exception
	{

		try
		{
			waitForElement(locator, driver);

			driver.findElement(locator).click();
		}
		catch (Exception e)
		{
			//screen.getscreenshot(driver,screenName);

			System.out.println("Not Able to Click");
			
			logger("Steps","clickButton",  e);

		}
	}

	public void clickJSButton(By locator ,WebDriver driver , String screenName) throws Exception
	{
		try{
			waitForElement(locator, driver);

			WebElement element = driver.findElement(locator);

			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

		} catch (Exception e)
		{

		//	screen.getscreenshot(driver,screenName);

			System.out.println("Unable to click on element");
			
			logger("Steps","clickJSButton", e);

		}	
	}

	public void Alert(WebDriver driver)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions.alertIsPresent());
			
			driver.switchTo().alert().accept();
		}
		catch(Exception e)
		{
			System.out.println("Alert is not present");
			
			logger("Steps","Alert", e);

		}
	}

	public void Clear(By locator ,WebDriver driver , String screenName) throws Exception
	{

		try
		{
			waitForElement(locator, driver);
			
			driver.findElement(locator).clear();

		}
		catch (Exception e)
		{

			System.out.println("Not Able to Clear");
			
			logger("Steps","Clear", e);

		}
	}

	public void selectDropdown(By locator,  WebDriver driver , String strDataFileName ,String strElement ,String Methodname)
	{
		try
		{
			int rowNumber = 1;

			String	 strData = readData.readDataFile(strDataFileName, rowNumber, strElement , Methodname);
			
			waitForElement(locator, driver);

			Select dropdownValue = new Select(driver.findElement(locator));
			
			dropdownValue.selectByVisibleText(strData);	

		}

		catch (Exception e)
		{
			System.out.println("Dropdown hasn't selected");
			
			logger("Steps","selectDropdown", e);

		}

	}

	public void Facility(By locator,  WebDriver driver , String strDataFileName ,String strElement ,String Methodname)
	{
		try
		{
			int rowNumber = 1;

			String	 strData = readData.readDataFile(strDataFileName, rowNumber, strElement , Methodname);
			
			waitForElement(locator, driver);

			Select dropdownValue = new Select(driver.findElement(locator));
			
			dropdownValue.selectByVisibleText(strData);	
		}

		catch (Exception e)
		{
			System.out.println("Facility hasn't selected");
			
			logger("Steps","Facility", e);

		}

	}

	public void Location(By locator,  WebDriver driver , String strDataFileName ,String strElement ,String Methodname)
	{
		try
		{
			int rowNumber = 1;

			String	 strData = readData.readDataFile(strDataFileName, rowNumber, strElement , Methodname);
			
			waitForElement(locator, driver);

			Select dropdownValue = new Select(driver.findElement(locator));
			
			dropdownValue.selectByVisibleText(strData);	
		}

		catch (Exception e)
		{
			System.out.println("Location hasn't selected");
			
			logger("Steps","Location", e);

		}

	}

	public void selectDropdownIndex(By locator,  WebDriver driver , String strDataFileName ,String strElement ,String Methodname)
	{
		try
		{
			int rowNumber = 1;

			String	 strData = readData.readDataFile(strDataFileName, rowNumber, strElement , Methodname);

			Select dropdownValue = new Select(driver.findElement(locator));

			dropdownValue.selectByIndex(rowNumber);


		}

		catch (Exception e)
		{
			System.out.println("Dropdown hasn't selected");
			
			logger("Steps","selectDropdownIndex",  e);

		}

	}

	/*public void Searchwindow(By locator,  WebDriver driver , String strDataFileName ,String strElement ,String Methodname)
	{

	try
	{
		int rowNumber = 1;

		String	 strData = readData.readDataFile(strDataFileName, rowNumber, strElement , Methodname);

		driver.findElement(locator).sendKeys(strData);


	}
	catch(Exception e)
	{

	}
	}*/

	public void Verifytext(By locator,  WebDriver driver , String strDataFileName ,String strElement ,String Methodname)
	{
		try
		{
			int rowNumber = 1;

			String ExpectedText = readData.readDataFile(strDataFileName, rowNumber, strElement , Methodname);

			String Actualtext = driver.findElement(locator).getText();

			if(Actualtext.contains(ExpectedText))
			{
				System.out.println("Text is present");
				
				logger(strDataFileName,"Verifytext", "Text is present");

			}
			else 
			{
				System.out.println("Text is not present");
				
				logger("Steps","Verifytext", "Text is Not present");

			}

		}

		catch (Exception e)
		{
			System.out.println("Text hasn't verified");
			
			logger("Steps","Verifytext",  e);

		}

	}
	public void Verifytext(By locator,  WebDriver driver , String strtext , String Methodname )
	{

		int rowNumber = 1;
		

		String ExpectedText = strtext;

		String Actualtext = driver.findElement(locator).getText();

		waitForElement(locator, driver);

		if(Actualtext.equalsIgnoreCase(ExpectedText))
		{
			System.out.println("Text is present");
			System.out.println(Actualtext);
			
		}
		else 
		{
			System.out.println("Text is not present");
			System.out.println(Actualtext);
			

		}



	}
	public int Verifytext(By locator,  WebDriver driver , String strtext , int status )
	{

		int rowNumber = 1;
		

		String ExpectedText = strtext;

		String Actualtext = driver.findElement(locator).getText();

		waitForElement(locator, driver);

		if(Actualtext.equalsIgnoreCase(ExpectedText))
		{
			System.out.println("Text is present");
			System.out.println(Actualtext);
			status = 1;
			
			Assert.assertEquals(Actualtext, ExpectedText);
		}
		else 
		{
			System.out.println("Text is not present");
			System.out.println(Actualtext);
			 status = 0;
				//assertEquals(Actualtext, ExpectedText);
				Assert.assertEquals(Actualtext, ExpectedText);


		}
		return status;



	}

	public void waitForElement(By locator,  WebDriver driver)
	{
		try
		{
			for (int i=0; i<120; i++)
			{
				driver.findElement(locator).isDisplayed();
				Thread.sleep(5000);
				break;
			}                      
		}

		catch (Exception e)
		{
			System.out.println("Not Able to Find Element");
			
			logger("Steps","waitForElement", e);

		}
	}

	public void waitElementDisplay(By locator,  WebDriver driver)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 180);

			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		}

		catch (Exception e)
		{
			System.out.println("Not Able to Dispaly Element");
			
			logger("Steps","waitElementDisplay", e);

		}
	}

	public void Actions(By locator,  WebDriver driver , String strDataFileName ,String Methodname)
	{
		try
		{

			Actions act = new Actions(driver);
			act.click(driver.findElement(locator)).perform();
			//act.perform();

		}

		catch (Exception e)
		{
			System.out.println("Not Able to Perform Action");
			
			logger("Steps","Actions",  e);

		}

	}
	public void Window(WebDriver driver)
	{
		try
		{
			((JavascriptExecutor)driver).executeScript("window.showModalDialogger =window.open;");

			System.out.println("Modal pop window converted to Normal window");
		}
		catch(Exception e)
		{
			System.out.println("Modal pop window not converted to Normal window");
			
			logger("Steps","Window",  e);

		}
	}

	public void ChildWindow(WebDriver driver)
	{
		try
		{
			String subWindowHandler = null;

			Set<String> handles = driver.getWindowHandles();

			Iterator<String> iterator = handles.iterator();

			while (iterator.hasNext())
			{
				subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler);
		}
		catch(Exception e)
		{
			System.out.println("Winow not handled");
			
			logger("Steps","Window", e);

		}
	}


	public void Date(By locator,  WebDriver driver , String strDataFileName ,String strElement,String Methodname,String Format)
	{
		String	 strData = readData.readDataFile(strDataFileName, rownumber, strElement , Methodname);
		try{
			WebElement elementList1 = driver.findElement(locator);
			int status=0;
			String date = strData;
			String ele;
			System.out.println(date);
			String[] temp = new String[3];
			String[] temp1= new String[2];

			temp = date.split("/");
			String d, m, y;
			String cd,cm,cy;
			String LowYear,UpYear;
			int ILowyear,IUpYear,Iy;
			String Format1=Format+"title']";
			String sliderXpath1= Format+"prevArrow']";
			String Years1=Format+"years']/table/tbody/tr";
			String Month1=Format+"months']/table/tbody/tr";
			String Days1=Format+"days']/table/tbody/tr";
			d=temp[0];
			m=temp[1];
			y=temp[2];
			System.out.println(d);
			System.out.println(m);
			System.out.println(y);
			String cyear,cmonth;
			WebElement cal;
			List<WebElement> rows;
			List<WebElement> cells;
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//ele=elementList1.getText();
			//System.out.println(ele);
			elementList1.click();
			driver.findElement(By.xpath(Format1)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Format1)).click();
			Thread.sleep(2000);
			String Years= driver.findElement(By.xpath(Format1)).getText();
			System.out.println(Years);
			String[] temp2 = new String[2];
			temp2 = Years.split("-");
			LowYear=temp2[0];
			ILowyear=Integer.parseInt(LowYear);
			System.out.println(ILowyear);
			UpYear = temp2[1];
			IUpYear = Integer.parseInt(UpYear);
			System.out.println(IUpYear);
			Iy=Integer.parseInt(y);
			Boolean Ystatus=true;
			while(Ystatus)
			{
				if(ILowyear>=Iy)
				{
					driver.findElement(By.xpath(sliderXpath1)).click();
					Thread.sleep(2000);
					Years= driver.findElement(By.xpath(Format1)).getText();
					temp2 = Years.split("-");
					LowYear=temp2[0];
					ILowyear=Integer.parseInt(LowYear);
					System.out.println(ILowyear);
					UpYear = temp2[1];
					IUpYear = Integer.parseInt(UpYear);
					System.out.println(IUpYear);
				}
				else 
				{
					break;
				}
			}
			List<WebElement> YearsList;
			List<WebElement> MonthsList;
			List<WebElement> DaysList;
			YearsList=driver.findElements(By.xpath(Years1));
			status=0;
			System.out.println(YearsList.size());
			List<WebElement> IndYear;
			for (int l = 0; l < YearsList.size(); l++) 
			{
				if(status==0)
				{
					IndYear = YearsList.get(l).findElements(By.tagName("td"));
					System.out.println(IndYear.size());
					for (int k = 0; k < IndYear.size(); k++) 
					{
						if (IndYear.get(k).getText().equals(y)) 
						{	
							System.out.println(IndYear.get(k).getText());
							IndYear.get(k).click();
							Thread.sleep(2000);
							status=1;
							k=100;
						}
					}
				}
				else
				{
					break;
				}
			}

			MonthsList=driver.findElements(By.xpath(Month1));
			status=0;
			List<WebElement> IndMonth;
			for (int l = 0; l < MonthsList.size(); l++) 
			{
				if(status==0)
				{
					IndMonth = MonthsList.get(l).findElements(By.tagName("td"));
					System.out.println(IndMonth.size());
					for (int k = 0; k < IndMonth.size(); k++) 
					{
						if (IndMonth.get(k).getText().equals(m)) 
						{
							System.out.println(IndMonth.get(k).getText());
							IndMonth.get(k).click();
							Thread.sleep(2000);
							status=1;
							k=100;
						}
					}
				}
				else
				{
					break;
				}
			}
			DaysList=driver.findElements(By.xpath(Days1));
			status=0;
			System.out.println(DaysList.size());
			List<WebElement> IndDate;
			for (int l = 0; l < YearsList.size(); l++) 
			{
				if(status==0)
				{
					IndDate = DaysList.get(l).findElements(By.tagName("td"));
					System.out.println(IndDate.size());
					for (int k = 0; k < IndDate.size(); k++) 
					{
						if (IndDate.get(k).getText().equals(d)) 
						{
							System.out.println(IndDate.get(k).getText());
							IndDate.get(k).click();
							Thread.sleep(2000);
							status=1;
							k=100;
						}
					}
				}
				else
				{
					break;
				}
			}
		}
		catch(Exception e){
			
			System.out.println("Unable to select Date");
			
			logger("Steps","DATES", e);

		}
	}

	public void MoveElement(By locator ,WebDriver driver , String screenName)
	{

		try
		{
			Actions mov = new Actions(driver);
			
			waitForElement(locator, driver);

			mov.moveToElement(driver.findElement(locator));

			mov.build().perform();

		}
		catch (Exception e)
		{
			System.out.println("Not Able to Move");
			
			logger("Steps","MoveElement",  e);

		}
	}

	public String start()
	{
		Calendar calendar = new GregorianCalendar();
		strStartTime = null;
		int hour, min, sec;
		Long actualStartTime = System.currentTimeMillis();
		hour = calendar.get(Calendar.HOUR);
		min = calendar.get(Calendar.MINUTE);
		sec = calendar.get(Calendar.SECOND);
		if (calendar.get(Calendar.AM_PM) == 0) {
			am_pm = "AM";
		} else {
			am_pm = "PM";
		}
		running = true;
		startTime = actualStartTime;
		strStartTime = "" + hour + ":" + min + ":" + sec + " " + am_pm;
		System.out.println(strStartTime);
		return strStartTime;
	}

	public String Executionstart() 
	{
		Calendar calendar = new GregorianCalendar();
		strExestartTime = null;
		int hour, min, sec;
		Long exeactualStartTime = System.currentTimeMillis();
		hour = calendar.get(Calendar.HOUR);
		min = calendar.get(Calendar.MINUTE);
		sec = calendar.get(Calendar.SECOND);
		if (calendar.get(Calendar.AM_PM) == 0) {
			am_pm = "AM";
		} else {
			am_pm = "PM";
		}
		running = true;
		exestartTime = exeactualStartTime;
		strExestartTime = "" + hour + ":" + min + ":" + sec + " " + am_pm;
		System.out.println(strExestartTime);
		return strExestartTime;
	}

	public String stop()
	{
		String strStoTime = null;

		Calendar stop = new GregorianCalendar();
		Long actualstopTime = System.currentTimeMillis();
		hour = stop.get(Calendar.HOUR);
		min = stop.get(Calendar.MINUTE);
		sec = stop.get(Calendar.SECOND);
		if (stop.get(Calendar.AM_PM) == 0)
			am_pm = "AM";
		else
			am_pm = "PM";
		// .currentTimeMillis();
		stopTime = actualstopTime;
		strStoTime = "" + hour + ":" + min + ":" + sec + " " + am_pm;

		running = false;
		return strStoTime;
	}
	public String exestop() 
	{
		String exestrStoTime = null;

		Calendar stop = new GregorianCalendar();
		Long exeactualstopTime = System.currentTimeMillis();
		hour = stop.get(Calendar.HOUR);
		min = stop.get(Calendar.MINUTE);
		sec = stop.get(Calendar.SECOND);
		if (stop.get(Calendar.AM_PM) == 0)
			am_pm = "AM";
		else
			am_pm = "PM";
		// .currentTimeMillis();
		exestopTime = exeactualstopTime;
		exestrStoTime = "" + hour + ":" + min + ":" + sec + " " + am_pm;

		running = false;
		return exestrStoTime;
	}
	public float getElapsedTime() {
		float elapsedTime = 0;
		if (running) {
			elapsedTime = (System.currentTimeMillis() - startTime);
			// .currentTimeMillis() - startTime);
		} else {
			elapsedTime = (stopTime - startTime);
		}
		return elapsedTime;
	}
	public float getExecutionElapsedTime() {
		float elapsedTime = 0;
		if (running) {

			elapsedTime = (System.currentTimeMillis() - exestartTime);
			// .currentTimeMillis() - startTime);
		} else {
			elapsedTime = (exestopTime - exestartTime);
		}
		return elapsedTime;
	}

	public String ExecutionTime( float timeElapsed)
	{
		int seconds = Math.round((timeElapsed / (60000)) * 60);
		int hours = 0;
		int minutes = 0;
		int newSeconds = 0;
		int newSecond1 = 0;
		String strExecutiontime = "";
		if (seconds >= 3600) {
			hours = seconds / 3600;
			minutes = (seconds % 3600) / 60;
			newSeconds = (seconds % 3600) % 60;
			if (minutes == 0) {
				newSecond1 = (seconds % 3600) % 60;
				if (newSecond1 != 0) {
					strExecutiontime = hours + " Hour(s)" + newSecond1 + " Second(s)";
				} else {
					strExecutiontime = hours + " Hour(s)";
				}
			}

			if (minutes > 0 && minutes < 60) {
				if (newSeconds > 0 && minutes > 0) {
					strExecutiontime = hours + " Hour(s) " + minutes + " Minute(s)" + newSeconds + " Second(s)";
				}
				if (newSeconds == 0 && minutes > 0) {
					strExecutiontime = hours + " Hour(s) " + minutes + " Minute(s)";
				}
			}

			if (minutes > 60) {
				seconds = minutes % 60;
				minutes = minutes / 60;
				strExecutiontime = hours + " Hour(s) " + minutes + " Minutes " + seconds + " Seconds";
			}

		} else {
			minutes = seconds / 60;
			seconds = seconds % 60;
			if (minutes > 0 && seconds == 0) {
				strExecutiontime = minutes + " Minute(s)";
			}
			if (minutes > 0 && seconds > 0) {
				strExecutiontime = minutes + " Minute(s) " + seconds + " Second(s)";
			}
			if (minutes == 0) {
				strExecutiontime = seconds + " Second(s)";
			}
		}
		return strExecutiontime;

	}

	
	    public  void logger(String module , String method, String log) 
	    {
	    	
	        BufferedWriter writer = null;
	        try {
	            //create a temporary file
	            String timeLog = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
	            File logFile = new File(strAbsolutepath+ "\\Log\\" + module);

	            // This will output the full path where the file will be written to...
	           // File logFile = new File(module);
	            System.out.println(logFile.getCanonicalPath());

	            writer = new BufferedWriter(new FileWriter(logFile , true));
	            
	            String finalLog = "Module : " + module + " : Method : " + method + ":" + "Timestamp: " + timeLog + " " +    "Message  : " + log; 
	            
	            writer.newLine();
	            writer.newLine();

	            writer.write(finalLog);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                // Close the writer regardless of what happens...
	                writer.close();
	            } catch (Exception e) {
	            }
	        }
	    
	}
	    public  void logger(String module , String method, Exception log) 
	    {
	    	
	        BufferedWriter writer = null;
	        try {
	            //create a temporary file
	            String timeLog = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
	            //File logFile = new File("Exception");
	           File logFile = new File(strAbsolutepath+ "\\Log\\Exception");


	            // This will output the full path where the file will be written to...
	            System.out.println(logFile.getCanonicalPath());

	            writer = new BufferedWriter(new FileWriter(logFile , true));
	            
	            String finalLog = "Module : " + module + " : Method : " + method + ":" + "Timestamp: " + timeLog + " " +    "Message  : " + log; 
	            
	            writer.newLine();
	            writer.newLine();
	            writer.write(finalLog);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                // Close the writer regardless of what happens...
	                writer.close();
	            } catch (Exception e) {
	            }
	        }
	    
	}
	    
	    public  void logger(String module , Exception log) 
	    {
	    	
	        BufferedWriter writer = null;
	        try {
	            //create a temporary file
	            String timeLog = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
	           // File logFile = new File("Exception");
	            File logFile = new File(strAbsolutepath+ "\\Log\\Exception");

	            // This will output the full path where the file will be written to...
	            System.out.println(logFile.getCanonicalPath());

	            writer = new BufferedWriter(new FileWriter(logFile, true));
	            
	            String finalLog = "Module : " + module + ":" + "Timestamp: " + timeLog + " " +    "Message  : " + log; 
	            writer.newLine();
	            writer.newLine();
	            writer.write(finalLog);
	         

	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        } 
	        finally
	        {
	            try 
	            {
	                // Close the writer regardless of what happens...
	                writer.close();
	            }
	            catch (Exception e)
	            {
	            
	            }
	        }
	    
	}


}
